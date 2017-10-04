package org.suai.zabik.JeffersonDisk;

public class Key {
    private int shift;
    private String ciphertext;

    public Key(String ciphertext, int shift) {
        this.ciphertext = ciphertext;
        this.shift = shift;
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
}
