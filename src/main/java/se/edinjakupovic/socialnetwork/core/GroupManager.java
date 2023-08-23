package se.edinjakupovic.socialnetwork.core;

import org.jooq.DSLContext;
import se.edinjakupovic.socialnetwork.api.request.CreateGroupRequest;
import se.edinjakupovic.socialnetwork.domain.Attribute;
import se.edinjakupovic.socialnetwork.domain.Group;
import se.edinjakupovic.socialnetwork.domain.aggregates.GroupAndAttributes;

import java.util.Collection;

public class GroupManager {

    private final DSLContext dsl;

    public GroupManager(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Group createGroup(CreateGroupRequest name) {
        return null;
    }

    public Group getGroupById(String id) {
        return null;
    }

    public GroupAndAttributes createGroupWithAttributes(CreateGroupRequest request, Collection<Attribute> attributes) {
        return null;
    }

    public GroupAndAttributes getGroupWithAttributes(String id) {
        return null;
    }

    public Group addAttributes(String id, Collection<Attribute> attributes) {
        return null;
    }

    public Group removeAttributes(String id, Collection<String> attributeKeys) {
        return null;
    }
}
