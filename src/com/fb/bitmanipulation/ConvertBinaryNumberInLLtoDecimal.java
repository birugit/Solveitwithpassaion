package com.fb.bitmanipulation;

/**
 * @author swamy on 3/9/21
 */
public class ConvertBinaryNumberInLLtoDecimal {
    static class LinkedNode{
        int val;
        LinkedNode next;
        public LinkedNode(int val){
            this.val = val;
        }
    }
  public static void main(String[] args) {
      ConvertBinaryNumberInLLtoDecimal c = new ConvertBinaryNumberInLLtoDecimal();
      LinkedNode head = new LinkedNode(1);
      head.next = new LinkedNode(0);
      head.next.next = new LinkedNode(1);

     int res =  c.convertToDecomal(head);
     System.out.println(res);
     System.out.print(c.getDecimalValue(head));
  }

  /**
   * We initialise an integer variable num to 0. For each node in the linked list, we will left
   * shift num by 1 position to make way for the val in the next node in linked list. This is same
   * as multiplying num by 2, but using the left shift operator makes it easier to visualise how the
   * binary number is being made. For eg. if num in binary is 10, after left shift it would become
   * 100.
   *
   * @param head
   * @return Here is the mathematical visualization. Hope this helps. (10110)2 = (22)10
   *     <p>initially sum = 0
   *     steps: 1. sum * 2 = sum ( or left shift)
   *             2. sum + 1 or 0 = sum then
   *     goes to step 1 and loops until head!=null ---------------------------------------
   *     left shift 1 => ( 0 * 2 ) = 0
   *     After sum => 0 + 1 = 1
   *     left shift 1 => ( 1 * 2 ) = 2
   *     After sum => 2 + 0 = 2
   *     left shift 1 => ( 2 * 2 ) = 4
   *     After sum => 4 + 1 = 5
   *     left shift 1 => ( 5 * 2 ) = 10
   *     After sum => 10 + 1 = 11
   *     left shift 1 => ( 11 * 2 ) = 22
   *     After sum => 22 + 0 = 22
   */
  public int getDecimalValue(LinkedNode head) {
        int num = 0;                // Initialise num to 0
        while(head!=null) {         // Iteratore over the linked list until head is null
            num <<= 1;              // Left shift num by 1 position to make way for next bit
            num += head.val;        // Add next bit to num at least significant position
            head = head.next;       // Update head
        }
        return num;
      /**
       * input 101
       num =0
       loop start
       0 * 2 = 0 //num<<=1
       0 + 1 = 1 //num+=head.val
       head = head.next
       1 * 2 = 2
       2 + 0 = 2
       head = head.next
       2 * 2 = 4
       4 + 1 = 5
       head = head.next

       */
  }

    /**
     * using java parseInt
     * @param head
     * @return
     */
    private int convertToDecomal(LinkedNode head) {
        String s = "";
        while(head!= null){
            s += Integer.toString(head.val);
            head = head.next;
        }
        return Integer.parseInt(s, 2);
    }

}
