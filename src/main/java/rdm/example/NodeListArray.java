package rdm.example;

import java.util.*;

/** NodeList that uses an ArrayList as its implementation. 
 * @author RyanMulderig */
public class NodeListArray extends NodeList {
  /** List of nodes. */
  private final List<Node> m_list = new ArrayList<>();
  
  /* (non-Javadoc)
   * @see java.lang.Iterable#iterator() */
  @SuppressWarnings("null") // NOPMD
  @Override
  public Iterator<Node> iterator() {
    return m_list.iterator();
  }

  /* (non-Javadoc)
   * @see rdm.example.NodeList#add(rdm.example.Node) */
  @Override
  public void add(final Node p_child) {
    m_list.add(p_child);
  }

  /* (non-Javadoc)
   * @see rdm.example.NodeList#addAll(rdm.example.NodeList) */
  @Override
  public void addAll(final NodeList p_list) {
    final Iterator<Node> itor = p_list.iterator();
    while (itor.hasNext()) {
      @SuppressWarnings("null")
      final Node node = itor.next();
      m_list.add(node);
    }
  }

  /* (non-Javadoc)
   * @see rdm.example.NodeList#get(int) */
  @SuppressWarnings("null") // NOPMD
  @Override
  public Node get(final int pIdx) {
    return m_list.get(pIdx);
  }

  /* (non-Javadoc)
   * @see rdm.example.NodeList#isEmpty() */
  @Override
  public boolean isEmpty() {
    return m_list.isEmpty();
  }

  /* (non-Javadoc)
   * @see rdm.example.NodeList#size() */
  @Override
  public int size() {
    return m_list.size();
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#toString() */
  @SuppressWarnings("null") // NOPMD
  @Override
  public String toString() {
    return m_list.toString();
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object) */
  @SuppressWarnings({ "null", "unused" })  // NOPMD
  @Override 
  public boolean equals(final Object p_right) {
    if (p_right == null) {
      return false;
    }
    if (!(p_right instanceof NodeList)) {
      return false;
    }
    
    final NodeList right = (NodeList)p_right;
    if (right.size() != size()) {
      return false;
    }
    
    for (int idx = 0; idx < size(); idx++) {
      final Node leftNode = get(idx);
      final Node rightNode = right.get(idx);
      if (!leftNode.equals(rightNode)) {
        return false;
      }
    }
    return true;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode() */
  @Override
  public int hashCode() {
    return m_list.hashCode(); 
  }
}
