package org.example.com;

import java.util.Locale;

public class SetLocale {
    private Locale currentLocale;

    /**
     * sets the current locale based on the language tag
     * @param languageTag  locale identifier
     */
    public void setCurrentLocale(String languageTag)
    {
        currentLocale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(currentLocale);
    }
    public Locale getCurrentLocale()
    {
        return currentLocale;
    }
}
