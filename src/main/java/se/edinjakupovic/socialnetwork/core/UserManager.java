package se.edinjakupovic.socialnetwork.core;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Row3;
import org.jooq.impl.DSL;
import se.edinjakupovic.socialnetwork.api.request.CreateUserRequest;
import se.edinjakupovic.socialnetwork.domain.Attribute;
import se.edinjakupovic.socialnetwork.domain.User;
import se.edinjakupovic.socialnetwork.domain.aggregates.UserAndAttributes;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static se.edinjakupovic.generated.Tables.USERS;
import static se.edinjakupovic.generated.Tables.USER_ATTRIBUTES;

public class UserManager {
    private final DSLContext dsl;

    public UserManager(DSLContext dsl) {
        this.dsl = dsl;
    }

    public String createUser(CreateUserRequest request) {
        var id = UUID.randomUUID().toString();
        dsl.insertInto(USERS)
                .columns(USERS.ID, USERS.NAME)
                .values(id, request.name())
                .execute();
        return id;
    }

    public User getUserById(String id) {
        return null;
    }

    public UserAndAttributes addUserAttributes(String id, Collection<Attribute> attributes) {
        return dsl.transactionResult(configuration -> {
            List<Row3<String, String, String>> rows = attributes.stream()
                    .map(attribute -> DSL.row(id, attribute.key(), attribute.value()))
                    .toList();

            dsl.insertInto(USER_ATTRIBUTES)
                    .columns(USER_ATTRIBUTES.USER_ID,
                            USER_ATTRIBUTES.ATTRIBUTE_KEY,
                            USER_ATTRIBUTES.ATTRIBUTE_VALUE)
                    .valuesOfRows(rows)
                    .execute();

            return getUserAndAttributesById(id);
        });
    }

    public UserAndAttributes removeAttributes(String id, Collection<String> attributeKeys) {
        return null;
    }

    @SuppressWarnings("DataFlowIssue")
    public boolean isAdmin(String userId) {
        return dsl.selectCount()
                       .from(USER_ATTRIBUTES)
                       .where(USER_ATTRIBUTES.ATTRIBUTE_KEY.eq("level")
                               .and(USER_ATTRIBUTES.ATTRIBUTE_VALUE.eq("admin")))
                       .and(USER_ATTRIBUTES.USER_ID.eq(userId)) // Replace with the actual user ID
                       .fetchOne(Record1::value1) > 0;
    }

    public UserAndAttributes getUserAndAttributesById(String id) {
        List<Attribute> newAttributes = fetchUserAttributes(id);
        String name = fetchUserName(id);
        return new UserAndAttributes(
                new User(name, id),
                newAttributes
        );
    }

    private String fetchUserName(String id) {
        return dsl.select(USERS.NAME)
                .from(USERS)
                .where(USERS.ID.eq(id))
                .fetchOne(Record1::value1);
    }

    private List<Attribute> fetchUserAttributes(String id) {
        return dsl.select(USER_ATTRIBUTES.ATTRIBUTE_KEY, USER_ATTRIBUTES.ATTRIBUTE_VALUE)
                .from(USER_ATTRIBUTES)
                .where(USER_ATTRIBUTES.USER_ID.eq(id))
                .fetch(rec -> new Attribute(rec.value1(), rec.value2()));
    }
}
