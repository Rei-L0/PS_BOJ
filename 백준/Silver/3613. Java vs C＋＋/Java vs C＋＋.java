import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        String res = "Error!";

        if (s.contains("_")) {
            res = cpp(s);
        } else if (Character.isLowerCase(s.charAt(0)) && res.equals("Error!")) {
            res = java(s);
        }

        System.out.println(res);
    }

    static String java(String s) {
        if (s.contains(" ")) {
            return "Error!";
        }
        String ans = "";

        String chk = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                ans += chk + "_";
                chk = "";
                chk += Character.toLowerCase(s.charAt(i));
                continue;
            }
            chk += s.charAt(i);
        }
        if (!chk.equals("")) {
            ans += chk + "_";
        }

        return ans.substring(0, ans.length() - 1);
    }


    static String cpp(String s) {
        for (String line : s.split("_")) {
            for (int i = 0; i < line.length(); i++) {
                if (Character.isUpperCase(line.charAt(i))) {
                    return "Error!";
                }
            }
        }
        if (s.charAt(s.length() - 1) == '_') {
            return "Error!";
        }
        if (s.charAt(0) == '_') {
            return "Error!";
        }
        if (s.contains("__")) {
            return "Error!";
        }
        String ans = "";
        for (String x : s.split("_")) {
            String a = x.substring(0, 1).toUpperCase();
            String b = x.substring(1);
            ans += (a + b);
        }
        ans = ans.substring(0, 1).toLowerCase() + ans.substring(1);
        return ans;
    }

}