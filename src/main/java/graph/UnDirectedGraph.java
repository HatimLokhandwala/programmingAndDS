package graph;

/**
 * Created by hatim.lokhandwala on 14/07/19.
 */
public class UnDirectedGraph extends BaseGraph {

	UnDirectedGraph(int vertices){
		super(vertices);
	}

	@Override
	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}
}
