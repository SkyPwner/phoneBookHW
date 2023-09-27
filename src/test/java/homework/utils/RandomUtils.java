package homework.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    private static Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomPassword() {
        return faker.internet().password(8, 16, true, true, true);
    }
}