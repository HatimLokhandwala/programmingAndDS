//package graph;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created by hatim.lokhandwala on 21/05/19.
// */
//
//class Graph{
//	int nVertices;
//	List<Integer> adjList[];
////	Graph g;
//
//	Graph(int nVertices){
//		this.nVertices = nVertices;
//		adjList = new ArrayList[nVertices];
//		for(int i=0;i<nVertices;i++){
//			adjList[i] = new ArrayList<Integer>();
//		}
////		g= null;
////		initiateObject();
//
//	}
//
//	public void addEdge(int src, int dest) {
//		adjList[src].add(dest);
//		adjList[dest].add(src);
//	}
//
//	public void DFSTraverseUtil(){
//		boolean visited[] = new boolean[nVertices];
//		for(int i=0;i<nVertices;i++){
//			visited[i] = false;
//		}
//		for(int i=0;i<nVertices;i++){
//			if(!visited[i]){
//				visited[i] = true;
//				DFSTraverse(i, visited);
//			}
//		}
//
//	}
//
//	private void DFSTraverse(int index, boolean visited[]){
//		System.out.println(index);
//		Iterator<Integer> it = adjList[index].listIterator()
//		Iterator it = adjList[index].iterator();
//		while(it.hasNext()){
//			Integer adj = (Integer)it.next();
//			if(!visited[adj]){
//				visited[adj] = true;
//				DFSTraverse(adj, visited);
//			}
//		}
//	}
////	private Graph initiateObject() {
////		if(g==null) g = new Graph(10);
////		return g;
//// 	}
//
//
//}
//public class DFSTraversal {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int vertices = sc.nextInt();
//		Graph g = new Graph(vertices);
//		int edges = sc.nextInt();
//		while(edges>0){
//			int src = sc.nextInt();
//			int dest = sc.nextInt();
//			g.addEdge(src,dest);
//			edges--;
//		}
//		g.DFSTraverseUtil();
//
//
//		try{
//
//		} catch(Exception e) {
//
//		}
//	}
//
//
//
//
//
//}
