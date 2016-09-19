package rdm.example;

/** Used to do a depth first traversal of Nodes that are NodeChildrenAsList.
 * Future: Implemented more  generically and move up to main package. 
 * @author RyanMulderig */
public class DepthFirstTraverse implements NodeTraverse {
  /* (non-Javadoc)
   * @see rdm.example.NodeTraverse#traverse(rdm.example.Node, rdm.example.NodeVisitor) */
  @Override
  public void traverse(final Node p_node, final NodeVisitor p_visitor) {
    p_visitor.visit(p_node);
    if (!p_node.hasChildren()) {
      return;
    }
    final NodeList children = p_node.getChildren();
    for (final Node child: children) {
      traverse(child, p_visitor);
    }
  }
}
