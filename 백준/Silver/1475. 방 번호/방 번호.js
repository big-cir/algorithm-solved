let fs = require("fs");
let input = fs.readFileSync(0, "utf-8").toString().trim().split("\n").toString();

let needs = Array.from({ length: 10 }).fill(0);
for (let i = 0; i < input.length; i++) {
    let num = parseInt(input.charAt(i), 10);

    if (num === 6 || num === 9) {
        if (needs[6] >= needs[9]) needs[9]++;
        else needs[6]++;
    } else {
        needs[num]++;
    }
}

let max = -1;
for (let num of needs) {
    if (num > max) max = num;
}

console.log(max);