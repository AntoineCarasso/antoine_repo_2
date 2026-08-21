package com.cast.ACA.code_samples;

// This class contains the "main(String[] args)"
public class CallAllJVEntryPts
{
    public static void callAllJVEntryPts()
    {
        TopLevel1.allJVEntryPt_1();
        TopLevel2.allJVEntryPt_2();
        TopLevel3.allJVEntryPt_3(); // 1st bookmark, relative line# in the "caller" object is 5
        TopLevel4.allJVEntryPt_4();
        TopLevel5.allJVEntryPt_5();
        TopLevel6.allJVEntryPt_6();
        TopLevel7.allJVEntryPt_7();
        TopLevel8.allJVEntryPt_8();
        TopLevel9.allJVEntryPt_9();

        TopLevel1.allJVEntryPt_1();

        TopLevel2.allJVEntryPt_2();
        TopLevel2.allJVEntryPt_2();

        TopLevel3.allJVEntryPt_3(); // 2nd bookmark, relative line# in the "caller" object is 18
        TopLevel3.allJVEntryPt_3(); // 3rd bookmark, relative line# in the "caller" object is 19
        TopLevel3.allJVEntryPt_3(); // 4th bookmark, relative line# in the "caller" object is 20

		TopLevel_Latin1.allJVEntryPt_Latin1();
		TopLevel_Greek.allJVEntryPt_Greek();
		TopLevel_Hiragana.allJVEntryPt_Hiragana();

		TopLevel_Demo_Inherit_Links.allJVEntryPt_DIL();
    }

    public static void testCallOfImplicitConstructor()
    {
        // To see how look like the bookmarks between this method and the
        // constructor called in the line below that has no source code...
        CallAllJVEntryPts x = new CallAllJVEntryPts();
    }
	
	public static void main(String[] args)
	{
		System.out.println("starting main() - We are in CallAllJVEntryPts().");
		callAllJVEntryPts();
		System.out.println("\nending main() - We are in CallAllJVEntryPts().");
	}
}
