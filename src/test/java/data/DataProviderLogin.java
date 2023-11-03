package data;

import dto.UserInfoLombok;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderLogin {

    @DataProvider
    public Iterator<Object[]> negativePasswordDataLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                UserInfoLombok.builder()
                        .email("testqa20@gmail.com")
                        .password("123456A88")
                        .build()
        });
        list.add(new Object[]{
                UserInfoLombok.builder()
                        .email("testqa20@gmail.com")
                        .password("123456Aaa")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginCSV() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/datalogin.csv";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("datalogin.csv")))) {
            String line = reader.readLine();
            while(line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{
                        UserInfoLombok.builder()
                                .email(split[0])
                                .password(split[1])
                                .build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }
}
