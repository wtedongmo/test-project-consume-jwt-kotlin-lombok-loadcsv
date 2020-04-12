package com.twb.loadfile.csv;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.catalina.mapper.Mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CsvUtils {

    public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException { //, String... columns
        CsvMapper mapper = new CsvMapper();//.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY).;
        CsvSchema schema = mapper.schemaFor(clazz)
                .withColumnSeparator(';')
                .withColumnReordering(true)
                .sortedBy("id", "username", "phoneNumber", "address");
        CsvSchema.Column col = schema.column("id").withType(CsvSchema.ColumnType.NUMBER);
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        return reader.<T>readValues(stream).readAll();
    }
}
