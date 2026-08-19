/**
 * @param {string} digits
 * @return {string[]}
 */

const map = {
    "2": ["a", "b", "c"],
    "3": ["d", "e", "f"],
    "4": ["g", "h", "i"],
    "5": ["j", "k", "l"],
    "6": ["m", "n", "o"],
    "7": ["p", "q", "r", "s"],
    "8": ["t", "u", "v"],
    "9": ["w", "x", "y", "z"]
};

const set = new Set();

var letterCombinations = function(digits) {
    set.clear();
    backtrack(digits, "", 0);

    return Array.from(set);
};

const backtrack = (digits, str, keyIdx) => {
    if (str.length === digits.length) {
        set.add(str);
        return;
    }

    const letters = map[(digits[keyIdx])];
    for (const letter of letters) {
        str += letter;
        backtrack(digits, str, keyIdx + 1);
        str = str.slice(0, -1);
    }
}
