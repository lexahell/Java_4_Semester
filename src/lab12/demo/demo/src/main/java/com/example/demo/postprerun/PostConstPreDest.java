package com.example.demo.postprerun;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Scanner;

@Component
public class PostConstPreDest implements CommandLineRunner {
    StringBuilder hash = new StringBuilder("null");
    String output;

    @Override
    public void run(String... args) throws Exception {
        String inputFilePath = "C:\\Users\\aleks\\IdeaProjects\\Java_4_Semester\\src\\lab12\\demo\\demo\\src\\main\\resources\\static\\"+args[0];
        output = args[1];
        File file = new File(inputFilePath);
        FileInputStream fis = new FileInputStream(file);

        hash.delete(0, hash.length());

        Scanner scanner = new Scanner(fis);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            hash.append(line);
        }
        scanner.close();
        fis.close();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] hashBytes = digest.digest(hash.toString().getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        hash = hexString;
        System.out.println(hash + " " + output);
    }

    @PreDestroy
    public void bye() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\aleks\\IdeaProjects\\Java_4_Semester\\src\\lab12\\demo\\demo\\src\\main\\resources\\static\\"+output);
            writer.write(hash.toString());
            writer.close();
        } catch (IOException ignored) {

        }
    }
}
