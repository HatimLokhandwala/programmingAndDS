package Tree;

/**
 * Created by hatim.lokhandwala on 12/05/19.
 */
public class ReverseTreePath {
}

//https://codeshare.io/areYDZ
//
//	Write code to reverse path from root to given node in a binary tree.
//
//		4
//		/  \
//		5    8
//
//
//		/ \   / \
//		6   9  10 --- 8  3
//		/
//		2 -- 4
//
//		Node - 2
//
//		2
//		/  \
//		5    10
//		/ \   / \
//		6   9  8  3
//		/
//		4
//
//		Class Node{
//private int data;
//		Node left;
//		Node right;
//		Node(){
//		this.data = data;
//		this.left = null;
//		this.right = null;
//		}
//		}
//
//class Solution{
//	boolean searchValue(Node head, int searchValue, List<Node> pathList){
//		if(head == null ) return false;
//		if(head.data == searchValue){
//			pathList.add(head);
//			return true;
//		}
//		if(searchValue(head.left, searchValue)){
//			pathList.add(head);
//			return true;
//		}
//
//		if(searchValue(head.right, searchValue)){
//			pathList.add(head);
//			return true;
//		}
//		return false;
//	}
//
//	boolean reversePath(List<Node> pathList){
//		int start =0;
//		int end = pathList.size()-1;
//		while(start<end){
//			Node a = pathList.get(start);
//			Node b = pathList.get(end);
//			int temp = a.data;
//			a.data = b.data;
//			b.data = temp;
//			start++;
//			end--;
//		}
//	}
//
//
//	void reversePath(Node head, int searchValue){
//		if(head == null ) return;
//		if(searchNode(head,searchValue)){
//			List<Node> pathList = new ArrayList();
//			if(travsereTree(head, searchValue, pathList)){
//				reversePath(pathList,serachValue,head);
//			}
//
//		}
//	}
//
//
//	public static void main(String args[]){
//
//	}
//}
//
//
