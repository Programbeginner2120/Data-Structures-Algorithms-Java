import java.util.ArrayList;
import java.util.HashMap;

class WeightedGraph<E> extends Graph<E>{

    private HashMap<E, HashMap<E, Integer>> map = new HashMap<>();

    @Override
    /**
     * Method that adds a vertex to the instace of WeightedGraph
     * @param newVertex
     */
    public void addVertex(E newVertex){
        super.addVertex(newVertex);
        map.put(newVertex, new HashMap<E, Integer>());
    }


    /**
     * Method that adds a weighted edge between nodes source and destination, checks if directed or undirected
     * with boolean bidirectional
     * @param source
     * @param destination
     * @param weight
     * @param bidirectional
     */
    public void addEdge(E source, E destination, int weight, boolean bidirectional){
        super.addEdge(source, destination, bidirectional);
        this.map.get(source).put(destination, weight);
        if (bidirectional)
            this.map.get(destination).put(source, weight);
    }

    @Override
    /**
     * A somewhat complicated toString() method for weighted graphs
     * @return - returns state of WeightedGraph instance sb.toString()
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ArrayList<E> vertexList = getVertexList();
        for (E vertex : vertexList){
            sb.append("Vertex " + vertex + " is connected to ");
            HashMap <E, Integer> temp = map.get(vertex);
            Object [] conn = (E []) temp.keySet().toArray();
            for (int i = 0; i < conn.length; i++){
                sb.append(conn[i] + " with weight " + temp.get(conn[i]));
                if (i < conn.length - 1)
                    sb.append(", ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

public class WeightedGraphDS {

    public static void main(String [] args){
        Graph<Integer> weightedGraph = new WeightedGraph<>();

        weightedGraph.addVertex(999);
        ((WeightedGraph)weightedGraph).addEdge(999, 77, 10, true);
        weightedGraph.addVertex(22);
        ((WeightedGraph)weightedGraph).addEdge(999, 22, 30, false);

        weightedGraph.calculateAdjacencyMatrix();

        System.out.println(weightedGraph);
    }

}