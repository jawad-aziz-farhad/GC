package doctors.with.appointment.globalclinician;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jawad on 7/3/2018.
 */

public class SessionManager {

    public static String TAG = SessionManager.class.getSimpleName();

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "GC_APP_LOGIN";
    private static final String IS_LOGGED_IN_KEY = "isLoggedIn";
    private static final String AUTH_TOKEN_KEY = "authToken";

    public SessionManager(Context context){
        this.context = context;
        sharedPreferences = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    /* SETTING LOGIN STATUS AND AUTH TOKEN TO SHARED PREFERENCES */
    public void setLogin(String token){
        editor.putString(AUTH_TOKEN_KEY,token);
        editor.putBoolean(IS_LOGGED_IN_KEY, true);
        editor.commit();
    }

    /* GETTING LOGIN STATUS*/
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN_KEY, false);
    }
    /* GETTING AUTH TOKEN */
    public String getAuthTokenKey(){
        return sharedPreferences.getString(AUTH_TOKEN_KEY, null);
    }

}
