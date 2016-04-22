package com.redtulip.workfone.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.redtulip.workfone.fragment.OnBoardingPagerFragment;

public class OnBoardingPagerAdapter extends FragmentStatePagerAdapter {

    public OnBoardingPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        return new OnBoardingPagerFragment().newInstance(position);
//        OnBoardingPagerFragment onBoardingPagerFragment = OnBoardingPagerFragment_.builder().index(position).build();
//        return onBoardingPagerFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
