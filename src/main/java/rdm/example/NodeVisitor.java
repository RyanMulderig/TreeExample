package rdm.example;

/** Defines a functional pattern for operating on nodes as a tree is 
 * traversed.  
 * @author RyanMulder */
public interface NodeVisitor {
  /** Defines operation for visiting a node and doing something.  
   * @param p_node node that was just reached.  
   * @return result of visit. Can be anything or nothing.,  */
  Object visit(Node p_node);
}
