package logger_rate_limiter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 7/4/18.
 */
public class Logger {

    public Logger() {};

    private Map<String, Integer> m = new HashMap<>();

    boolean shouldPrintMessage(int timestamp, String message) {
        if (!m.containsKey(message)) {
            m.put(message, timestamp);
            return true;
        }
        if (timestamp - m.get(message) >= 10) {
            m.put(message, timestamp);
            return true;
        }
        return false;
    }
}
