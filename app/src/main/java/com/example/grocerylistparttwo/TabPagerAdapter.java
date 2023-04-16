package com.example.grocerylistparttwo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.grocerylistparttwo.fragments.FragmentAdd;
import com.example.grocerylistparttwo.fragments.FragmentInfo;
import com.example.grocerylistparttwo.fragments.FragmentMain;

public class TabPagerAdapter extends FragmentStateAdapter {


    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new FragmentMain();
            case 1:
                return new FragmentAdd();
            case 2:
                return new FragmentInfo();
            default:
                return new FragmentMain();
        }
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
