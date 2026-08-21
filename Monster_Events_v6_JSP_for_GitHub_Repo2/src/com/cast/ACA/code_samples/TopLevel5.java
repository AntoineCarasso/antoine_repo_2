package com.cast.ACA.code_samples;

interface I5<T>
{
    T f(T t);
}

class B5<T> implements I5<T>
{
    public B5() { /* NOP */ }

    public B5(T t) { this(); }

    public B5(T t1, T t2) { this(t1); }

    @Override
    public T f(T t)
    {
        System.out.print(" --> B5<T>.f(T)");
        TopLevel5.DF_Access_5_A();
        return null;
    }
}

class D5<T> extends B5<T>
{
    public D5() { /* NOP */ }

    public D5(T t) { super(t); }

    public D5(T t1, T t2) { super(t1); }

    @Override
    public T f(T t)
    {
        System.out.print(" --> D5<T>.f(T)");
        TopLevel5.DF_Access_5_B();
        return t;
    }
}

class X5 extends B5<Integer>
{
    public X5(Integer i) { super(i); }

    @Override
    public Integer f(Integer i)
    {
        System.out.print(" --> X5.f(Integer)");
        TopLevel5.DF_Access_5_C();
        return null;
    }
}

class Y5 extends D5<String>
{
    public Y5(String s) { super(s); }

    @Override
    public String f(String s)
    {
        System.out.print(" --> Y5.f(String)");
        TopLevel5.DF_Access_5_D();
        return s;
    }
}

class TopLevel5
{
    public static void allJVEntryPt_5()
    {
        System.out.println("\n------------");

        JVEntryPt_5_A(); // JVEntryPt_5_A() --> B5<T>.f(T) --> DF_Access_5_A()
        JVEntryPt_5_B(); // JVEntryPt_5_B() --> D5<T>.f(T) --> DF_Access_5_B()
        JVEntryPt_5_C(); // JVEntryPt_5_C() --> X5.f(Integer) --> DF_Access_5_C()
        JVEntryPt_5_D(); // JVEntryPt_5_D() --> Y5.f(String) --> DF_Access_5_D()
    }

    ///////////////////////

    public static void JVEntryPt_5_A()
    {
        System.out.print("TopLevel5.JVEntryPt_5_A()");
        B5<Integer> b5 = new B5<Integer>(1);
        Integer r = b5.f(3); // calls B5<Integer>.f(T t)
    }

    public static void JVEntryPt_5_B()
    {
        System.out.print("TopLevel5.JVEntryPt_5_B()");
        D5<String> d5 = new D5<String>("foo", "bar");
        String r = d5.f("bar"); // calls D5<String>.f(T t)
    }

    public static void JVEntryPt_5_C()
    {
        System.out.print("TopLevel5.JVEntryPt_5_C()");
        I5<Integer> x5 = new X5(0);
        Integer r = x5.f(1); // calls X5.f(Integer i)
    }

    public static void JVEntryPt_5_D()
    {
        System.out.print("TopLevel5.JVEntryPt_5_D()");
        I5<String> y5 = new Y5("a");
        String r = y5.f("b"); // calls Y5.f(String s)
    }

    ///////////////////////

    public static void DF_Access_5_A()
    {
        // Reached by JVEntryPt_5_A() --> B5<T>.f(T) --> DF_Access_5_A()
        System.out.print(" --> DF_Access_5_A()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_5_B()
    {
        // Reached by JVEntryPt_5_B() --> D5<T>.f(T) --> DF_Access_5_B()
        System.out.print(" --> DF_Access_5_B()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_5_C()
    {
        // Reached by JVEntryPt_5_C() --> X5.f(Integer) --> DF_Access_5_C()
        System.out.print(" --> DF_Access_5_C()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_5_D()
    {
        // Reached by JVEntryPt_5_D() --> Y5.f(String) --> DF_Access_5_D()
        System.out.print(" --> DF_Access_5_D()");
        Access_DF.findAllMonsters();
    }
}
