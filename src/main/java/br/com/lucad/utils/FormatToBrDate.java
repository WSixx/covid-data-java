package br.com.lucad.utils;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatToBrDate {

    @NotNull
    public static String getFormatedDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        try {
            Date parsedDate = dateFormat.parse(date);
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

}
