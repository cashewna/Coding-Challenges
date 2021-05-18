package SocialNetworkProject;

public class Graph implements Cloneable {

  protected boolean[][] edges;
  protected Object[] labels;

  /**
   * Parametrised constructor to create a new graph with n vertices, no edges, and null labels.
   *
   * @param n Number of vertices for this graph object.
   */
  public Graph(int n) {
    edges = new boolean[n][n];
    labels = new Object[n];
  }

  /** Default constructor */
  public Graph() {}

  /**
   * Adds a directed edge between two vertices.
   *
   * @param source Starting vertex.
   * @param target Target vertex.
   * @param directed True if the edge between two vertices is directed, false otherwise.
   */
  public void addEdge(int source, int target, boolean directed) {
    edges[source][target] = true;

    // If undirected between two vertices, then make both vertex a complimentary source and target
    // of each other.
    if (!directed) {
      edges[target][source] = true;
    }
  }

  /**
   * Generates a copy of this graph object.
   *
   * @return Returns a copy of this graph.
   * @throws OutOfMemoryError Indicates insufficient memory for creating the clone.
   */
  @Override
  public Object clone() {
    Graph answer;

    try {
      answer = (Graph) super.clone();
    } catch (CloneNotSupportedException e) {
      // Catches internal runtime errors such as OutOfMemory.
      throw new InternalError(e.toString());
    }

    answer.edges = edges.clone();
    answer.labels = labels.clone();

    return answer;
  }

  /**
   * Print labels of a graph with depth-first search, starting at a specified vertex.
   *
   * @param g The graph object to traverse.
   * @param start Starting vertex from specified graph.
   * @throws NullPointerException Indicates that graph g is null.
   * @throws ArrayIndexOutOfBoundsException Indicates that start vertex does not exist.
   * @throws OutOfMemoryError Indicates insufficient memory for an array of boolean used by this
   *     method.
   */
  public void depthFirstPrint(Graph g, int start) {
    boolean[] marked = new boolean[g.getSize()];

    depthFirstRecurse(g, start, marked);
  }

  /**
   * Recursive method helper for depthFirstPrint.
   *
   * @param g The graph object to traverse.
   * @param v Current vertex being traversed from graph g.
   * @param marked An array to indicate which vertices have been traversed.
   * @throws NullPointerException Indicates that graph g is null.
   * @throws ArrayIndexOutOfBoundsException Indicates that the current vertex does not exist, or
   *     marked[] was the wrong size.
   */
  public void depthFirstRecurse(Graph g, int v, boolean[] marked) {
    int[] connections = g.neighbours(v);
    int nextNeighbour;

    marked[v] = true;
    System.out.println(g.getLabel(v));

    // Traverse all the neighbours, looking for unmarked vertices:
    for (int i = 0; i < connections.length; i++) {
      nextNeighbour = connections[i];
      if (!marked[nextNeighbour]) {
        depthFirstRecurse(g, nextNeighbour, marked);
      }
    }
  }

  /**
   * Accessor method to get the labels of a vertex.
   *
   * @param vertex The vertex number to get the label from.
   * @return Returns the label from the specified vertex.
   * @exception ArrayIndexOutOfBoundsException Indicates that vertex is invalid.
   */
  public Object getLabel(int vertex) {
    return labels[vertex];
  }

  /**
   * Accessor boolean method to determine whether there is a directed edge between two vertices from
   * source to target.
   *
   * @param source The starting vertex between two vertices.
   * @param target The ending vertex between two vertices.
   * @return Returns true if a directed edge exists from source to target.
   * @exception ArrayIndexOutOfBoundsException Indicates that either source or target vertices are
   *     invalid.
   */
  public boolean isEdge(int source, int target) {
    return edges[source][target];
  }

  /**
   * Accessor getter method to get an array list of neighbours from a vertex. Neighbours are
   * vertices that have the specified parameter vertex as their source.
   *
   * @param vertex The vertex to get a list from.
   * @return Returns the neighbours of a vertex as an array list.
   * @exception ArrayIndexOutOfBoundsException Indicates that the specified vertex is invalid.
   */
  public int[] neighbours(int vertex) {
    int i;
    int count;
    int[] answer;

    // First count how many edges have the vertex as their source.
    count = 0;
    for (i = 0; i < labels.length; i++) {
      if (edges[vertex][i]) {
        count++;
      }
    }

    // Allocate the array for the answer
    answer = new int[count];

    // Fill the array for the answer
    count = 0;
    for (i = 0; i < labels.length; i++) {
      if (edges[vertex][i]) {
        answer[count++] = i;
      }
    }
    return answer;
  }

  /**
   * Removes a directed edge from two vertices.
   *
   * @param source The source vertex of the directed edge.
   * @param target The target vertex of the directed edge.
   * @exception ArrayIndexOutOfBoundsException Indicates that either vertices are invalid.
   */
  public void removeEdge(int source, int target) {
    edges[source][target] = false;
  }

  /**
   * Accessor setter method to set the label of a vertex.
   *
   * @param vertex Vertex number to set the label for.
   * @param newLabel New label for the specified vertex and can be null.
   * @exception ArrayIndexOutOfBoundsException Indicates that the vertex is invalid.
   */
  public void setLabel(int vertex, Object newLabel) {
    labels[vertex] = newLabel;
  }

  /**
   * Get Vertex Index
   * @param label Label to get vertex index from.
   * @return Number of vertex corresponding specified label.
   */
  public int getVertexIndex(Object label) {
    for (int i = 0; i < labels.length; i++) {
      if (labels[i].equals(label)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the number of vertices in this graph object.
   *
   * @return The number of vertices in this graph object.
   */
  public int getSize() {
    return labels.length;
  }
}
