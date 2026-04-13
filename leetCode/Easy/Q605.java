class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int fLength = flowerbed.length;
        if (n == 0) return true;
        if (fLength == 1) {
            return flowerbed[0] == 0 ? true : false;
        }

        for (int i = 0; i < fLength; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            } else if (i == fLength - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }

            if (n == 0) return true;
        }

        return false;
    }
}
