package com.thoughtworks.salestax;

import com.thoughtworks.salestax.model.Item;
import com.thoughtworks.salestax.model.ShoppingCart;
import com.thoughtworks.salestax.util.ItemParser;

import java.io.*;
import java.util.stream.Stream;

import static com.thoughtworks.salestax.util.Constants.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br;
        ItemParser parser = new ItemParser();

        if(args.length > 0) {
            try {
                for (int j = 0; j < args.length; j++) {
                    String fileName = args[j];
                    br = new BufferedReader(new FileReader(args[j]));
                    Stream<String> lines = br.lines();

                    ShoppingCart cart = new ShoppingCart();

                    lines.forEach(line -> {
                        Item item = parser.parseItem(line,fileName);
                        cart.addItem(item);
                    });
                    br.close();

                    cart.createReceipt(STANDARD_TAX, IMPORT_TAX);
                    System.out.printf("%n===========================%n%n");
                    cart.getReceipt().print(j);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No input found. Please make sure to pass in file names as arguments to the program");
        }
    }
}
