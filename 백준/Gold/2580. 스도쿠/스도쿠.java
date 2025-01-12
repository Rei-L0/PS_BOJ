import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int S = 9; // 스도쿠 크기
    static StringBuilder sb = new StringBuilder();

    // 스도쿠 배열
    static int[][] bArr;
    // 빈 칸 리스트
    static List<Pos> candidate;
    // 행, 열, 박스 체크 배열
    static boolean[][] rowCheck, colCheck, boxCheck;

    static class Pos {

        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bArr = new int[S][S];
        candidate = new ArrayList<>();

        // 체크 배열 초기화
        rowCheck = new boolean[S][S + 1];
        colCheck = new boolean[S][S + 1];
        boxCheck = new boolean[S][S + 1];

        // 입력 받기
        for (int i = 0; i < S; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < S; j++) {
                int num = Integer.parseInt(st.nextToken());
                bArr[i][j] = num;
                if (num == 0) {
                    candidate.add(new Pos(i, j)); // 빈 칸 저장
                } else {
                    mark(i, j, num, true); // 초기 값 체크
                }
            }
        }

        // 스도쿠 풀이
        solve(0);

        // 결과 출력
        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                sb.append(bArr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 백트래킹
    static boolean solve(int idx) {
        if (idx == candidate.size()) {
            return true; // 모든 빈 칸을 채우면 종료
        }

        Pos now = candidate.get(idx);
        int x = now.x, y = now.y;

        for (int num = 1; num <= S; num++) {
            if (isValid(x, y, num)) {
                bArr[x][y] = num; // 값 설정
                mark(x, y, num, true); // 체크 업데이트

                if (solve(idx + 1)) {
                    return true; // 정답을 찾으면 종료
                }

                mark(x, y, num, false); // 체크 복구
                bArr[x][y] = 0; // 값 복구
            }
        }
        return false; // 정답을 찾지 못하면 false 반환
    }

    // 유효성 검사
    static boolean isValid(int x, int y, int num) {
        int boxIdx = (x / 3) * 3 + (y / 3); // 박스 인덱스 계산
        return !rowCheck[x][num] && !colCheck[y][num] && !boxCheck[boxIdx][num];
    }

    // 체크 업데이트
    static void mark(int x, int y, int num, boolean isAdd) {
        int boxIdx = (x / 3) * 3 + (y / 3); // 박스 인덱스 계산
        rowCheck[x][num] = isAdd;
        colCheck[y][num] = isAdd;
        boxCheck[boxIdx][num] = isAdd;
    }
}
