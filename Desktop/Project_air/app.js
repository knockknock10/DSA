const express = require("express");
const app = express();
const mongoose = require("mongoose");
const Listing = require("./models/listing.js");
const path = require("path");
const methodOverride = require("method-override");
const { ppid } = require("process");
const ejsMate = require("ejs-mate");
const wrapAsync = require("./utils/wrapAsync.js");
const { wrap } = require("module");
const ExpressError = require("./utils/ExpressError.js");
const { listingSchema } = require("./schema.js");

app.use(methodOverride("_method"));
app.set("view engine", "ejs");
app.set("views", path.join(__dirname, "views"));
app.use(express.urlencoded({ extended: true }));
app.engine("ejs", ejsMate);
app.use(express.static(path.join(__dirname, "/public")));
app.use(express.static("public"));

const Mongo_url = "mongodb://127.0.0.1:27017/wanderlust";
main()
  .then(() => {
    console.log("Connected to DB");
  })
  .catch((err) => {
    console.log(err);
  });
async function main() {
  await mongoose.connect(Mongo_url);
}

//test
// app.get("/testlisting", async(req, res) => {
//     let samplelisting = new Listing({
//         title: "My new Villa",
//         description: "By the beach",
//         price: 1200,
//         location: "Goa",
//         country: "India",
//     })
//     await samplelisting.save();
//     console.log("Sample was saved");
//     res.send("Successfull testing");
// })

app.get("/", (req, res) => {
  res.send("hi i am Root");
});

//middleware for validateSchema
const validateListing = (req, res, next) => {
  let { error } = listingSchema.validate(req.body);

  if (error) {
    let errMsg = error.details.map((el) => el.message).join(",");
    throw new ExpressError(404, errMsg);
  } else {
    next();
  }
};

//index route
app.get(
  "/listings",
  wrapAsync(async (req, res) => {
    const allListings = await Listing.find({});
    res.render("./listings/index", { allListings });
  })
);

//Create /new route
//we are writing this here bcz else writeing this after show route
//our app.js treate /new as an id
// app.get("/listings/new", (req, res) => {

//     res.render("listings/new.ejs")

// })
//Show Route
app.get("/listings/new", (req, res) => {
  res.render("listings/new");
});

app.get(
  "/listings/:id",
  wrapAsync(async (req, res) => {
    let { id } = req.params;
    const listing = await Listing.findById(id);
    res.render("listings/show.ejs", { listing });
  })
);
//Create route
app.post(
  "/listings",
  validateListing,
  wrapAsync(async (req, res, next) => {
    //let { title, description, image, price, country, location } = req.body;
    //but if we write in new as listings[price]...
    // let listing = req.body.listing;

    // if (!req.body.listing) {
    //   throw new ExpressError(404, "Send valid data for listing");
    // }
    //     let result = listingSchema.validate(req.body);
    // if (!newListing.title) {
    //   throw new ExpressError(404, "Title is missing!");
    // }
    let result = listingSchema.validate(req.body);
    console.log(result);
    const newListing = new Listing(req.body.listing);
    await newListing.save();
    res.redirect("/listings");
  })
);

// Edit Route
app.get(
  "/listings/:id/edit",
  wrapAsync(async (req, res) => {
    let { id } = req.params;
    const listing = await Listing.findById(id);
    res.render("listings/edit.ejs", { listing });
  })
);
//update route
app.put(
  "/listings/:id",
  validateListing,
  wrapAsync(async (req, res) => {
    // if (!req.body.listing) {
    //   throw new ExpressError(404, "Send valid data for listing");
    // }
    const { id } = req.params;
    const listing = await Listing.findById(id);

    if (!listing) {
      return res.status(404).send("Listing not found");
    }

    // Update regular fields
    listing.title = req.body.listing.title;
    listing.price = req.body.listing.price;
    listing.description = req.body.listing.description;

    // Handle image update
    if (req.file) {
      // If using multer and user uploaded a new image
      listing.image = {
        filename: req.file.filename,
        url: `/uploads/${req.file.filename}`, // or cloud URL
      };
    } else if (req.body.listing.image && req.body.listing.image.url) {
      // Keep the old image from hidden fields
      listing.image = {
        filename: req.body.listing.image.filename,
        url: req.body.listing.image.url,
      };
    } else {
      // Optional: If no image at all, remove or leave empty
      listing.image = null;
    }

    await listing.save();
    res.redirect(`/listings/${id}`);
  })
);

//Delete Route
app.delete(
  "/listings/:id",
  wrapAsync(async (req, res) => {
    let { id } = req.params;
    let deletedlisting = await Listing.findByIdAndDelete(id);
    console.log(deletedlisting);
    res.redirect("/listings");
  })
);

app.all(/.*/, (req, res, next) => {
  next(new ExpressError(404, "Page Not Found !"));
});

app.use((err, req, res, next) => {
  let { statusCode = 404, message = "Something Went Wrong" } = err;
  res.status(statusCode).render("error.ejs", { message, err });
  //res.status(statusCode).send(message);
});

app.listen(8080, () => {
  console.log("Server is listening to Port 8080");
});
