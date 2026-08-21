package com.cast.ACA.code_samples;

import java.util.List;

public class TopLevel6
{
    public static void allJVEntryPt_6()
    {
        TopLevel6 x = new TopLevel6();

        System.out.println("\n------------");
        x.JVEntryPt_6_A1(); // JVEntryPt_6_A1() --> E6<U,V>.copyList() --> D6.copyList() --> B6.copyList() --> DF_Access_6_A()
        x.JVEntryPt_6_A2(); // JVEntryPt_6_A2() --> E6<U,V>.g() --> D6.g() --> D6.copyList() --> B6.copyList() --> DF_Access_6_A()

        // JVEntryPt_6_B() --> E6<U,V>.h() --> B6.f() --> DF_Access_6_B()
        // JVEntryPt_6_B() --> E6<U,V>.h() --> B6.f() --> B6.copyList() --> DF_Access_6_A()
        x.JVEntryPt_6_B();
    }

    ///////////////////////

    interface I6
    {
        public <T> T copyList(List<T> dest, List<? extends T> src);
    }

    class B6 implements I6
    {
        @Override
        public <T> T copyList(List<T> dest, List<? extends T> src)
        {
            System.out.print(" --> B6.copyList()");
            DF_Access_6_A();
            return null;
        }

        public Integer f()
        {
            System.out.print(" --> B6.f() { ");
            List<Integer> dest = null, src = null;
            DF_Access_6_B();
            System.out.print(" / ");
            Integer i = ((B6)this).copyList(dest,src); // ? calls B6.copyList(Integer,Integer)
            System.out.print(" }");
            return i;
        }
    }

    class D6 extends B6
    {
        @Override
        public <T> T copyList(List<T> dest, List<? extends T> src)
        {
            System.out.print(" --> D6.copyList()");
            B6 b6 = new B6();
            return b6.copyList(dest, src); // calls B6.copyList()
        }

        public <U> U g(List<U> dest, List<? extends U> src)
        {
            System.out.print(" --> D6.g()");
            D6 d6 = new D6();
            return d6.copyList(dest, src); // calls D6.copyList()
        }
    }

    interface J6<U, V>
    {
        public <V> V copyList(List<U> dest, List<V> src);
    }

    class E6<U, V> implements J6<U, V>
    {
        @SuppressWarnings("unchecked") // because cast "(V)u" is unsafe
        @Override
        public <V> V copyList(List<U> dest, List<V> src)
        {
            System.out.print(" --> E6<U,V>.copyList()");

            // calls D6.copyList(List<T> dest, List<? extends T> src)
            D6 d6 = new D6();
            U u = d6.copyList(dest, null);
            return (V)u;
        }

        public Integer g()
        {
            System.out.print(" --> E6<U,V>.g()");

            // calls D6.g(List<U> dest, List<? extends U> src)
            List<String> dest = null;
            List<String> src = null;
            String s = new D6().g(dest,src);
            return 0;
        }

        public String h()
        {
            System.out.print(" --> E6<U,V>.h()");
            Integer i = new B6().f();
            return null;
        }
    }

    ///////////////////////

    public void JVEntryPt_6_A1()
    {
        System.out.print('\n' + "Starting JVEntryPt_6_A1()");
        E6<Integer, String> e6 = new E6<Integer, String>();
        e6.copyList(null, null);
    }

    public void JVEntryPt_6_A2()
    {
        System.out.print('\n' + "Starting JVEntryPt_6_A2()");
        new E6<Integer, String>().g();
    }

    public void JVEntryPt_6_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_6_B()");
        E6<Integer, String> e6 = new E6<Integer, String>();
        e6.h();
    }

    ///////////////////////

    public void DF_Access_6_A()
    {
        // Reached by JVEntryPt_6_A1() --> E6<U,V>.copyList() --> D6.copyList() --> B6.copyList() --> DF_Access_6_A()
        // Reached by JVEntryPt_6_A2() --> E6<U,V>.g() --> D6.g() --> D6.copyList() --> B6.copyList() --> DF_Access_6_A()
        // Reached by JVEntryPt_6_B() --> E6<U,V>.h() --> B6.f() --> B6.copyList() --> DF_Access_6_A()
        System.out.print(" --> DF_Access_6_A()");
        Access_DF.findAllMonsters();
    }

    public void DF_Access_6_B()
    {
        // Reached by JVEntryPt_6_B() --> E6<U,V>.h() --> B6.f() --> DF_Access_6_B()
        System.out.print(" --> DF_Access_6_B()");
        Access_DF.findAllMonsters();
    }
}
