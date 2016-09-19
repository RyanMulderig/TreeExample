package rdm.example;

/** Defines an interface where concrete implementation can use a 
 * specific traversal policy.  
 * @author RyanMulderig */
public interface NodeTraverse {
  /** Traverse a tree of nodes, doing something with them.
   * @param p_node start of tree of nodes to traverse. This could be a sub-tree. 
   * @param p_visitor what to do with each node as it is reached. */
  void traverse(Node p_node, NodeVisitor p_visitor);
}
