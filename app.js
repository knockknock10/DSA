let str = "abcdabcdabcdaabbbbcccddff";
let ans = "";
function unique(str) {
  for (let i = 0; i < str.length(); i++) {
    let curr = str[i];
    if (str.indexOf(curr) == -1) {
      ans += curr;
    }
  }
}
console.log(ans);
