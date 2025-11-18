const mongoose = require("mongoose");
const { Schema } = mongoose;
main()
  .then(() => console.log("Connection Successful"))
  .catch((err) => console.log(err));

async function main() {
  await mongoose.connect("mongodb://127.0.0.1:27017/relation");
}

const userSchema = new Schema({
  userName: String,
  address: [
    {
      _id: false, // here automatically every new location id was being assigned so
      location: String,
      city: String,
    },
  ],
});

const User = mongoose.model("User", userSchema);

const addUser = async () => {
  let user1 = new User({
    userName: "scherlock",
    address: [
      {
        location: "Baker stree",
        city: "London",
      },
    ],
  });
  user1.address.push({ location: "wall street", city: "London" });
  let result = await user1.save();
  console.log(result);
};
addUser();
