// name[]
// yearning[]
// photo[][]
function solution(name, yearning, photo) {
    let map = new Map();
    
    for (let i = 0; i < name.length; i++) {
        map.set(name[i], yearning[i]);
    }
    
    let answer = new Array();
    for (let i = 0; i < photo.length; i++) {
        let sum = 0;
        for (let str of photo[i]) {
            if (map.get(str) === undefined) continue;
            sum += map.get(str);
        }  
        answer[i] = sum;
    }
        
    return answer;
}