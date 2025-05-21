package hw6_1;

public class Main_202014008 {

    public static void main(String[] args) {
        System.out.println("hw6_1:김민서");
        
        // 연산에 사용할 키값 배열 초기화
        int[] addList = {13, 6, 2, 10, 1, 5, 7, 11, 4, 3, 8, 9, 3, 6, 10, 13};
        
        // 검색할 키 값 배열 초기화
        int[] searchList = {12, 3, 6, 10, 13};
        
        // 삭제할 키 값 배열 초기화
        int[] removeList = {12, 3, 6, 10, 13, 2, 1, 5, 4, 7, 8, 9, 11};

        // 정수 키값을 저장할 공백 이진검색트리 tree를 생성
        MyBinarySearchTree tree = new MyBinarySearchTree();

        // 키 값을 이진검색트리에 추가
        for (int i = 0; i < addList.length; i++) {
            tree.add(addList[i]);
        }
        
        // 이진검색트리에 저장된 키 값 출력
        tree.inorder();
        
        // 검색한 키 값의 존재 여부 출력
        for (int i = 0; i < searchList.length; i++) {
            System.out.print(tree.contains(searchList[i]) + " ");
        }
        System.out.println();
        
        // 이진검색트리에 저장된 모든 키 값의 합 출력
        System.out.println(tree.sum());

        // 키 값을 이진검색트리에서 제거
        for (int i = 0; i < removeList.length; i++) {
            tree.remove(removeList[i]);
        }

        // 키 값이 제거된 이진검색트리 출력
        tree.inorder();
        
        // 제거 후 이진검색트리에 저장된 모든 키 값의 합 출력
        System.out.println(tree.sum());
    }
}

class MyBinarySearchTree {	// 정수 키값을 갖는 이진검색트리를 구현

    private Node root = null;
    
    private class Node {    // 노드의 구조를 정의
        int key;
        Node left;
        Node right;
    }

    public void add(int key) {    // 키 값을 이진검색트리에 추가
        root = treeInsert(root, key);
    }

    private Node treeInsert(Node t, int key) {    // 이진검색트리에 키 값을 추가
        if (t == null) {
            Node r = new Node();
            r.key = key;
            return r;
        } else if (key < t.key) {
            t.left = treeInsert(t.left, key);
            return t;
        } else if (key > t.key) {
            t.right = treeInsert(t.right, key);
            return t;
        } else {
            return t;	
        }
    }
    
    public void inorder() {    // 중위 순회를 통해 이진검색트리의 모든 키 값을 출력하는 메서드
        System.out.print("( ");
        inorder(root);
        System.out.println(")");
    }

    private void inorder(Node t) {    // 중위 순회를 통해 트리를 순회하는 메서드
        if (t != null) {
            inorder(t.left);
            System.out.print(t.key + " ");
            inorder(t.right);
        }
    }

    public boolean contains(int key) {    // 주어진 키 값이 이진검색트리에 존재하는지 확인
        return contains(root, key);
    }
    private boolean contains(Node node, int key) {
        for (Node current = node; current != null;) {
            if (key == current.key) {
                return true;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public int sum() {    // 이진검색트리에 저장된 모든 키 값의 합을 계산하는 메서드
        return sum(root);
    }
    private int sum(Node t) {
        if (t == null) {
            return 0;
        }
        return t.key + sum(t.left) + sum(t.right);
    }

    public void remove(int key) {    // 주어진 키 값을 이진검색트리에서 제거하는 메서드
        root = treeDelete(root, key);
    }

    private Node treeDelete(Node r, int key) {	    // 주어진 키 값을 이진검색트리에서 제거하는 메서드
        if (r == null) {
            return null;
        }
 
        if (key < r.key) {
            r.left = treeDelete(r.left, key);
        } else if (key > r.key) {
            r.right = treeDelete(r.right, key);
        } else {
            if (r.left == null) {
                return r.right;
            } else if (r.right == null) {
                return r.left;
            }

            r.key = minValue(r.right);
            r.right = treeDelete(r.right, r.key);
        }
        return r;
    }
    
    private int minValue(Node node) {    // 주어진 노드의 가장 작은 키 값을 찾는 메서드
        int minv = node.key;
        while (node.left != null) {
            minv = node.left.key;
            node = node.left;
        }
        return minv;
    }
}