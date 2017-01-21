package com.quickblox.sample.chat.ui.activity;

import android.os.Bundle;

import com.quickblox.sample.chat.App;
import com.quickblox.sample.chat.R;
import com.quickblox.sample.chat.utils.SharedPreferencesUtil;
import com.quickblox.sample.core.ui.activity.CoreSplashActivity;

public class SplashActivity extends CoreSplashActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (checkConfigsWithSnackebarError()){
            proceedToTheNextActivityWithDelay();
        }
    }

    @Override
    protected String getAppName() {
        return getString(R.string.splash_app_title);
    }

    @Override
    protected void proceedToTheNextActivity() {
        if (SharedPreferencesUtil.hasQbUser()) {
            DialogsActivity.start(this);
        } else {
            LoginActivity.start(this);
        }
        finish();
    }

    @Override
    protected boolean sampleConfigIsCorrect() {
        boolean result = super.sampleConfigIsCorrect();
        result = result && App.getSampleConfigs() != null;
        return result;
    }
}