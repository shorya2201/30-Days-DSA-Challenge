
class Solution
{
        //static  Node prev = null;
    public static void flatten(Node root)
    {
  //Morris traversala algorithm practical application
      
      //Creating a stack
      Stack<Node> st = new Stack<>();
      //pushing root node into stack so that we can start our loop and the root will be our first node also.
      st.push(root);
      
      Node curr = null;
      while(!st.empty()){
        //store the top value into current node to traverse it
          curr= st.peek();
          st.pop(); //remove that node
        //explore right and left child of node
          if(curr.right!=null) st.push(curr.right);
          if(curr.left!=null) st.push(curr.left);
        //rearranging nodes as fixing top value as right child and marking null to left child as its value is already stored in stack
          if(!st.empty()){
          curr.right = st.peek();
          curr.left = null;
          }
      }
    }
}
