package rdm.example;

/** Defines source of NodeList objects that the NodeListFactory can use. 
 * @author RyanMulderig */
public interface NodeListSource {
  /** @return a NodeList */
  NodeList get();
}
