package com.jw.studio.quicktile;


import android.content.ComponentName;
import android.content.Intent;
import android.service.quicksettings.TileService;
import android.util.Log;
import android.widget.Toast;

public class QslideTileService extends TileService {
    @Override
    public void onClick() {
        super.onClick();
        Log.d("aoa","aaa");
        ComponentName componentName = new ComponentName("com.lge.filemanager","com.lge.filemanager.view.FloatingActivity");
        //ComponentName componentName = new ComponentName("com.jw.qslideview","com.jw.qslideview.MainActivity");
        try {
            startActivityAndCollapse(getActivityIntent(componentName));
        }catch (Exception e){
            getApplicationContext().sendBroadcast(new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
            Toast.makeText(this, "LG 파일관리자가 설치 되어있지 않습니다.", Toast.LENGTH_SHORT).show();
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
//    @Override
//    public void onStartListening() {
//        super.onStartListening();
////        Tile tile = getQsTile();
////        tile.setLabel(getString(R.string.filemgr));
////        tile.setState(Tile.STATE_ACTIVE);
////        tile.setIcon(Icon.createWithResource(this,R.drawable.ic_folder_open_black_24dp));
////        tile.updateTile();
//    }
    public static Intent getActivityIntent(ComponentName activity) {
        Intent intent = new Intent();
        intent.setComponent(activity);
        intent.putExtra("com.lge.app.floating.launchAsFloating", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
}
