package rdm.example;

/** Defines a class that can hold a list of Nodes.  
 * @author RyanMulderig */
public abstract class NodeList implements Iterable<Node> {
  /** @param p_child */
  public abstract void add(Node p_child);
  /** @param p_currentPath */
  public abstract void addAll(NodeList p_currentPath);
  /** Get a specific node.
   * @param p_idx where node is in list. 
   * @return node at index. */
  public abstract Node get(int p_idx);
  /** @return true is list is empty. */
  public abstract boolean isEmpty();
  /** @return size of list */
  public abstract int size();
}
