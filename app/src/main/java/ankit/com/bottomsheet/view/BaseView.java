package ankit.com.bottomsheet.view;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by ankit on 23/04/17.
 */

public interface BaseView {

    interface View {
        Context getActivityContext();

        void showProgress();

        void hideProgress();

        void showError(Throwable e);
    }

    interface ViewModel{
        void onViewCreated();
        void onViewResumed();
        void onViewAttached(View view);
        void onViewDetached();
        void onDestroy();
    }
}
