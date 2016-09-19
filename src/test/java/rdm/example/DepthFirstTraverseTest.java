/** Test Class */
package rdm.example;

import junit.framework.*;

/** Test the DepthFirstTraverse class
 * @author RyanMulderig */
public class DepthFirstTraverseTest extends TestCase {
  @Override
  protected void setUp() {
    NodeTestHelper.initialize();
  }
  
  /** Test method for 
   * {@link rdm.example.DepthFirstTraverse#traverse(rdm.example.Node, rdm.example.NodeVisitor)}.  */
  public static void testTraverse() {
    final NodeListAccumlator visitor = new NodeListAccumlator();
    final Node root = NodeTestHelper.getTestTree();
    final NodeTraverse walker = new DepthFirstTraverse();
    walker.traverse(root, visitor);
    
    final NodeList actualList  = visitor.get();
    final StringBuffer actual = new StringBuffer();
    for (final Node node: actualList) {
      actual.append(node.getName());
    }
    assertEquals("Paths mismatch", NodeTestHelper.treeAsString(), actual.toString());  //$NON-NLS-1$
  }

}
