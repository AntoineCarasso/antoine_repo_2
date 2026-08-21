package com.cast.ACA.code_samples;

public class TopLevel_Latin1
{
    public static void allJVEntryPt_Latin1()
    {
        TopLevel_Latin1 x = new TopLevel_Latin1();

        System.out.println("\n------------");

        x.JVEntryPt_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A(); // JVEntryPt_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A() --> E4.foo1() --> DF_Access_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A1()
        x.JVEntryPt_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B(); // JVEntryPt_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B() --> E4.bar1() --> E4.foo2() --> DF_Access_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B()
        x.JVEntryPt_1_L_Càáâãäåæçèéêëìíîï_C(); // JVEntryPt_1_L_Càáâãäåæçèéêëìíîï_C() --> TopLevel_Latin1.qux1() --> E2.foo3() --> DF_Access_1_L_Càáâãäåæçèéêëìíîï_C()
        x.JVEntryPt_1_L_Dðñòóôõöæøùúûüýþÿ_D(); // JVEntryPt_1_L_Dðñòóôõöæøùúûüýþÿ_D() --> TopLevel_Latin1.qux2() --> E4.foo3() --> DF_Access_1_L_Dðñòóôõöæøùúûüýþÿ_D()
    }

    ///////////////////////

    interface I1
    {
        void foo1();
        void foo3();

        String glub2_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A( String s );
        String glub2_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B( String s );
        String glub2_L_Càáâãäåæçèéêëìíîï_C( String s );
        String glub2_L_Dðñòóôõöæøùúûüýþÿ_D( String s );
    };

    enum E2 implements I1
    {
        e2a, e2b;

        @Override
        public void foo1() // nobody calls this method
        {
            System.out.print(" --> E2.foo1()");
            DF_Access_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A2();
        }

        @Override
        public void foo3()
        {
            System.out.print(" --> E2.foo3()");
            DF_Access_1_L_Càáâãäåæçèéêëìíîï_C();
        }

        public String glub2_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A( String s ) { return s; }
        public String glub2_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B( String s ) { return s; }
        public String glub2_L_Càáâãäåæçèéêëìíîï_C( String s ) { return s; }
        public String glub2_L_Dðñòóôõöæøùúûüýþÿ_D( String s ) { return s; }
    }

    protected void qux1( I1 i )
    {
        System.out.print(" --> TopLevel_Latin1.qux1()");
        i.foo3();
    }

    protected void qux2( I1 i )
    {
        System.out.print(" --> TopLevel_Latin1.qux2()");
        i.foo3();
    }

    interface I3
    {
        int bar1( int i );
    };

    enum E4 implements I1, I3
    {
        e4a, e4b, e4c;

        @Override
        public void foo1()
        {
            System.out.print(" --> E4.foo1()");
            DF_Access_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A1();
        }

        public void foo2()
        {
            System.out.print(" --> E4.foo2()");
            DF_Access_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B();
        }

        @Override
        public int bar1(int i)
        {
            System.out.print(" --> E4.bar1()");
            foo2(); // calls E4.foo2()
            return i;
        }

        @Override
        public void foo3()
        {
            System.out.print(" --> E4.foo3()");
            DF_Access_1_L_Dðñòóôõöæøùúûüýþÿ_D();
        }

        public String glub2_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A( String s ) { return s; }
        public String glub2_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B( String s ) { return s; }
        public String glub2_L_Càáâãäåæçèéêëìíîï_C( String s ) { return s; }
        public String glub2_L_Dðñòóôõöæøùúûüýþÿ_D( String s ) { return s; }
    }

    ///////////////////////

    public void JVEntryPt_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A()");
        E4 e = E4.e4a;
        e.foo1();
    }

    public void JVEntryPt_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B()");
        E4 e = E4.e4b;
        int i = e.bar1(0);
        i = i + i; // for removing Eclipse warning about unused local var.
    }

    public void JVEntryPt_1_L_Càáâãäåæçèéêëìíîï_C()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_L_Càáâãäåæçèéêëìíîï_C()");
        E2 e = E2.e2a;
        qux1(e);
    }

    public void JVEntryPt_1_L_Dðñòóôõöæøùúûüýþÿ_D()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_L_Dðñòóôõöæøùúûüýþÿ_D()");
        E4 e = E4.e4c;
        qux2(e);
    }

    ///////////////////////

    public static void DF_Access_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A1()
    {
        // Reached by JVEntryPt_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A() --> E4.foo1() --> DF_Access_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A1()
        System.out.print(" --> DF_Access_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A1()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A2()
    {
        // Never reached in theory
        System.out.print("error: we should not be in DF_Access_1_L_AÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ_A2()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B()
    {
        // Reached by JVEntryPt_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B() --> E4.bar1() --> E4.foo2() --> DF_Access_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B()
        System.out.print(" --> DF_Access_1_L_BÐÑÒÓÔÕÆÖØÙÚÛÜÝÞß_B()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_L_Càáâãäåæçèéêëìíîï_C()
    {
        // Reached by JVEntryPt_1_L_Càáâãäåæçèéêëìíîï_C --> TopLevel_Latin1.qux1() --> E2.foo3() --> DF_Access_1_L_Càáâãäåæçèéêëìíîï_C()
        System.out.print(" --> DF_Access_1_L_Càáâãäåæçèéêëìíîï_C()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_L_Dðñòóôõöæøùúûüýþÿ_D()
    {
        // Reached by JVEntryPt_1_L_Dðñòóôõöæøùúûüýþÿ_D --> TopLevel_Latin1.qux2() --> E4.foo3() --> DF_Access_1_L_Dðñòóôõöæøùúûüýþÿ_D()
        System.out.print(" --> DF_Access_1_L_Dðñòóôõöæøùúûüýþÿ_D()");
        Access_DF.findAllMonsters();
    }
}
