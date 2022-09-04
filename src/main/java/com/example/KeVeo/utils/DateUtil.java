package com.example.KeVeo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    private static final DateTimeFormatter DATE_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String dateToString(ZonedDateTime date) {
        return date != null ? date.format(DATE_FORMATER) : null;
    }

    public static ZonedDateTime stringToDate(String stringDate) {
        return ZonedDateTime.parse(stringDate, DATE_FORMATER.withZone(ZoneId.of("UTC")));
    }

    public static Date stringToDatedate(String stringDate) throws ParseException {

           return new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);

    }
}