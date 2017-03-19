package siri.apisiri.ui.splash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

public class SplashPresenter implements SplashContract.Presenter {
    private static final String TAG = SplashPresenter.class.getClass().getSimpleName();
    private SplashActivity mView;
    private Context mContext;

    public SplashPresenter(@NonNull SplashActivity mView) {
        this.mContext = mView.getBaseContext();
        this.mView = checkNotNull(mView);
    }

    @Override
    public void executeUpdate(Context context) {
        new UpdateCheckTask().execute(this);
    }

    private void sendUpdateCheckResult(String releaseVer, String deviceVer) {
        mView.showCheckUpdate(releaseVer, deviceVer);
    }

    private class UpdateCheckTask extends AsyncTask<Object, Void, String> {
        SplashPresenter mPresenter;
        String mReleaseVer;
        String mDeviceVer;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Object... params) {
            mPresenter = (SplashPresenter) params[0];
            try {
                Document doc = Jsoup
                        .connect(
                                "https://play.google.com/store/apps/details?id="+ mContext.getPackageName())
                        .get();
                Elements Version = doc.select("div");

                for (Element v : Version) {
                    if (v.attr("itemprop").equals("softwareVersion")) {
                        mReleaseVer = v.text();
                    }
                }
                return mReleaseVer;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // Version check the execution application.
            PackageInfo pi = null;
            try {
                pi = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            mDeviceVer = pi.versionName;
            mReleaseVer = result;

            if(mReleaseVer != null) {
                if (!mReleaseVer.equals(mDeviceVer))
                    mPresenter.sendUpdateCheckResult(mReleaseVer, mDeviceVer);
            }

            super.onPostExecute(result);
        }
    }
}
