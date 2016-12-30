package com.thoughtworks.salestax.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Receipt {
    private String text;

    public Receipt() {
        text = "";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * Writes the final receipt text to a file
     * @param argPos - The position within the Main "args" String array
     * @throws IOException if there is an error with the BufferedWriter or FileWriter
     */
    public void print(int argPos) throws IOException {
        BufferedWriter bw;
        String fileName = "receipt" + (argPos + 1) + ".txt";
        bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(text);
        System.out.printf("Receipt:%n%s%n%n===========================%n%n",text);
        System.out.printf("Your receipt has also been printed to %s!%n%n===========================%n", fileName);
        bw.close();
    }
}
