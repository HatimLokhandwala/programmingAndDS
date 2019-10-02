package graph;

import java.util.*;

/**
 * Created by hatim.lokhandwala on 16/07/19.
 */

class Node{
	int id;
	int weight;
	Node(int id, int weight) {
		this.id = id;
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		Node that = (Node)obj;
		return this.id == that.id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}
}

class GraphNode {
	int id;
	int weight;
	GraphNode(int id, int weight){
		this.id = id;
		this.weight = weight;
	}
}

class PrimGraph{
	LinkedList<GraphNode>[] adj;
	int vertices;
	PrimGraph(int vertices) {
		this.vertices = vertices;
		adj = new LinkedList[this.vertices];
		for(int i=0; i<vertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	void addEdge(int src, int dest, int weight) {
		adj[src].add(new GraphNode(dest, weight));
		adj[dest].add(new GraphNode(src, weight));
	}
}

class Solution{
	List<PrimsAlgorithm.Edge> primsImplementation(PrimGraph graph) {
		Set<Integer> mstSet = new HashSet<>();
		TreeSet<Node> queue = new TreeSet<>((n1, n2) -> n1.weight - n2.weight);
		Node[] nodeArr = new Node[graph.vertices];
		int[] parent = new int[graph.vertices];
		nodeArr[0] = new Node(0, 0);
		parent[0] = -1;
		for(int i=1; i<nodeArr.length; i++) {
			nodeArr[i] = new Node(i, Integer.MAX_VALUE);
			parent[i] = -1;
		}
		queue.add(nodeArr[0]);
//		for(int i = 1; i < graph.vertices; i++) {
//			queue.add(new Node(i, Integer.MAX_VALUE));
//		}
		while(mstSet.size() < graph.vertices) {
			Node node = queue.first();
			queue.remove(node);
//			queue.remove()
			mstSet.add(node.id);
			LinkedList<GraphNode> adjList = graph.adj[node.id];
			for (GraphNode graphNode: adjList) {
				if(!mstSet.contains(graphNode.id)) {
					if(nodeArr[graphNode.id].weight > (node.weight + graphNode.weight)) {
						nodeArr[graphNode.id].weight = (node.weight + graphNode.weight);
						parent[graphNode.id] = node.id;
					}
					if(!queue.contains(nodeArr[graphNode.id])){
						queue.add(nodeArr[graphNode.id]);
					}

				}
			}
			System.out.println(node.id + "------------");
			for (Node node1 : queue) {
				System.out.println(node1.id + " "  + node1.weight);
			}
		}
		System.out.println( queue.size());
		for(int i=0; i<parent.length;i++) {
			System.out.println(parent[i]);
		}
		return Collections.emptyList();
	}
}
public class PrimsAlgorithm {
	class Edge{
		int src;
		int dest;
		int weight;
	}



	public static void main(String[] args) {
		PrimGraph unDirectedGraph = new PrimGraph(4);
		unDirectedGraph.addEdge(0,1, 2);
		unDirectedGraph.addEdge(0,3, 2);
//		unDirectedGraph.addEdge(0,3, 2);
		unDirectedGraph.addEdge(1,2, 2);
//		unDirectedGraph.addEdge(0,2, 2);
		unDirectedGraph.addEdge(2,3, 4);
		Solution s= new Solution();
		s.primsImplementation(unDirectedGraph);

//		TreeSet<Node> treeSet = new TreeSet<>((t1, t2) -> t1.weight - t2.weight);
//		System.out.println(treeSet.add(new Node(1, 100)));
//		System.out.println(treeSet.add(new Node(213, 100)));
//		System.out.println("===" + treeSet.size());
//		TreeSet<Node> treeSet2 = new TreeSet<>((t1, t2) -> t1.weight - t2.weight);
//		treeSet2.add(new Node(2, 10012));
//		System.out.println("===" + treeSet.equals(treeSet2));


	}
}


//intialize zero weight to one vertex
//initialize empty set to maintain all the included vertices
//loop to find minimum weight vertex
//update the weights of all the adjacent vertices



//0   1    0
//1 3  2   1
//2 3  2
