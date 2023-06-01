package org.example.app;

import org.example.com.DisplayLocales;
import org.example.com.SetLocale;
import org.example.com.Info;
import java.util.ResourceBundle;

import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args)
    {
        ResourceBundle messages = ResourceBundle.getBundle("Messages");
        Scanner scanner = new Scanner(System.in);
        SetLocale setLocale = new SetLocale();
        Info info = new Info();
        String command;
        /**
         * reads command from keyboard
         * analyzes the command, executes the given input
         */
        while(true)
        {
            System.out.print(messages.getString("prompt"));
            command = scanner.nextLine();
            if(command.equalsIgnoreCase("set"))
            {
                System.out.print(messages.getString("locale.set"));
                String languageTag = scanner.nextLine();
                setLocale.setCurrentLocale(languageTag);
            }
            else if(command.equalsIgnoreCase("display"))
            {
                DisplayLocales displayLocales = new DisplayLocales();
                displayLocales.displayLocales();
            }
            else if(command.equalsIgnoreCase("info"))
            {
                Locale locale = setLocale.getCurrentLocale();
                info.displayInfo(locale);
            }
            else if(command.equalsIgnoreCase("exit"))
                break;
            else System.out.print(messages.getString("invalid"));
        }
    }
}
