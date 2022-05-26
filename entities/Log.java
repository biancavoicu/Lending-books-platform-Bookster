package entities;

import java.sql.Timestamp;

public class Log {
    private String action;
    private Timestamp timestamp;

    public Log(String action) {
        this.action = action;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
