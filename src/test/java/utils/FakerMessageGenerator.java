package utils;

import com.github.javafaker.Faker;

public class FakerMessageGenerator {

    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String generatePassword() {
        return new Faker().internet().password();
    }

    public static String generateTitle() {
        return new Faker().company().name();
    }

    public static String generateCodeForProject() {
        return new Faker().lorem().characters(2, 9).toUpperCase();
    }

    public static String generateText() {
        return new Faker().lorem().sentence();
    }

    public static Integer generateSeverity() {
        return new Faker().number().numberBetween(1, 7);
    }

    public static Integer generatePriority() {
        return new Faker().number().numberBetween(1, 4);
    }
    public static String generateName() {
        return new Faker().name().fullName();
    }
}