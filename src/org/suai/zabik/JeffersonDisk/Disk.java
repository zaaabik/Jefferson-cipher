package org.suai.zabik.JeffersonDisk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import static java.nio.file.Files.readAllLines;

public class Disk {
    private int diskCount;
    Vector<Vector<Character>> disks;
    final int alphabetLength = 128;

    public Disk(int diskCount, Vector<Character> alphabet) {
        this.diskCount = diskCount;
        disks = new Vector<>();
        for (int i = 0; i < diskCount; ++i) {
            disks.add(new Vector<>(alphabet));
            Collections.shuffle(disks.get(i));
        }
    }

    public Disk(String path, int diskCount) throws IOException {
        path += "disk.txt";
        disks = new Vector<>();
        this.diskCount = diskCount;
        byte[] rawDisks = Files.readAllBytes(Paths.get(path));
        String allDisks = new String(rawDisks);
        for (int i = 0; i < diskCount; ++i) {
            String subStr = allDisks.substring(i * alphabetLength, (i + 1) * alphabetLength);
            Vector<Character> tmpVec = new Vector<>();
            for (int j = 0; j < subStr.length(); ++j) {
                tmpVec.add(subStr.charAt(j));
            }
            disks.add(tmpVec);
        }
    }

    public int getAlphabetLength() {
        return disks.get(0).size();
    }

    public int getDiskCount() {
        return diskCount;
    }

    public int getCharacterPosition(char character, int diskNumber) {
        return disks.get(diskNumber).indexOf(character);
    }

    public char getCharacter(int pos, int diskNumber) {
        return disks.get(diskNumber).elementAt(pos);
    }

    public void writeDisk(String path) throws IOException {
        path += "disk.txt";
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path), Charset.forName("US-ASCII"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        for (Vector<Character> i : disks) {
            StringBuilder sb = new StringBuilder();
            for (char j : i) {
                sb.append(j);
            }
            bufferedWriter.write(sb.toString());
        }
        bufferedWriter.close();
    }
}
