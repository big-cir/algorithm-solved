class ATM {

    private int[] amounts;
    private int[] info = {500, 200, 100, 50, 20};

    public ATM() {
        amounts = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) amounts[i] += banknotesCount[i];
    }

    public int[] withdraw(int amount) {
        int n = amounts.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = amounts[n - i - 1];
            int value = info[i];

            if (cnt == 0) continue;

            int divide = Math.min(amount / value, cnt);
            amount -= (value * divide);
            
            if (amount < 0) {
                amount += (value * divide);
                continue;
            }

            result[n - 1 - i] += divide;
        }

        if (amount != 0) {
            return new int[] {-1};
        }

        for (int i = 0; i < n; i++) {
            amounts[i] -= result[i];
        }

        return result;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */

