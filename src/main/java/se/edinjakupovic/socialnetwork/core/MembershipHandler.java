package se.edinjakupovic.socialnetwork.core;

import org.jooq.DSLContext;
import se.edinjakupovic.socialnetwork.api.request.GroupJoinRequest;
import se.edinjakupovic.socialnetwork.api.request.GroupLeaveRequest;
import se.edinjakupovic.socialnetwork.domain.aggregates.GroupAndMembers;
import se.edinjakupovic.socialnetwork.domain.aggregates.GroupMembership;
import se.edinjakupovic.socialnetwork.domain.aggregates.UserMembership;

public class MembershipHandler {
    private final DSLContext dsl;

    public MembershipHandler(DSLContext dsl) {
        this.dsl = dsl;
    }

    public UserMembership addUserToGroup(GroupJoinRequest request) {
        return null;
    }

    public UserMembership getUserMembership(String userId) {
        return null;
    }

    public GroupMembership removeUserFromGroup(GroupLeaveRequest request) {
        return null;
    }

    public GroupAndMembers getGroupMembers(String groupId) {
        return null;
    }
}
