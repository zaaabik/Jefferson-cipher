package org.suai.zabik.JeffersonDisk;

import java.util.Random;
import java.util.Vector;

public class JeffersonCypher {
    public static Disk createDisks(int diskCount){
        final int charactersCount = 128;
        Vector<Character> alphabet = new Vector();
        for(char i = 0; i < charactersCount;++i){
            alphabet.add(i);
        }
        Disk disk = new Disk(diskCount,alphabet);
        return disk;
    }


    public static String encrypt(Disk disk, String input, int shift){
        int alphabetLength = disk.getAlphabetLength();
        //int shift = rand.nextInt() % (alphabetLength - 1) + 1;
        Vector<Character> result =  new Vector();
        for(int i = 0; i < input.length();++i){
            result.add(disk.getCharacter((disk.getCharacterPosition(input.charAt(i),i) + shift) % alphabetLength,i));
        }
        System.out.println(shift);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size();++i){
            sb.append(result.elementAt(i));
        }
        return  sb.toString();
    }

    public static String decrypt(Disk disk, String encryptedText, int shift){
        int alphabetLength = disk.getAlphabetLength();
        Vector<Character> result =  new Vector();
        for(int i = 0; i < encryptedText.length();++i){
            int pos = ((disk.getCharacterPosition(encryptedText.charAt(i),i)  - shift) % alphabetLength);
            if(pos < 0){
                pos = alphabetLength + pos;
            }
            result.add((char)disk.getCharacter(pos,i));
        }
        System.out.println(shift);
        return  result.toString();
    }


}
