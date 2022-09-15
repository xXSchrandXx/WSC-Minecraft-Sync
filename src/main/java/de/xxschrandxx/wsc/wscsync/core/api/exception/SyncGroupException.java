package de.xxschrandxx.wsc.wscsync.core.api.exception;

public class SyncGroupException extends Exception {

    public SyncGroupException(String message) {
        super(message);
    }

    public SyncGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public SyncGroupException(Throwable cause) {
        super(cause);
    }
}
