/** Test class */
package rdm.example;


import junit.framework.*;

/** Tests for Accumulator
 * @author RyanMulderig */
public class NodeListAccumlatorTest extends TestCase {
  /** name for simple test node. */
  private final static String NODENAME = "AccumlatorTest"; //$NON-NLS-1$

  @Override
  protected void setUp() {
    NodeTestHelper.initialize();
  }
  
  /** Test method for {@link rdm.example.NodeListAccumlator#visit(rdm.example.Node)}. */
  public static void testVisit() {
    final NodeVisitor visitor = new NodeListAccumlator();
    final Node node = new Node(NODENAME);
    final Node actual = (Node)visitor.visit(node);
    assertEquals("node from vistor not match node added to list.", node, actual); //$NON-NLS-1$
  }

  /** Test method for {@link rdm.example.NodeListAccumlator#get()}. */
  public static void testGetNodes() {
    final Node nodeA = new Node("A"); //$NON-NLS-1$
    final Node nodeB = new Node("B"); //$NON-NLS-1$
    final Node nodeC = new Node("C"); //$NON-NLS-1$
    final Node nodeD = new Node("D"); //$NON-NLS-1$
    
    final NodeListAccumlator visitor = new NodeListAccumlator();
    visitor.visit(nodeA);
    visitor.visit(nodeB);
    visitor.visit(nodeC);
    visitor.visit(nodeD);
    
    final String msg = "node mismatch"; //$NON-NLS-1$
    final NodeList list = visitor.get();
    assertEquals(msg, nodeA, list.get(0)); 
    assertEquals(msg, nodeB, list.get(1)); 
    assertEquals(msg, nodeC, list.get(2)); 
    assertEquals(msg, nodeD, list.get(3)); 
  }

}
