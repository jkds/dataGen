package com.maskibth.util;

import au.com.bytecode.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DataGenerator20 implements Generator {

    private static final Logger log = LoggerFactory.getLogger(DataGenerator20.class);

    public void generate(String fileWithAbsolutePath, int rowCount) throws IOException {


        CSVWriter writer = new CSVWriter(new FileWriter(fileWithAbsolutePath));

        List<String[]> rows = new ArrayList<>();
        rows.add(DataUtils.generate20Headers());

        for (int i = 0; i < rowCount; i++) {

            String[] row = new String[DataUtils.generate20Headers().length];

            int j = 0;
            row[j++] = Integer.toString(DataUtils.generateRandomInteger(500));
            row[j++] = DataUtils.generateRandomString(20);
            row[j++] = DataUtils.generateRandomString(8);
            row[j++] = DataUtils.generateRandomString(19);
            row[j++] = DataUtils.generateRandomString(10);
            row[j++] = DataUtils.generateRandomDate(1995, 2016);
            row[j++] = DataUtils.generateRandomDate(2000, 2016);
            row[j++] = DataUtils.generateRandomString(20);
            row[j++] = Integer.toString(DataUtils.generateRandomInteger(1000));
            row[j++] = Integer.toString(DataUtils.generateRandomInteger(5));
            row[j++] = DataUtils.generateRandomDate(2015, 2016);
            row[j++] = DataUtils.generateRandomString(4);
            row[j++] = DataUtils.generateRandomString(8);
            row[j++] = DataUtils.generateRandomString(8);
            row[j++] = DataUtils.generateRandomString(17);
            row[j++] = DataUtils.STATUS.getRandomStatus().toString();
            row[j++] = DataUtils.generateRandomString(14);
            row[j++] = DataUtils.generateRandomString(19);
            row[j++] = Integer.toString(DataUtils.generateRandomInteger(500));
            row[j] = DataUtils.generateRandomCurrency();
            rows.add(row);

            if(i % 10000 == 0) {
                flush(writer, rows);
            }
            if(i % 100000 == 0) {
                log.debug("Written {} rows", i);
            }



        }

        flush(writer,rows);
        writer.close();

    }

}
