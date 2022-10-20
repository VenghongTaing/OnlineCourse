package com.example.onlinecourse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class CourseManage extends AppCompatActivity {

    private Toolbar mToolbarBottom;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private CourseFragment courseFragment;
    private MyLearningFragment myLearningFragment;
    private CartFragment cartFragment;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coursemange);

        mToolbarBottom = (Toolbar) findViewById(R.id.tabToolBar);
        setSupportActionBar(mToolbarBottom);

        mToolbar = (Toolbar) findViewById(R.id.tabToolBar);
        setSupportActionBar(mToolbar);

        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tabLayout);

        courseFragment = new CourseFragment();
        myLearningFragment = new MyLearningFragment();
        cartFragment = new CartFragment();

        mTabLayout.setupWithViewPager(mViewPager);

//Set up TabLayout Titles with array index
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(courseFragment, "Courses");
        viewPagerAdapter.addFragment(myLearningFragment, "My Learning");
        viewPagerAdapter.addFragment(cartFragment, "Cart");
        mViewPager.setAdapter(viewPagerAdapter);

//Set up TabLayout Icon with array index
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_library_books_24);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_collections_bookmark_24);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_shopping_cart_24);

//        BadgeDrawable badgeDrawable = mTabLayout.getTabAt(0).getOrCreateBadge();
//        badgeDrawable.setVisible(true);
//        badgeDrawable.setNumber(99);

        //set event for navigationicon back
        mToolbarBottom.setNavigationOnClickListener(v -> {
            //Back button on click event
            onBackPressed();
        });
    }

    //Using ViewPagerAdapter to stores the fragments(Page content) and titles
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitles = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitles.add(title);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }

    //Set the menu to the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
}