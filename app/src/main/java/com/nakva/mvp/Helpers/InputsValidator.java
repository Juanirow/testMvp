package com.nakva.mvp.Helpers;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class InputsValidator {

    public static boolean isEmailFormatValid(String email){
        if(email.contains("@")){
            return true;
        }

        return false;
    }

    public static boolean isTextNotEmpty(String text){
        if(text.isEmpty())
            return false;
        return true;
    }
}
