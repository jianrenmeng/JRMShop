package com.qf.servlet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        DateTimeFormatter FORMAT_FOURTEEN = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");

        DateTimeFormatter FORMAT_NINETEEN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        System.out.println(FORMAT_FOURTEEN.format(LocalDateTime.now()));
        System.out.println(FORMAT_DATE.format(LocalDateTime.now()));
        System.out.println(FORMAT_NINETEEN.format(LocalDateTime.now()));

    }
}

