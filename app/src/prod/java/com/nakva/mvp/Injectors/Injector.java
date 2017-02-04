package com.nakva.mvp.Injectors;

import com.nakva.mvp.Login.ILoginModel;
import com.nakva.mvp.Login.LoginModel;

/**
 * Created by Juancho on 04/02/17.
 * Nakva
 * linanjm90@gmail.com
 */

public class Injector {

    public static ILoginModel provideInjector(){
        return new LoginModel();
    }
}
