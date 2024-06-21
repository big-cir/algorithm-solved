let fs = require("fs");
let input = fs.readFileSync(0, "utf-8").toString().trim().split("\n");

// 정점 개수, 간선 개수, 시작 정점
let [n, m, v] = input[0].split(" ").map(Number);
let arr = Array.from({ length: n + 1 }, () => []);
for (let i = 0; i < m; i++) {
    let [v1, v2] = input[i + 1].split(" ").map(Number);
    arr[v1].push(v2);
    arr[v2].push(v1);
}

arr.forEach(vertex => vertex.sort((a, b) => a - b));

function dfs(arr, ch, v, answer) {
    if (ch[v] === 0) {
        answer.push(v);
        ch[v] = 1;

        for (let next of arr[v]) {
            if (ch[next] === 0) {
                dfs(arr, ch, next, answer);
            }
        }
    }
}

function bfs(arr, v, answer) {
    let ch = Array.from({ length: n + 1 }, () => 0);
    let queue = [];
    queue.push(v);
    answer.push(v);
    ch[v] = 1;

    while (queue.length) {
        let now = queue.shift();

        for (let next of arr[now]) {
            if (ch[next] === 0) {
                ch[next] = 1;
                answer.push(next);
                queue.push(next);
            }
        }
    }
}

let answer = [];
let copy = arr.slice();
let ch = Array.from({ length: n + 1 }, () => 0);
dfs(arr, ch, v, answer);
console.log(answer.join(" "));

answer = [];
copy = arr.slice();
bfs(arr, v, answer);
console.log(answer.join(" "));