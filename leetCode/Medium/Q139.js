/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    const set = new Set();
    for (const word of wordDict) set.add(word);
    const ch = new Array(s.length + 1).fill(false);
    ch[0] = true;
    let rt = 1;
    for (; rt <= s.length; rt++) {
        for (let lt = 0; lt < rt; lt++) {
            if (!ch[lt]) continue;
            
            const str = s.slice(lt, rt);
            if (set.has(str)) {
                ch[rt] = true;
            }
        }
    }

    console.log(ch)

    return ch[s.length];
};
