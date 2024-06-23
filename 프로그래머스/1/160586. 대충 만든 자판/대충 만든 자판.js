function solution(keymap, targets) {
    let map = new Map();
    for (let i = 0; i < keymap.length; i++) {
        let spl = keymap[i].split("");
        for (let j = 0; j < spl.length; j++) {
            if (map.has(spl[j])) {
                map.set(spl[j], Math.min(map.get(spl[j]), j + 1));
            } else {
                map.set(spl[j], j + 1);
            }
        }
    }

    let answer = [];
    for (let i = 0; i < targets.length; i++) {
        let spl = targets[i].split("");
        let cnt = 0;
        for (let j = 0; j < spl.length; j++) {
            if (map.has(spl[j])) {
                cnt += map.get(spl[j]);
            } else {
                cnt = -1;
                break;
            }
        }
        answer[i] = cnt;
    }
    return answer;
}