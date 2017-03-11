package com.zhoujian.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {



    public static final String[] titles = new String[]{"精选","训练","饮食","商城"};
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private  TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout.addTab(mTabLayout.newTab().setText(titles[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles[2]));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles[3]));

        mTabLayout.setupWithViewPager(mViewPager);

        fragmentList.add(FirstFragment.newInstance());
        fragmentList.add(SecondFragment.newInstance());
        fragmentList.add(ThirdFragment.newInstance());
        fragmentList.add(FourthFragment.newInstance());

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList, Arrays.asList(titles));
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }
            @Override
            public void onPageSelected(int position)
            {
            }
            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

    }
}
