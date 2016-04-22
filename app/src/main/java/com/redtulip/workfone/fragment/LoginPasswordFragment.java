package com.redtulip.workfone.fragment;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.redtulip.workfone.MainActivity;
import com.redtulip.workfone.R;
import com.redtulip.workfone.WorkfoneApplication;
import com.redtulip.workfone.interfaces.OnMainFragmentListener;
import com.redtulip.workfone.restful.client.RestClient;
import com.redtulip.workfone.restful.client.RestErrorHandler;
import com.redtulip.workfone.restful.model.LoginModel;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

@EFragment(R.layout.login_password_fragment)
public class LoginPasswordFragment extends BaseFragment {

    @RestService
    RestClient restClient;

    @Bean
    RestErrorHandler restErrorHandler;

    @FragmentArg
    String username;

    @ViewById(R.id.loginPasswordEditText)
    EditText loginPasswordEditText;

    @ViewById(R.id.loginPasswordSignInButton)
    TextView loginPasswordSignInButton;

    private OnMainFragmentListener mainFragmentListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainFragmentListener = (OnMainFragmentListener) activity;
    }


    @AfterInject
    void afterInject() {
        restErrorHandler.setSendErrorListener(new RestErrorHandler.SendErrorListener() {
            @Override
            public void sendError(String errorMessage) {
                showErrorMessage(getResources().getString(R.string.unauthorized));
            }
        });
        restClient.setRestErrorHandler(restErrorHandler);

    }

    @Click(R.id.loginPasswordSignInButton)
    void signClick(View v) {
        if (loginPasswordEditText.getText().toString().length() > 3) {
            signInRequest();
        } else {
            showPasswordError();
        }
    }

    @Background
    void signInRequest() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(loginPasswordEditText.getWindowToken(), 0);

        LoginModel.LoginRequest request = new LoginModel.LoginRequest();
        request.email = username;
        request.password = loginPasswordEditText.getText().toString();

        LoginModel loginModel = restClient.loginOfficer(request);
        if (loginModel != null) {
            loginSuccess();
            getPreferences().edit().putBoolean(WorkfoneApplication.getInstance().IS_LOGIN, true).commit();

            getPreferences().edit().putString(WorkfoneApplication.getInstance().USER_TOKEN, loginModel.id).commit();
            getPreferences().edit().putInt(WorkfoneApplication.getInstance().TTL, loginModel.ttl).commit();
            getPreferences().edit().putString(WorkfoneApplication.getInstance().CREATED, loginModel.created).commit();
            getPreferences().edit().putInt(WorkfoneApplication.getInstance().USER_ID, loginModel.userId).commit();

        }
    }

    @UiThread
    void showPasswordError() {
        Toast.makeText(getActivity(), "You must enter a valid username", Toast.LENGTH_LONG).show();
    }

    @UiThread
    void loginSuccess() {
        Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_LONG).show();
        ((MainActivity) getActivity()).toOnboardingFragment();
    }

    @UiThread
    void showErrorMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();

    }

}
