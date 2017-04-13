package cs2k18.com.zarf17;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by MSaqib on 27-11-2016.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String REG_TOKEN = "REG_TOKEN";
    @Override
    public void onTokenRefresh() {
       // Toast.makeText(getApplicationContext(),"REfreshewd",Toast.LENGTH_SHORT).show();
        String recentToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recentToken);
    }
}
