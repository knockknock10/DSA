const mongoose = require("mongoose");
const Schema = mongoose.Schema;

// const listingSchema = new Schema({
//     title: {
//         type: String,
//         required: true,
//     },
//     description: String,

//     image: {
//         // type: String,
//         // default:"https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fbeach-house&psig=AOvVaw07WaMyQSDlu2yA2EvUODBp&ust=1759304232429000&source=images&cd=vfe&opi=89978449&ved=0CBUQjRxqFwoTCJiByZH9_48DFQAAAAAdAAAAABAE",
//         // set: (v) => v === ""
//         //     ? ""         //ternary op
//         //     : v,
//         type: String,
//         default: "https://default-image-link.com",
//         set: v => v === "" 
//             ? "https://default-image-link.com"  // fallback default
//             : v
//     },
//     price: Number,
//     location: String,
//     country:String,

// })

const listingSchema = new Schema({
  title: { type: String, required: true },
  description: String,
  image: {
    filename: String,
    url: {
      type: String,
      default: "https://images.unsplash.com/photo-1476514525535-07fb3b4ae5f1?auto=format&fit=crop&w=800&q=60"
    }
  },
  price: {
    type: Number,
    default: 2000
  },
  location: String,
  country: String,
});

const Listing = mongoose.model("Listing", listingSchema);
module.exports = Listing;
