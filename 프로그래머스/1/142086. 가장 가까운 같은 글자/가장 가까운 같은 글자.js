function solution(s) {
    let answer = [];
    let map = new Map();
    for (let i = 0; i < s.length; i++) {
        if (map.has(s.charAt(i))) {
            answer[i] = i - map.get(s.charAt(i));
        } else {
            answer[i] = -1;
        }

        map.set(s.charAt(i), i);
    }

    return answer;
}