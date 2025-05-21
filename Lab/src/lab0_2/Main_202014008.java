// 202014008 김민서
// 24. 03. 07
// 사용자로부터 양의 정수 n을 입력받아 n!를 구하고, n부터 1까지 출력

package lab0_2;

import java.util.Scanner;

public class Main_202014008 {

	public static void main(String[] args) {
		System.out.println("lab0_2:김민서");
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		System.out.println(factorial(n));
		show(n);
		scanner.close();
	}
	
	// n!을 구하여 리턴하는 메소드
	private static int factorial(int n) {
		if(n == 1) return 1;
		else return n + factorial(n-1);
	}
	
	// n부터 1까지 출력하는 메소드
	private static void show(int n) {
		if(n > 1) {
			show(n-1);
		}
		System.out.print(n + " ");
	}
}
