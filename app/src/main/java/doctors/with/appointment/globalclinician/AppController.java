package doctors.with.appointment.globalclinician;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jawad on 7/3/2018.
 */

public class AppController extends Application {

    private static final String TAG = AppController.class.getSimpleName();

    private RequestQueue requestQueue;
    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static synchronized AppController getInstance(){
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(getApplicationContext());

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request <T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request <T> req){
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag){
        if(tag != null)
            requestQueue.cancelAll(tag);
    }

}
