
class Solution {

  //helper function which will add the 1 to number and return carry and helps driver function to decide wheather there is a need to create a new node or not, 
 // by returning carry as 0 or 1. Consider case of 999 it return 1, and for 121 it return 0.
    public int helperAdd(Node temp){
      
        if(temp==null)
        return 1;//if reaches at end of LL, returns 1 which will be added to number starting from end.....BACKTRACKING
        int carry = helperAdd(temp.next);//RECURSIVE CALLS
        temp.data = temp.data+carry;//adds 1 or carry if present
        if(temp.data<10) return 0;//if value after add if greater than 10 or no carry is there, returns 0 to save time traversing the remaining LL
        temp.data = 0;//if carry is there or value is greater than 10, return 1 indicating that further addition is required.
        return 1;
    }

  //driver function which will add 1 to the number represented as linked list
    public Node addOne(Node head) {
        int carry = helperAdd(head);//it will store the carry we get from helper method
        
        if(carry==1){//if carry is 1. consider example of 999.
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
      // if carry is 0, it returns the new number generated after adding 1.
        return head;
    }
}
