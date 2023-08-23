package se.edinjakupovic.socialnetwork.core;

import se.edinjakupovic.socialnetwork.api.request.CreateGroupRequest;
import se.edinjakupovic.socialnetwork.api.request.CreateUserRequest;
import se.edinjakupovic.socialnetwork.api.request.GroupJoinRequest;
import se.edinjakupovic.socialnetwork.api.request.GroupLeaveRequest;
import se.edinjakupovic.socialnetwork.domain.Attribute;
import se.edinjakupovic.socialnetwork.domain.Group;
import se.edinjakupovic.socialnetwork.domain.User;
import se.edinjakupovic.socialnetwork.domain.aggregates.GroupAndAttributes;
import se.edinjakupovic.socialnetwork.domain.aggregates.GroupAndMembers;
import se.edinjakupovic.socialnetwork.domain.aggregates.GroupMembership;
import se.edinjakupovic.socialnetwork.domain.aggregates.UserAndAttributes;
import se.edinjakupovic.socialnetwork.domain.aggregates.UserMembership;

import java.util.Collection;

public class SocialNetwork implements se.edinjakupovic.socialnetwork.api.SocialNetwork {

    private final GroupManager groupManager;
    private final UserManager userManager;
    private final MembershipHandler membershipHandler;

    public SocialNetwork(GroupManager groupManager, UserManager userManager, MembershipHandler membershipHandler) {
        this.groupManager = groupManager;
        this.userManager = userManager;
        this.membershipHandler = membershipHandler;
    }

    @Override
    public Group createGroup(CreateGroupRequest request) {
        return groupManager.createGroup(request);
    }

    @Override
    public Group getGroup(String id) {
        return groupManager.getGroupById(id);
    }

    @Override
    public GroupAndMembers getGroupMembers(String id) {
        return membershipHandler.getGroupMembers(id);
    }

    @Override
    public GroupAndAttributes createGroup(CreateGroupRequest request, Collection<Attribute> attributes) {
        return groupManager.createGroupWithAttributes(request, attributes);
    }

    @Override
    public GroupAndAttributes getGroupAndAttributes(String id) {
        return groupManager.getGroupWithAttributes(id);
    }

    @Override
    public Group addGroupAttributes(String id, Collection<Attribute> attributes) {
        return groupManager.addAttributes(id, attributes);
    }

    @Override
    public Group removeGroupAttributes(String id, Collection<String> attributeKeys) {
        return groupManager.removeAttributes(id, attributeKeys);
    }

    @Override
    public String createUser(CreateUserRequest request) {
        return userManager.createUser(request);
    }

    @Override
    public User getUser(String id) {
        return userManager.getUserById(id);
    }

    @Override
    public UserAndAttributes getUserAndAttributes(String id) {
        return userManager.getUserAndAttributesById(id);
    }

    @Override
    public UserAndAttributes addUserAttributes(String id, Collection<Attribute> attributes) {
        return userManager.addUserAttributes(id, attributes);
    }

    @Override
    public UserAndAttributes removeUserAttributes(String id, Collection<String> attributeKeys) {
        return userManager.removeAttributes(id, attributeKeys);
    }

    @Override
    public UserMembership joinGroup(GroupJoinRequest request) {
        return membershipHandler.addUserToGroup(request);
    }

    @Override
    public UserMembership getUserGroups(String userId) {
        return membershipHandler.getUserMembership(userId);
    }

    @Override
    public GroupMembership removeGroupMembership(GroupLeaveRequest request) {
        return membershipHandler.removeUserFromGroup(request);
    }
}
