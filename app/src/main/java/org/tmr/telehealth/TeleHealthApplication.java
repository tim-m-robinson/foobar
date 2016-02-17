package org.tmr.telehealth;

import android.app.Application;

/**
 * Created by tmr on 12/02/2016.
 */
public class TeleHealthApplication extends Application {

    private boolean _loggedIn = false;

    public boolean loggedIn () {
        return _loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        _loggedIn = loggedIn;
    }
}
