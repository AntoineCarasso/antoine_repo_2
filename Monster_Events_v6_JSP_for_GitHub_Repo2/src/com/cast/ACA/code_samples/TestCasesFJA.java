package com.cast.ACA.code_samples;

/*
TCC configuration : 
-entry point free definition : name like ENTRYPOINT%
-data function free definition : name like DATAFUNCTION%
TCC results : 
-for ENTRYPOINT11, 12, etc.,      Ae in main class, some internally escalated, but links not filtered    => NO ISSUE IN TCC
-for ENTRYPOINTEMB11, 12, etc.,   Ae in a sub class, some internally escalated, but links filtered       => ISSUE IN TCC
-for ENTRYPOINTINNER11, 12, etc., Ae in an anonymous class, all internally escalated, but links filtered => ISSUE IN TCC
*/
public class TestCasesFJA
{
    void ENTRYPOINT11()
    {
        f11();
    }

    void ENTRYPOINT12()
    {
        f12();
    }

    void ENTRYPOINT13()
    {
        f13();
    }

    void ENTRYPOINT14()
    {
        f14();
    }

    void ENTRYPOINT15()
    {
        f15();
    }

    void ENTRYPOINT16()
    {
        f16();
    }

    void ENTRYPOINT17()
    {
        f17();
    }

    void ENTRYPOINT18() throws DATAFUNCTIONEXCEPTION
    {
        f18();
    }

    void ENTRYPOINT11EMB()
    {
        new EmbTest().Embf11();
    }

    void ENTRYPOINT12EMB()
    {
        new EmbTest().Embf12();
    }

    void ENTRYPOINT13EMB()
    {
        new EmbTest().Embf13();
    }

    void ENTRYPOINT14EMB()
    {
        new EmbTest().Embf14();
    }

    void ENTRYPOINT15EMB()
    {
        new EmbTest().Embf15();
    }

    void ENTRYPOINT16EMB()
    {
        new EmbTest().Embf16();
    }

    public class InnerTest
    {
    }

    void ENTRYPOINT11INNER()
    {
        fi11();
    }

    void fi11()
    {
        new InnerTest()
        {
            void Innerf11()
            {
                int ii = ff();
            }
        }.Innerf11();
    }

    void ENTRYPOINT12INNER()
    {
        fi12();
    }

    void fi12()
    {
        new InnerTest()
        {
            void Innerf12()
            {
                {
                    ff();
                }
            }
        }.Innerf12();
    }

    void ENTRYPOINT13INNER()
    {
        fi13();
    }

    void fi13()
    {
        new InnerTest()
        {
            void Innerf13()
            {
                for (int i = 0; i < 10; i++)
                {
                    ff();
                }
            }
        }.Innerf13();
    }

    void ENTRYPOINT14INNER()
    {
        fi14();
    }

    void fi14()
    {
        new InnerTest()
        {
            void Innerf14()
            {
                int ii = 0;
                ii = ff();
            }
        }.Innerf14();
    }

    void ENTRYPOINT15INNER()
    {
        fi15();
    }

    void fi15()
    {
        new InnerTest()
        {
            void Innerf15()
            {
                ff();
            }
        }.Innerf15();
    }

    void ENTRYPOINT16INNER()
    {
        fi16();
    }

    void fi16()
    {
        new InnerTest()
        {
            void Innerf16()
            {
                try
                {
                    ff();
                }
                catch (Exception e)
                {
                    // no
                }
            }
        }.Innerf16();
    }

    void DATAFUNCTION()
    {
    	// This really accesses some DFs
    	Access_DF.findAllMonsters();
    }

    int ff()
    {
        DATAFUNCTION();
        return 0;
    }

    void f11()
    {
        int ii = ff();
    }

    void f12()
    {
        {
            ff();
        }
    }

    void f13()
    {
        for (int i = 0; i < 10; i++)
        {
            ff();
        }
    }

    void f14()
    {
        int ii = 0;
        ii = ff();
    }

    void f15()
    {
        ff();
    }

    void f16()
    {
        try
        {
            ff();
        }
        catch (Exception e)
        {
            // no
        }
    }

    void f17()
    {
        try
        {
            int i = 0;
            throw new DATAFUNCTIONEXCEPTION();
        }
        catch (DATAFUNCTIONEXCEPTION e)
        {
            // no
        }
    }

    void f18() throws DATAFUNCTIONEXCEPTION
    {
        int i = 0;
        throw new DATAFUNCTIONEXCEPTION();
    }

    class DATAFUNCTIONEXCEPTION extends Exception
    {

    }

    public class EmbTest
    {
        void Embf11()
        {
            int ii = ff();
        }

        void Embf12()
        {
            {
                ff();
            }
        }

        void Embf13()
        {
            for (int i = 0; i < 10; i++)
            {
                ff();
            }
        }

        void Embf14()
        {
            int ii = 0;
            ii = ff();
        }

        void Embf15()
        {
            ff();
        }

        void Embf16()
        {
            try
            {
                ff();
            }
            catch (Exception e)
            {
                // no
            }
        }
    }
}
