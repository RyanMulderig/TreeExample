package rdm.example;

import org.apache.logging.log4j.*;

/** Adds nodes to a list. 
 * @author RyanMulderig */
public class NodeListAccumlator implements NodeVisitor {
  /** Logger */
  private static final Logger logger = Utility.getLogger(NodeListAccumlator.class);
  /**  List of nodes */
  private final NodeList m_list = NodeListFactory.get();

  /* (non-Javadoc)
   * @see rdm.example.NodeVisitor#visit(rdm.example.Node) */
  @Override
  public Object visit(final Node p_node) {
    logger.trace("{}", () -> addNodeTraceMsg(p_node.getName()));     //$NON-NLS-1$
    m_list.add(p_node);
    // return the node that was added to allow for chaining of operations., 
    return p_node;
  }
  
  /** @return list of nodes. */
  public NodeList get() {
    return m_list;
  }
  
  /** Get trace message for adding node.
   * @param p_name name of node being added.
   * @return message with name of node being added. */
  @SuppressWarnings({ "nls", "null" })
  private static String addNodeTraceMsg(final String p_name) {
    final String format = "Adding node %s to list.";
    return String.format(format, p_name);
  }
}