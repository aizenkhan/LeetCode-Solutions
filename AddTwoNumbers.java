/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // trivial case check
        if(l1 == null || l2 == null) return null;
        
        // use tailPointer to add new nodes to the end of the result list
        ListNode result = new ListNode(-1);
        ListNode tailPointer = result;
        int carry = 0;
        int sum = 0;
        
        // iterate till we have nodes to scan in any one of the lists
        while(l1 != null || l2 != null){
            
            // sum contains carry, then adds the values/digits of the two lists with null checks
            // replicates sum = carry + digit1 + digit2
            sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
               
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            // replicates sum%10 as the resultant sum and sum/10 as the resultant carry
            // makes use of the fact that when only two numbers are being added the carry generated can never exceed 1
            carry = 0;
            if(sum >= 10){
                sum-=10;
                carry = 1;
            }
            
            // make a new node with the resultant sum as its value
            // append the new node to the tail of the list using tailPointer
            tailPointer.next = new ListNode(sum);
            tailPointer = tailPointer.next;         
            
        }
               
        // take care of any extra carry that's generated by appending to the list as well
        if(carry == 1){
            tailPointer.next = new ListNode(carry);
        }
        
        // make sure to ignore the 1st node's value since it contains -1 (acts just like a "header" node)
        return result.next;
    }
}
