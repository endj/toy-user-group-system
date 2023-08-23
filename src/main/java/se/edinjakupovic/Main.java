package se.edinjakupovic;

import se.edinjakupovic.socialnetwork.api.request.CreateUserRequest;
import se.edinjakupovic.socialnetwork.config.App;
import se.edinjakupovic.socialnetwork.domain.Attribute;
import se.edinjakupovic.socialnetwork.domain.aggregates.UserAndAttributes;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DbMigration.migrate();
        var socialNetworkClient = App.socialNetwork("edin");


        String newUserId = socialNetworkClient.handleRequest(
                socialNetwork -> socialNetwork.createUser(new CreateUserRequest("Joe"))
        );


        expectException(() -> socialNetworkClient.handleRequest(
                newUserId,
                socialNetwork -> socialNetwork.addUserAttributes(
                        newUserId,
                        List.of(new Attribute("level", "admin"))
                )
        ));


        UserAndAttributes afterMakingAdmin = socialNetworkClient.handleRequest(
                socialNetwork -> socialNetwork.addUserAttributes(
                        newUserId,
                        List.of(new Attribute("level", "admin"))
                )
        );
        System.out.println("User after making admin: " + afterMakingAdmin);

        UserAndAttributes afterCool = socialNetworkClient.handleRequest(
                newUserId,
                socialNetwork -> socialNetwork.addUserAttributes(
                        newUserId,
                        List.of(new Attribute("cool", "true"))
                ));

        System.out.println("After cool: " + afterCool);
    }

    static void expectException(Runnable run) {
        boolean threw = false;
        try {
            run.run();
        } catch (Exception e) {
            threw = true;
        }
        if (!threw) {
            throw new IllegalStateException("Expected to throw");
        }
    }
}