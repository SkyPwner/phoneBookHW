package data;

import dto.UserInfoLombok;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.annotations.DataProvider;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    public Iterator<Object[]> loginYAML() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("datalogin.yaml");
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            UserInfoLombok[] userData = mapper.readValue(is, UserInfoLombok[].class);

            return Arrays.stream(userData)
                    .map(user -> new Object[]{user})
                    .iterator();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @DataProvider
    public Iterator<Object[]> regYAML() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("datareg.yaml");
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            UserInfoLombok[] userData = mapper.readValue(is, UserInfoLombok[].class);

            return Arrays.stream(userData)
                    .map(user -> new Object[]{user})
                    .iterator();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}