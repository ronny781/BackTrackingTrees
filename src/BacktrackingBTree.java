

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
					root = splittedNode;}//Insert the node before the split has occurred.
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
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(2);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(122);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(17);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(23);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(80);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(70);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(60);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(54);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(32);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(95);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(25);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(7);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(1);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		tree.insert(0);
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");

		for(int i = 0; i< 100; i++){
			Random rand = new Random();
			int rand_int1 = rand.nextInt(1000);
			tree.insert(rand_int1);
			System.out.println(tree.toString());;
			System.out.println("/////////////////////////////");
		}
		for(int i = 0; i< 100; i++){
			System.out.println("BackTrack" +i);
			tree.Backtrack();
			System.out.println(tree.toString());;
			System.out.println("/////////////////////////////");
		}
//		System.out.println("BackTrack #1");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #2");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #3");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #4");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #5");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #6");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #7");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #8");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #9");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #10");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #11");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #12");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #13");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #14");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #15");
//		tree.Backtrack();
//		System.out.println(tree.toString());;
//		System.out.println("/////////////////////////////");
//		System.out.println("BackTrack #16");
//		tree.Backtrack();
//		System.out.println(tree.toString());;



	}

}
//

