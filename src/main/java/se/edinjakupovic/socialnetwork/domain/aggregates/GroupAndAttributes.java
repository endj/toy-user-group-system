package se.edinjakupovic.socialnetwork.domain.aggregates;

import se.edinjakupovic.socialnetwork.domain.Attribute;
import se.edinjakupovic.socialnetwork.domain.Group;

import java.util.Collection;

public record GroupAndAttributes(Group group, Collection<Attribute> groupAttributes) {
}
