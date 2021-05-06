package com.java8;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author swamy on 9/19/20
 */
public class Test {
    public static void main(String[] args) {
        boolean payReq = true;
        if(!payReq)
            System.out.println(payReq);

        // A list of size 4 to be converted:
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Declaring an array of size 4:
        Integer[] arr = new Integer[4];

        // Passing the declared array as the parameter:
        list.toArray(arr);

        // Printing all elements of the array:
        System.out.println("Printing 'arr':");
        for(Integer i: arr)
            System.out.println(i);

        // Declaring another array of insufficient size:
        Integer[] arr2 = new Integer[3];

        // Passing the array as the parameter:
        Integer[] arr3 = list.toArray(arr2);

        // Printing the passed array:
        System.out.println("\n'arr2' isn't filled because it is small in size:");
        for(Integer i: arr2)
            System.out.println(i);

        // Printing the newly allocated array:
        System.out.println("\n'arr3' references the newly allocated array:");
        for(Integer i: arr3)
            System.out.println(i);

        //yyyy-MM-dd'T'HH:mm:ss.SSS'Z'

        //2020-12-16 04:10:53.655Z
        //2020-12-15T20:23:19.210Z
        //2020-08-27T06:00:01.000Z
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(LocalDateTime.now()));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        int sum = 0;
        for (int i = 1; i < 100; i++)
        { sum += i; }
        System.out.println(sum);

        BigDecimal a = new BigDecimal("10.10");//.add(new BigDecimal("0.001"));

        System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
        BigDecimal bigDecimal = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(bigDecimal);

        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        System.out.println("timeStampMillis:"+timeStampMillis);

        Map<String, String> ids = ZoneId.SHORT_IDS;
       for(Map.Entry<String, String> id: ids.entrySet()){
           if(id.getValue().equals("America/Los_Angeles"))
               System.out.println(id.getKey());
       }
        System.out.println("%%%");
        System.out.println(ids.get("America/Los_Angeles"));
        System.out.println("###");
        ZoneId zz=  ZoneId.of("America/Los_Angeles");

        System.out.println("***");
        String[] availId = TimeZone.getAvailableIDs();
        for (String availId1 : availId) {
       //     System.out.println(availId1);
        }
       // DateFormat dff = new SimpleDateFormat("dd-MM-yy HH:mm:SS z");
        System.out.println(TimeZone.getTimeZone("America/Los_Angeles").getDisplayName());
        System.out.println(TimeZone.getTimeZone("America/Los_Angeles").getID());
        System.out.println(TimeZone.getTimeZone("America/Los_Angeles").getDisplayName(Locale.US));

        //capturing today's date
        Date today = new Date();

        //displaying this date on IST timezone
        DateFormat dff = new SimpleDateFormat("dd-MM-yy HH:mm:SS z");
        dff.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String IST = dff.format(today);
        System.out.println("Date in Indian Timezone (IST) : " + IST);

        //dispalying date on PST timezone
        dff.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        String PST = dff.format(today);
        System.out.println("Date in PST Timezone : " + PST);


       // Read more: https://www.java67.com/2012/12/how-to-display-date-in-multiple-timezone-java.html#ixzz6eNCGkQfb

        boolean test = true;
        if(!test){
            System.out.println("sdfdf"+test);
        }

   String val = "1234";
        double db = Double.parseDouble(String.valueOf(val));
        System.out.println(db/100);

        BigDecimal b = BigDecimal.valueOf(db);

        double x = 1234;
        x /= 100;
        System.out.println(x);

       System.out.println( new  Double(x/100));
        System.out.println( BigDecimal.valueOf(Long.parseLong("1234")/100));

        int i=1234;
        Double d= new Double(i);//first way
        Double d2=Double.valueOf(i);//second way
        System.out.println(String.format("%.2f", d));
        System.out.println(d2);

        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(d2);
        System.out.println(formatted);

        String strDouble = String.format("%.2f", 1.23456);
        System.out.println(strDouble);


     //   Read more: https://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html#ixzz6YXN5G2az
        // Create via a long
        BigDecimal bd1 = new BigDecimal("123456789.0123456890");
        BigDecimal bd2 = BigDecimal.valueOf(123L);

        bd1 = bd1.add(bd2);
        System.out.println(bd1);

        System.out.println(new BigDecimal("35.3456").round(new MathContext(4, RoundingMode.HALF_UP)));

        System.out.println(new BigDecimal("35.3456").setScale(4, RoundingMode.HALF_UP));

        BigDecimal value1 = new BigDecimal("3383878445");
        BigDecimal returnValue = calculation(2,value1);
        System.out.println("value is :" + returnValue);


    }
    public static BigDecimal calculation(int no1, BigDecimal no2){
        BigDecimal value = BigDecimal.valueOf(no1).multiply(no2);
        return value;
    }
}
