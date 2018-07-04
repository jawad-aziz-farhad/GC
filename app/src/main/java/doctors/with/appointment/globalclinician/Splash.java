package doctors.with.appointment.globalclinician;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Splash extends Activity {

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        sessionManager = new SessionManager(Splash.this);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                chekingLogin();
            }
        }, 2000);
    }

    private void chekingLogin(){

        if(sessionManager.isLoggedIn())
            openBrowser();
        else{
            startActivity(new Intent(Splash.this, LoginActivity.class));
            finish();
        }
    }

    private void openBrowser(){
        String url = AppConfig.REDIRECT_URL+ sessionManager.getAuthTokenKey();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
        finish();
    }

}
