package com.cast.ACA.code_samples;

public class TopLevel_Demo_Inherit_Links
{
    public static void allJVEntryPt_DIL()
    {
    	TopLevel_Demo_Inherit_Links x = new TopLevel_Demo_Inherit_Links();

        System.out.println("\n------------");

        x.JVEntryPt_DIL_A();
        x.JVEntryPt_DIL_B();
        x.JVEntryPt_DIL_C();
        x.JVEntryPt_DIL_D();
    }

    ///////////////////////

    class C
    {
        public void f1()
        {
            System.out.print(" --> TopLevel_Demo_Inherit_Links.C.f1()");
            f2();
        }

        public void f2()
        {
            System.out.print(" --> TopLevel_Demo_Inherit_Links.C.f2()");
            DF_Access_DIL_1();
        }

        public void Cg1()
        {
            System.out.print(" --> TopLevel_Demo_Inherit_Links.C.Cg1()");
            Cg2();
        }

        public void Cg2()
        {
            System.out.print(" --> TopLevel_Demo_Inherit_Links.C.Cg2()");
            DF_Access_DIL_2();
        }

    }

    class D extends C
    {
        public void f1()
        {
            System.out.print(" --> TopLevel_Demo_Inherit_Links.D.f1()");
            f2();
        }

        public void f2()
        {
            System.out.print(" --> TopLevel_Demo_Inherit_Links.D.f2()");
            DF_Access_DIL_3();
        }

        public void Dg1()
        {
            System.out.print(" --> TopLevel_Demo_Inherit_Links.D.Dg1()");
            Dg2();
        }

        public void Dg2()
        {
            System.out.print(" --> TopLevel_Demo_Inherit_Links.D.Dg2()");
            DF_Access_DIL_4();
        }
     
    }

    ///////////////////////

    public void JVEntryPt_DIL_A()
    {
        System.out.print('\n' + "Starting JVEntryPt_DIL_A()");
        C c = new C();
        c.f1();
    }

    public void JVEntryPt_DIL_B()
    {
        System.out.print('\n' + "Starting JVEntryPt_DIL_B()");
        C c = new C();
        c.Cg1();
    }

    public void JVEntryPt_DIL_C()
    {
        System.out.print('\n' + "Starting JVEntryPt_DIL_C()");
        D d = new D();
        d.f1();
    }

    public void JVEntryPt_DIL_D()
    {
        System.out.print('\n' + "Starting JVEntryPt_DIL_D()");
        D d = new D();
        d.Dg1();
    }

    ///////////////////////

    public static void DF_Access_DIL_1()
    {
        // Reached by JVEntryPt_DIL_A() --> TopLevel_Demo_Inherit_Links.C.f1() --> TopLevel_Demo_Inherit_Links.C.f2() --> DF_Access_DIL_1()
        System.out.print(" --> DF_Access_DIL_1()");
        Access_DF.accessSpookyOption();
    }

    public static void DF_Access_DIL_2()
    {
        // Reached by JVEntryPt_DIL_B() --> TopLevel_Demo_Inherit_Links.C.Cg1() --> TopLevel_Demo_Inherit_Links.C.Cg2() --> DF_Access_DIL_2()
        System.out.print(" --> DF_Access_DIL_2()");
        Access_DF.accessSpookyOption();
    }

    public static void DF_Access_DIL_3()
    {
        // Reached by JVEntryPt_DIL_C() --> TopLevel_Demo_Inherit_Links.D.f1() --> TopLevel_Demo_Inherit_Links.D.f2() --> DF_Access_DIL_3()
        System.out.print(" --> DF_Access_DIL_3()");
        Access_DF.accessSpookyPlace();
    }

    public static void DF_Access_DIL_4()
    {
        // Reached by JVEntryPt_DIL_D() --> TopLevel_Demo_Inherit_Links.D.Dg1() --> TopLevel_Demo_Inherit_Links.D.Dg2() --> DF_Access_DIL_4()
        System.out.print(" --> DF_Access_DIL_4()");
        Access_DF.accessSpookyPlace();
    }
}
