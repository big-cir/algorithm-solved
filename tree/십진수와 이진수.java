import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();

        BigInteger decimal = new BigInteger(binary, 2);

        decimal = decimal.multiply(BigInteger.valueOf(17));

        String answer = decimal.toString(2);
        System.out.println(answer);
    }
}

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String binary = br.readLine();

//         int radix = 2;
//         int multi = 1;
//         int len = binary.length() - 1;

//         int decimal = new BigInteger(0);
//         while (len > -1) {
//             char ch = binary.charAt(len);

//             if (ch == '1') {
//                 int value = ch - '0';
//                 decimal += value * multi;
//             }

//             multi *= radix;
//             len--;
//         }

//         decimal *= 17;

//         StringBuilder answer = new StringBuilder();
//         while (decimal > 0) {
//             int remain = decimal % radix;
//             decimal /= radix;
//             answer.append(remain);
//         }

//         System.out.println(answer.reverse());
//     }
// }
