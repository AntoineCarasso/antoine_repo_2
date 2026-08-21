package com.cast.ACA.code_samples;

public class TopLevel4
{
    public static void allJVEntryPt_4()
    {
        TopLevel4 x = new TopLevel4();

        System.out.println("\n------------");
        x.JVEntryPt_4_A(); // JVEntryPt_4_A() --> D4.h1() --> D4.g() --> B4.f() --> DF_Access_4_A()
        x.JVEntryPt_4_B(); // JVEntryPt_4_B() --> D4.h2() --> D4.g() --> D4.f() --> DF_Access_4_B()
    }

    ///////////////////////

    interface I4
    {
        void f();
    }

    class B4 implements I4
    {
        public void f()
        {
            System.out.print(" --> B4.f()");
            DF_Access_4_A();
        }
    }

    class D4 extends B4
    {
        public void f()
        {
            System.out.print(" --> D4.f()");
            DF_Access_4_B();
        }

        private void g(I4 i)
        {
            System.out.print(" --> D4.g()");
            i.f(); // according to i.class, calls B4.f() or D4.f()
        }

        public void h1()
        {
            System.out.print(" --> D4.h1()");
            B4 b = new B4();
            g(b); // g() will call B4.f()
        }

        public void h2()
        {
            System.out.print(" --> D4.h2()");
            D4 d = new D4();
            g(d); // g() will call D4.f()
        }
    }

    ///////////////////////

    public void JVEntryPt_4_A()
    {
        System.out.print("TopLevel4.JVEntryPt_4_A()");
        D4 d4a = new D4();
        d4a.h1();
    }

    public void JVEntryPt_4_B()
    {
        System.out.print("TopLevel4.JVEntryPt_4_B()");
        D4 d4b = new D4();
        d4b.h2();
    }

    ///////////////////////

    public static void DF_Access_4_A()
    {
        // Reached by JVEntryPt_4_A() --> D4.h1() --> D4.g() --> B4.f() --> DF_Access_4_A()
        System.out.print(" --> DF_Access_4_A()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_4_B()
    {
        // Reached by JVEntryPt_4_B() --> D4.h2() --> D4.g() --> D4.f() --> DF_Access_4_B()
        System.out.print(" --> DF_Access_4_B()");
        Access_DF.findAllMonsters();
    }
}
