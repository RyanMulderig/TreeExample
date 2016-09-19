package rdm.example;

/** Tree (node) utility functions 
 * @author RyanMulderig */
public class TreeUtility {
  /** Walks the nodes in the graph, visiting each node exactly once. 
   * @param p_start start of the graph to walk 
   * @return List containing every Node in the graph with no duplicates. */
  public static NodeList walkGraph(final Node p_start) {
    final NodeListAccumlator visitor = new NodeListAccumlator();
    final NodeTraverse walker = new DepthFirstTraverse();
    walker.traverse(p_start, visitor);
    return visitor.get();
  }

  /** private constructor to enforce utility nature of class. */
  private TreeUtility() {
    // does nothing
  }
}
