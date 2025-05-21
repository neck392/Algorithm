package hw8_1; 
import java.util.Scanner;

public class Main_202014008 { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        
        // 원소 수 입력 받고 객체 생성
        int n = scanner.nextInt();
        MySet mySet = new MySet(n);
        
        int m = scanner.nextInt();	// Union 연산 횟수 입력 받기
        for (int i = 0; i < m; i++) {	// Union 연산 수행
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            mySet.union(x, y);
        }
        
        for (int i = 0; i < n; i++) {	// 부모 원소 출력
            System.out.print(mySet.parent[i] + " ");
        }
        System.out.println();
        
        for (int i = 0; i < n; i++) {	// FindSet 연산 후 부모 원소 출력
            System.out.print(mySet.findSet(i) + " ");
        }
        scanner.close();
    }
}

class MySet { 
    public int n; // 원소 수를 저장하는 변수
    public int[] parent; // 부모 노드를 저장하는 배열

    public MySet(int n) { 
        this.n = n; 
        parent = new int[n]; 
        for (int i = 0; i < n; i++) { // 각 원소에 대해 makeSet 연산 수행
            makeSet(i);
        }
    }

    public void makeSet(int x) { 
        parent[x] = x; 
    }

    public int findSet(int x) { 
        if (parent[x] != x) { // 현재 노드의 부모가 자기 자신이 아니라면
            parent[x] = findSet(parent[x]); // 경로를 압축하여 최종 부모를 찾음
        }
        return parent[x]; // 최종 부모 반환
    }

    public void union(int x, int y) { 
        int parentX = findSet(x); // x의 최종 부모
        int parentY = findSet(y); // y의 최종 부모
        parent[parentY] = parentX; // y의 부모를 x의 부모로 설정
    }
}
