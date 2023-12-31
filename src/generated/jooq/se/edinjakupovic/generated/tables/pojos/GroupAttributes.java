/*
 * This file is generated by jOOQ.
 */
package se.edinjakupovic.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GroupAttributes implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer id;
    private final String groupId;
    private final String attributeKey;
    private final String attributeValue;

    public GroupAttributes(GroupAttributes value) {
        this.id = value.id;
        this.groupId = value.groupId;
        this.attributeKey = value.attributeKey;
        this.attributeValue = value.attributeValue;
    }

    public GroupAttributes(
        Integer id,
        String groupId,
        String attributeKey,
        String attributeValue
    ) {
        this.id = id;
        this.groupId = groupId;
        this.attributeKey = attributeKey;
        this.attributeValue = attributeValue;
    }

    /**
     * Getter for <code>social.group_attributes.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Getter for <code>social.group_attributes.group_id</code>.
     */
    public String getGroupId() {
        return this.groupId;
    }

    /**
     * Getter for <code>social.group_attributes.attribute_key</code>.
     */
    public String getAttributeKey() {
        return this.attributeKey;
    }

    /**
     * Getter for <code>social.group_attributes.attribute_value</code>.
     */
    public String getAttributeValue() {
        return this.attributeValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final GroupAttributes other = (GroupAttributes) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.groupId == null) {
            if (other.groupId != null)
                return false;
        }
        else if (!this.groupId.equals(other.groupId))
            return false;
        if (this.attributeKey == null) {
            if (other.attributeKey != null)
                return false;
        }
        else if (!this.attributeKey.equals(other.attributeKey))
            return false;
        if (this.attributeValue == null) {
            if (other.attributeValue != null)
                return false;
        }
        else if (!this.attributeValue.equals(other.attributeValue))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.groupId == null) ? 0 : this.groupId.hashCode());
        result = prime * result + ((this.attributeKey == null) ? 0 : this.attributeKey.hashCode());
        result = prime * result + ((this.attributeValue == null) ? 0 : this.attributeValue.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GroupAttributes (");

        sb.append(id);
        sb.append(", ").append(groupId);
        sb.append(", ").append(attributeKey);
        sb.append(", ").append(attributeValue);

        sb.append(")");
        return sb.toString();
    }
}
