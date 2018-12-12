package com.dev.abhishek360.srrms;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookTicketFragment.OnFragmentInteractionListener,
                                                                            PNRstatusFragment.OnFragmentInteractionListener,TrainsFragment.OnFragmentInteractionListener
{


    private FragmentManager mFragmentManager;
    private BookTicketFragment mPropFragment;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager= getSupportFragmentManager();

        final ViewPager viewPager = findViewById(R.id.main_view_pager);
        setupViewPager(viewPager);

        final BottomNavigationView bNavView = findViewById(R.id.bottom_navigation_view);
        bNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)

            {
                switch(item.getItemId())
                {
                    case R.id.menu_properties:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_inbox:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_bookings:
                        viewPager.setCurrentItem(2);

                        return true;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position)
            {
                if (prevMenuItem != null) prevMenuItem.setChecked(false);
                else bNavView.getMenu().getItem(0).setChecked(false);

                bNavView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bNavView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });




    }

    private void setupViewPager(ViewPager v)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(mFragmentManager);
        mPropFragment = new BookTicketFragment();
        adapter.addFragment(mPropFragment);
        adapter.addFragment(new PNRstatusFragment());
        adapter.addFragment(new TrainsFragment());
        v.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

class ViewPagerAdapter extends FragmentStatePagerAdapter
{
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private FragmentManager fragmentManager;

    ViewPagerAdapter(FragmentManager m)
    {
        super(m);
        fragmentManager=m;

    }

    @Override
    public Fragment getItem(int position)
    {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return mFragmentList.size();
    }

    public void addFragment(Fragment f)
    {
        mFragmentList.add(f);

    }

    public void clearFragment(int i)
    {
        fragmentManager.beginTransaction().replace(R.id.main_view_pager,mFragmentList.get(i)).commit();
        notifyDataSetChanged();

    }
}
