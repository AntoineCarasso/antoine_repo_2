package com.cast.PGU.code_samples;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppC02
{
    public static void allJVEntryPt_02() throws IOException
    {
        AppC02 x = new AppC02();

        System.out.println("\n------------");

        x.JVEntryPt_02_A(); // JVEntryPt_02_A() --> DF_Access_02_A()
        x.JVEntryPt_02_B(); // JVEntryPt_02_B() --> DF_Access_02_B()
    }

    ///////////////////////

    public void JVEntryPt_02_A() throws IOException
    {
        System.out.print('\n' + "Starting JVEntryPt_02_A()");
        DF_Access_02_A();
    }

    public void JVEntryPt_02_B() throws IOException
    {
        System.out.print('\n' + "Starting JVEntryPt_02_B()");
        DF_Access_02_B();
    }

    ///////////////////////

    public static void DF_Access_02_A() throws IOException
    {
        System.out.print(" --> DF_Access_02_A()");
        Access_DF.findAllMonsters();

        FileWriter fw = null;
        try
        {
			fw = new FileWriter("c:/foo/", false);
		}
        catch (IOException e)
        {
			// NOP
		}
        finally
        {
			fw.close();
		}
    }

    public static void DF_Access_02_B() throws IOException
    {
        System.out.print(" --> DF_Access_02_A()");
        Access_DF.findAllMonsters();

        FileReader fr = null;
        try
        {
			fr = new FileReader("c:/foo/");
		}
        catch (IOException e)
        {
			// NOP
		}
        finally
        {
			fr.close();
		}
    }
}
