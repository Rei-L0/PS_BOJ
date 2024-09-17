import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int M = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        if (n.charAt(0) == '0') {  // 첫 자리가 '0'이면 해석 불가
            System.out.println(0);
            return;
        }

        long[] dp = new long[n.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < n.length(); i++) {
            char now = n.charAt(i);
            char prev = n.charAt(i - 1);

            // 현재 숫자가 '0'이 아닌 경우 -> 하나의 문자로 해석 가능
            if (now != '0') {
                dp[i + 1] += dp[i];
                dp[i + 1] %= M;  // M으로 나눈 나머지 계산
            }

            // 이전 숫자와 현재 숫자를 함께 해석할 수 있는 경우
            int twoDigit = (prev - '0') * 10 + (now - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i + 1] += dp[i - 1];
                dp[i + 1] %= M;  // M으로 나눈 나머지 계산
            }
        }

        System.out.println(dp[n.length()]);
    }
}