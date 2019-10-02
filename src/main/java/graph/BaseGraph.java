package graph;

import com.sun.xml.internal.rngom.parse.host.Base;

import java.util.LinkedList;

/**
 * Created by hatim.lokhandwala on 16/07/19.
 */


public abstract class BaseGraph implements Graph {
	int vertices;
	LinkedList<Integer>[] adj;
	BaseGraph(int vertices) {
		this.vertices = vertices;
		adj = new LinkedList[this.vertices];
		for(int i=0; i<vertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public int getVertices() {
		return vertices;
	}
}
