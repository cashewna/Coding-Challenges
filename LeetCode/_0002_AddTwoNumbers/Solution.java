package _0002_AddTwoNumbers;

// 1. Initialise dummyHead as 0 and current pointer to head.
// 2. Initialise nodes p and q as list1 and list2 respectively.
// 3. Loop through p and q respectively until you reach both ends.
//  - set x to node p current. If p has reached the end of list1, set x to 0.
//  - set y to node q current. If q has reached the end of list2, set y to 0.
//  - sum = x + y + carry
//  - carry = sum / 10
//  - create a new node with the digit value of (sum mod 10) and set it to curr.next, then advance
// curr to curr.next.
//  - advance both p and q if they're not at the end of the list.
// 4. if carry == 1, append carry to the end of the list.
// 5. Return dummyHead next node.

public class Solution {
  public ListNode addTwoNumbers(ListNode list1, ListNode list2) {

    int carry = 0;
    ListNode dummyHead = new ListNode(0);
    ListNode p = list1, q = list2, curr = dummyHead;

    while (p != null || q != null) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;
      int sum = x + y + carry;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }

    if (carry == 1) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
    // dummyHead will point to ListNode(0) which is our null safe check, dummyHead.next
    // will point to the actual sum nodes.
  }
}
