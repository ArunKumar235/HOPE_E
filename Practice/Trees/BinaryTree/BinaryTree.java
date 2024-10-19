package Practice.Trees.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {

    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner sc){
        System.out.println("Enter the root Node: ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(root, sc);
    }

    private void populate(Node node, Scanner sc) {
        System.out.println("Do you want to add a left child to " + node.value + "? (y/n)");
        if(sc.next().equals("y")) {
            System.out.println("Enter the value of the left child: ");
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(node.left, sc);
        }

        System.out.println("Do you want to add a right child to " + node.value + "? (y/n)");
        if(sc.next().equals("y")) {
            System.out.println("Enter the value of the right child: ");
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(node.right, sc);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void display() {
        display(this.root, " ");
    }

    private void display(Node node, String indent) {
        if(node == null) {
            return;
        }

        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    public void bfs(){
        bfs(root, new ArrayDeque<>());
    }

    private void bfs(Node node, Queue<Node> queue){
        if(node == null){
            return;
        }
        queue.offer(node);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.value + " ");
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }
}