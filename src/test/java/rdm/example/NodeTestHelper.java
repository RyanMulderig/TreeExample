package rdm.example;

import org.apache.commons.lang.mutable.*;

/** Helps with node tests.
 * @author RyanMulderig */
public class NodeTestHelper {
  /** all of the paths from the root to all leaf nodes.  */
  private final static Paths sm_paths = new Paths();

  /** all of the nodes as a collapsed list */
  private final static NodeList sm_nodesAsList = NodeListFactory.get();
  
  /** List of the names of the node concatenated into a strong.  */
  private static String sm_nodesAsString = ""; //$NON-NLS-1$
  
  // individual nodes 
  /** test node A */
  private final static Node A = new Node("A"); //$NON-NLS-1$ // NOPMD
  /** test node B */
  private final static Node B = new Node("B"); //$NON-NLS-1$ // NOPMD
  /** test node C */
  private final static Node C = new Node("C"); //$NON-NLS-1$ // NOPMD
  /** test node D */
  private final static Node D = new Node("D"); //$NON-NLS-1$ // NOPMD
  /** test node E */
  private final static Node E = new Node("E"); //$NON-NLS-1$ // NOPMD
  /** test node F */
  private final static Node F = new Node("F"); //$NON-NLS-1$ // NOPMD
  /** test node G */
  private final static Node G = new Node("G"); //$NON-NLS-1$ // NOPMD
  /** test node H */
  private final static Node H = new Node("H"); //$NON-NLS-1$ // NOPMD
  /** test node I */
  private final static Node I = new Node("I"); //$NON-NLS-1$ // NOPMD
  /** test node J */
  private final static Node J = new Node("J"); //$NON-NLS-1$ // NOPMD
  /** test node K */
  private final static Node K = new Node("K"); //$NON-NLS-1$ // NOPMD
  /** test node L */
  private final static Node L = new Node("L"); //$NON-NLS-1$ // NOPMD

  /** track whether class has been initialized */
  private final static MutableBoolean sm_initialized = new MutableBoolean();
  
  /** Setup the test data. */
  @SuppressWarnings("null")
  public  static void initialize() {
    synchronized (sm_initialized) {
      if (sm_initialized.booleanValue()) {
        return;
      }
      final NodeList pathABEI = NodeListFactory.get();
      final NodeList pathABEJKL = NodeListFactory.get();
      final NodeList pathABF = NodeListFactory.get();
      final NodeList pathACG = NodeListFactory.get();
      final NodeList pathACH = NodeListFactory.get();
      final NodeList pathAD = NodeListFactory.get();
      sm_paths.add(pathABEI);
      sm_paths.add(pathABEJKL);
      sm_paths.add(pathABF);
      sm_paths.add(pathACG);
      sm_paths.add(pathACH);
      sm_paths.add(pathAD);
  
      final StringBuffer nodesAsString = new StringBuffer();
      nodesAsString.append(A.getName());
  
      pathABEI.add(A);
      pathABEI.add(B);
      pathABEI.add(E);
      pathABEI.add(I);
      pathABEJKL.add(A);
      pathABEJKL.add(B);
      pathABEJKL.add(E);
      pathABEJKL.add(J);
      pathABEJKL.add(K);
      pathABEJKL.add(L);
      pathABF.add(A);
      pathABF.add(B);
      pathABF.add(F);
      pathACG.add(A);
      pathACG.add(C);
      pathACG.add(G);
      pathACH.add(A);
      pathACH.add(C);
      pathACH.add(H);
      pathAD.add(A);
      pathAD.add(D);
  
      // tree is just A here
      sm_nodesAsList.add(A);
      // add B at A as part of second generation
      addTo(A, B, sm_nodesAsList, nodesAsString);
      // add E to B as third generation 
      addTo(B, E, sm_nodesAsList, nodesAsString);
      // Add I to E as fourth generation 
      addTo(E,I, sm_nodesAsList, nodesAsString);
      // Add J as sibling of I in fourth generation 
      addTo(E,J, sm_nodesAsList, nodesAsString);
      // add K to J as fifth generation 
      addTo(J,K, sm_nodesAsList, nodesAsString);
      // Add L to K as sixth generation
      addTo(K, L, sm_nodesAsList, nodesAsString);
      // add F to B as third generation 
      addTo(B, F, sm_nodesAsList, nodesAsString);
      // add C to A in the second generation
      addTo(A, C, sm_nodesAsList, nodesAsString);
      // add G to C at fourth generation
      addTo(C,G, sm_nodesAsList, nodesAsString);
      // add H to C at fourth generation 
      addTo(C,H, sm_nodesAsList, nodesAsString);
      // add D to A as second generation
      addTo(A,D, sm_nodesAsList, nodesAsString);
      
      sm_nodesAsString = nodesAsString.toString();
      
      sm_initialized.setValue(true);
    }
  }  
  
  /** Create simple test tree.
   * @return root of a tree with a few nodes in it. */
  public static Node getTestTree() {
    // return the parent of the tree
    return A;
  }
  
  /** Get list of nodes as a path
   * @return list of nodes. */
  public static NodeList get() {
    return sm_nodesAsList;
  }
  
  /** Get the list of paths
   * @return the list of lists. */
  public static Paths getPaths() {
    return sm_paths;
  }

  /** Add child to parent and add to string list.
   * @param pParent parent node
   * @param pChild child node
   * @param pNodesAsList tree collapsed to a list
   * @param pNodesAsString depth first list of nodes as a string. */
  private static void addTo(final Node pParent, final Node pChild, 
      final NodeList pNodesAsList, final StringBuffer pNodesAsString) {
    pParent.addChild(pChild); 
    pNodesAsList.add(pChild);
    pNodesAsString.append(pChild.getName());
  }

  /** @return the tree of nodes a depth first string. */
  @SuppressWarnings("null")
  public static String treeAsString() {
    return sm_nodesAsString;
  }

}
