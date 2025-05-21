/*
학번: 202014008
이름: 김민서
날짜: 24. .5. 28.
*/
package hw10_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {	// 그래프의 간선을 나타내는 클래스 Edge
    int v1, v2, weight;

    public Edge(int v1, int v2, int weight) {	// 간선 초기화
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    // 간선의 가중치를 기준으로 간선을 비교
    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    // 간선을 문자열로 나타냄
    @Override
    public String toString() {
        return "(" + v1 + "," + v2 + "," + weight + ")";
    }
}

public class Main_202014008 {
    private static int[] parent;	// 각 노드의 부모 노드를 나타내는 배열

    public static void main(String[] args) {
        System.out.println("hw10_1 : 김민서"); 
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 정점 수 입력
        int e = scanner.nextInt(); // 간선 수 입력

        List<Edge> edgeList = new ArrayList<>();	// 모든 간선을 저장할 리스트

        for (int i = 0; i < e; i++) {	// 각 간선을 읽어서 edgeList에 추가
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int weight = scanner.nextInt();
            edgeList.add(new Edge(v1, v2, weight));
        }

        parent = new int[n];	
        
        for (int x = 0; x < n; x++) {	// 각 정점으로 구성된 n개의 상호배타적 집합 생성
            makeSet(x);
        }

        Collections.sort(edgeList);	// 간선 리스트를 가중치 오름차순으로 정렬

        List<Edge> treeEdgeList = new ArrayList<>();	// 최소 신장 트리의 간선을 저장할 리스트

        for (Edge edge : edgeList) {	// 정렬된 간선을 순차적으로 처리
            if (findSet(edge.v1) != findSet(edge.v2)) {	// 해당 간선을 추가했을 때 사이클이 생기지 않는 경우
                treeEdgeList.add(edge); // 간선을 최소 신장 트리에 추가
                union(edge.v1, edge.v2); // 두 정점을 하나의 집합으로 합침
            }
        }

        scanner.close();

        System.out.println(treeEdgeList);	// 최소 신장 트리의 간선 리스트 출력
    }

    private static void makeSet(int x) {	// 하나의 원소로 구성된 집합을 초기화
        parent[x] = x;
    }

    private static int findSet(int x) {	// x가 속한 집합의 대표 원소를 찾음
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    private static void union(int x, int y) {	// x와 y가 속한 두 집합을 합침
        int rootX = findSet(x); // x의 루트
        int rootY = findSet(y); // y의 루트
        if (rootX != rootY) { // 다르면
            parent[rootY] = rootX; // y의 루트를 x의 루트로 변경
        }
    }
}
