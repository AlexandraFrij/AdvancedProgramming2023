package org.example.com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales{
    Locale[] availableLocales;
    public DisplayLocales()
    {
        availableLocales = Locale.getAvailableLocales();
    }
    public Locale[] getAvailableLocales()
    {
        return availableLocales;
    }
    public void displayLocales()
    {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.example.res.Messages");
        System.out.println(resourceBundle.getString("locales"));
        for(Locale locale: availableLocales)
            System.out.println("Country: "+locale.getCountry()+ " language: "+ locale.getLanguage());
    }
}
