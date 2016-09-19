package rdm.example;

/** Builds root to leaf paths. 
 * @author RyanMulderig */
public class PathBuilder {
  /** Get all the root to leaf paths.
   * @param p_start root of tree to get all paths for. 
   * @param p_traversal method to use to create path
   * @return list of node lists containing all paths. */
  public static Paths paths(final Node p_start, final PathBuildingMethod p_traversal) {
    final Paths allPaths = new Paths();
    final NodeList currentPath = NodeListFactory.get();
    switch (p_traversal) { // NOPMD 
    case RECURSIVE:
    default:
      recursive(p_start, currentPath, allPaths);  
      break;
    }
    return allPaths;
  }
  
  /** Recurse though all paths from a node to all of its leaves. 
   * @param p_current where recursion is starting
   * @param p_currentPath the path from root to current node
   * @param pAllPaths the collection of all paths.*/
  private static void recursive(final Node p_current, final NodeList p_currentPath,
      final Paths pAllPaths) {
    p_currentPath.add(p_current);
    if (!p_current.hasChildren()) {
      pAllPaths.add(p_currentPath);
      return;
    }
    for (final Node child: p_current.getChildren()) {
      final NodeList newPath = NodeListFactory.get();
      newPath.addAll(p_currentPath);
      recursive(child, newPath, pAllPaths);
    }
  }
    
  /** Private method that does noting to enforce this being a utility class. 
   * @author RyanMulderig */
  private PathBuilder() {
    // nothing to do, this is a utility class
  }
}
