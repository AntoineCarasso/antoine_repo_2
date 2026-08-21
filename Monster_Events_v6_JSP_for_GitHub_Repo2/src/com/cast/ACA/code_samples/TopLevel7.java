package com.cast.ACA.code_samples;

public class TopLevel7
{
    public static void allJVEntryPt_7()
    {
        TopLevel7 x = new TopLevel7();

        System.out.println("\n------------");

        x.JVEntryPt_7_A();  // JVEntryPt_7_A() --> JVEntryPt_7_A.new I7() { f() } --> DF_Access_7_A()
        JVEntryPt_7_B();    // JVEntryPt_7_B() --> JVEntryPt_7_B.new C7() { f() } --> DF_Access_7_B()
        x.JVEntryPt_7_C();  // JVEntryPt_7_C() --> JVEntryPt_7_C.new C7() { f() } --> DF_Access_7_C()
        x.JVEntryPt_7_D();  // JVEntryPt_7_D() --> TopLevel7.g1() --> JVEntryPt_7_D.new I7() { g() } --> DF_Access_7_D()
        JVEntryPt_7_E();    // JVEntryPt_7_E() --> TopLevel7.g2() --> JVEntryPt_7_E.new C7() { g() } --> DF_Access_7_E()

        // JVEntryPt_7_F1() --> C7.bar() --> DF_Access_7_J()
        // JVEntryPt_7_F1() --> TopLevel7.h() --> C7.h() --> DF_Access_7_F()
        x.JVEntryPt_7_F1();

        x.JVEntryPt_7_F2(); // JVEntryPt_7_F2() --> TopLevel7.h() --> C7.h() --> DF_Access_7_F()
        x.JVEntryPt_7_G();  // JVEntryPt_7_G() --> TopLevel7.h() --> JVEntryPt_7_G.new C7() { h() } --> TODO
        x.JVEntryPt_7_H();  // JVEntryPt_7_H() --> TopLevel7.h() --> JVEntryPt_7_H.new C7() { h() } --> C7.h() --> DF_Access_7_F()
        JVEntryPt_7_J();    // JVEntryPt_7_J() --> TopLevel7.k() --> JVEntryPt_7_J.new D7() { bar() } --> C7.bar() --> DF_Access_7_J()
        x.JVEntryPt_7_K();  // JVEntryPt_7_K() --> TopLevel7.k() --> JVEntryPt_7_K.new D7() { bar() } --> DF_Access_7_K()
    }

    ///////////////////////

    public interface I7
    {
        void f();
        int g(int i);
    }

    public static class C7 implements I7
    {
        public void f()
        {
            System.out.print(" --> C7.f()");
        }

        public int g(int i)
        {
            System.out.print(" --> C7.g()");
            return i;
        }

        public void h(int i)
        {
            System.out.print(" --> C7.h()");
            DF_Access_7_F();
        }

        public void bar()
        {
            System.out.print(" --> C7.bar()");
            DF_Access_7_J();
        }
    }

    public static class D7 extends C7
    {
        @Override
        public void f()
        {
            System.out.print(" --> D7.f()");
            DF_Access_7_K();
        }
    }

    int g1( I7 i7 )
    {
        System.out.print(" --> TopLevel7.g1()");
        int r = i7.g(1);
        return r;
    }

    static int g2( C7 c7 )
    {
        System.out.print(" --> TopLevel7.g2()");
        return c7.g(2);
    }

    int h( C7 c7 )
    {
        System.out.print(" --> TopLevel7.h()");
        c7.h(0);
        return 0;
    }

    static void k( C7 c7 )
    {
        System.out.print(" --> TopLevel7.k()");
        c7.bar();
    }

    ///////////////////////

    public void JVEntryPt_7_A()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_A()");
        I7 i7 = new I7() {
            @Override
            public void f() {
                System.out.print(" --> JVEntryPt_7_A.new I7() { f() }");
                DF_Access_7_A();
            }

            @Override
            public int g(int i) {
                System.out.print(" --> JVEntryPt_7_A.new I7() { g() }");
                return i;
            } };
        i7.f();
    }

    public static void JVEntryPt_7_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_B()");
        C7 c7 = new C7() {
            @Override
            public void f() {
                System.out.print(" --> JVEntryPt_7_B.new C7() { f() }");
                DF_Access_7_B();
            } };
        c7.f();
    }

    public void JVEntryPt_7_C()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_C()");
        C7 c7 = new C7() {
            @Override
            public void f() {
                System.out.print(" --> JVEntryPt_7_C.new C7() { f() }");
                DF_Access_7_C();
            } };
        c7.f();
    }

    public void JVEntryPt_7_D()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_D()");
        I7 i7 = new I7() {
            @Override
            public void f() {
                System.out.print(" --> JVEntryPt_7_D.new I7() { f() }");
                DF_Access_7_D();
            }

            @Override
            public int g(int i) {
                System.out.print(" --> JVEntryPt_7_D.new I7() { g() }");
                DF_Access_7_D();
                return i;
            } };
        int j = 0;
        j = g1(i7) + j;
    }

    public static int JVEntryPt_7_E()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_E()");
        C7 c7 = new C7() {
            @Override
            public int g(int i) {
                System.out.print(" --> JVEntryPt_7_E.new C7() { g() }");
                DF_Access_7_E();
                return i;
            } };
        return g2(c7);
    }

    public void JVEntryPt_7_F1()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_F1() { ");
        ( new C7() { } ).bar();
        System.out.print(" / ");
        C7 c7 = new C7() { };
        h(c7);
        System.out.print(" }");
    }

    public int JVEntryPt_7_F2()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_F2()");
        return h( new C7() { } );
    }

    public void JVEntryPt_7_G()
    {
        // Same as JVEntryPt_7_H(), except that the nested class doesn't call "super.h(int)"
        System.out.print('\n' + "Starting JVEntryPt_7_G()");
        C7 c7 = new C7() {
            @Override
            public void h(int i) {
                System.out.print(" --> JVEntryPt_7_G.new C7() { h() }");
            } };
        h(c7);
    }

    public void JVEntryPt_7_H()
    {
        // Same as JVEntryPt_7_G(), except that the nested class calls "super.h(int)"
        System.out.print('\n' + "Starting JVEntryPt_7_H()");
        C7 c7 = new C7() {
            @Override
            public void h(int i) {
                System.out.print(" --> JVEntryPt_7_H.new C7() { h() }");
                super.h(i); // 'super' is 'C7'
            } };
        h(c7);
    }

    public static void JVEntryPt_7_J()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_J()");
        k( new D7() {
            @Override
            public void bar() {
                System.out.print(" --> JVEntryPt_7_J.new D7() { bar() }");
                super.bar(); // 'super' is 'C7'
            } } );
    }

    public void JVEntryPt_7_K()
    {
        System.out.print('\n' + "Starting JVEntryPt_7_K()");
        D7 d7 = new D7() {
            @Override
            public void bar() {
                System.out.print(" --> JVEntryPt_7_K.new D7() { bar() }");
                DF_Access_7_K();
            } };
        k( d7 );
    }

    ///////////////////////

    public static void DF_Access_7_A()
    {
        // Reached by JVEntryPt_7_A() --> JVEntryPt_7_A.new I7() { f() } --> DF_Access_7_A()
        System.out.print(" --> DF_Access_7_A()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_7_B()
    {
        // Reached by JVEntryPt_7_B() --> JVEntryPt_7_B.new C7() { f() } --> DF_Access_7_B()
        System.out.print(" --> DF_Access_7_B()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_7_C()
    {
        // Reached by JVEntryPt_7_C() --> JVEntryPt_7_C.new C7() { f() } --> DF_Access_7_C()
        System.out.print(" --> DF_Access_7_C()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_7_D()
    {
        // Reached by JVEntryPt_7_D() --> TopLevel7.g1() --> JVEntryPt_7_D.new I7() { g() } --> DF_Access_7_D()
        System.out.print(" --> DF_Access_7_D()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_7_E()
    {
        // Reached by JVEntryPt_7_E() --> TopLevel7.g2() --> JVEntryPt_7_E.new C7() { g() } --> DF_Access_7_E()
        System.out.print(" --> DF_Access_7_E()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_7_F()
    {
        // Reached by JVEntryPt_7_F1() --> TopLevel7.h() --> C7.h() --> DF_Access_7_F()
        // Reached by JVEntryPt_7_F2() --> TopLevel7.h() --> C7.h() --> DF_Access_7_F()
        // Reached by JVEntryPt_7_H() --> TopLevel7.h() --> JVEntryPt_7_H.new C7() { h() } --> C7.h() --> DF_Access_7_F()
        System.out.print(" --> DF_Access_7_F()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_7_J()
    {
        // Reached by JVEntryPt_7_F1() --> C7.bar() --> DF_Access_7_J()
        // Reached by JVEntryPt_7_J() --> TopLevel7.k() --> JVEntryPt_7_J.new D7() { bar() } --> C7.bar() --> DF_Access_7_J()
        System.out.print(" --> DF_Access_7_J()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_7_K()
    {
        // Reached by JVEntryPt_7_K() --> TopLevel7.k() --> JVEntryPt_7_K.new D7() { bar() } --> DF_Access_7_K()
        System.out.print(" --> DF_Access_7_K()");
        Access_DF.findAllMonsters();
    }
}
