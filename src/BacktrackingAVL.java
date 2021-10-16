

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;






public class BacktrackingAVL extends AVLTree {
	public static class dequeElements{
		//Cases: 
		//    	0 = No rotations applied
		//    	1 = LL
		//    	2 = LR
		//    	3 = RR
		//    	4 = RL
		protected int caseNum; // The insertion case
		protected Node node; // The node we need to apply reverse rotations
		protected Node inserted; // The inserted node we need to delete at the end of backtracking

		public dequeElements(int caseNum,  Node node ,Node inserted) {
			this.caseNum = caseNum;
			this.node = node;
			this.inserted = inserted;
		}
	}
	//You are to implement the function Backtrack.
    public void Backtrack() {
    	IntegrityStatement.signature(); // Do not remove this line
      if(!deque.isEmpty()) {
    	  dequeElements element = (dequeElements) deque.removeLast();
    	  if (this.root.height == 1)
    		  this.root = null;
    	  else {
	    	  switch(element.caseNum) {
	    	  
	    	  case 0:
	    		  Node temp = element.inserted.parent;
	    		  delete(element.inserted);	
	    		  fixHeight(temp);
	    		
	    		  break;
	    	  case 1:
	    		  if(element.node.parent == null) { //root
	    			  element.node.parent = leftRotate(element.node);
	    			  this.root = element.node.parent;
	    		  }
	    		  else 
	    			  if (element.node.parent.right == element.node)
	    				  element.node.parent.right = leftRotate(element.node);
	    			  else
	    				  element.node.parent.left = leftRotate(element.node); 
	    		  Node temp1 = element.inserted.parent;
	    		  delete(element.inserted);	
	    		  fixHeight(temp1);
	    		  break;
	    	  case 2:
	    		  if(element.node.parent == null) { //root
	    			  element.node.parent = leftRotate(element.node);
	    			  this.root = element.node.parent;
	    			  element.node.parent.left = rightRotate(element.node);	  
	    		  }
	    		  else {
	    			  if (element.node.parent.right == element.node)
	    				  element.node.parent.right = leftRotate(element.node);
	    			  else
	    				  element.node.parent.left = leftRotate(element.node); 
	    			  element.node.parent.left = rightRotate(element.node);
	    		  }
	    		  Node temp2 = element.inserted.parent;
	    		  delete(element.inserted);	
	    		  fixHeight(temp2);
	    		  break;
	    	  case 3:
	    		  if(element.node.parent == null) {  //root
	    			  element.node.parent = rightRotate(element.node);
	    			  this.root = element.node.parent;

	    		  }
	    		  else
	    			  if (element.node.parent.right == element.node)
	    				  element.node.parent.right = rightRotate(element.node);
	    			  else
	    				  element.node.parent.left = rightRotate(element.node); 
	    		  Node temp3 = element.inserted.parent;
	    		  delete(element.inserted);	
	    		  fixHeight(temp3);
	    		  break;
	    	  case 4:
	    		  if(element.node.parent == null) { //root
	    			  element.node.parent = rightRotate(element.node);
	    			  this.root = element.node.parent;
	    			  element.node.parent.right = leftRotate(element.node);
	    		  }
	    		  else {
	    			  if (element.node.parent.right == element.node)
	    				  element.node.parent.right = rightRotate(element.node);
	    			  else
	    				  element.node.parent.left = rightRotate(element.node); 
	    			  element.node.parent.right = leftRotate(element.node);
	    		  }
	    		  Node temp4 = element.inserted.parent;
	    		  delete(element.inserted);	
	    		  fixHeight(temp4);
	    		  break;   		 
	    	  }
    	  }
    	  
    		  
      } 
    }
    // Delete inserted node after rotations are done
    private void delete (Node x) { 
    	if (x.parent.left == x) {
    		x.parent.left = null;
    	}
    	else {
    		x.parent.right = null;
    	x.parent = null;
    	}
    }
    // Fixing heights after deletion
    private void fixHeight(Node x) {
    	if (x == null)
    		return;
    	int height = x.height;
    	updateHeight(x);
    	if (height == x.height)
    		return;
    	fixHeight(x.parent);
    }

	protected int getNodeHeight(Node node) {
		return (node==null) ? 0 : node.height;
	}

	private void updateHeight(Node n) {
		n.height = Math.max(getNodeHeight(n.left), getNodeHeight(n.right)) + 1;
	}

    
    //Change the list returned to a list of integers answering the requirements
	public static List<Integer> AVLTreeBacktrackingCounterExample(){
        IntegrityStatement.signature(); // Do not remove this line
        List<Integer> counterExample = new LinkedList<Integer>();
        counterExample.add(3);
        counterExample.add(2);
        counterExample.add(1);
        return counterExample;
    }
    public static void main(String[] args){
     	BacktrackingAVL tree = new BacktrackingAVL();
    	tree.insert(10);
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.insert(8);    	
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.insert(17);
    	tree.printTree();
     	System.out.println("--------------------------------");
    	tree.insert(16);
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.insert(15);
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.insert(11);
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.insert(7);
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.Backtrack();
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.Backtrack();
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.Backtrack();
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.Backtrack();
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.Backtrack();
    	tree.printTree();
    	System.out.println("--------------------------------");
    	tree.Backtrack();
    	tree.printTree();
    	System.out.println("--------------------------------");

    	
    }
    

    
  
}
