package hw11_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_202014008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("hw11_1:김민서");

        int n = scanner.nextInt();	// 동전 갯수 입력

        int[] coins = new int[n];	// 동전 갯수에 해당하는 액면 입력
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        Arrays.sort(coins);	// 동전 액면을 내림차순으로 정렬
        for (int i = 0; i < n / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[n - i - 1];
            coins[n - i - 1] = temp;
        }

        boolean multiple = true;	// 액면의 배수 검사
        int i = 0;
        while (i < n - 1) {
            if (coins[i] % coins[i + 1] != 0) {
                multiple = false;
                break;
            }
            i++;
        }

        if (!multiple) {	// 검사 결과 배수가 아니면 실패
            System.out.println("그리디 알고리즘은 최적해를 보장하지 않습니다.");
        } else {	// 검사 결과 배수이면 거스름돈 액수를 입력받아 최적해를 구함 
            int amount = scanner.nextInt();	
            int[] result = new int[n];
            int amountChange = amount;

            i = 0;
            while (i < n) {
                result[i] = amountChange / coins[i];
                amountChange = amountChange % coins[i];
                i++;
            }

            if (amountChange != 0) {	// 최적해를 구하는 과정에서 거스름돈 액수를 맞출 수 없으면 실패
                System.out.println("원하는 거스름돈 액수를 맞출 수 없습니다.");
            } else {	// 최적해를 구했으면 동전액면 x 갯수 형식으로 출력하되 액면이 높은 동전부터 차례대로 출력
                for (i = 0; i < n; i++) {
                    if (result[i] != 0) {
                        System.out.println(coins[i] + " x " + result[i]);
                    }
                }
            }
        }

        scanner.close();
    }
}
