package org.suai.zabik.JeffersonDisk;

public class Main {

    public static void main(String[] args) {
        String in = "hello, i am Artem!";
        Disk disk = JeffersonCypher.createDisks(in.length());
        String t1 = JeffersonCypher.encrypt(disk, in, 10);
        String result = JeffersonCypher.decrypt(disk,t1 , 10);

        System.out.println(result);
    }
}