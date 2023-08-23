/*
 * This file is generated by jOOQ.
 */
package se.edinjakupovic.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GroupUserMembership implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String groupId;
    private final String userId;

    public GroupUserMembership(GroupUserMembership value) {
        this.groupId = value.groupId;
        this.userId = value.userId;
    }

    public GroupUserMembership(
        String groupId,
        String userId
    ) {
        this.groupId = groupId;
        this.userId = userId;
    }

    /**
     * Getter for <code>social.group_user_membership.group_id</code>.
     */
    public String getGroupId() {
        return this.groupId;
    }

    /**
     * Getter for <code>social.group_user_membership.user_id</code>.
     */
    public String getUserId() {
        return this.userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final GroupUserMembership other = (GroupUserMembership) obj;
        if (this.groupId == null) {
            if (other.groupId != null)
                return false;
        }
        else if (!this.groupId.equals(other.groupId))
            return false;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.groupId == null) ? 0 : this.groupId.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GroupUserMembership (");

        sb.append(groupId);
        sb.append(", ").append(userId);

        sb.append(")");
        return sb.toString();
    }
}