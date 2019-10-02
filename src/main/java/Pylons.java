import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hatim.lokhandwala on 13/04/19.
 */
//Problem Statment: https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104e03
public class Pylons {
	private static final String POSSIBLE = " POSSIBLE";
	private static final String IMPOSSIBLE = " IMPOSSIBLE";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases  = sc.nextInt();
		int count = 1;
		int row, column;
		while(count<=testCases){
			row = sc.nextInt();
			column = sc.nextInt();
			compute(row,column, count);
			count++;

		}
	}

	private static void compute(int row, int column, int index) {
		boolean flag = true;
		Graph g = new Graph(row, column);

		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				flag = false;
				if( ((i + 1) <= row && (j + 2) <= column)) {
					flag = true;
				}
				if(((i + 1) <= row && (j - 2) >= 1)){
					flag = true;
				}
				if ((i - 1) >= 1 && (j+2) <=column) {
					flag = true;
				}
				if	(((i - 1) >=1 && (j-2) >=1) ){
					flag = true;
				}
				if(!flag) break;
			}
		}

		if(flag){
			boolean traverseFlag = false;
			for(int i=1;i<= (row*column); i++){
				g.clearPathAndMarkVisitFalse();
				g.traverse(i);

				if(g.checkAllVisited()){
					System.out.println("Case #" + index + ":" + POSSIBLE);
					g.printPath();
					traverseFlag = true;
					break;
				}
			}
			if(!traverseFlag)
				System.out.println("Case #" + index + ":" + IMPOSSIBLE);
		}
		else {
			System.out.println("Case #" + index + ":" + IMPOSSIBLE);
		}

	}

}
class Graph{
	int nodes;
	Node nodeList[];
	List<Integer> path;
	int row,column;
	Graph(int row, int column){
		this.row = row;
		this.column = column;
		this.nodes = row*column;
		nodeList = new Node[nodes+1];
		assign(row, column);
		path = new ArrayList<Integer>();
	}
	private void assign(int row, int column){
		nodeList[0] = new Node(-1 ,-1, -1);
		int nodeNumber = 1;
		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				nodeList[nodeNumber] = new Node(i,j, nodeNumber);
				nodeNumber++;
			}
		}

		for(int i=1;i<=nodes ;i++){
			for(int j=1;j<=nodes;j++){
				if (!(i == j || nodeList[i].x == nodeList[j].x || nodeList[i].y == nodeList[j].y
				|| ((nodeList[i].x - nodeList[i].y) ==  (nodeList[j].x - nodeList[j].y))
				|| ((nodeList[i].x + nodeList[i].y) ==  (nodeList[j].x + nodeList[j].y))) ) {
					addEdge(i,j);
				}
			}
		}
	}


	void addEdge(int n1, int n2){
		nodeList[n1].addEdge(nodeList[n2]);
	}
	void clearPathAndMarkVisitFalse(){
		path.clear();
		for(Node n: nodeList){
			n.setMarkedFalse();
		}
	}

	void printPath(){
		for(int number: path){
			System.out.println(nodeList[number].x + " " + nodeList[number].y);
		}
	}

	void traverse(int start){
//		if(nodeList[start].getMarked()) return;
		path.add(start);
		nodeList[start].setMarkedTrue();
		for (Node anAdj : nodeList[start].adj) {
			if(!anAdj.getMarked())
				traverse(anAdj.nodeNumber);
		}
	}

	boolean checkAllVisited(){
		for(Node n: nodeList){
			if( n.nodeNumber != -1 && !n.getMarked()) return false;
		}
		return true;
	}


}

class Node{
	int x;
	int y;
	int nodeNumber;
	private boolean isMarked;
	List<Node> adj;
	Node(int x , int y, int nodeNumber){
		this.x = x;
		this.y = y;
		this.nodeNumber = nodeNumber;
		isMarked = false;
		adj = new ArrayList<Node>();
	}
	void setMarkedFalse(){
		isMarked = false;
	}

	void setMarkedTrue(){
		isMarked = true;
	}

	boolean getMarked(){
		return isMarked;
	}

	void addEdge(Node n){
		adj.add(n);
	}

	void deleteEdge(Node n){
		adj.remove(n);
	}
}
