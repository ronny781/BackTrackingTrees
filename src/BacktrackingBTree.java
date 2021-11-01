

import java.util.*;


public class BacktrackingBTree<T extends Comparable<T>> extends BTree<T> {

	public static class listElements<T extends Comparable<T>>{

		public Node leftNode;
		public Node rightNode;
		public Node insertedNode;
		public T insertedValue;
		public Node splittedNode;

		//This constructor meant create an element that will keep information regarding a Node split.
		public listElements(Node splittedNode, Node leftNode ,Node rightNode) {
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.splittedNode = splittedNode;
		}
		//This constructor meant create an element that will keep information of an inserted value to the tree.
		public listElements(T insertedValue, Node insertedNode ) {
			this.insertedValue = insertedValue;
			this.insertedNode = insertedNode;

		}

	}
	public BacktrackingBTree(int order) {
		super(order);
		}
	public BacktrackingBTree() {
		super();
	}


	public void Backtrack() {
		IntegrityStatement.signature(); // Reminder!
		if(!backTrackList.isEmpty()) {
			Deque<Object> list = (Deque<Object>) backTrackList.removeFirst();
			listElements element = (listElements) list.removeFirst();
			element.insertedNode.removeKey(element.insertedValue); //Remove the last value that has been inserted.
			while(!list.isEmpty()) {//If we have reached so far what's left is to undo the splits
				listElements element1 = (listElements) list.removeFirst();
				merge(element1.splittedNode,element1.leftNode,element1.rightNode);
			}
		}
	}

	//Change the list returned to a list of integers answering the requirements
	public static List<Integer> BTreeBacktrackingCounterExample(){
		IntegrityStatement.signature(); // Reminder!
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		return list;
	}

	private void merge(Node<T> splittedNode,Node<T> left,Node<T> right) {

		if(splittedNode.parent == root && root.numOfKeys == 1) {
			splittedNode.parent.removeChild(right); //Delete right child
			splittedNode.parent.removeChild(left); //Delete right child
			splittedNode.parent.removeKey(splittedNode.keys[splittedNode.getNumberOfKeys()/2]);//Remove the median key
			root = splittedNode;
		}//Insert the node before the split has occurred.
		else {
			splittedNode.parent.removeChild(right); //Delete right child
			splittedNode.parent.removeChild(left); //Delete right child
			splittedNode.parent.removeKey(splittedNode.keys[splittedNode.getNumberOfKeys()/2]); //Remove the median key
			splittedNode.parent.addChild(splittedNode);//Insert the node before the split has occurred.
				
			}
	}




	public static void main(String [] args) {
		BacktrackingBTree<Integer> tree = new BacktrackingBTree<Integer>();
//		tree.insert(19);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(16);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(5);


	}

}
//

