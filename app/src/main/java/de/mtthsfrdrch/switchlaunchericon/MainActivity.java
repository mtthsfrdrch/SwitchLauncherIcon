package de.mtthsfrdrch.switchlaunchericon;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton green = (ImageButton) findViewById(R.id.btn_green);
        green.setOnClickListener(this);

        ImageButton blue = (ImageButton) findViewById(R.id.btn_blue);
        blue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        changeLauncherIcon(v.getId());
    }

    private void changeLauncherIcon(int id) {
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(
                new ComponentName(this, "de.mtthsfrdrch.switchlaunchericon.MainActivity-greenLauncher"),
                id == R.id.btn_green ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED :
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(
                new ComponentName(this, "de.mtthsfrdrch.switchlaunchericon.MainActivity-blueLauncher"),
                id == R.id.btn_blue ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED :
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        // Find launcher and kill it
//        Intent i = new Intent(Intent.ACTION_MAIN);
//        i.addCategory(Intent.CATEGORY_HOME);
//        i.addCategory(Intent.CATEGORY_DEFAULT);
//        List<ResolveInfo> resolves = packageManager.queryIntentActivities(i, 0);
//        for (ResolveInfo res : resolves) {
//            if (res.activityInfo != null) {
//                ActivityManager activityManager = (ActivityManager) getSystemService(Activity
//                        .ACTIVITY_SERVICE);
//                activityManager.killBackgroundProcesses(res.activityInfo.packageName);
//            }
//        }

    }
}
