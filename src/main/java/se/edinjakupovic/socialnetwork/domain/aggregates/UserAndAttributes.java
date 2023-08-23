package se.edinjakupovic.socialnetwork.domain.aggregates;

import se.edinjakupovic.socialnetwork.domain.Attribute;
import se.edinjakupovic.socialnetwork.domain.User;

import java.util.Collection;

public record UserAndAttributes(User user, Collection<Attribute> attributes) {
}
