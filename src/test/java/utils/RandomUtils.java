package utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

public class RandomUtils {
    private static Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomPassword() {
        return faker.internet().password(8, 12, true, true, true);
    }

    public static String generateStringDigits(int length) {
        return faker.numerify(StringUtils.repeat("#", length));
    }
}