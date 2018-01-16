package ankit.com.bottomsheet.view;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ankit.com.bottomsheet.App;
import ankit.com.bottomsheet.R;
import ankit.com.bottomsheet.uiutils.BottomSheetUtil;
import ankit.com.bottomsheet.uiutils.MyBottomSheetBehavior;
import ankit.com.bottomsheet.view.adapter.PagerAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.pager)
    ViewPager viewPager;
    private MyBottomSheetBehavior anchorBehavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.getInstance().component().inject(this);

        anchorBehavior = MyBottomSheetBehavior.from(findViewById(R.id.bottomSheetAnchor));

        tabLayout.addTab(tabLayout.newTab().setText("Repository"));
        tabLayout.addTab(tabLayout.newTab().setText("Owner"));

        PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        BottomSheetUtil.setupViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (anchorBehavior.getState() == MyBottomSheetBehavior.STATE_COLLAPSED) {
                    anchorBehavior.setState(MyBottomSheetBehavior.STATE_ANCHOR);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (anchorBehavior.getState() == MyBottomSheetBehavior.STATE_COLLAPSED) {
                    anchorBehavior.setState(MyBottomSheetBehavior.STATE_ANCHOR);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (anchorBehavior.getState() == MyBottomSheetBehavior.STATE_EXPANDED
                || anchorBehavior.getState() == MyBottomSheetBehavior.STATE_ANCHOR) {
            anchorBehavior.setState(MyBottomSheetBehavior.STATE_COLLAPSED);
        } else {
            finish();
        }
    }
}
