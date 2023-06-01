package org.example.com;

import java.util.Locale;
import java.util.ResourceBundle;


public class DisplayLocales {
    Locale[] availableLocales;

    public DisplayLocales() {
        availableLocales = Locale.getAvailableLocales();
    }

    /**
     * displays available locales and the countries and languages
     */
    public void displayLocales() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages");
        System.out.println(resourceBundle.getString("locales"));
        for (Locale locale : availableLocales)
            System.out.println("Country: " + locale.getCountry() + " language: " + locale.getLanguage());
    }
}
