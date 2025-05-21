package hw9_1;
import java.util.Scanner;

public class Main_202014008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("hw9_1:김민서");

        int n = scanner.nextInt();	// 계단의 개수 입력
        int[] scores = new int[n];	// 배열에 저장
        
        for (int i = 0; i < n; i++) {	// 계단마다의 점수 입력
            scores[i] = scanner.nextInt();
        }

        int[] dp = new int[n];	// 배열 초기화
        int[] path = new int[n];// 배열 초기화

        if (n > 0) {
            dp[0] = scores[0];
            path[0] = -1;  // 초기값
        }
        if (n > 1) {
            dp[1] = scores[0] + scores[1];
            path[1] = 0;  // 첫 번째 계단을 밟은 경우
        }
        if (n > 2) {
            dp[2] = Math.max(scores[0], scores[1]) + scores[2];
            if (scores[0] > scores[1]) {
                path[2] = 0;  // 0번 계단에서 올라온 경우
            } else {
                path[2] = 1;  // 1번 계단에서 올라온 경우
            }
        }

        for (int i = 3; i < n; i++) {	// 최대 점수 계산
            if (dp[i-2] > dp[i-3] + scores[i-1]) {
                dp[i] = dp[i-2] + scores[i];
                path[i] = i - 2;  // 두 계단 전에서 올라온 경우
            } else {
                dp[i] = dp[i-3] + scores[i-1] + scores[i];
                path[i] = i - 1;  // 한 계단 전에서 올라온 경우
            }
        }

        System.out.println(dp[n-1]);	// 최대 점수 출력

        int[] result = new int[n];
        int index = 0;
        for (int i = n - 1; i >= 0;) {	// 최대 점수를 얻기 위해 밟은 계단의 점수
            result[index++] = scores[i];
            int prev = path[i];
            if (prev == -1) {
                break;
            }
            if (prev == i - 1) {  // 한 계단 전에서 올라온 경우
                result[index++] = scores[i - 1];
                i = i - 3;  // 연속된 세 계단을 피하기 위해 3계단 전으로 이동
            } else {
                i = prev;
            }
        }

        for (int i = index - 1; i >= 0; i--) {	// 출력
            if (i != index - 1) System.out.print(" ");
            System.out.print(result[i]);
        }

        scanner.close();
    }
}
