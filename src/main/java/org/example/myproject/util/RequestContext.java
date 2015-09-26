package org.example.myproject.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by k on 9/28/15.
 */
public class RequestContext {

    private static final Logger logger = LoggerFactory.getLogger(RequestContext.class);

    /**
     * ThreadLocal storage of username Strings.
     */
    private static ThreadLocal<String> usernames = new ThreadLocal<>();

    /**
     * Get the username for the current thread.
     *
     * @return A String username.
     */
    public static String getUsername() {
        return usernames.get();
    }

    /**
     * Set the username for the current thread.
     *
     * @param username A String username.
     */
    public static void setUsername(String username) {
        usernames.set(username);
        logger.info("RequestContext added username {} to current thread", username);
    }

    /**
     * Initialize the ThreadLocal attributes for the current thread.
     */
    public static void init() {
        usernames.set("anonymous");
    }

}
