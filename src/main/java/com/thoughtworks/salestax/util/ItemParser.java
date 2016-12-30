package com.thoughtworks.salestax.util;

import com.thoughtworks.salestax.ex.ParseException;
import com.thoughtworks.salestax.model.Item;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    /**
     * @param line The line to be parsed into an Item
     * @param fileName The file the line came from. (Only used when catching a ParseException)
     * @see ParseException
     * @return The item parsed from the line
     */
    public Item parseItem(String line, String fileName) {
        /* Any number of digits, followed by a space, followed by any number of words, followed by " at ",
           followed by a number formatted like 'D.XX' where D can by any number of digits */
        Pattern pattern = Pattern.compile("(?<quantity>\\d+)" +
                "\\s+" +
                "(?<name>.*)" +
                "\\s+at\\s+" +
                "(?<price>\\d+\\.\\d{2})");
        Matcher matcher = pattern.matcher(line);

        if(matcher.find()) {
            return new Item(matcher.group("name"),
                    Double.parseDouble(matcher.group("price")),
                    Integer.parseInt(matcher.group("quantity")));
        } else {
            throw new ParseException(line,fileName);
        }
    }
}
