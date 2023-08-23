package se.edinjakupovic.socialnetwork.api.interceptor;

public class RequestContext {
    private final ThreadLocal<String> current = new ThreadLocal<>();

    public Session setCurrentUser(String userId) {
        current.set(userId);
        return new Session(current::remove);
    }

    public String currentUser() {
        return current.get();
    }
}
