package com.cast.ACA.code_samples;

// Inspired by FJA's code in SCRAIP-30539 & JFAMILY-674, which
// correspond to the other class 'TestCasesFJA' in this project.
public class TopLevel8
{
    public static void allJVEntryPt_8()
    {
        TopLevel8 x = new TopLevel8();

        System.out.println("\n------------");

        x.JVEntryPt_8_11a_Plain();  // JVEntryPt_8_11a_Plain() --> DF_Access_8_Plain_f11a() --> TopLevel8.ff()
        x.JVEntryPt_8_11b_Plain();  // JVEntryPt_8_11b_Plain() --> DF_Access_8_Plain_f11b() --> TopLevel8.ff()
        x.JVEntryPt_8_11c_Plain();  // JVEntryPt_8_11c_Plain() --> DF_Access_8_Plain_f11c() --> TopLevel8.ff()
        x.JVEntryPt_8_12a_Plain();  // JVEntryPt_8_12a_Plain() --> DF_Access_8_Plain_f12a() --> TopLevel8.ff()
        x.JVEntryPt_8_12b_Plain();  // JVEntryPt_8_12b_Plain() --> DF_Access_8_Plain_f12b() --> TopLevel8.ff()
        x.JVEntryPt_8_12c_Plain();  // JVEntryPt_8_12c_Plain() --> DF_Access_8_Plain_f12c() --> TopLevel8.ff()
        x.JVEntryPt_8_13a_Plain(); // JVEntryPt_8_13a_Plain() --> DF_Access_8_Plain_f13a() --> TopLevel8.ff()
        x.JVEntryPt_8_13b_Plain(); // JVEntryPt_8_13b_Plain() --> DF_Access_8_Plain_f13b() --> TopLevel8.ff()
        x.JVEntryPt_8_13c_Plain(); // JVEntryPt_8_13c_Plain() --> DF_Access_8_Plain_f13c() --> TopLevel8.ff()
        x.JVEntryPt_8_13d_Plain(); // JVEntryPt_8_13d_Plain() --> DF_Access_8_Plain_f13d() --> TopLevel8.ff()
        x.JVEntryPt_8_14_Plain();  // JVEntryPt_8_14_Plain() --> DF_Access_8_Plain_f14() --> TopLevel8.ff()
        x.JVEntryPt_8_15_Plain();  // JVEntryPt_8_15_Plain() --> DF_Access_8_Plain_f15() --> TopLevel8.ff()
        x.JVEntryPt_8_16_Plain();  // JVEntryPt_8_16_Plain() --> DF_Access_8_Plain_f16() --> TopLevel8.ff()
        x.JVEntryPt_8_17_Plain();  // JVEntryPt_8_17_Plain() --> DF_Access_8_Plain_f17() --> DATAFUNCTION_EXCEPTION() --> TopLevel8.ff()
        try
        {
            x.JVEntryPt_8_18_Plain(); // JVEntryPt_8_18_Plain() --> DF_Access_8_Plain_f18() --> DATAFUNCTION_EXCEPTION() --> TopLevel8.ff()
        }
        catch( Exception e )
        {
            // NOP
        }

        x.JVEntryPt_8_11a_Embedded();  // JVEntryPt_8_11a_Embedded() --> EmbTest.DF_Access_8_Emb_f11a() --> TopLevel8.ff()
        x.JVEntryPt_8_11b_Embedded();  // JVEntryPt_8_11b_Embedded() --> EmbTest.DF_Access_8_Emb_f11b() --> TopLevel8.ff()
        x.JVEntryPt_8_11c_Embedded();  // JVEntryPt_8_11c_Embedded() --> EmbTest.DF_Access_8_Emb_f11c() --> TopLevel8.ff()
        x.JVEntryPt_8_12a_Embedded();  // JVEntryPt_8_12a_Embedded() --> EmbTest.DF_Access_8_Emb_f12a() --> TopLevel8.ff()
        x.JVEntryPt_8_12b_Embedded();  // JVEntryPt_8_12b_Embedded() --> EmbTest.DF_Access_8_Emb_f12b() --> TopLevel8.ff()
        x.JVEntryPt_8_12c_Embedded();  // JVEntryPt_8_12c_Embedded() --> EmbTest.DF_Access_8_Emb_f12c() --> TopLevel8.ff()
        x.JVEntryPt_8_13a_Embedded(); // JVEntryPt_8_13a_Embedded() --> EmbTest.DF_Access_8_Emb_f13a() --> TopLevel8.ff()
        x.JVEntryPt_8_13b_Embedded(); // JVEntryPt_8_13b_Embedded() --> EmbTest.DF_Access_8_Emb_f13b() --> TopLevel8.ff()
        x.JVEntryPt_8_13c_Embedded(); // JVEntryPt_8_13c_Embedded() --> EmbTest.DF_Access_8_Emb_f13c() --> TopLevel8.ff()
        x.JVEntryPt_8_13d_Embedded(); // JVEntryPt_8_13d_Embedded() --> EmbTest.DF_Access_8_Emb_f13d() --> TopLevel8.ff()
        x.JVEntryPt_8_14_Embedded();  // JVEntryPt_8_14_Embedded() --> EmbTest.DF_Access_8_Emb_f14() --> TopLevel8.ff()
        x.JVEntryPt_8_15_Embedded();  // JVEntryPt_8_15_Embedded() --> EmbTest.DF_Access_8_Emb_f15() --> TopLevel8.ff()
        x.JVEntryPt_8_16_Embedded();  // JVEntryPt_8_16_Embedded() --> EmbTest.DF_Access_8_Emb_f16() --> TopLevel8.ff()
        x.JVEntryPt_8_17_Embedded();  // JVEntryPt_8_17_Embedded() --> EmbTest.DF_Access_8_Emb_f17() --> DATAFUNCTION_EXCEPTION() --> TopLevel8.ff()

        x.JVEntryPt_8_11_Inner();  // JVEntryPt_8_11_Inner() --> DF_Access_8_Inner_f11() --> DF_Access_8_Inner_f11().newInnerTest() { Inner_f11() } --> TopLevel8.ff()
        x.JVEntryPt_8_12_Inner();  // JVEntryPt_8_12_Inner() --> DF_Access_8_Inner_f12() --> DF_Access_8_Inner_f12().newInnerTest() { Inner_f12() } --> TopLevel8.ff()
        x.JVEntryPt_8_13a_Inner(); // JVEntryPt_8_13a_Inner() --> DF_Access_8_Inner_f13a() --> DF_Access_8_Inner_f13a().newInnerTest() { Inner_f13a() } --> TopLevel8.ff()
        x.JVEntryPt_8_13b_Inner(); // JVEntryPt_8_13b_Inner() --> DF_Access_8_Inner_f13b() --> DF_Access_8_Inner_f13b().newInnerTest() { Inner_f13b() } --> TopLevel8.ff()
        x.JVEntryPt_8_13c_Inner(); // JVEntryPt_8_13c_Inner() --> DF_Access_8_Inner_f13c() --> DF_Access_8_Inner_f13c().newInnerTest() { Inner_f13c() } --> TopLevel8.ff()
        x.JVEntryPt_8_13d_Inner(); // JVEntryPt_8_13d_Inner() --> DF_Access_8_Inner_f13d() --> DF_Access_8_Inner_f13d().newInnerTest() { Inner_f13d() } --> TopLevel8.ff()
        x.JVEntryPt_8_14_Inner();  // JVEntryPt_8_14_Inner() --> DF_Access_8_Inner_f14() --> DF_Access_8_Inner_f14().newInnerTest() { Inner_f14() } --> TopLevel8.ff()
        x.JVEntryPt_8_15_Inner();  // JVEntryPt_8_15_Inner() --> DF_Access_8_Inner_f15() --> DF_Access_8_Inner_f15().newInnerTest() { Inner_f15() } --> TopLevel8.ff()
        x.JVEntryPt_8_16_Inner();  // JVEntryPt_8_16_Inner() --> DF_Access_8_Inner_f16() --> DF_Access_8_Inner_f16().newInnerTest() { Inner_f16() } --> TopLevel8.ff()
        x.JVEntryPt_8_17_Inner();  // JVEntryPt_8_17_Inner() --> DF_Access_8_Inner_f17() --> DF_Access_8_Inner_f17().newInnerTest() { Inner_f17() } --> DATAFUNCTION_EXCEPTION() --> TopLevel8.ff()
    }

    ///////////////////////

    int ff()
    {
        System.out.print(" --> TopLevel8.ff()");

        return Access_DF.findAllMonsters();
    }

    class DATAFUNCTION_EXCEPTION extends Exception
    {
        private static final long serialVersionUID = -397032515598781550L;

        DATAFUNCTION_EXCEPTION()
        {
            System.out.print(" --> DATAFUNCTION_EXCEPTION()");
            ff();
        }
    }

    ///////////////////////

    void JVEntryPt_8_11a_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_11a_Plain()");
        DF_Access_8_Plain_f11a();
    }

    void JVEntryPt_8_11b_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_11b_Plain()");
        DF_Access_8_Plain_f11b();
    }

    void JVEntryPt_8_11c_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_11c_Plain()");
        DF_Access_8_Plain_f11c();
    }

    void JVEntryPt_8_12a_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_12a_Plain()");
        DF_Access_8_Plain_f12a();
    }

    void JVEntryPt_8_12b_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_12b_Plain()");
        DF_Access_8_Plain_f12b();
    }

    void JVEntryPt_8_12c_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_12c_Plain()");
        DF_Access_8_Plain_f12c();
    }

    void JVEntryPt_8_13a_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13a_Plain()");
        DF_Access_8_Plain_f13a();
    }

    void JVEntryPt_8_13b_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13b_Plain()");
        DF_Access_8_Plain_f13b();
    }

    void JVEntryPt_8_13c_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13c_Plain()");
        DF_Access_8_Plain_f13c();
    }

    void JVEntryPt_8_13d_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13d_Plain()");
        DF_Access_8_Plain_f13d();
    }

    void JVEntryPt_8_14_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_14_Plain()");
        DF_Access_8_Plain_f14();
    }

    void JVEntryPt_8_15_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_15_Plain()");
        DF_Access_8_Plain_f15();
    }

    void JVEntryPt_8_16_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_16_Plain()");
        DF_Access_8_Plain_f16();
    }

    void JVEntryPt_8_17_Plain()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_17_Plain()");
        DF_Access_8_Plain_f17();
    }

    void JVEntryPt_8_18_Plain() throws DATAFUNCTION_EXCEPTION
    {
        System.out.print('\n' + "Starting JVEntryPt_8_18_Plain()");
        DF_Access_8_Plain_f18();
    }

    void DF_Access_8_Plain_f11a()
    {
        System.out.print(" --> DF_Access_8_Plain_f11a()");

        ff();
    }

    void DF_Access_8_Plain_f11b()
    {
        System.out.print(" --> DF_Access_8_Plain_f11b()");

        int ii = ff();
        ii = ii + 0; // for removing Eclipse warning about unused local var.
    }

    void DF_Access_8_Plain_f11c()
    {
        System.out.print(" --> DF_Access_8_Plain_f11c()");

        int ii;
        ii = ff();
        ii = ii + 0; // for removing Eclipse warning about unused local var.
    }

    void DF_Access_8_Plain_f12a()
    {
        System.out.print(" --> DF_Access_8_Plain_f12a()");

        {
            ff();
        }
    }

    void DF_Access_8_Plain_f12b()
    {
        System.out.print(" --> DF_Access_8_Plain_f12b()");

        {
            int ii = ff();
            ii = ii + 0; // for removing Eclipse warning about unused local var.
        }
    }

    void DF_Access_8_Plain_f12c()
    {
        System.out.print(" --> DF_Access_8_Plain_f12c()");

        {
            int ii;
            ii = ff();
            ii = ii + 0; // for removing Eclipse warning about unused local var.
        }
    }

    void DF_Access_8_Plain_f13a()
    {
        System.out.print(" --> DF_Access_8_Plain_f13a()");

        for (int i = 0; i <= 0; i++)
        {
            ff();
        }
    }

    void DF_Access_8_Plain_f13b()
    {
        System.out.print(" --> DF_Access_8_Plain_f13b()");

        for (int i = 0; i <= 0; i++)
            ff();
    }

    void DF_Access_8_Plain_f13c()
    {
        System.out.print(" --> DF_Access_8_Plain_f13c()");

        while(true)
        {
            ff();
            break;
        }
    }

    void DF_Access_8_Plain_f13d()
    {
        System.out.print(" --> DF_Access_8_Plain_f13d()");

        int i = 0;
        while( ++i == 1 )
            ff();
    }

    void DF_Access_8_Plain_f14()
    {
        System.out.print(" --> DF_Access_8_Plain_f14()");

        int ii = 0;
        ii = ff();
        ii = ii + 0; // for removing Eclipse warning about unused local var.
    }

    void DF_Access_8_Plain_f15()
    {
        System.out.print(" --> DF_Access_8_Plain_f15()");
        ff();
    }

    void DF_Access_8_Plain_f16()
    {
        System.out.print(" --> DF_Access_8_Plain_f16()");

        try
        {
            ff();
        }
        catch (Exception e)
        {
            // NOP
        }
    }

    void DF_Access_8_Plain_f17()
    {
        System.out.print(" --> DF_Access_8_Plain_f17()");

        try
        {
            throw new DATAFUNCTION_EXCEPTION();
        }
        catch (DATAFUNCTION_EXCEPTION e)
        {
            // NOP
        }
    }

    void DF_Access_8_Plain_f18() throws DATAFUNCTION_EXCEPTION
    {
        System.out.print(" --> DF_Access_8_Plain_f18()");
        throw new DATAFUNCTION_EXCEPTION();
    }


    ///////////////////////

    void JVEntryPt_8_11a_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_11a_Embedded()");
        new EmbTest().DF_Access_8_Emb_f11a();
    }

    void JVEntryPt_8_11b_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_11b_Embedded()");
        new EmbTest().DF_Access_8_Emb_f11b();
    }

    void JVEntryPt_8_11c_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_11c_Embedded()");
        new EmbTest().DF_Access_8_Emb_f11c();
    }

    void JVEntryPt_8_12a_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_12a_Embedded()");
        new EmbTest().DF_Access_8_Emb_f12a();
    }

    void JVEntryPt_8_12b_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_12b_Embedded()");
        new EmbTest().DF_Access_8_Emb_f12b();
    }

    void JVEntryPt_8_12c_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_12c_Embedded()");
        new EmbTest().DF_Access_8_Emb_f12c();
    }

    void JVEntryPt_8_13a_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13a_Embedded()");
        new EmbTest().DF_Access_8_Emb_f13a();
    }

    void JVEntryPt_8_13b_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13b_Embedded()");
        new EmbTest().DF_Access_8_Emb_f13b();
    }

    void JVEntryPt_8_13c_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13c_Embedded()");
        new EmbTest().DF_Access_8_Emb_f13c();
    }

    void JVEntryPt_8_13d_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13d_Embedded()");
        new EmbTest().DF_Access_8_Emb_f13d();
    }

    void JVEntryPt_8_14_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_14_Embedded()");
        new EmbTest().DF_Access_8_Emb_f14();
    }

    void JVEntryPt_8_15_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_15_Embedded()");
        new EmbTest().DF_Access_8_Emb_f15();
    }

    void JVEntryPt_8_16_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_16_Embedded()");
        new EmbTest().DF_Access_8_Emb_f16();
    }

    void JVEntryPt_8_17_Embedded()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_17_Embedded()");
        new EmbTest().DF_Access_8_Emb_f17();
    }

    ///////////////////////

    void JVEntryPt_8_11_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_11_Inner()");
        DF_Access_8_Inner_f11();
    }

    void JVEntryPt_8_12_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_12_Inner()");
        DF_Access_8_Inner_f12();
    }

    void JVEntryPt_8_13a_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13a_Inner()");
        DF_Access_8_Inner_f13a();
    }

    void JVEntryPt_8_13b_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13b_Inner()");
        DF_Access_8_Inner_f13b();
    }

    void JVEntryPt_8_13c_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13c_Inner()");
        DF_Access_8_Inner_f13c();
    }

    void JVEntryPt_8_13d_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_13d_Inner()");
        DF_Access_8_Inner_f13d();
    }

    void JVEntryPt_8_14_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_14_Inner()");
        DF_Access_8_Inner_f14();
    }

    void JVEntryPt_8_15_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_15_Inner()");
        DF_Access_8_Inner_f15();
    }

    void JVEntryPt_8_16_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_16_Inner()");
        DF_Access_8_Inner_f16();
    }

    void JVEntryPt_8_17_Inner()
    {
        System.out.print('\n' + "Starting JVEntryPt_8_17_Inner()");
        DF_Access_8_Inner_f17();
    }

    ///////////////////////

    public class InnerTest
    {
    }

    void DF_Access_8_Inner_f11()
    {
        System.out.print(" --> DF_Access_8_Inner_f11() { ");

        new InnerTest()
        {
            void Inner_f11()
            {
                System.out.print(" --> DF_Access_8_Inner_f11().new InnerTest() { Inner_f11() }");

                int ii = ff();
                ii = ii + 0; // for removing Eclipse warning about unused local var.
            }
        }.Inner_f11();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f12()
    {
        System.out.print(" --> DF_Access_8_Inner_f12() { ");

        new InnerTest()
        {
            void Inner_f12()
            {
                System.out.print(" --> DF_Access_8_Inner_f12().new InnerTest() { Inner_f12() }");

                {
                    ff();
                }
            }
        }.Inner_f12();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f13a()
    {
        System.out.print(" --> DF_Access_8_Inner_f13a() { ");

        new InnerTest()
        {
            void Inner_f13a()
            {
                System.out.print(" --> DF_Access_8_Inner_f13a().new InnerTest() { Inner_f13a() }");

                for (int i = 0; i <= 0; i++)
                {
                    ff();
                }
            }
        }.Inner_f13a();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f13b()
    {
        System.out.print(" --> DF_Access_8_Inner_f13b() { ");

        new InnerTest()
        {
            void Inner_f13b()
            {
                System.out.print(" --> DF_Access_8_Inner_f13b().new InnerTest() { Inner_f13b() }");

                for (int i = 0; i <= 0; i++)
                    ff();
            }
        }.Inner_f13b();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f13c()
    {
        System.out.print(" --> DF_Access_8_Inner_f13c() { ");

        new InnerTest()
        {
            void Inner_f13c()
            {
                System.out.print(" --> DF_Access_8_Inner_f13c().new InnerTest() { Inner_f13c() }");

                while (true)
                {
                    ff();
                    break;
                }
            }
        }.Inner_f13c();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f13d()
    {
        System.out.print(" --> DF_Access_8_Inner_f13d() { ");

        new InnerTest()
        {
            void Inner_f13d()
            {
                System.out.print(" --> DF_Access_8_Inner_f13d().new InnerTest() { Inner_f13d() }");

                int i = 0;
                while ( ++i == 1 )
                    ff();
            }
        }.Inner_f13d();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f14()
    {
        System.out.print(" --> DF_Access_8_Inner_f14() { ");

        new InnerTest()
        {
            void Inner_f14()
            {
                System.out.print(" --> DF_Access_8_Inner_f14().new InnerTest() { Inner_f14() }");

                int ii = 0;
                ii = ff();
                ii = ii + 0; // for removing Eclipse warning about unused local var.
            }
        }.Inner_f14();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f15()
    {
        System.out.print(" --> DF_Access_8_Inner_f15() { ");

        new InnerTest()
        {
            void Inner_f15()
            {
                System.out.print(" --> DF_Access_8_Inner_f15().new InnerTest() { Inner_f15() }");

                ff();
            }
        }.Inner_f15();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f16()
    {
        System.out.print(" --> DF_Access_8_Inner_f16() { ");

        new InnerTest()
        {
            void Inner_f16()
            {
                System.out.print(" --> DF_Access_8_Inner_f16().new InnerTest() { Inner_f16() }");

                try
                {
                    ff();
                }
                catch (Exception e)
                {
                    // NOP
                }
            }
        }.Inner_f16();

        System.out.print(" }");
    }

    void DF_Access_8_Inner_f17()
    {
        System.out.print(" --> DF_Access_8_Inner_f17() { ");

        new InnerTest()
        {
            void Inner_f17()
            {
                System.out.print(" --> DF_Access_8_Inner_f17().new InnerTest() { Inner_f17() }");

                try
                {
                    int i = 0;
                    i = i + 0; // for removing Eclipse warning about unused local var.
                    throw new DATAFUNCTION_EXCEPTION();
                }
                catch (DATAFUNCTION_EXCEPTION e)
                {
                    // NOP
                }
            }
        }.Inner_f17();

        System.out.print(" }");
    }

    public class EmbTest
    {

        void DF_Access_8_Emb_f11a()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f11a()");

            ff();
        }

        void DF_Access_8_Emb_f11b()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f11b()");

            int ii = ff();
            ii = ii + 0; // for removing Eclipse warning about unused local var.
        }

        void DF_Access_8_Emb_f11c()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f11c()");

            int ii;
            ii = ff();
            ii = ii + 0; // for removing Eclipse warning about unused local var.
        }

        void DF_Access_8_Emb_f12a()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f12a()");

            {
                ff();
            }
        }

        void DF_Access_8_Emb_f12b()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f12b()");

            {
                int ii = ff();
                ii = ii + 0; // for removing Eclipse warning about unused local var.
            }
        }

        void DF_Access_8_Emb_f12c()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f12c()");

            {
                int ii;
                ii = ff();
                ii = ii + 0; // for removing Eclipse warning about unused local var.
            }
        }

        void DF_Access_8_Emb_f13a()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f13a()");

            for (int i = 0; i <= 0; i++)
            {
                ff();
            }
        }

        void DF_Access_8_Emb_f13b()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f13b()");

            for (int i = 0; i <= 0; i++)
                ff();
        }

        void DF_Access_8_Emb_f13c()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f13c()");

            while (true)
            {
                ff();
                break;
            }
        }

        void DF_Access_8_Emb_f13d()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f13d()");

            int i = 0;
            while ( ++i == 1 )
                ff();
        }

        void DF_Access_8_Emb_f14()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f14()");

            int ii = 0;
            ii = ff();
            ii = ii + 0; // for removing Eclipse warning about unused local var.
        }

        void DF_Access_8_Emb_f15()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f15()");

            ff();
        }

        void DF_Access_8_Emb_f16()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f16()");

            try
            {
                ff();
            }
            catch (Exception e)
            {
                // NOP
            }
        }

        void DF_Access_8_Emb_f17()
        {
            System.out.print(" --> EmbTest.DF_Access_8_Emb_f17()");

            try
            {
                throw new DATAFUNCTION_EXCEPTION();
            }
            catch (DATAFUNCTION_EXCEPTION e)
            {
                // NOP
            }
        }
    }
}
