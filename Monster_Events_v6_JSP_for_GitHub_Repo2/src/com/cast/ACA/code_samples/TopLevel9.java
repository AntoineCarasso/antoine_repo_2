package com.cast.ACA.code_samples;

class C9
{
	private static final int i;
	// Static class initializer (called before the 1st instance gets created)
	static
	{
		// BUG/LIMITATION in JEE analyzer (8.3.4 + JEE extension funcrel-1.0.3):
		// KB object built for this initializer doesn't have any incoming link.
        System.out.print(" --> C9.<static_initializer> {");
		i = TopLevel9.DF_Access_9_A();
        System.out.print(" }");
	}

	private final int j1;
	private final int j2;
	// Instance initializer (called before the constructor)
	private int j3;
	{
		// BUG/LIMITATION in JEE analyzer (8.3.4 + JEE extension funcrel-1.0.3):
		// KB object built for this initializer doesn't have any incoming link.
        System.out.print(" --> C9.<instance_initializer> {");
		j1 = new TopLevel9().DF_Access_9_B();
        System.out.print(" }");
	}
	// Ctor.
	public C9( int k )
	{
        System.out.print(" --> C9.C9() {");
		j2 = k + TopLevel9.DF_Access_9_C();
		j3 = 0;
        System.out.print(" }");
	}

	public int f()
	{
        System.out.print(" --> C9.f()");
        j3 += TopLevel9.DF_Access_9_D();
		return i + j1 + j2 + j3; // for removing Eclipse warning about unused members
	}
}

class D9 extends C9
{
	private static final int i;
	// Static class initializer (called before the 1st instance gets created)
	static
	{
		// BUG/LIMITATION in JEE analyzer (8.3.4 + JEE extension funcrel-1.0.3):
		// KB object built for this initializer doesn't have any incoming link.
        System.out.print(" --> D9.<static_initializer> {");
		i = TopLevel9.DF_Access_9_E();
        System.out.print(" }");
	}

	private final int j1;
	private final int j2;
	// Instance initializer (called before the constructor)
	private int j3;
	{
		// BUG/LIMITATION in JEE analyzer (8.3.4 + JEE extension funcrel-1.0.3):
		// KB object built for this initializer doesn't have any incoming link.
        System.out.print(" --> D9.<instance_initializer> {");
		j1 = new TopLevel9().DF_Access_9_F();
        System.out.print(" }");
	}
	// Ctor.
	public D9( int k )
	{
		super( k );
        System.out.print(" --> D9.D9() {");
		j2 = k + TopLevel9.DF_Access_9_G();
		j3 = 0;
        System.out.print(" }");
	}

	@Override
	public int f()
	{
        System.out.print(" --> D9.f()");
        j3 += TopLevel9.DF_Access_9_H();
		return i + j1 + j2 + j3; // for removing Eclipse warning about unused members
	}
}

///////////////////////
public class TopLevel9
{
    public static void allJVEntryPt_9()
    {
        TopLevel9 x = new TopLevel9();

        System.out.println("\n------------");

        x.JVEntryPt_9_A(); // JVEntryPt_9_A() --> C9.<static_initializer> { --> DF_Access_9_A() } --> C9.<instance_initializer> { --> DF_Access_9_B() } --> C9.C9() { --> DF_Access_9_C() }
        x.JVEntryPt_9_B(); // JVEntryPt_9_B() --> C9.<instance_initializer> { --> DF_Access_9_B() } --> C9.C9() { --> DF_Access_9_C() } --> C9.f() --> DF_Access_9_D()
        x.JVEntryPt_9_C(); // JVEntryPt_9_C() --> C9.<instance_initializer> { --> DF_Access_9_B() } --> C9.C9() { --> DF_Access_9_C() } --> C9.f() --> DF_Access_9_D()
        x.JVEntryPt_9_D(); // JVEntryPt_9_D() --> D9.<static_initializer> { --> DF_Access_9_E() } --> C9.<instance_initializer> { --> DF_Access_9_B() } --> C9.C9() { --> DF_Access_9_C() } --> D9.<instance_initializer> { --> DF_Access_9_F() } --> D9.D9() { --> DF_Access_9_G() } --> D9.f() --> DF_Access_9_H()
    }
    
    ///////////////////////

    public void JVEntryPt_9_A()
    {
        System.out.print('\n' + "Starting JVEntryPt_9_A()");
        C9 c9 = new C9(0);
        c9 = (C9)c9; // for removing Eclipse warning about unused members
    }

    public void JVEntryPt_9_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_9_B()");
        new C9(1).f();
    }

    public void JVEntryPt_9_C()
    {
        System.out.print('\n' + "Starting JVEntryPt_9_C()");
        C9 d9 = new C9(2);
        d9.f(); // will call C9.f() in reality
    }

    public void JVEntryPt_9_D()
    {
        System.out.print('\n' + "Starting JVEntryPt_9_D()");
        D9 d9 = new D9(1);
        d9.f();
    }

    ///////////////////////

    public static int DF_Access_9_A()
    {
        // Reached by JVEntryPt_9_A() --> C9.<static_initializer> / --> DF_Access_9_A()
        System.out.print(" --> DF_Access_9_A()");
        Access_DF.findAllMonsters();
        return 0;
    }

    public int DF_Access_9_B()
    {
        // Reached by JVEntryPt_9_A() --> C9.<static_initializer> / --> DF_Access_9_A() --> C9.<instance_initializer> --> DF_Access_9_B()
        // Reached by JVEntryPt_9_B() --> C9.<instance_initializer> --> DF_Access_9_B()
        // Reached by JVEntryPt_9_C() --> D9.<static_initializer> / --> DF_Access_9_E() --> C9.<instance_initializer> --> DF_Access_9_B()
        // Reached by JVEntryPt_9_D() --> C9.<instance_initializer> --> DF_Access_9_B()
        System.out.print(" --> DF_Access_9_B()");
        Access_DF.findAllMonsters();
        return 1;
    }

    public static int DF_Access_9_C()
    {
        // Reached by JVEntryPt_9_A() --> C9.<static_initializer> / --> DF_Access_9_A() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9() --> DF_Access_9_C()
        // Reached by JVEntryPt_9_B() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9()--> DF_Access_9_C()
        // Reached by JVEntryPt_9_C() --> D9.<static_initializer> / --> DF_Access_9_E() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9() --> DF_Access_9_C()
        // Reached by JVEntryPt_9_D() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9() --> DF_Access_9_C()
        System.out.print(" --> DF_Access_9_C()");
        Access_DF.findAllMonsters();
        return 2;
    }

    public static int DF_Access_9_D()
    {
        // Reached by JVEntryPt_9_B() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9()--> DF_Access_9_C() --> C9.f()--> DF_Access_9_D()
        // Reached by JVEntryPt_9_D() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9() --> DF_Access_9_C() --> C9.f() --> DF_Access_9_D()
        System.out.print(" --> DF_Access_9_D()");
        Access_DF.findAllMonsters();
        return 3;
    }

    public static int DF_Access_9_E()
    {
        // Reached by JVEntryPt_9_C() --> D9.<static_initializer> / --> DF_Access_9_E()
        System.out.print(" --> DF_Access_9_E()");
        Access_DF.findAllMonsters();
        return 0;
    }

    public int DF_Access_9_F()
    {
        // Reached by JVEntryPt_9_C() --> D9.<static_initializer> / --> DF_Access_9_E() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9() --> DF_Access_9_C() --> D9.<instance_initializer> --> DF_Access_9_F() --> D9.D9() --> DF_Access_9_G() --> D9.f() --> DF_Access_9_H()
        System.out.print(" --> DF_Access_9_F()");
        Access_DF.findAllMonsters();
        return 1;
    }

    public static int DF_Access_9_G()
    {
        // Reached by JVEntryPt_9_C() --> D9.<static_initializer> / --> DF_Access_9_E() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9() --> DF_Access_9_C() --> D9.<instance_initializer> --> DF_Access_9_F() --> D9.D9() --> DF_Access_9_G() --> D9.f() --> DF_Access_9_H()
        System.out.print(" --> DF_Access_9_G()");
        Access_DF.findAllMonsters();
        return 2;
    }

    public static int DF_Access_9_H()
    {
        // Reached by JVEntryPt_9_C() --> D9.<static_initializer> / --> DF_Access_9_E() --> C9.<instance_initializer> --> DF_Access_9_B() --> C9.C9() --> DF_Access_9_C() --> D9.<instance_initializer> --> DF_Access_9_F() --> D9.D9() --> DF_Access_9_G() --> D9.f() --> DF_Access_9_H()
        System.out.print(" --> DF_Access_9_H()");
        Access_DF.findAllMonsters();
        return 3;
    }
}
