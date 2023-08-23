package se.edinjakupovic.socialnetwork.api.interceptor;

import se.edinjakupovic.api.visibility.Admin;
import se.edinjakupovic.socialnetwork.api.SocialNetwork;
import se.edinjakupovic.socialnetwork.core.UserManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.util.Objects.requireNonNull;

public class AccessControlChecker implements InvocationHandler {
    private final SocialNetwork socialNetwork;
    private final RequestContext requestsContext;
    private final UserManager userManager;

    public AccessControlChecker(SocialNetwork network,
                                RequestContext requestsContext,
                                UserManager userManager) {
        this.socialNetwork = network;
        this.requestsContext = requestsContext;
        this.userManager = userManager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Admin admin = method.getAnnotation(Admin.class);
        try {
            if (admin == null)
                return method.invoke(socialNetwork, args);

            String currentUserId = requireNonNull(requestsContext.currentUser());
            if (!userManager.isAdmin(currentUserId))
                throw new IllegalCallerException(currentUserId + " not allowed to call " + method.getName());

            return method.invoke(socialNetwork, args);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
