function solution(s, skip, index) {
    let answer = "";
    let set = new Set(skip);
    for (let i = 0; i < s.length; i++) {
        let num = s.charAt(i).charCodeAt();
        
        for (let j = 0; j < index; j++) {
            num++;
            if (num >= 123) num -= 26;

            while (set.has(String.fromCharCode(num))) {
                num++;
                if (num >= 123) num -= 26;
            }
        }

        answer += String.fromCharCode(num)
    }
    return answer;
}