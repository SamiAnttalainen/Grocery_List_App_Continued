package com.example.grocerylistparttwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Button;

import com.example.grocerylistparttwo.fragments.FragmentMain;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //Fragment fragment = new FragmentMain();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*FragmentMain fragmentMain = new FragmentMain();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, fragmentMain);
        fragmentTransaction.commit();*/


        TabLayout tabLayout = findViewById(R.id.tabArea);
        ViewPager2 fragmentArea = findViewById(R.id.fragmentArea);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);
        fragmentArea.setAdapter(tabPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }
}


/*Button mainFragment = findViewById(R.id.buttonMain);
        Button listFragment = findViewById(R.id.buttonList);
        Button addFragment = findViewById(R.id.buttonAdd);
        Button infoFragment = findViewById(R.id.buttonInfo);
        mainFragment.setOnClickListener(listener);
        listFragment.setOnClickListener(listener);
        addFragment.setOnClickListener(listener);
        infoFragment.setOnClickListener(listener);*/

/*private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = null;

            switch (view.getId()) {
                case R.id.buttonMain:
                    fragment = new FragmentMain();
                    break;
                case R.id.buttonList:
                    fragment = new FragmentList();
                    Bundle data = new Bundle();
                    data.putString("dataID", "Tekstiä Mainista!");
                    fragment.setArguments(data);
                    break;
                case R.id.buttonAdd:
                    fragment = new FragmentAdd();
                    break;
                case R.id.buttonInfo:
                    fragment = new FragmentInfo();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayId, fragment).commit();
        }
    };*/