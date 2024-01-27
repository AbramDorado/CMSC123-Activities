package ph.edu.upm.cas.dpsm.rbchua;

import java.util.ArrayList;
import java.util.Iterator;

public class MinimumSpanningTree {
    /**
     * Create a ArrayList minimum spanning tree using Prim's Algorithm and return it.
     * @param graph ListGraph to use for creating MST.
     * @return ArrayList containing the edges of the MST.
     */
    public static ArrayList<Edge> getMST(Graph graph) {
        ArrayList<Edge> mst = new ArrayList<>();
        ArrayList<Integer> vertices = new ArrayList<>(graph.getNumV()); 

        Iterator<Edge> edgeIterator = graph.edgeIterator(findVertexWithEdge(graph)); 
        Edge cur = edgeIterator.next(); 
        mst.add(cur); 
        vertices.add(cur.getSource()); vertices.add(cur.getDest()); 
        while(vertices.size() < graph.getNumV()) {
            Iterator<Integer> vertexIterator = vertices.iterator(); 
            Edge min = new Edge(0, 0, Double.POSITIVE_INFINITY); 
            while(vertexIterator.hasNext()) {
                edgeIterator = graph.edgeIterator(vertexIterator.next()); 
                while(edgeIterator.hasNext()) {
                    cur = edgeIterator.next();
                    if(cur.getWeight() < min.getWeight() && !vertices.contains(cur.getDest())) { 
                        min = cur;
                    }
                }

            }
            mst.add(min); 
            vertices.add(min.getDest()); 
        }
        return mst;
    }

    /**
     * Find an edge in a graph and return its source vertex.
     * @param graph ListGraph used to find vertex.
     * @return int source vertex of the edge.
     */
    private static int findVertexWithEdge(Graph graph) {
        for(int i = 0; i < graph.getNumV(); i++) {
            if(graph.edgeIterator(i).hasNext()) {
                return i;
            }
        }
        return -1;
    }

    public static void printMST(ArrayList<Edge> mst) {
        int cost = 0;
        Iterator<Edge> iterator = mst.iterator();
        System.out.println("Minimum Spanning Tree:");
        while(iterator.hasNext()) {
            Edge cur = iterator.next();
            cost += cur.getWeight();
            System.out.println(cur.getSource() + " " + cur.getDest() + " " + cur.getWeight());
        }
        System.out.println("Cost of MST: " + cost);
    }
}
