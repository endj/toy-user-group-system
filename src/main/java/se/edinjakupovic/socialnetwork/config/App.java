package se.edinjakupovic.socialnetwork.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import se.edinjakupovic.socialnetwork.api.interceptor.AccessControlProxyFactory;
import se.edinjakupovic.socialnetwork.api.interceptor.RequestContext;
import se.edinjakupovic.socialnetwork.api.interceptor.SocialNetworkClient;
import se.edinjakupovic.socialnetwork.core.GroupManager;
import se.edinjakupovic.socialnetwork.core.MembershipHandler;
import se.edinjakupovic.socialnetwork.core.UserManager;


import static java.util.Objects.requireNonNull;
import static se.edinjakupovic.generated.Tables.USERS;

public class App {

    public static SocialNetworkClient socialNetwork(String userName) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/social");
        config.setUsername("social");
        config.setPassword("social");


        DSLContext dsl = DSL.using(new HikariDataSource(config), SQLDialect.MYSQL);

        String id = dsl.select(USERS.ID)
                .from(USERS)
                .where(USERS.NAME.eq(userName))
                .fetchOne(Record1::value1);
        requireNonNull(id, "No user with name " + userName);

        RequestContext requestContext = new RequestContext();
        AccessControlProxyFactory accessControlProxyFactory = new AccessControlProxyFactory(
                new UserManager(dsl),
                new GroupManager(dsl),
                new MembershipHandler(dsl),
                requestContext
        );


        return new SocialNetworkClient(
                accessControlProxyFactory.socialNetwork(),
                requestContext,
                id
        );
    }
}
