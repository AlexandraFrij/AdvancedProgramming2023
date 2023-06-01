package org.example.com;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;
import java.text.DateFormat;
import java.time.LocalDate;
public class Info {
    /**
     * displays info about a given locale
     * @param locale  a given locale
     */
    public void displayInfo(Locale locale)
    {
        System.out.println("Country: "+ locale.getCountry());
        System.out.println("Language: "+ locale.getLanguage());
        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency: "+ currency.getCurrencyCode());
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        System.out.println("Week days: "+ dateFormatSymbols.getWeekdays());
        System.out.println("Months: "+ dateFormatSymbols.getMonths());
        LocalDate currentDate = LocalDate.now();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(currentDate);
        System.out.println("Today: "+ formattedDate);

    }
}
