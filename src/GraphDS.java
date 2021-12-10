import java.util.*;

class Graph<E> {

    private Map<E, LinkedList<E>> map = new HashMap<>();
    private int numEdges = 0;
    private ArrayList<E> vertexList = new ArrayList<>();

    /**
     * @param - vertex to be added to the Graph instance newVertex of type Generic
     */
    public void addVertex(E newVertex){
        map.put(newVertex, new LinkedList<E>());
        vertexList.add(newVertex);
    }

    public int getNumEdges() {
        return numEdges;
    }

    public ArrayList<E> getVertexList() {
        return vertexList;
    }

    /**
     * Method used to add edge between two vertices source and destination
     * @param - starting vertex source
     * @param - ending vertex destination
     * @param - boolean to determine directed or undirected edge bidirectional
     */
    public void addEdge(E source, E destination, boolean bidirectional){

        if (!map.containsKey(source))
            addVertex(source);
        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);

        if (bidirectional)
            map.get(destination).add(source);

        numEdges++;
    }

    /**
     * Method used to see if desired vertex is present in graph
     * @param vertex to be searched for vertex
     */
    public void hasVertex(E vertex){
        boolean isPresent = map.containsKey(vertex) ? true : false;

        if (isPresent)
            System.out.println("Vertex " + vertex + " is present.");
        else
            System.out.println("Vertex " + vertex + " is not present.");
    }


    /**
     * Method used to determine if edge exists between two nodes
     * @param - starting vertex source
     * @param - ending vertex destination
     */
    public void hasEdge(E source, E destination) { // NOTE: Think about using contains() on linked lists to shorten
        boolean hasEdge = false;

        for (E vertex : map.get(source))
            if (vertex.equals(destination)){
                hasEdge = true;
                break;
            }

        if (!hasEdge){
            for (E vertex : map.get(destination)){
                if (vertex.equals(source)){
                    hasEdge = true;
                    break;
                }
            }
        }

        if (hasEdge)
            System.out.println("Edge between " + source + " and " + destination + " is present");
        else
            System.out.println("Edge between " + source + " and " + destination + " is not present");
    }


    /**
     * This method computes the adjacency matrix for the graph instance
     */
    public void calculateAdjacencyMatrix() {
        int numVertices = vertexList.size();
        int[][] adjMatrix = new int[numVertices][numVertices];

        Object[] vertices = (E []) vertexList.toArray();

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++)
                adjMatrix[i][j] = map.get(vertices[i]).contains(vertices[j]) ? 1 : 0;
        }

        int i = 0;
        System.out.println("  " + vertexList);
        for (int [] row : adjMatrix){
            System.out.println(vertexList.get(i) + " " + Arrays.toString(row));
            i++;
        }
    } // TODO: TRY TO MAKE THE ADJACENCY MATRIX LOOK BETTER


    @Override
    /**
     * Basic toString() method to print out the graph
     * @return - state of graph sb.toString()
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (E vertex : map.keySet())
            sb.append("Vertex " + vertex.toString() + " is connected to " + map.get(vertex).toString() + "\n");
        return sb.toString();
    }
}


// Driver Code
public class GraphDS {

    public static void main(String args[]) {

        // Object of graph is created.
        Graph<Integer> g = new Graph<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        g.addVertex(87);

        // Printing the graph
        System.out.println("Graph:\n"
                + g.toString());

        System.out.println("Adjacency Matrix for graph:");
        g.calculateAdjacencyMatrix();

    }
}
