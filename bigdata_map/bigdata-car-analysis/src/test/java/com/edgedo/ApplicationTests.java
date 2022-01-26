package com.edgedo;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApplicationTests {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH,11);
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyyM");
        System.out.print(sdf.format(cal.getTime()));
    }

}
