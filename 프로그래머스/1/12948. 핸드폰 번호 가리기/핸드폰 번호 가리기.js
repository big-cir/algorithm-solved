function solution(phone_number) {
    let size = phone_number.length;
    let answer = '';
    for (let i = 0; i < size - 4; i++) {
        answer += '*';
    }
    
    answer += phone_number.substring(size - 4, size);
    return answer;
}