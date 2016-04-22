package com.redtulip.workfone;

import android.os.Bundle;

import com.redtulip.workfone.activity.BaseActivity;
import com.redtulip.workfone.fragment.LoginPasswordFragment;
import com.redtulip.workfone.fragment.LoginPasswordFragment_;
import com.redtulip.workfone.fragment.LoginUserNameFragment;
import com.redtulip.workfone.fragment.LoginUserNameFragment_;
import com.redtulip.workfone.fragment.OnBoardingFragment;
import com.redtulip.workfone.fragment.OnBoardingFragment_;
import com.redtulip.workfone.fragment.ShowTokenFragment;
import com.redtulip.workfone.fragment.ShowTokenFragment_;
import com.redtulip.workfone.interfaces.OnMainFragmentListener;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements OnMainFragmentListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (checkIfLogin()) {
            toOnboardingFragment();
        } else {
            toLoginUserNameFragment();
        }
    }

    public void toLoginUserNameFragment() {
        getSupportActionBar().hide();
        LoginUserNameFragment loginUserNameFragment = new LoginUserNameFragment_();
        replaceFragment(R.id.main_frame, loginUserNameFragment, true);
    }

    public void toLoginPasswordFragment(String username) {
        getSupportActionBar().hide();
        LoginPasswordFragment loginPasswordFragment = LoginPasswordFragment_.builder().username(username).build();
        replaceFragmentWithAnimation(R.id.main_frame, loginPasswordFragment, true);
    }

    public void toOnboardingFragment() {
        getSupportActionBar().hide();
        OnBoardingFragment onBoardingFragment = new OnBoardingFragment_();
        replaceFragmentWithAnimation(R.id.main_frame, onBoardingFragment, false);
    }

    public void toShowTokenFragment() {
        ShowTokenFragment showTokenFragment = new ShowTokenFragment_();
        replaceFragment(R.id.main_frame, showTokenFragment, false);
    }

    @Override
    public void onCloseFragment(String tag) {

    }

    @Override
    public void onStartFragment(String tag) {

    }

    @Override
    public void sendDataFromFragment(Bundle bundle) {

    }

    @Override
    public void loginSuccess(boolean isSuccess) {

    }

    @Override
    public void backClicked(String fragmentName) {

    }

    private boolean checkIfLogin() {
        return getPreferences().getBoolean(WorkfoneApplication.getInstance().IS_LOGIN, false);
    }
}
