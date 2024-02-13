class Solution {
    public String solution(String new_id) {
        // step1
        new_id = new_id.toLowerCase();

        // step2
        new_id = new_id.replaceAll("[^\\w\\.\\_\\-]", "");

        // step3
        new_id = new_id.replaceAll("\\.+", ".");

        // step4
        if (new_id.startsWith(".")) new_id = new_id.substring(1, new_id.length());
        if (new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length() - 1);

        // step5
        if (new_id.equals("")) new_id = "a";

        // step6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length() - 1);
        }

        // step 7
        if (new_id.length() <= 2) {
            String str = new_id.substring(new_id.length() - 1, new_id.length());
            while (new_id.length() < 3) {
                new_id += str;
            }
        }
        return new_id;
    }
}