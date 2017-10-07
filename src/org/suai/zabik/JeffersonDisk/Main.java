package org.suai.zabik.JeffersonDisk;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {
        final String defaultFilePath = (System.getProperty("user.dir") + "/");
        //JeffersonCypher.encrypt(defaultFilePath);
        String result = JeffersonCypher.decrypt(defaultFilePath);
        showRes(defaultFilePath, result);
    }

    public static void showRes(String path, String str) {
        try {
            System.out.println(str);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path + "res.txt"), Charset.forName("US-ASCII"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}