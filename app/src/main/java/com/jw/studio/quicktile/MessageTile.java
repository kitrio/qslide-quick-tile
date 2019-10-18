package com.jw.studio.quicktile;

import android.content.ComponentName;
import android.content.Intent;
import android.service.quicksettings.TileService;
import android.widget.Toast;

public class MessageTile extends TileService {
    @Override
    public void onClick() {
        super.onClick();
        ComponentName componentName = new ComponentName("com.android.mms","com.android.mms.ui.FloatingComposer");
        try {
            startActivityAndCollapse(getActivityIntent(componentName));
        }catch (Exception e){
            getApplicationContext().sendBroadcast(new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
            Toast.makeText(this, getString(R.string.is_support), Toast.LENGTH_SHORT).show();
        }
        onStopListening();
    }

    @Override
    public void onTileRemoved(){
        super.onTileRemoved();
    }

    @Override
    public void onTileAdded(){
        super.onTileAdded();
    }

    public static Intent getActivityIntent(ComponentName activity) {
        Intent intent = new Intent();
        intent.setComponent(activity);
        intent.putExtra("com.lge.app.floating.launchAsFloating", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
}
