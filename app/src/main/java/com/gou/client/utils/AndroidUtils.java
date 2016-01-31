package com.gou.client.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jordi on 26/01/16.
 */
public class AndroidUtils {
    private static final String TAG_LOG = AndroidUtils.class.getName();

    public static void printHashKeys(Context context) {
        // Add code to print out the key hash
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    "com.gou.client",
                    PackageManager.GET_SIGNATURES);
            Log.d(TAG_LOG, "Length signatures: " + info.signatures.length);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d(TAG_LOG, Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            Log.d(TAG_LOG, e.getMessage());
        }
    }
}
