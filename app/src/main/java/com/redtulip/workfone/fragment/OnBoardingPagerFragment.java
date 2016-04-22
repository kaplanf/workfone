package com.redtulip.workfone.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.redtulip.workfone.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.onboarding_pager_fragment)
public class OnBoardingPagerFragment extends BaseFragment {

    private static final String INDEX = "index";

    @ViewById(R.id.onboardingPagerFragmentImage)
    ImageView onboardingPagerFragmentImage;

    @FragmentArg(INDEX)
    protected int index;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public static OnBoardingPagerFragment_ newInstance(int index) {
        OnBoardingPagerFragment_ loginPagerFragment = new OnBoardingPagerFragment_();
        Bundle args = new Bundle();
        args.putInt(INDEX, index);
        loginPagerFragment.setArguments(args);
        return loginPagerFragment;
    }

    @AfterViews
    protected void afterViews() {
        switch (index) {
            case 0:
                onboardingPagerFragmentImage.setImageResource(R.drawable.onboard1_main);
                break;
            case 1:
                onboardingPagerFragmentImage.setImageResource(R.drawable.onboard2_main);
                break;
            case 2:
                onboardingPagerFragmentImage.setImageResource(R.drawable.onboard3_main);
                break;
        }
    }

}
