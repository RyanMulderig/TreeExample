package rdm.example;

import java.util.*;

/** Holds lists of NodeLists. 
 * @author RyanMulderig */
public class Paths {
  /** List of NodeLists */
  private final List<NodeList> m_list = new ArrayList<>();

  /** @param pPath add a path the collection of paths. */
  public void add(final NodeList pPath) {
    m_list.add(pPath);
  }

  /** @return count of paths*/
  public int size() {
    return m_list.size();
  }

  /** @param pIdx index of path to get.
   * @return a path. */
  @SuppressWarnings("null")
  public NodeList get(final int pIdx) {
    return m_list.get(pIdx);
  }
}
