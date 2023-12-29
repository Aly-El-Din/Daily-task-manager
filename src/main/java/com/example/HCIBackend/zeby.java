package com.example.HCIBackend;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class zeby {
     public static void main(String[] args) {
         Date date=new Date();
        // System.out.println(date.getDate() +" "+ date.getMonth()+" "+ date.getYear());

         Calendar d=new GregorianCalendar();
         String s=d.getTime().toString().replace(" EET","");
         System.out.println(s.getClass().getSimpleName());
         System.out.println(s);


    }
}
