package com.redtulip.workfone.fragment;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.redtulip.workfone.MainActivity;
import com.redtulip.workfone.R;
import com.redtulip.workfone.adapter.OnBoardingPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by kaplanfatt on 30/12/15.
 */
@EFragment(R.layout.onboarding_fragment)
public class OnBoardingFragment extends BaseFragment {

    @ViewById(R.id.onboardingFragmentViewPager)
    ViewPager viewPager;

    @ViewById(R.id.onboardingFragmentText)
    TextView onboardingFragmentText;

    @ViewById(R.id.onboardingFragmentMessageText)
    TextView onboardingFragmentMessageText;

    @ViewById(R.id.onboardingFragmentPagerIndicator)
    CirclePageIndicator onboardingFragmentPagerIndicator;

    OnBoardingPagerAdapter adapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @AfterViews
    protected void afterViews() {
        adapter = new OnBoardingPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        onboardingFragmentPagerIndicator.setViewPager(viewPager);

        onboardingFragmentText.setText(R.string.skip);
        onboardingFragmentMessageText.setText(R.string.first_onboarding_message);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        onboardingFragmentText.setText(R.string.skip);
                        onboardingFragmentMessageText.setText(R.string.first_onboarding_message);
                        break;
                    case 1:
                        onboardingFragmentText.setText(R.string.skip);
                        onboardingFragmentMessageText.setText(R.string.second_onboarding_message);
                        break;
                    case 2:
                        onboardingFragmentText.setText(R.string.done);
                        onboardingFragmentMessageText.setText(R.string.third_onboarding_message);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Click(R.id.onboardingFragmentText)
    void topRightTextClicked(View v) {
        ((MainActivity) getActivity()).toShowTokenFragment();
    }
}
