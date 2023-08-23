package se.edinjakupovic.socialnetwork.domain.aggregates;

import se.edinjakupovic.socialnetwork.domain.Group;
import se.edinjakupovic.socialnetwork.domain.User;

import java.util.Collection;

public record GroupAndMembers(Group group, Collection<User> users) {
}
