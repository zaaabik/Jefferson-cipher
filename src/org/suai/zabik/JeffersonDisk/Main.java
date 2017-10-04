package org.suai.zabik.JeffersonDisk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;



public class Main {

    public static void main(String[] args) throws IOException {

    final int alphabetLength = 128;
        String in = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "//cipherText.txt")), "US-ASCII");
        Disk disk = new Disk(System.getProperty("user.dir") + "//disk.txt", alphabetLength, in.length());
//        Disk disk = JeffersonCypher.createDisks(in.length());
//        disk.writeDisk(System.getProperty("user.dir") + "//disk.txt");

        String res = JeffersonCypher.decrypt(disk, in, 114);
//        System.out.println(res);
//        BufferedWriter out = Files.newBufferedWriter(Paths.get(System.getProperty("user.dir") + "//res.txt"), Charset.forName("US-ASCII"),StandardOpenOption.CREATE);
//        out.write(res);
//        out.close();
//        Key key = JeffersonCypher.encrypt(disk, in);
//        BufferedWriter cipheText = Files.newBufferedWriter(Paths.get(System.getProperty("user.dir") + "//cipherText.txt"), Charset.forName("US-ASCII"), StandardOpenOption.WRITE);
//        cipheText.write(key.getCiphertext());
//        cipheText.close();
//        BufferedWriter shift = Files.newBufferedWriter(Paths.get(System.getProperty("user.dir") + "//shift.txt"), Charset.forName("US-ASCII"),StandardOpenOption.WRITE);
//        shift.write(String.valueOf(key.getShift()));
//        shift.close();
        //disk.writeDisk(System.getProperty("user.dir") + "//disk.txt");
        System.out.println(res);
    }
}