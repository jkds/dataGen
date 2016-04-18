package com.maskibth.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

class DataUtils {

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom stringRandom = new SecureRandom();
    private static String[] currencyArray;

    static String generateRandomString(int length) {
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(AB.charAt(stringRandom.nextInt(AB.length())));
        }
        return builder.toString();
    }

    static int generateRandomInteger(int max) {
        return stringRandom.nextInt(max - 1) + 1;
    }

    static String generateRandomDate(int fromYear, int toYear) {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(fromYear, toYear);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        return format.format(gc.getTime());
    }

    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    static String generateRandomCurrency() {
        if (currencyArray == null || currencyArray.length < 1) {
            readCurrencyFromFile();
        }
        return currencyArray[stringRandom.nextInt(166)];
    }

    private static void readCurrencyFromFile() {
        List<String> currencyList = new ArrayList<>();
        BufferedReader br = null;
        try {
            FileInputStream fstream = new FileInputStream("src/main/resources/currency.txt");
            br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                currencyList.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        currencyArray = new String[currencyList.size()];
        currencyList.toArray(currencyArray);
    }

    static String[] generateHeaders() {
        String headerString = "col1Int,col2String,col3String,col4String,col5String,col6Date, col7Date,col8String, col9Int, col10Int, col11Date, col12String, col13String, col14String, col15String," +
                "col16Enum, col17String, col18String, col19Int, col20String ";
        return headerString.split(",");
    }

    enum STATUS {

        NEW, AMEND, CANCEL;

        private static final List<STATUS> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

        private static final int SIZE = VALUES.size();
        private static final SecureRandom RANDOM = new SecureRandom();

        public static STATUS getRandomStatus() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }

    }

}
