package com.maskibth.util;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.IOException;
import java.util.List;

/**
 * Created on 20/04/2016.
 */
public interface Generator {

    void generate(String fileWithAbsolutePath, int rowCount) throws IOException;


    default void flush(CSVWriter writer, List<String[]> rows) throws IOException {
        writer.writeAll(rows);
        writer.flush();
        rows.clear();
    }

}
