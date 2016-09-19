package rdm.example;

/** Test visitor that just prints the name of a node and 
 * returns that value. 
 * @author RyanMulderig */
public class NodePrintNamesVisitor implements NodeVisitor {
  /* (non-Javadoc)
   * @see rdm.example.NodeVisitor#visit(rdm.example.Node) */
  @Override
  public Object visit(final Node p_node) {
    System.out.println(p_node.getName()); // NOPMD 
    return p_node.getName();
  }
}
