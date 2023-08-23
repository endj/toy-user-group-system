package se.edinjakupovic.socialnetwork.domain.aggregates;

import se.edinjakupovic.socialnetwork.domain.Group;

import java.util.List;


public record GroupMembership(Group group, List<String> groupMemberIds) {
}
