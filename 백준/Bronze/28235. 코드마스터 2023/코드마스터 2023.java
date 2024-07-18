import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 구호와 응원을 매핑하는 HashMap 생성
        Map<String, String> cheerMap = new HashMap<>();
        cheerMap.put("SONGDO", "HIGHSCHOOL");
        cheerMap.put("CODE", "MASTER");
        cheerMap.put("2023", "0611");
        cheerMap.put("ALGORITHM", "CONTEST");

        // 사용자로부터 입력 받기
        Scanner scanner = new Scanner(System.in);
        String inputCheer = scanner.nextLine().trim();

        // 입력된 구호에 맞는 응원 출력
        if (cheerMap.containsKey(inputCheer)) {
            System.out.println(cheerMap.get(inputCheer));
        } else {
            System.out.println("잘못된 구호입니다.");
        }

        scanner.close();
    }
}