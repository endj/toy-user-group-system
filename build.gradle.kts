plugins {
    id("java")
    id("nu.studer.jooq") version "8.2"
}


group = "se.edinjakupovic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

jooq {
    configurations {
        create("main") {
            configurations {
                jooqConfiguration.apply {
                    jdbc.apply {
                        driver = "com.mysql.cj.jdbc.Driver"
                        url = "jdbc:mysql://localhost:3306/social"
                        user = "social"
                        password = "social"
                    }
                    generator.apply {
                        name = "org.jooq.codegen.DefaultGenerator"
                        database.apply {
                            name = "org.jooq.meta.mysql.MySQLDatabase"
                            includes = ".*"
                            inputSchema = "social" // Replace with your database schema
                        }
                        generate.apply {
                            isDeprecated = false
                            isRecords = false
                            isImmutablePojos = true
                            isFluentSetters = false
                        }
                        target.apply {
                            packageName = "se.edinjakupovic.generated"
                            directory = "src/generated/jooq"
                        }
                    }
                }
            }
        }
    }
}


dependencies {
    implementation("org.jooq:jooq:3.18.6")
    implementation("org.jooq:jooq-meta:3.18.6")
    implementation("org.jooq:jooq-codegen:3.18.6")

    implementation("com.zaxxer:HikariCP:5.0.1")


    implementation("mysql:mysql-connector-java:8.0.33")


    jooqGenerator("mysql:mysql-connector-java:8.0.33")
    implementation("org.flywaydb:flyway-core:9.21.2")
    implementation("org.flywaydb:flyway-mysql:9.21.2")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<nu.studer.gradle.jooq.JooqGenerate>("generateJooq") {
    // generateJooq can be configured to use a different/specific toolchain
    (launcher::set)(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(17))
    })
}
