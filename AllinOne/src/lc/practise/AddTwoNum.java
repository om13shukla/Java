package lc.practise;
/**
 * 
 * @author oshukla
 *You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNum {

  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode listSum = new ListNode(0);
    ListNode largerList;
    ListNode smallerList;
    int l1Length = countListLength(l1);
    int l2Length = countListLength(l2);
    System.out.println("length1: " + l1Length + " length1: " + l2Length);
    if(l1Length >= l2Length) {
      largerList = l1;
      smallerList = l2;
    }
    else {
      largerList = l2;
      smallerList = l1;
    }

    int carry = 0, newDigit = 0;
    ListNode listSumRef = listSum;

    while(largerList != null) {
      if(largerList.next != null) { // EdgeCase: dont add a node if current node
                                    // is last node.
        listSumRef.next = new ListNode(0);
      } // System.out.print("\n largerList.val: " +largerList.val+"
        // smallerList.val: " +smallerList.val);

      int digitSum = largerList.val;
      if(smallerList != null) {
        digitSum += smallerList.val;
      }
      digitSum += carry;
      carry = 0;
      newDigit = digitSum;
      if(newDigit > 9) {
        carry = digitSum / 10;
        newDigit = digitSum % 10;
      }
      listSumRef.val = newDigit;
      System.out.print("  || carry: " + carry + "  newDigit: " + newDigit);
      digitSum = 0;
      newDigit = 0;

      largerList = largerList.next;
      if(smallerList != null) {
        smallerList = smallerList.next;
      }

      if(largerList == null && carry != 0) {
        listSumRef.next = new ListNode(carry); // EdgeCase: we still need to add
                                               // a node if we have carry from
                                               // previous Sum.
        break;
      }

      listSumRef = listSumRef.next;
      printList(listSum);
    }
    return listSum;

  }

  public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  static int countListLength(ListNode l1) {
    int length = 0;
    ListNode l1Ref = l1;
    boolean counterBreak = false;
    while(!counterBreak) {
      if(l1Ref.next != null) {
        length++;
        l1Ref = l1Ref.next;
      }
      else {
        length++; // count the current node
        counterBreak = true;
      }

    }
    return length;
  }

  static int printList(ListNode l1) {
    int length = 0;
    ListNode l1Ref = l1;
    System.out.print("\n[");
    while(l1Ref.next != null) {
      length++;
      System.out.print(l1Ref.val + ", ");
      l1Ref = l1Ref.next;
    }
    System.out.print(l1Ref.val);
    System.out.print("]");
    return length;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
