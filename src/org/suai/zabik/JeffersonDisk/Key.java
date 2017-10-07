package org.suai.zabik.JeffersonDisk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Key {
    private int shift;
    private String ciphertext;

    public Key(String ciphertext, int shift) {
        this.ciphertext = ciphertext;
        this.shift = shift;
    }

    public Key(String path) {
        final String shiftFileName = "shift.txt";
        final String textFileName = "ciphertext.txt";
        BufferedWriter bufferedWriter = null;
        try {
            shift = new Scanner(new File(path + shiftFileName)).nextInt();
            byte[] rawText = Files.readAllBytes(Paths.get(path + textFileName));
            ciphertext = new String(rawText, Charset.forName("US-ASCII"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getShift() {
        return shift;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public void writeCiphertext(String path) {
        final String fileName = "ciphertext.txt";
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = Files.newBufferedWriter(Paths.get(path + fileName), Charset.forName("US-ASCII"),StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            bufferedWriter.write(ciphertext);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeShift(String path) {
        final String fileName = "shift.txt";
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = Files.newBufferedWriter(Paths.get(path + fileName),StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            bufferedWriter.write(String.valueOf(shift));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
