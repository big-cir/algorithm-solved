class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);

            int sum = 0;
            while (n != 0) {
                int value = n % 10;
                sum += Math.pow(value, 2);
                n /= 10;
            }

            n = sum;
        }

        return n == 1;
    }
}
