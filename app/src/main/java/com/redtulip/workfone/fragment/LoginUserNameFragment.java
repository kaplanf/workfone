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
import com.redtulip.workfone.interfaces.OnMainFragmentListener;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.login_username_fragment)
public class LoginUserNameFragment extends BaseFragment {

    @ViewById(R.id.loginUsernameEditText)
    EditText loginUsernameEditText;

    @ViewById(R.id.loginUsernameNextButton)
    TextView loginUsernameNextButton;

    private OnMainFragmentListener mainFragmentListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainFragmentListener = (OnMainFragmentListener) activity;
    }

    @Click(R.id.loginUsernameNextButton)
    void nextClick(View v) {
        if (loginUsernameEditText.getText().toString().length() > 3 && isEmailValid(loginUsernameEditText.getText().toString())) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(loginUsernameEditText.getWindowToken(), 0);
            ((MainActivity) getActivity()).toLoginPasswordFragment(loginUsernameEditText.getText().toString());
        } else {
            showUsernameError();
        }
    }

    @UiThread
    void showUsernameError() {
        Toast.makeText(getActivity(), "You must enter a valid username", Toast.LENGTH_LONG).show();
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
