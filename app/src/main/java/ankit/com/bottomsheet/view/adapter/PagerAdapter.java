package ankit.com.bottomsheet.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ankit.com.bottomsheet.view.gitrepositoriessearch.GitRepositoriesFragment;
import ankit.com.bottomsheet.view.gitownersearch.OwnersFragment;


/**
 * Created by ankit on 22/04/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new GitRepositoriesFragment();
            case 1:
                return new OwnersFragment();

            default:
            return null;
        }
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
