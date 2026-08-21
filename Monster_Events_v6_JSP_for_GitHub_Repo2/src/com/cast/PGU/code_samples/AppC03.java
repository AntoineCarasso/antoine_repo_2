package com.cast.PGU.code_samples;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AppC03
{
    public static void allJVEntryPt_03()
    {
        AppC03 x = new AppC03();

        System.out.println("\n------------");

        x.JVEntryPt_03_A(); // JVEntryPt_03_A() --> DF_Access_03_A()
        x.JVEntryPt_03_B(); // JVEntryPt_03_B() --> DF_Access_03_B()
    }

    ///////////////////////

    public void JVEntryPt_03_A()
    {
        System.out.print('\n' + "Starting JVEntryPt_03_A()");
        DF_Access_03_A();
    }

    public void JVEntryPt_03_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_03_B()");
        DF_Access_03_B();
    }

    ///////////////////////

    public static void DF_Access_03_A()
    {
        System.out.print(" --> DF_Access_03_A()");
        Access_DF.findAllMonsters();

        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("foo", 0);
    }

    public static void DF_Access_03_B()
    {
        System.out.print(" --> DF_Access_03_A()");
        Access_DF.findAllMonsters();

        Map<String,Integer> map = new TreeMap<String,Integer>();
        map.get("bar");
    }
}
