package rdm.example;

import org.apache.logging.log4j.*;
import org.eclipse.jdt.annotation.*;

/** Collection of utility functions
 * @author RyanMulderig */
public class Utility {

  /** Get a logger
   * @param p_class class to get logger for
   * @return a logger*/
  public static Logger getLogger(Class<@NonNull ?> p_class) {
    Logger logger = LogManager.getLogger(p_class);
    if (logger != null) {
      return logger;
    }
    String format = "Logger for class %s could not be gotten."; //$NON-NLS-1$
    String msg = String.format(format, p_class.getName());
    throw new RuntimeException(msg);
  }
}
