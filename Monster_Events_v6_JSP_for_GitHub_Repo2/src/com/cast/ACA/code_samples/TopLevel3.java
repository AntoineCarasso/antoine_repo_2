package com.cast.ACA.code_samples;

// Example inspired from https://stackoverflow.com/questions/2831426/is-it-possible-to-override-a-static-method-in-derived-class
class TopLevel3_Foo
{
    public void instanceMethod3()
    {
        System.out.print(" --> TopLevel3_Foo.instanceMethod3()");
        TopLevel3.DF_Access_3_D();
    }

    public void instanceMethod3o()
    {
        System.out.print(" --> TopLevel3_Foo.instanceMethod3o()");
        TopLevel3.DF_Access_3_E();
    }

    public static void classMethod3()
    {
        System.out.print(" --> TopLevel3_Foo.classMethod3()");
        TopLevel3.DF_Access_3_C();
    }
}

class TopLevel3_Bar extends TopLevel3_Foo
{
    public void instanceMethod3() // without "@Override"
    {
        System.out.print(" --> TopLevel3_Bar.instanceMethod3()");
        TopLevel3.DF_Access_3_A();
    }

    @Override
    public void instanceMethod3o() // with "@Override"
    {
        System.out.print(" --> TopLevel3_Bar.instanceMethod3o()");
        TopLevel3.DF_Access_3_B();
    }

    public static void classMethod3()
    {
        System.out.print(" --> TopLevel3_Bar.classMethod3()");
        TopLevel3.DF_Access_3_F();
    }
}

class TopLevel3
{
    public static void allJVEntryPt_3()
    {
        System.out.println("\n------------");

        JVEntryPt_3_A(); // JVEntryPt_3_A() --> TopLevel3_Bar.instanceMethod3() --> DF_Access_3_A()
        JVEntryPt_3_B(); // JVEntryPt_3_B() --> TopLevel3_Bar.instanceMethod3o() --> DF_Access_3_B()
        JVEntryPt_3_C(); // JVEntryPt_3_C() --> TopLevel3_Foo.classMethod3() --> DF_Access_3_C()
    }

    ///////////////////////

    public static void JVEntryPt_3_A()
    {
        System.out.print('\n' + "Starting JVEntryPt_3_A()");
        TopLevel3_Foo f = new TopLevel3_Bar();
        // ERROR: the Java Analyzer produces 2 links: 1 "OK" to TopLevel3_Bar.instanceMethod3(), and 1 "KO" to TopLevel3_Foo.instanceMethod3()
        f.instanceMethod3(); // JVM will call TopLevel3_Bar.instanceMethod3()
    }

    public static void JVEntryPt_3_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_3_B()");
        TopLevel3_Foo f = new TopLevel3_Bar();
        // ERROR: the Java Analyzer produces 2 links: 1 "OK" to TopLevel3_Bar.instanceMethod3o(), and 1 "KO" to TopLevel3_Foo.instanceMethod3o()
        f.instanceMethod3o(); // JVM will call TopLevel3_Bar.instanceMethod3o()
    }

    public static void JVEntryPt_3_C()
    {
        System.out.print('\n' + "Starting JVEntryPt_3_C()");
        TopLevel3_Foo f = new TopLevel3_Bar();
        f.classMethod3(); // JVM will call TopLevel3_Foo.classMethod3() even though prefixed by f = instance of TopLevel3_Bar
    }

    ///////////////////////

    public static void DF_Access_3_A()
    {
        // Reached by JVEntryPt_3_A() --> TopLevel3_Bar.instanceMethod3() --> DF_Access_3_A()
        System.out.print(" --> DF_Access_3_A()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_3_B()
    {
        // Reached by JVEntryPt_3_B() --> TopLevel3_Bar.instanceMethod3o() --> DF_Access_3_B()
        System.out.print(" --> DF_Access_3_B()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_3_C()
    {
        // Reached by JVEntryPt_3_C() --> TopLevel3_Foo.classMethod3() --> DF_Access_3_C()
        System.out.print(" --> DF_Access_3_C()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_3_D()
    {
        // Never reached in a TF graph in theory, since no Entry Point calls TopLevel3_Foo.instanceMethod3()
        System.out.print("error: we should not be in DF_Access_3_D()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_3_E()
    {
        // Never reached in a TF graph in theory, since no Entry Point calls TopLevel3_Foo.instanceMethod3o()
        System.out.print("error: we should not be in DF_Access_3_E()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_3_F()
    {
        // Never reached in a TF graph in theory, since no Entry Point calls TopLevel3_Bar.classMethod3()
        System.out.print("error:we should not be in DF_Access_3_F()");
        Access_DF.findAllMonsters();
    }
}
