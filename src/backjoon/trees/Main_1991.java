package backjoon.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991 {
    static class Node {
        char data;
        Node left, right;
        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static int N;
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        root = new Node('A', null, null);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insert(root, data, left, right);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

        br.close();
    }

    static void insert(Node root, char data, char left, char right) {
        if(root.data == data) {
            root.left = left=='.'? null: new Node(left, null, null);
            root.right = right=='.'? null: new Node(right, null, null);
        } else {
            if(root.left != null) insert(root.left, data, left, right);
            if(root.right != null) insert(root.right, data, left, right);
        }
    }

    static void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

}