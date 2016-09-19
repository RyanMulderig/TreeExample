package rdm.example;

import java.util.*;

/** Used to get message from resource bundle
 * @author RyanMulderig */
public class Messages {
  /** Name of the bundle to get messages from. */
  private static final String BUNDLE_NAME = "rdm.example.messages"; //$NON-NLS-1$

  /** Bundle messages will be coming from. */
  private static final ResourceBundle RESOURCE_BUNDLE = getBundle();
  
  /** Get a message from the resource bundle (message.properties)
   * @param key key to the message
   * @return the message or !key} */
  public static String getString(final String key) {
    try {
      final String msg = RESOURCE_BUNDLE.getString(key);
      if (msg != null) {
        return msg;
      }
      throw new RuntimeException("Message returned from bundle was null."); //$NON-NLS-1$ // NOPMD by "Ryan Mulderig" on 9/18/16 2:41 PM
    } catch (@SuppressWarnings("unused") MissingResourceException e) {
      return '!' + key + '!';
    }
  }

  /** @return resources for message. */
  private static ResourceBundle getBundle() {
    final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    if (bundle != null) {
      return bundle;
    }
    throw new RuntimeException("resource buyndle returned from ResouceBunde.getBundle was null."); //$NON-NLS-1$ // NOPMD by "Ryan Mulderig" on 9/18/16 2:41 PM
  }
  
  /** Empty constructor to enforce Utility class pattern.  */
  private Messages() {
  }
  
}
