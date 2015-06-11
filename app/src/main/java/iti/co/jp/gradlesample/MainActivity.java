package iti.co.jp.gradlesample;

import android.content.pm.ApplicationInfo;
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

    @AfterViews
    protected void init() {
        PackageManager pm = getPackageManager();
        List<ApplicationInfo> appInfoList = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        for(ApplicationInfo appInfo : appInfoList) {
            Log.d("MainActivity", appInfo.sourceDir);
        }

        buildType.setText(BuildType.TYPE_NAME);
        flavor.setText(Flavor.FLAVOR_NAME);
    }
}
