package se.edinjakupovic.socialnetwork.api.interceptor;

import se.edinjakupovic.socialnetwork.api.SocialNetwork;

import java.util.function.Function;

public class SocialNetworkClient {

    private final SocialNetwork network;
    private final RequestContext requestContext;
    private final String userId;

    public SocialNetworkClient(SocialNetwork network,
                               RequestContext requestContext,
                               String userId) {
        this.requestContext = requestContext;
        this.network = network;
        this.userId = userId;
    }

    public <T> T handleRequest(String asUser, Function<SocialNetwork, T> action) {
        try (Session session = requestContext.setCurrentUser(asUser)) {
            return action.apply(network);
        }
    }

    public <T> T handleRequest(Function<SocialNetwork, T> action) {
        try (Session session = requestContext.setCurrentUser(userId)) {
            return action.apply(network);
        }
    }

}
