import java.util.*;
class Solution {
    private static String[][] allCase = {{"+-*"}, {"+*-"}, {"-+*"}, {"-*+"}, {"*+-"}, {"*-+"}};

    public static long cal(String op, List<Long> expressionVal, int idx) {
        long val = switch (op) {
            case "+" -> expressionVal.get(idx) + expressionVal.get(idx + 1);
            case "-" -> expressionVal.get(idx) - expressionVal.get(idx + 1);
            default -> expressionVal.get(idx) * expressionVal.get(idx + 1);
        };

        return val;
    }

    public static long solve(String oper, List<String> op, List<Long> expressionVal){
        List<String> emptyOp = new ArrayList<>(op);
        List<Long> emptyVal = new ArrayList<>(expressionVal);

        for (int i = 0; i < oper.length(); i++) {
            String s = String.valueOf(oper.charAt(i));
            for (String x : op) {
                if (s.equals(x)) {
                    int idx = emptyOp.indexOf(x);
                    long val = cal(x, emptyVal, idx);

                    emptyOp.remove(idx);
                    emptyVal.set(idx, val);
                    emptyVal.remove(idx + 1);
                }
            }
        }

        return Math.abs(emptyVal.get(0));
    }

    public long solution(String expression) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        List<Long> expressionVal = new ArrayList<>();
        List<String> op = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                sb.append(expression.charAt(i));
                if (i == expression.length() - 1) expressionVal.add(Long.parseLong(sb.toString()));
            } else {
                expressionVal.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                op.add(String.valueOf(expression.charAt(i)));
            }
        }

        for (int i = 0; i < allCase.length; i++) {
            answer = Math.max(answer, solve(allCase[i][0], op, expressionVal));
        }

        System.out.println(answer);
        return answer;
    }
}