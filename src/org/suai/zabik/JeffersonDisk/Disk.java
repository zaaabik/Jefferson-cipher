package org.suai.zabik.JeffersonDisk;

import java.util.Collections;
import java.util.Vector;

public class Disk {
    private int diskCount;
    Vector<Vector<Character>> disks;

    public Disk(int diskCount, Vector<Character> alphabet) {
        this.diskCount = diskCount;
        disks = new Vector<>();
        for(int i = 0; i < diskCount;++i){
            disks.add(new Vector<>(alphabet));
            Collections.shuffle(disks.get(i));
        }
    }

    public int getAlphabetLength(){
        return disks.get(0).size();
    }

    public int getDiskCount(){
        return diskCount;
    }

    public int getCharacterPosition(char character, int diskNumber){
        return disks.get(diskNumber).indexOf(character);
    }
    public char getCharacter(int pos, int diskNumber){
        return disks.get(diskNumber).elementAt(pos);
    }


}
