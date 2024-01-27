package ph.edu.upm.cas.dpsm.rbchua;

import java.util.*;
import java.util.function.Consumer;

public class MatrixGraph extends AbstractGraph {

	private double[][] edges;

	public MatrixGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new double[numV][numV];
		for(int i=0; i<numV; i++){
			for(int j=0; j<numV; j++){
				edges[i][j] = Double.POSITIVE_INFINITY;
			}
		}
	}
	
	public boolean isEdge(int source, int dest){return edges[source][dest] != Double.POSITIVE_INFINITY;}
	
	public void insert(Edge edge){
		edges[edge.getSource()][edge.getDest()] = edge.getWeight();
		if(!isDirected()){
			edges[edge.getDest()][edge.getSource()] = edge.getWeight();
		}
	}
	
	private class Iter<Edge> implements Iterator {
		 
		private Queue<Edge> adjacentEdges;
	
		public Iter(Queue<Edge> adjacentEdges){this.adjacentEdges = adjacentEdges;}

		public void forEachRemaining(Consumer arg0) {((Iterator) adjacentEdges).forEachRemaining(arg0);}

		public boolean hasNext() {return adjacentEdges.peek() != null;}

		public Object next() {return adjacentEdges.poll();}

		public void remove() {adjacentEdges.poll();}
		
		public String toString(){return adjacentEdges.toString();}
	}
	
	public Iterator<Edge> edgeIterator(int source){
		Queue<Edge> adjacentEdges = new ArrayDeque<Edge>();
		int end = edges.length;
		for(int i = 0; i < end; i++){
			double weight = edges[source][i];
			if(weight != Double.POSITIVE_INFINITY){
				adjacentEdges.offer(new Edge(source, i, weight));
			}
		}
		return new Iter<Edge>(adjacentEdges);
	}
	
	public Edge getEdge(int source, int dest){
		return new Edge(source, dest, edges[source][dest]);
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		for(double[] e : edges) {
			string.append(Arrays.toString(e) + "\n");
		}
		
		return string.toString();
	}
	
}

