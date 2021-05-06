package com.aug;

import java.util.HashMap;

/**
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 * <p>
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * <p>
 * It is possible that several messages arrive roughly at the same time.
 * <p>
 * Example:
 * <p>
 * Logger logger = new Logger();
 * <p>
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 * <p>
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * <p>
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * <p>
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * <p>
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * <p>
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class LoggerRateLimiter {
    static HashMap<String, Integer> logger;

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();

        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        //returns true;

        // logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2, "bar")); //returns true;

        // logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3, "foo")); //returns false;

        // logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8, "bar")); //returns false;

        // logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10, "foo")); //returns false;

        // logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11, "foo"));// returns true;
    }

    public LoggerRateLimiter() {
        logger = new HashMap<>();
    }

    public static boolean shouldPrintMessage(Integer timestamp, String message) {
        if (!logger.containsKey(message)) {
            logger.put(message, timestamp);
            return true;
        }
        Integer oldTimestamp = logger.get(message);
        if ((timestamp - oldTimestamp) >= 10) {
            logger.put(message, timestamp);
            return true;
        } else
            return false;
    }


}
