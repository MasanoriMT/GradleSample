package iti.co.jp.gradlesample;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    TextView buildType;
    @ViewById
    TextView flavor;
    @ViewById
    TextView version;

    @AfterViews
    protected void init() {
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> appInfoList = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        for(ApplicationInfo appInfo : appInfoList) {
            Log.d("MainActivity", appInfo.sourceDir);
        }

        String versionStr = "";
        try{
            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(), 0);
            versionStr = String.format("%s(%d)", packageInfo.versionName, packageInfo.versionCode);
        }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }

        version.setText(versionStr);
        buildType.setText(BuildType.TYPE_NAME);
        flavor.setText(Flavor.FLAVOR_NAME);
    }
}
