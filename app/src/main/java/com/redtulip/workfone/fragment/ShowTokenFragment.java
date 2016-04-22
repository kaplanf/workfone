package com.redtulip.workfone.fragment;

import android.app.Activity;
import android.widget.TextView;

import com.redtulip.workfone.R;
import com.redtulip.workfone.WorkfoneApplication;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by kaplanfatt on 06/01/16.
 */
@EFragment(R.layout.show_token_fragment)
public class ShowTokenFragment extends BaseFragment {

    @ViewById(R.id.showTokenFragmentIdValue)
    TextView showTokenFragmentIdValue;

    @ViewById(R.id.showTokenFragmentTtlValue)
    TextView showTokenFragmentTtlValue;

    @ViewById(R.id.showTokenFragmentCreatedValue)
    TextView showTokenFragmentCreatedValue;

    @ViewById(R.id.showTokenFragmentUserIdValue)
    TextView showTokenFragmentUserIdValue;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @AfterViews
    protected void afterViews() {
        String token = getPreferences().getString(WorkfoneApplication.getInstance().USER_TOKEN, "");
        int ttl = getPreferences().getInt(WorkfoneApplication.getInstance().TTL, 0);
        String date = getPreferences().getString(WorkfoneApplication.getInstance().CREATED, "");
        int userId = getPreferences().getInt(WorkfoneApplication.getInstance().USER_ID, 0);


        showTokenFragmentIdValue.setText(token);
        showTokenFragmentTtlValue.setText(Integer.toString(ttl));
        showTokenFragmentCreatedValue.setText(date);
        showTokenFragmentUserIdValue.setText(Integer.toString(userId));
    }
}
