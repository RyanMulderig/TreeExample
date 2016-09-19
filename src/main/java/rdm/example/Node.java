package rdm.example;

import org.apache.logging.log4j.*;

/** Node that is part of a tree.  
 * @author RyanMulderig */
public class Node {
  /** Name of this node */
  private final String m_name;
  /** children of this node */
  private final NodeList m_children = NodeListFactory.get();
  /** Logger */
  private static final Logger logger = Utility.getLogger(Node.class);

  /** Create node.
   * @param p_name name for node. */
  public Node(final String p_name) {
    logger.trace("{}", () -> getCreationTraceMsg(p_name));     //$NON-NLS-1$
    m_name = p_name;
  }

  /** @return the name of the node */
  public String getName() {
    return m_name;
  }
  
  /** @return the children of this node as an array. */
  public NodeList getChildren() {
    return m_children;
  }
  
  /** @param p_child child to add to list of children */
  public void addChild(final Node p_child) {
    logger.trace("{}", () -> getAddChildTraceMsg(p_child));     //$NON-NLS-1$
    m_children.add(p_child);
  }
  
  /** @return true if the node has children. */
  public boolean hasChildren() {
    return !m_children.isEmpty();
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString() */
  @Override
  public String toString() {
    if (m_name.isEmpty()) {
      return Messages.getString("ChildrenAsList.EmptyName");  //$NON-NLS-1$
    }
    return m_name;
  }
  
  /** Get the trace message for adding a child 
   * @param p_child child being added
   * @return info describing what happened */
  @SuppressWarnings("null")
  private String getAddChildTraceMsg(final Node p_child) {
    final String format = "Node %s adding child %s. %s"; //$NON-NLS-1$
    final String childName = p_child.getName();
    return String.format(format, toString(), childName, ""); //$NON-NLS-1$
  }

  /** Get message for when node is created.
   * @param p_name name of node
   * @return message describing what is happening. */
  @SuppressWarnings({ "nls", "null" })
  private static String getCreationTraceMsg(final String p_name) {
    String nameMsg = null;
    if (p_name.isEmpty()) {
      nameMsg = "(empty name)"; 
    } else {
      nameMsg = Messages.getString("ChildrenAsList.Name") + p_name; 
    }
    final String format = "Creating node of type %s with %s"; //$NON-NLS-1$
    return String.format(format, Node.class, nameMsg);
  }
}
