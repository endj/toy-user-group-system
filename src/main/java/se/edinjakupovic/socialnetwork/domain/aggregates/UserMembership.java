package se.edinjakupovic.socialnetwork.domain.aggregates;

import se.edinjakupovic.socialnetwork.domain.Group;
import se.edinjakupovic.socialnetwork.domain.User;

import java.util.Collection;


public record UserMembership(User user, Collection<Group> groupsJoined) {
}
