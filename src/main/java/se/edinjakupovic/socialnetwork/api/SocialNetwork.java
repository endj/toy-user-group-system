package se.edinjakupovic.socialnetwork.api;

import se.edinjakupovic.api.visibility.Admin;
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

public interface SocialNetwork {

    @Admin
    Group createGroup(CreateGroupRequest request);

    Group getGroup(String id);

    GroupAndMembers getGroupMembers(String id);

    @Admin
    GroupAndAttributes createGroup(CreateGroupRequest request, Collection<Attribute> attributes);

    @Admin
    GroupAndAttributes getGroupAndAttributes(String id);

    @Admin
    Group addGroupAttributes(String id, Collection<Attribute> attributes);

    @Admin
    Group removeGroupAttributes(String id, Collection<String> attributeKeys);

    String createUser(CreateUserRequest request);

    User getUser(String id);

    UserAndAttributes getUserAndAttributes(String id);

    @Admin
    UserAndAttributes addUserAttributes(String id, Collection<Attribute> attributes);

    @Admin
    UserAndAttributes removeUserAttributes(String id, Collection<String> attributeKeys);

    UserMembership joinGroup(GroupJoinRequest request);

    UserMembership getUserGroups(String userId);

    @Admin
    GroupMembership removeGroupMembership(GroupLeaveRequest request);


}
