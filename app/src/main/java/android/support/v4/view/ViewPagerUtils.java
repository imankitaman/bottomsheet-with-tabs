package android.support.v4.view;

import android.view.View;

/**
 * Created Fake package with  {@link android.support.v4.view} to access layoutParams.position
 *
 * ViewPagerUtils Helps to Pass Current View available in ViewPager
 */
public class ViewPagerUtils {

    public static View getCurrentView(ViewPager viewPager) {
        final int currentItem = viewPager.getCurrentItem();
        for (int i = 0; i < viewPager.getChildCount(); i++) {
            final View child = viewPager.getChildAt(i);
            final ViewPager.LayoutParams layoutParams = (ViewPager.LayoutParams) child.getLayoutParams();
            if (!layoutParams.isDecor && currentItem == layoutParams.position) {
                return child;
            }
        }
        return null;
    }

}
