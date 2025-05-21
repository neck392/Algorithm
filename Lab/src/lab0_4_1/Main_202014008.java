package lab0_4_1;
import java.util.Scanner;

public class Main_202014008 {
    public static void main(String[] args) {
        System.out.println("hw4_1:김민서");

        // 사용자로부터 원소 개수(n)와 n개의 실수값을 입력받아 배열에 저장
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextDouble();
        }

        // 배열 원소들을 퀵 정렬 알고리즘을 이용하여 정수부를 기준으로 오름차순으로 정렬
        quickSort(array, 0, n - 1);

        // 정렬된 배열 원소들을 출력
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        scanner.close();
    }

    // 배열 array[p...]을 퀵 정렬
    public static void quickSort(double[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q);
            quickSort(array, q + 1, r);
        }
    }

    // array[p... ]을 분할하여 기준원소 인덱스를 리턴
    public static int partition(double[] array, int p, int r) {
        double pivot = array[p];  // 피벗 설정
        int i = p - 1;
        int j = r + 1;
        while (true) {
            do {
                i++;
            } while ((int) array[i] < (int) pivot || ((int) array[i] == (int) pivot && array[i] < pivot));  // 정수부를 기준으로 비교합니다.
            do {
                j--;
            } while ((int) array[j] > (int) pivot || ((int) array[j] == (int) pivot && array[j] > pivot));  // 정수부를 기준으로 비교합니다.
            if (i >= j)
                return j;
            double temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
