package se.edinjakupovic.socialnetwork.api.interceptor;


import se.edinjakupovic.socialnetwork.api.SocialNetwork;
import se.edinjakupovic.socialnetwork.core.GroupManager;
import se.edinjakupovic.socialnetwork.core.MembershipHandler;
import se.edinjakupovic.socialnetwork.core.UserManager;

import java.lang.reflect.Proxy;

public class AccessControlProxyFactory {

    private final UserManager userManager;
    private final GroupManager groupManager;
    private final MembershipHandler membershipHandler;
    private final RequestContext requestContext;

    public AccessControlProxyFactory(UserManager userManager,
                                     GroupManager groupManager,
                                     MembershipHandler membershipHandler,
                                     RequestContext requestContext) {
        this.userManager = userManager;
        this.groupManager = groupManager;
        this.membershipHandler = membershipHandler;
        this.requestContext = requestContext;
    }

    public SocialNetwork socialNetwork() {
        AccessControlChecker accessControlChecker = new AccessControlChecker(
                new se.edinjakupovic.socialnetwork.core.SocialNetwork(
                        groupManager,
                        userManager,
                        membershipHandler
                ),
                requestContext,
                userManager
        );
        return (SocialNetwork) Proxy.newProxyInstance(
                SocialNetwork.class.getClassLoader(),
                new Class[]{SocialNetwork.class},
                accessControlChecker
        );
    }

}
