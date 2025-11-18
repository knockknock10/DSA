const mongoose = require("mongoose");
const { Schema } = mongoose;

main()
  .then(() => console.log("Connection sucessful"))
  .catch((err) => console.log(err));

async function main() {
  await mongoose.connect("mongodb://127.0.0.1:27017/relation");
}

const orderSchema = new Schema({
  items: String,
  price: Number,
});

const customerSchema = new Schema({
  name: String,
  orders: [
    {
      type: Schema.Types.ObjectId,
      ref: "Order",
    },
  ],
});

const Order = mongoose.model("Order", orderSchema);
const Customer = mongoose.model("Customer", customerSchema);

const addCustomer = async () => {
  //   let cust1 = new Customer({
  //     name: "Sanjeev",
  //   });
  //   let order1 = await Order.findOne({ items: "chips" });
  //   let order2 = await Order.findOne({ items: "chips" });
  //   cust1.orders.push(order1);
  //   cust1.orders.push(order2);
  //   let reslut = await cust1.save();
  //   console.log(reslut);
  let res = await Customer.find({});
  console.log(res);
};
addCustomer();
// const addOrder = async () => {
//   let res = await Order.insertMany([
//     { items: "samosa", price: 20 },
//     { items: "chips", price: 34 },
//     { items: "chocolate", price: 24 },
//   ]);
//   console.log(res);
// };
//addOrder();
