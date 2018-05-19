package com.example.mohamedramadan.storemanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by Mohamed Ramadan on 19-May-18.
 */

public class InternetConnection {

    public static boolean isConnectingToInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networks = connectivityManager.getActiveNetworkInfo();
        if(networks != null)
        {
            return connectivityManager != null && networks.isConnected();
        }
        return false;
    }
}
