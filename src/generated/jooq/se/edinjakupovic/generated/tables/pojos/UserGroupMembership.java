/*
 * This file is generated by jOOQ.
 */
package se.edinjakupovic.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserGroupMembership implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String userId;
    private final String groupId;

    public UserGroupMembership(UserGroupMembership value) {
        this.userId = value.userId;
        this.groupId = value.groupId;
    }

    public UserGroupMembership(
        String userId,
        String groupId
    ) {
        this.userId = userId;
        this.groupId = groupId;
    }

    /**
     * Getter for <code>social.user_group_membership.user_id</code>.
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * Getter for <code>social.user_group_membership.group_id</code>.
     */
    public String getGroupId() {
        return this.groupId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserGroupMembership other = (UserGroupMembership) obj;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.groupId == null) {
            if (other.groupId != null)
                return false;
        }
        else if (!this.groupId.equals(other.groupId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.groupId == null) ? 0 : this.groupId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserGroupMembership (");

        sb.append(userId);
        sb.append(", ").append(groupId);

        sb.append(")");
        return sb.toString();
    }
}