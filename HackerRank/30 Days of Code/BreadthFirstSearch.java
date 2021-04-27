import java.util.*;
import java.io.*;

/**
 * Day 23
 * Also known as level-order traversal. You are given a pointer root pointing at the root of a binary search tree.
 * Print the BFS of a binary search tree.
 */
class Node {
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right = null;
    }
}
class BreadthFirstSearch {

    static void levelOrder(Node root){
        // Instantiate new queue
        Queue<Node> queue = new LinkedList<>();
        // Enqueue the pointer root
        queue.add(root);

        // While there are nodes in queue, pop and return the first node (dequeue) and print
        while(!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.data + " ");

            // If the returned node from above has left/right children, enqueue them, from left to right.
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static Node insert(Node root,int data){
        if(root == null) {
            return new Node(data);
        }
        else {
            Node cur;
            if(data <= root.data) {
                cur=insert(root.left,data);
                root.left=cur;
            }
            else {
                cur=insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    // Let T be the number of nodes
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while(T-->0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}