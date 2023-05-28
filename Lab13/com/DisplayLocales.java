package org.example.Lab13.com;
import java.util.Locale;

public class DisplayLocales {
    public static String display()
    {
        String output= "";
//        System.out.println("Available locales:");
        Locale available[] =
                Locale.getAvailableLocales();
        for(Locale locale : available) {
            String s = locale.getDisplayCountry() + "\t" + locale.getDisplayLanguage(locale);
            output+=s+"\n";
//            System.out.println(s);
        }
        return output;
    }
}
