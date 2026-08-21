package com.cast.ACA.code_samples;

public class TopLevel1
{
    public static void allJVEntryPt_1()
    {
        TopLevel1 x = new TopLevel1();

        System.out.println("\n------------");

        x.JVEntryPt_1_A(); // JVEntryPt_1_A() --> E4.foo1() --> DF_Access_1_A1()
        x.JVEntryPt_1_B(); // JVEntryPt_1_B() --> E4.bar1() --> E4.foo2() --> DF_Access_1_B()
        x.JVEntryPt_1_C(); // JVEntryPt_1_C() --> TopLevel1.qux1() --> E2.foo3() --> DF_Access_1_C()
        x.JVEntryPt_1_D(); // JVEntryPt_1_D() --> TopLevel1.qux2() --> E4.foo3() --> DF_Access_1_D()

        // JVEntryPt_1_E_SCC_with_3_objects() --> fnc_1_E_SCC_obj1() --> fnc_1_E_SCC_obj2() --> fnc_1_E_SCC_obj3() --> TopLevel1.qux3() --> E4.foo4() --> DF_Access_1_E()
        x.JVEntryPt_1_E_SCC_with_3_objects();

        // JVEntryPt_1_F_SCC_with_5_objects() --> fnc_1_F_SCC_obj1() --> fnc_1_F_SCC_obj2() --> fnc_1_F_SCC_obj3() --> fnc_1_F_SCC_obj4() --> fnc_1_F_SCC_obj5() --> TopLevel1.qux4() --> E4.foo5() --> DF_Access_1_F()
        x.JVEntryPt_1_F_SCC_with_5_objects();
    }

    ///////////////////////

    interface I1
    {
        void foo1();
        void foo3();
        void foo4();
        void foo5();
    };

    enum E2 implements I1
    {
        e2a, e2b;

        @Override
        public void foo1() // nobody calls this method
        {
            System.out.print(" --> E2.foo1()");
            DF_Access_1_A2();
        }

        @Override
        public void foo3()
        {
            System.out.print(" --> E2.foo3()");
            DF_Access_1_C();
        }

        @Override
        public void foo4()
        {
            System.out.print(" --> E2.foo4()");
            DF_Access_1_E();
        }

        @Override
        public void foo5()
        {
            System.out.print(" --> E2.foo5()");
            DF_Access_1_F();
        }
    }

    protected void qux1( I1 i )
    {
        System.out.print(" --> TopLevel1.qux1()");
        i.foo3();
    }

    protected void qux2( I1 i )
    {
        System.out.print(" --> TopLevel1.qux2()");
        i.foo3();
    }

    protected void qux3( I1 i )
    {
        System.out.print(" --> TopLevel1.qux3()");
        i.foo4();
    }

    protected void qux4( I1 i )
    {
        System.out.print(" --> TopLevel1.qux4()");
        i.foo5();
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
            DF_Access_1_A1();
        }

        public void foo2()
        {
            System.out.print(" --> E4.foo2()");
            DF_Access_1_B();
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
            DF_Access_1_D();
        }

        @Override
        public void foo4()
        {
            System.out.print(" --> E4.foo4()");
            DF_Access_1_E();
        }

        @Override
        public void foo5()
        {
            System.out.print(" --> E4.foo5()");
            DF_Access_1_F();
        }
    }

    ///////////////////////

    public void JVEntryPt_1_A()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_A()");
        E4 e = E4.e4a;
        e.foo1();
    }

    public void JVEntryPt_1_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_B()");
        E4 e = E4.e4b;
        int i = e.bar1(0);
        i = i + i; // for removing Eclipse warning about unused local var.
    }

    public void JVEntryPt_1_C()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_C()");
        E2 e = E2.e2a;
        qux1(e);
    }

    public void JVEntryPt_1_D()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_D()");
        E4 e = E4.e4c;
        qux2(e);
    }

    ///////////////////////

    public void JVEntryPt_1_E_SCC_with_3_objects()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_E_SCC_with_3_objects()");
        fnc_1_E_SCC_obj1();
    }

    protected void fnc_1_E_SCC_obj1()
    {
        System.out.print(" --> fnc_1_E_SCC_obj1()");
    	fnc_1_E_SCC_obj2();
    }

    protected void fnc_1_E_SCC_obj2()
    {
        System.out.print(" --> fnc_1_E_SCC_obj2()");
    	fnc_1_E_SCC_obj3();
    }

    protected void fnc_1_E_SCC_obj3()
    {
        System.out.print(" --> fnc_1_E_SCC_obj3()");
        E4 e = E4.e4c;
        qux3(e);

    	if (e == null) // will never be true, but avoids dead code be reported
    	{
    		fnc_1_E_SCC_obj1();
    	}
    }


    ///////////////////////

    public void JVEntryPt_1_F_SCC_with_5_objects()
    {
        System.out.print('\n' + "Starting JVEntryPt_1_F_SCC_with_5_objects()");
        fnc_1_F_SCC_obj1();
    }

    protected void fnc_1_F_SCC_obj1()
    {
        System.out.print(" --> fnc_1_F_SCC_obj1()");
    	fnc_1_F_SCC_obj2();
    }

    protected void fnc_1_F_SCC_obj2()
    {
        System.out.print(" --> fnc_1_F_SCC_obj2()");
    	fnc_1_F_SCC_obj3();
    }

    protected void fnc_1_F_SCC_obj3()
    {
        System.out.print(" --> fnc_1_F_SCC_obj3()");
    	fnc_1_F_SCC_obj4();
    }

    protected void fnc_1_F_SCC_obj4()
    {
        System.out.print(" --> fnc_1_F_SCC_obj4()");
    	fnc_1_F_SCC_obj5();
    }

    protected void fnc_1_F_SCC_obj5()
    {
        System.out.print(" --> fnc_1_F_SCC_obj5()");
        E4 e = E4.e4c;
        qux4(e);

    	if (e == null) // will never be true, but avoids dead code be reported
    	{
    		fnc_1_F_SCC_obj1();
    	}
    }

    ///////////////////////

    public static void DF_Access_1_A1()
    {
        // Reached by JVEntryPt_1_A() --> E4.foo1() --> DF_Access_1_A1()
        System.out.print(" --> DF_Access_1_A1()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_A2()
    {
        // Never reached in theory
        System.out.print("error: we should not be in DF_Access_1_A2()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_B()
    {
        // Reached by JVEntryPt_1_B() --> E4.bar1() --> E4.foo2() --> DF_Access_1_B()
        System.out.print(" --> DF_Access_1_B()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_C()
    {
        // Reached by JVEntryPt_1_C --> TopLevel1.qux1() --> E2.foo3() --> DF_Access_1_C()
        System.out.print(" --> DF_Access_1_C()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_D()
    {
        // Reached by JVEntryPt_1_D --> TopLevel1.qux2() --> E4.foo3() --> DF_Access_1_D()
        System.out.print(" --> DF_Access_1_D()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_E()
    {
        // Reached by JVEntryPt_1_E_SCC_with_3_objects() --> fnc_1_E_SCC_obj1() --> fnc_1_E_SCC_obj2() --> fnc_1_E_SCC_obj3() --> TopLevel1.qux3() --> E4.foo4() --> DF_Access_1_E()
        System.out.print(" --> DF_Access_1_E()");
        Access_DF.findAllMonsters();
    }

    public static void DF_Access_1_F()
    {
        // Reached by JVEntryPt_1_F_SCC_with_5_objects() --> fnc_1_F_SCC_obj1() --> fnc_1_F_SCC_obj2() --> fnc_1_F_SCC_obj3() --> fnc_1_F_SCC_obj4() --> fnc_1_F_SCC_obj5() --> TopLevel1.qux4() --> E4.foo5() --> DF_Access_1_F()
        System.out.print(" --> DF_Access_1_F()");
        Access_DF.findAllMonsters();
    }
}
