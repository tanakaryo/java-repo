package com.example.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
        list.forEach((element) -> {
            Path file = Paths.get(StringUtils.trim(element));
            try {
                String content = Files.readString(file);
                System.out.println(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
