package se.edinjakupovic;

import org.flywaydb.core.Flyway;

public class DbMigration {

    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .failOnMissingLocations(true)
                .dataSource("jdbc:mysql://localhost:3306/social", "social", "social")
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}
