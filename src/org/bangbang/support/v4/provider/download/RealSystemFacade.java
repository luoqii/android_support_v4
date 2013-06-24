/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bangbang.support.v4.provider.download;


import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
/**
 * copied from
 * https://raw.github.com/android/platform_packages_providers_downloadprovider/android-4.2_r1/src/com/android/providers/downloads/RealSystemFacade.java
 * @author bangbang.song@gmail.com
 *
 */
class RealSystemFacade implements SystemFacade {
    private Context mContext;

    public RealSystemFacade(Context context) {
        mContext = context;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public NetworkInfo getActiveNetworkInfo(int uid) {
        ConnectivityManager connectivity =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            Log.w(Constants.TAG, "couldn't get connectivity manager");
            return null;
        }

        // bangbagn.S
        /*final NetworkInfo activeInfo = connectivity.getActiveNetworkInfoForUid(uid);
        if (activeInfo == null && Constants.LOGVV) {
            Log.v(Constants.TAG, "network is not available");
        }
        return activeInfo;*/
        
        return null;
    }

    @SuppressLint("NewApi")
	@Override
    public boolean isActiveNetworkMetered() {
        //final 
        ConnectivityManager conn = null;
//        		conn = ConnectivityManager.from(mContext);
        conn = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return conn.isActiveNetworkMetered();
    }

    public boolean isNetworkRoaming() {
        ConnectivityManager connectivity =
            (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            Log.w(Constants.TAG, "couldn't get connectivity manager");
            return false;
        }

        NetworkInfo info = connectivity.getActiveNetworkInfo();
        boolean isMobile = (info != null && info.getType() == ConnectivityManager.TYPE_MOBILE);
        boolean isRoaming = isMobile 
        		// bangbang.S
//        		&& TelephonyManager.getDefault().isNetworkRoaming()
        		;
        if (Constants.LOGVV && isRoaming) {
            Log.v(Constants.TAG, "network is roaming");
        }
        return isRoaming;
    }

    @SuppressLint("NewApi")
	public Long getMaxBytesOverMobile() {
        return DownloadManager.getMaxBytesOverMobile(mContext);
    }

    @SuppressLint("NewApi")
	@Override
    public Long getRecommendedMaxBytesOverMobile() {
        return DownloadManager.getRecommendedMaxBytesOverMobile(mContext);
    }

    @Override
    public void sendBroadcast(Intent intent) {
        mContext.sendBroadcast(intent);
    }

    @Override
    public boolean userOwnsPackage(int uid, String packageName) throws NameNotFoundException {
        return mContext.getPackageManager().getApplicationInfo(packageName, 0).uid == uid;
    }

    @Override
    public void startThread(Thread thread) {
        thread.start();
    }
}