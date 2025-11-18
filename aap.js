const express = require("express");
const Expresserorr = require("./Expresserr");
const app = express();
//utility middlewares logger 
app.use((req, res, next) => {
    req.time = new Date(Date.now()).toString();
    console.log(req.method, req.hostname, req.path, req.time);
    next();
})
//always write middlewares on top to have the req,res
//Output
// GET localhost / Mon Oct 20 2025 19:03:09 GMT+0530 (India Standard Time)
let tokenacc = ("/api", (req, res, next) => {
    let { token } = req.query;
    if (token === "give access") {
        next();
    } else {
        // res.send("DENIED ACCESS");
        throw new Expresserorr(401, "ACCESS DENIED !");
    }
})
app.use("/api", tokenacc ,(req, res,) => {
    res.send("data");
})
app.use("/wrong", (req, res) => {
    abvg = kjh;
})
//activity
app.get("/admin",(req, res) => {
    throw new Expresserorr(403, "ACCESS IS FORBIDDEN");
})
app.use((err, req, res, next) => {
    // console.log("--------ERROR--------");
    // next(err);
    let { status = 500, message = "SOME ERROR" } = err;
    res.status(status).send(message);
})
app.listen(8080, (req, res) => {
    console.log("server listening to port");
})