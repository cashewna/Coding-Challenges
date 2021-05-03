import java.util.Scanner;

public class ReverseDLL {
  public static class DLL {
    Node head;
    Node tail;

    /** Doubly linked list Node */
    static class Node {
      int data;
      Node prev;
      Node next;

      /**
       * Constructor to create a new node. <br>
       * Next and previous are NULL by default.
       *
       * @param d Node data
       */
      Node(int d) {
        data = d;
      }
    }

    /**
     * Add a node at the end of the list.
     *
     * @param data New data to be appended.
     */
    void append(int data) {
      Node new_node = new Node(data);
      new_node.next = null;

      /* If the DLL is empty, make new head and tail node from input */
      if (head == null) {
        new_node.prev = null;
        head = tail = new_node;
        return;
      }

      /* Else append to the end of the list */
      tail.next = new_node;
      new_node.prev = tail;
      tail = new_node;
    }

    /**
     * Print DLL from the given node.
     *
     * @param node Starting node.
     */
    void printList(Node node) {
      Node current; // default none

      while (node != null) {
        System.out.print(node.data + " ");
        current = node;
        node = current.next;
      }
      System.out.println();
    }

    /** Reverse a DLL */
    void reverse() {
      Node temp = null;
      Node current = head;

      /* Swap next and previous for all nodes in DLL */
      while (current != null) {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;
        current = current.prev;
      }

      /* Check for empty lists or lists with only one node. */
      if (temp != null) {
        head = temp.prev;
      }
    }

    /**
     * Delete a DLL <br>
     * Java does garbage collection automatically
     */
    void deleteList() {
      head = null;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt(); // number of cases
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    DLL dll = new DLL();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt(); // number of elements per case
      for (int j = 0; j < n; j++) {
        dll.append(scanner.nextInt());
      }
      dll.reverse();
      dll.printList(dll.head);
      dll.deleteList();
    }
  }
}
