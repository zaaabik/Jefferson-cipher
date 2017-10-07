package org.suai.zabik.JeffersonDisk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Vector;

public class JeffersonCypher {
    public static Disk createDisks(int diskCount) {
        final int charactersCount = 128;
        Vector<Character> alphabet = new Vector();
        for (char i = 0; i < charactersCount; ++i) {
            alphabet.add(i);
        }
        Disk disk = new Disk(diskCount, alphabet);
        return disk;
    }

    public static Key encrypt(Disk disk, String input) {
        int alphabetLength = disk.getAlphabetLength();
        Random rand = new Random();
        int shift = rand.nextInt() % (alphabetLength - 1) + 1;
        if (shift < 0) {
            shift = alphabetLength + shift;
        }
        Vector<Character> result = new Vector();
        for (int i = 0; i < input.length(); ++i) {
            result.add(disk.getCharacter((disk.getCharacterPosition(input.charAt(i), i) + shift) % alphabetLength, i));
        }
        System.out.println(shift);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); ++i) {
            sb.append(result.elementAt(i));
        }
        return new Key(sb.toString(), shift);
    }

    public static String decrypt(Disk disk, String encryptedText, int shift) {
        int alphabetLength = disk.getAlphabetLength();
        Vector<Character> result = new Vector();
        for (int i = 0; i < encryptedText.length(); ++i) {
            int pos = ((disk.getCharacterPosition(encryptedText.charAt(i), i) - shift) % alphabetLength);
            if (pos < 0) {
                pos = alphabetLength + pos;
            }
            result.add(disk.getCharacter(pos, i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); ++i) {
            sb.append(result.elementAt(i));
        }
        return sb.toString();
    }

    public static String decrypt(String path) {
        String res = "";
        try {
            String ciphertext = new String(Files.readAllBytes(Paths.get(path + "ciphertext.txt")), "US-ASCII");
            Disk encrDisk = new Disk(path, ciphertext.length());
            Key encrKey = new Key(path);
            res = JeffersonCypher.decrypt(encrDisk, ciphertext, encrKey.getShift());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String encrypt(String path) {
        String res = "";
        try {
            String inputText = new String(Files.readAllBytes(Paths.get(path + "in.txt")), "US-ASCII");
            Disk disk = createDisks(inputText.length());
            disk.writeDisk(path);
            Key key = encrypt(disk, inputText);
            key.writeCiphertext(path);
            key.writeShift(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


}