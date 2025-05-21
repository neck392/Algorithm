package lab0_4_2;
import java.util.Scanner;

public class Main_202014008 {
    public static void main(String[] args) {
        System.out.println("hw4_2:김민서");

        // 사용자로부터 원소 개수(n)와 n개의 실수값을 입력받아 배열에 저장
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
        }

        // 배열을 정수부 기준으로 오름차순 병합 정렬
        mergeSort(array, 0, n - 1);

        // 정렬된 배열 원소들을 출력
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        scanner.close();
    }

    // 병합 정렬을 수행하는 메소드
    public static void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid); // 왼쪽 부분 배열을 정렬
            mergeSort(array, mid + 1, right); // 오른쪽 부분 배열을 정렬
            merge(array, left, mid, right); // 정렬된 두 부분 배열을 병합
        }
    }

    // 두 부분 배열을 병합하는 메소드
    public static void merge(double[] array, int left, int mid, int right) {
        int n1 = mid - left + 1; // 왼쪽 부분 배열의 크기
        int n2 = right - mid; // 오른쪽 부분 배열의 크기

        // 임시 배열을 생성하여 정렬된 값을 저장
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // 왼쪽 부분 배열을 복사
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        // 오른쪽 부분 배열을 복사
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // 두 부분 배열을 비교하여 병합
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if ((int) leftArray[i] < (int) rightArray[j] || ((int) leftArray[i] == (int) rightArray[j] && leftArray[i] < rightArray[j])) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 왼쪽 부분 배열에 남은 원소를 배열에 복사
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // 오른쪽 부분 배열에 남은 원소를 배열에 복사
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
