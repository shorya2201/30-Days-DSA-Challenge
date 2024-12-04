/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// Java Program to sort a linked list of 0s, 1s or 2s

class Node {
    int data;
    Node next;
    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Function to sort a linked list of 0s, 1s and 2s
public class Main {
  
    static Node sortList(Node head) {
      
        if(head==null || head.next == null) return head;

      //creating dummy heads for connecting
        Node zHead = new Node(-1);
        Node oHead = new Node(-1);
        Node tHead = new Node(-1);
        //creating dummy nodes for traversal
        Node zero = zHead;
        Node one = oHead;
        Node two = tHead;
        Node temp = head;
        //storing data into dummy nodes making them individual LL in themselves
        while(temp!=null){
            if(temp.data == 0){
            zero.next = temp;
            zero = zero.next;
            }
            else if(temp.data == 1){
              one.next = temp;
              one = one.next;
            } 
            else{
             two.next = temp;
             two = two.next;
            }
            temp = temp.next;
        }
        
        zero.next=oHead.next!=null?oHead.next:tHead.next;// will be connected to either 1's head next or 2's head next.
        one.next = tHead.next;//in any case will be connected to 2's next.
        two.next = null;//for any given situation it will only be connected to null
        
        Node res = zHead.next;
        
        return res;
        
        
        
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        // Create a hard-coded linked list:
        // 1 -> 1 -> 2 -> 1 -> 0 -> NULL
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        System.out.print("Linked List before Sorting:");
        printList(head);

        Node r = sortList(head);

        System.out.print("Linked List after Sorting:");
        printList(r);
    }
}
