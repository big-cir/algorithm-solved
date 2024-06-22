function solution(food) {
    let answer = "";

    for (let i = 1; i < food.length; i++) {
        let cnt = parseInt(food[i] / 2);

        for (let j = 0; j < cnt; j++) {
            answer += i;
        }
    }

    let tmp = answer.split("").reverse().join("");
    answer += 0;
    answer += tmp;
    return answer;
}