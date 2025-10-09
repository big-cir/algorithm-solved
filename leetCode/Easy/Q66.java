// sol1
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(digits[i]);
        }

        int upper = 0;
        for (int i = n - 1; i >= 0; i--) {
            int value = list.get(i);
            if (i == n - 1) {
                if (value == 9) {
                    list.set(i, 0);
                    upper = 1;
                    if (i == 0) list.addFirst(1);
                } else {
                    list.set(i, value + 1);
                    break;
                }
            } else {
                if (value == 9) {
                    if (upper == 1) {
                        list.set(i, 0);

                        if (i == 0) list.addFirst(1);
                    } else break;
                } else {
                    if (upper == 1) {
                        list.set(i, value + 1);
                        break;
                    }
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

// sol2
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] answer = new int[n + 1];
        answer[0] = 1;
        
        return answer;
    }
}
