package rdm.example;

import org.apache.logging.log4j.*;

/** Creates node lists. 
 * @author RyanMulderig */
public class NodeListFactory {
  /** Name of default class for NodeListSource */
  private final static String DEFAULT = Messages.getString("NodeListFactory.DEFAULT"); //$NON-NLS-1$
  /** Our Logger. */
  private static final Logger logger = Utility.getLogger(NodeListFactory.class);
  /** Source for node lists. */
  private static final NodeListSource sm_source = getSource();
  
  /** @return a node list */
  public static NodeList get() {
    return sm_source.get();
  }
  
  /** @return source for nodes either from configured value or from default. */
  private static NodeListSource getSource() {
    String className = System.getProperty(Messages.getString("NodeListFactory.NodeListSourceKey")); //$NON-NLS-1$
    if (className == null || className.isEmpty()) {
      className = DEFAULT;
    }
    return createSource(className);
  }
  
  /** Create the node list source.
   * @param p_className name of node list source class.
   *  @return source for nodes. */
  private static NodeListSource createSource(final String p_className) { 
    Class<?> sourceClass;
    try {
      sourceClass = Class.forName(p_className);
    } catch (ClassNotFoundException e) {
      if (p_className.equals(DEFAULT)) {
        throw new RuntimeException(Messages.getString("NodeListFactory.WarnMissingDefault"), e); //$NON-NLS-1$ // NOPMD by "Ryan Mulderig" on 9/18/16 3:07 PM
      }
      final String format = Messages.getString("NodeListFactory.MissingConfigured"); //$NON-NLS-1$
      final String message = String.format(format, p_className, DEFAULT);
      logger.warn(message);
      return createSource(DEFAULT);
    }
    NodeListSource source;
    try {
      source = (NodeListSource)sourceClass.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      if (p_className.equals(DEFAULT)) {
        final String format = Messages.getString("NodeListFactory.ErrorDefault"); //$NON-NLS-1$
        final String message = String.format(format, e.getMessage());
        throw new RuntimeException(message, e); // NOPMD
      }
      final String format = Messages.getString("NodeListFactory.ErrConfigured"); //$NON-NLS-1$
      final String message = String.format(format, p_className, e.getMessage(), DEFAULT);
      logger.warn(message);
      return createSource(DEFAULT);
      
    }
    if (source != null) {
      return source;
    }
    throw new RuntimeException(Messages.getString("NodeListFactory.ErrInvoke")); //$NON-NLS-1$ // NOPMD
  }

}
