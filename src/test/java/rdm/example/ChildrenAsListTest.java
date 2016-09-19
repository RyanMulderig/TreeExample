package rdm.example;

import junit.framework.*;

/** Tests ChilkdAsList class.
 * @author RyanMulderig */
public class ChildrenAsListTest extends TestCase { 
  @Override
  protected void setUp() {
    NodeTestHelper.initialize();
  }
  
  /** tests getting collapsing tree to a list. */
  public static void testWalkGraph() {
    final Node root = NodeTestHelper.getTestTree();
    final NodeList expected = NodeTestHelper.get();
    final NodeList actual = TreeUtility.walkGraph(root);
    assertTrue(expected.equals(actual)); // NOPMD 
  }

  /** test getting all paths. */
  public static void testPaths() {
    final Paths expected = NodeTestHelper.getPaths();
    final Node root = NodeTestHelper.getTestTree();
    final Paths actual = PathBuilder.paths(root, PathBuildingMethod.RECURSIVE);
    int idx = 0;
    final int size = expected.size();
    while (idx < size) {
      final NodeList expectedList = expected.get(idx);
      final NodeList actualList = actual.get(idx);
      assertTrue("path mismatch", expectedList.equals(actualList)); // NOPMD
      idx++;
    }
  }
}
