package utils;
import java.io.FileWriter;
import java.io.IOException;

public class TestDataGenerator {
    public static void main(String[] args) {
        int numberOfUsers = 3;
        String csvFilePath = "src/test/resources/datareg.yaml";

        try (FileWriter writer = new FileWriter(csvFilePath )) {
            for (int i = 0; i < numberOfUsers; i++) {
                String randomEmail = RandomUtils.randomEmail();
                String randomPassword = RandomUtils.randomPassword();

                writer.write(randomEmail + "," + randomPassword + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
