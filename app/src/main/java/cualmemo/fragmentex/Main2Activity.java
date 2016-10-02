package cualmemo.fragmentex;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity {
    private ViewPager mViewPager;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //SupermanFragment fragment= new SupermanFragment();
        //ft.add(android.R.id.content, fragment).commit();

        PageAdapater  adapater= new PageAdapater(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(adapater);

        actionBar =getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener= new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        //frgmentos a utilizar
        ActionBar.Tab tab = actionBar.newTab().setText("Superman").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Batman").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Flash").setTabListener(tabListener);
        actionBar.addTab (tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);

            }
        });
    }

    public class PageAdapater extends FragmentPagerAdapter{

        public PageAdapater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new SupermanFragment();
                case 1: return new BatmanFragment();
                case 2: return new FlashFragment();
                default:return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();

        switch (id) {
            case R.id.mSuperman:
                SupermanFragment fragment2 = new SupermanFragment();
                ft.replace(android.R.id.content, fragment2).commit();
                break;
            case R.id.mBatman:
                BatmanFragment fragment = new BatmanFragment();
                ft.replace(android.R.id.content, fragment).commit();
                break;
            case R.id.mFlash:
                FlashFragment fragment3 = new FlashFragment();
                ft.replace(android.R.id.content, fragment3).commit();
                break;

        }

        return super.onOptionsItemSelected(item);
    }*/
}
