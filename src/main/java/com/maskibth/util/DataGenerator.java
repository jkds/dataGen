package com.maskibth.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class DataGenerator {

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom stringRandom = new SecureRandom();

    public static String generateStringFor(int length) {
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(AB.charAt(stringRandom.nextInt(AB.length())));
        }
        return builder.toString();
    }

    public void generate() {

        int rowCount = 10;
        int columnCount = 9;

        List<String[]> rows = new ArrayList<>();
        rows.add(DataGenerator.generateHeaders());

        for (int i = 1; i < rowCount; i++) {
            String[] row = new String[columnCount];
            row[0] = Integer.toString(DataGenerator.generateIntegerFor(20_000_000));
            row[1] = DataGenerator.generateStringFor(20);
            row[2] = DataGenerator.generateStringFor(20);
            row[3] = DataGenerator.generateStringFor(20);
            row[4] = DataGenerator.generateStringFor(20);
            row[5] = DataGenerator.generateRandomDates(1900, 2016);
            row[6] = DataGenerator.generateRandomDates(1900, 2016);
            row[7] = DataGenerator.generateStringFor(20);
            row[8] = Integer.toString(DataGenerator.generateIntegerFor(20_000_000));
            rows.add(row);
        }

        CsvGenerator.writeCsv("/Users/rockstar/Documents/workspace/idea-ws/dataGen/data.csv", rows);

    }

    private static int generateIntegerFor(int max) {
        return stringRandom.nextInt(max - 1) + 1;
    }

    private static String[] generateHeaders() {
        String headerString = "col1Int,col2String,col3String,col4String,col4String,col6Date, col7date,col8String, col9Int";
        return headerString.split(",");
    }

    private static String generateRandomDates(int fromYear, int toYear) {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(fromYear, toYear);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.getTime().toString();
    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

}
