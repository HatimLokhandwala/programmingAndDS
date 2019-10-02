package graph;

/**
 * Created by hatim.lokhandwala on 14/07/19.
 */
public class DirectedGraph extends BaseGraph {
	DirectedGraph(int vertices) {
		super(vertices);
	}

	@Override
	public void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
}
