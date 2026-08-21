package com.cast.ACA.code_samples;

public class WrongLinkType
{
    static void yy()
    {
        /* NOP */
    }

    void for_loop_with_curly_braces()
    {
        for (int i = 0; i==0; ++i )
        {
            yy();
        }
    }

    void while_loop_with_curly_braces()
    {
        while (true)
        {
            yy();
        }
    }

    void do_while_loop_with_curly_braces()
    {
        do
        {
            yy();
        }
        while (false);
    }

    void nested_curly_braces()
    {
        {
            yy();
        }
    }

    enum NestedEnum
    {
        e1, e2;

        public void method_in_nested_enum()
        {
            yy();
        }
    }

    class NestedClass
    {
        public void method_in_nested_class()
        {
            yy();
        }
    }

    class A
    {
    }

    void g()
    {
        new A()
        {
            void call_from_anonymous_class1()
            {
                yy(); // this link should be typed {Ae} and have the "escalated from container" pty. in FusAcc
            }
        }.call_from_anonymous_class1();
    }

    interface I
    {
        void call_from_anonymous_class2();
    }

    void h()
    {
        new I()
        {
            @Override
            public void call_from_anonymous_class2()
            {
                yy(); // this link should be typed {Ae} and have the "escalated from container" pty. in FusAcc
            }
        }.call_from_anonymous_class2();
    }
}
