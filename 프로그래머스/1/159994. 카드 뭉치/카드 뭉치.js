function solution(cards1, cards2, goal) {
    let answer = "Yes";
    const n = cards1.length;
    const m = cards2.length;

    let oneIdx = 0;
    let twoIdx = 0;
    for (let str of goal) {
        if (oneIdx < n && str === cards1[oneIdx]) {
            oneIdx++;
            continue;
        }

        if (twoIdx < m && str === cards2[twoIdx]) {
            twoIdx++;
            continue;
        }

        answer = "No";
        break;
    }

    return answer;
}