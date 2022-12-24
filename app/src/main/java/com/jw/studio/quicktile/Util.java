package com.jw.studio.quicktile;

import android.content.ComponentName;
import android.content.Intent;

public class Util {
    public static Intent getActivityIntent(ComponentName activity) {
        Intent intent = new Intent();
        intent.setComponent(activity);
        intent.putExtra("com.lge.app.floating.launchAsFloating", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
}
