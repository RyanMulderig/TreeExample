package rdm.example;

import org.eclipse.jdt.annotation.*;

/** Source for NodeList that uses ArrayList implemenations. 
 * @author RyanMulderig */
public class ArrayNodeListSource implements NodeListSource {
  /* (non-Javadoc)
   * @see rdm.example.NodeListSource#get() */
  @Override
  public @NonNull NodeList get() {
    return new NodeListArray();
  }
}
