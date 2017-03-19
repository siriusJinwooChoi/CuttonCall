package siri.apisiri.ui.splash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import siri.apisiri.R;
import siri.apisiri.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getClass().getSimpleName();
    private ActionBar actionBar = null;
    private SplashPresenter mPresenter;
    private final Handler handler =  new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        actionBar = getSupportActionBar();
        actionBar.hide();

        mPresenter = new SplashPresenter(this);

        if ("release".equals(getResources().getString(R.string.dev_condi)))
            checkUpdate();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkState();
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 2000);

    }

    private void checkState() {
        SharedPreferences pref = getSharedPreferences("CottonCall", Activity.MODE_PRIVATE);
        boolean isInitial = pref.getBoolean("isInitial", true);
        boolean isAutoLogin = pref.getBoolean("isAutoLogin", false);

        if(isInitial) {
            Log.d(TAG, "checkInitialLaunch: IsInitial true");
        } else {
            if(isAutoLogin) {
                Log.d(TAG, "checkInitialLaunch: IsAutoLogin true");
            } else {
                Log.d(TAG, "checkInitialLaunch: IsAutoLogin false");
            }
        }

    }

    private void checkUpdate() {
        mPresenter.executeUpdate(getBaseContext());
    }

    public void showCheckUpdate(String releaseVer, String deviceVer) {
        AlertDialog.Builder mAltBuilder = new AlertDialog.Builder(this);

        mAltBuilder.setMessage(getString(R.string.update_check_dialog_content) +
                getString(R.string.update_check_dialog_recent_version) + releaseVer + "\n" +
                getString(R.string.update_check_dialog_current_version) + deviceVer)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.update_check_dialog_positive_button),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                Intent marketLaunch = new Intent(
                                        Intent.ACTION_VIEW);
                                marketLaunch.setData(Uri
                                        .parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
                                startActivity(marketLaunch);
                                finish();
                            }
                        }
                );
        AlertDialog alert = mAltBuilder.create();
        alert.setTitle(getString(R.string.update_check_dialog_title));
        alert.show();
    }
}