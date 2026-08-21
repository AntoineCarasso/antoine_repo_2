package com.cast.ACA.code_samples;

public class TopLevel2
{
    public static void allJVEntryPt_2()
    {
        TopLevel2 x = new TopLevel2();

        System.out.println("\n------------");

        x.JVEntryPt_2_A(); // JVEntryPt_2_A() --> C2.foo2() --> DF_Access_2_ACD()

        x.JVEntryPt_2_B(); // JVEntryPt_2_B() --> C2.qux2() --> DF_Access_2_BCD()

        // JVEntryPt_2_C() --> C4.bar2() --> C2.foo2() --> DF_Access_2_ACD()
        // JVEntryPt_2_C() --> C4.bar2() --> C2.qux2() --> DF_Access_2_BCD()
        x.JVEntryPt_2_C( x.new C4() );

        // JVEntryPt_2_D() --> TopLevel2.g() --> C2.foo2() --> DF_Access_2_ACD()
        // JVEntryPt_2_D() --> TopLevel2.g() --> C2.qux2() --> DF_Access_2_BCD()
        x.JVEntryPt_2_D();

        // JVEntryPt_2_E() --> TopLevel2.g() --> C6.foo2()
        // JVEntryPt_2_E() --> TopLevel2.g() --> C6.qux2()
        x.JVEntryPt_2_E();

        x.JVEntryPt_2_F(); // JVEntryPt_2_F() --> TopLevel2.h() --> C4.baz2() --> DF_Access_2_F1()
    }

    ///////////////////////

    interface I1
    {
        void foo2();
        void qux2();
    }

    class C2 implements I1
    {
        @Override
        public void foo2()
        {
            System.out.print(" --> C2.foo2()");
            DF_Access_2_ACD();
        }

        public void qux2()
        {
            System.out.print(" --> C2.qux2()");
            DF_Access_2_BCD();
        }

        public int baz2() // nothing calls this method
        {
            System.out.print(" --> C2.baz2()");
            DF_Access_2_F2();
            return 0;
        }
    }

    interface I3
    {
        int bar2( int i );
    }

    class C4 extends C2 implements I3
    {
        @Override
        public int bar2( int i )
        {
            System.out.print(" --> C4.bar2() { ");
            foo2(); // calls C2.foo2();
            System.out.print(" / ");
            qux2(); // calls C2.qux2();
            System.out.print(" }");
            if (false)
                bar2(0); // self-call to C4.bar2(int), disabled at run-time
            return i;
        }

        @Override
        public int baz2()
        {
            System.out.print(" --> C4.baz2()");
            DF_Access_2_F1();
            return 1;
        }
    }

    interface I5 extends I1, I3
    {
        String glub2( String s );
    }

    class C6 extends C4 implements I5
    {
        @Override
        // Note: TF graph of JVEntryPt_2_C() shows an un-existing link C6.foo2() -> C2.foo2() but this
        // wrong link is removed by my Standard adj. procedure - note: type of link "Ho" is correct.
        public void foo2()
        {
            System.out.print(" --> C6.foo2()");
        }

        // Note: TF graph of JVEntryPt_2_B() shows an un-existing link C6.qux2() -> C2.qux2() but this
        // wrong link is removed by my Standard adj. procedure - note: type of link "Ho" is correct.
        // Note: TF graph of JVEntryPt_2_C() shows an un-existing link C6.qux2() -> C2.qux2() but this
        // wrong link is removed by my Standard adj. procedure - note: type of link "Ho" is correct.
        public void qux2()
        {
            System.out.print(" --> C6.qux2()");
        }

        @Override
        public int bar2(int i)
        {
            System.out.print(" --> C6.bar2()");
            return i;
        }

        @Override
        public String glub2(String s)
        {
            System.out.print(" --> C6.glub2()");
            return null;
        }
    }

    protected static void g( C2 c ) // Called with a C2 and a C6
    {
        System.out.print(" --> TopLevel2.g() { ");
        c.foo2();
        System.out.print(" / ");
        c.qux2();
        System.out.print(" }");
    }

    private static int h( C2 c ) // Called with a C4
    {
        System.out.print(" --> TopLevel2.h()");
        return c.baz2();
    }

    ///////////////////////

    public void JVEntryPt_2_A()
    {
        System.out.print('\n' + "Starting JVEntryPt_2_A()");
        C2 c2 = new C2();
        c2.foo2();
    }

    public void JVEntryPt_2_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_2_B()");
        new C2().qux2();
    }

    public void JVEntryPt_2_C( C4 c4 )
    {
        System.out.print('\n' + "Starting JVEntryPt_2_C()");
        c4.bar2(1);
    }

    public void JVEntryPt_2_D()
    {
        System.out.print('\n' + "Starting JVEntryPt_2_D()");
        C2 c2 = new C2();
        g(c2);
    }

    public void JVEntryPt_2_E()
    {
        System.out.print('\n' + "Starting JVEntryPt_2_E()");
        C6 c6 = new C6();
        g(c6); // won't reach any DF because both C6.foo2() and C6.qux2() do NOP in their bodies
    }

    public int JVEntryPt_2_F()
    {
        System.out.print('\n' + "Starting JVEntryPt_2_F()");
        return h( new C4() );
    }

    ///////////////////////

    public static void DF_Access_2_ACD()
    {
        // Reached by JVEntryPt_2_A() --> C2.foo2() --> DF_Access_2_ACD()
        // Reached by JVEntryPt_2_C() --> C4.bar2() --> C2.foo2() --> DF_Access_2_ACD()
        // Reached by JVEntryPt_2_D() --> TopLevel2.g() --> C2.foo2() --> DF_Access_2_ACD()
        System.out.print(" --> DF_Access_2_ACD()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_2_BCD()
    {
        // Reached by JVEntryPt_2_B() --> C2.qux2() --> DF_Access_2_BCD()
        // Reached by JVEntryPt_2_C() --> C4.bar2() --> C2.qux2() --> DF_Access_2_BCD()
        // Reached by JVEntryPt_2_D() --> TopLevel2.g() --> C2.qux2() --> DF_Access_2_BCD()
        System.out.print(" --> DF_Access_2_BCD()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_2_F1()
    {
        // Reached by JVEntryPt_2_F() --> TopLevel2.h() --> C4.baz2() --> DF_Access_2_F1()
        System.out.print(" --> DF_Access_2_F1()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_2_F2()
    {
        // Never reached in theory
        System.out.print("error: we should not be in DF_Access_2_F2()");
        Access_DF.findAllMonsters();
    }
}
