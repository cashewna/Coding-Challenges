package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Java class to implement Generic Graph
 *
 * @param <T> Allows generic usage
 */
class Graph<T> {
  // Use HashMap to store edges in graph.
  Map<T, List<T>> map = new HashMap<>();

  public void addVertex(T s) {
    map.put(s, new LinkedList<>());
  }

  public void addEdge(T source, T destination, boolean bidirectional) {
    if (!map.containsKey(source)) {
      addVertex(source);
    }

    if (!map.containsKey(destination)) {
      addVertex(destination);
    }

    map.get(source).add(destination);
    if (bidirectional) {
      map.get(destination).add(source);
    }
  }

  public void getVertexCount() {
    System.out.println("The graph has " + map.keySet().size() + " vertex.");
  }

  public void getEdgesCount(boolean bidirection) {
    int count = 0;
    // For each vertex, count the number of edges.
    for (T v : map.keySet()) {
      count += map.get(v).size();
    }

    if (bidirection) {
      count = count / 2;
    }

    System.out.println("The graph has " + count + " edges.");
  }

  public void hasVertex(T s) {
    if (map.containsKey(s)) {
      System.out.println("The graph contains vertex " + s);
    } else {
      System.out.println("The graph does not contain vertex " + s);
    }
  }

  public void hasEdge(T s, T d) {
    if (map.get(s).contains(d)) {
      System.out.println("The graph has an edge between " + s + " and " + d);
    } else {
      System.out.println("The graph has no edge between " + s + " and " + d);
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (T v : map.keySet()) {
      builder.append("Vector ").append(v.toString()).append(": ");
      for (T w : map.get(v)) {
        builder.append(w.toString()).append(" ");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
}
