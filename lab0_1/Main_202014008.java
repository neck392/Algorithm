// 202014008 김민서
// 24.03.07
// 사용자가 원하는 갯수의 정수값을 입력받아 배열에 저장한 후 출력                
package lab0_1;

import java.util.Scanner;

public class Main_202014008 {
	public static void main(String[] args) {
		System.out.println("lab0_1:김민서");		
		Scanner scanner = new Scanner(System.in);
		
		// 사용자가 원하는 정수의 갯수 n을 입력받음
		int n = scanner.nextInt();
		
		// n개의 정수값을 입력받아 배열에 저장
		int [] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		// 배열에 저장된 정수들의 합과 평균값 구하기
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
        	sum += array[i];
        }
        double average = (double) sum / n;

        // 평균보다 큰 정수의 개수 세기
        int count = 0;
        for (int i = 0; i < array.length; i++) {
        	if (array[i] > average) {
                count++;
            }
        }

        // 결과 출력 
        System.out.println(average);
        System.out.println(count);
        
		scanner.close();
	}
}
