package se.edinjakupovic.socialnetwork.api.interceptor;

public class Session implements AutoCloseable {

    private final Runnable onEnd;

    public Session(Runnable onEnd) {
        this.onEnd = onEnd;
    }

    @Override
    public void close() {
        this.onEnd.run();
    }
}
