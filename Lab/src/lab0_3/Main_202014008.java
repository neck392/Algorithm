// 202014008 김민서
// 24.03.14
// 순차검색, 이진검색 후에 인덱스 값을 리턴
package lab0_3;

import java.util.Scanner;

public class Main_202014008 {
	public static void main(String[] args) {
		System.out.println("lab0_3:김민서");
		
		// 정렬되지 않은 배열 array, 정렬된 배열 sortedArray를 초기화
		int array[] = {120, 990, 130, 150, 20, 300, 400, 990, 40, 100, 110, 150, 60, 80, 190, 200};
		int sortedArray[] = {20, 40, 60, 80, 100, 110, 120, 130, 150, 150, 190, 200, 300, 400, 990, 990};
		
		// 검색할 원소를 입력받음
		Scanner scanner = new Scanner(System.in);
		int item = scanner.nextInt();
		
		// 정렬되지 않은 배열 array에서 원소를 순차검색하여 위치(인덱스)를 출력
		System.out.println(sequentialSearch(array, item));
		
		// 정렬된 배열 sortedArray에서 원소를 이진검색하여 위치(인덱스)를 출력
		System.out.println(binarySearch(sortedArray, 0, array.length-1, item));
		
		scanner.close();
	}

	//정렬되지 않은 배열 array에서 원소를 순차검색하여 위치(인덱스)를 리턴; 검색 실패시 -1 리턴
	private static int sequentialSearch(int[] array, int item) {
		for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i; // 해당 인덱스 반환
            }
        }
        return -1; // 검색 실패 -1 반환
	}
	
	// 정렬된 배열 sortedArray에서 원소를 이진검색하여 위치(인덱스)를 리턴; 검색 실패시 -1 리턴
	// 재귀알고리즘으로 구현해도 되고, 아니여도 됨. 재귀알고리즘으로 구현하지 않으려면 매개변수 form, to 필요 없음
	private static int binarySearch(int[] array, int from, int to, int item) {
		int mid = (from + to) / 2; // 중간 인덱스 계산
		
		if (from <= to) {
			if (array[mid] == item) { 
				return mid; // 검색한 원소가 중간 인덱스인 경우 해당 인덱스 반환
        	} else if (array[mid] > item) { 
            	return binarySearch(array, from, mid - 1, item); // 왼쪽 배열에서 재귀적 탐색
        	} else { 
            	return binarySearch(array, mid + 1, to, item); // 오른쪽 배열에서 재귀적 탐색
        	}
		}
        return -1;
	}
}