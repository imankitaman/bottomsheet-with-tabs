package ankit.com.bottomsheet.view.gitownersearch;

import android.util.Log;

import javax.inject.Inject;

import ankit.com.bottomsheet.App;
import ankit.com.bottomsheet.model.BaseResponse;
import ankit.com.bottomsheet.model.User;
import ankit.com.bottomsheet.network.manager.BaseManager;
import ankit.com.bottomsheet.utility.NetworkUtil;
import ankit.com.bottomsheet.view.BaseView;
import rx.Subscriber;
import rx.Subscription;

public class OwnersPresenter implements OwnersViewModelContract.ViewModel {

    private static final String TAG = OwnersPresenter.class.getSimpleName();

    @Inject
    BaseManager baseManager;
    private Subscription subscription;
    private OwnersViewModelContract.View viewCallBack;


    public OwnersPresenter() {
        App.getInstance().component().inject(this);
    }


    @Override
    public void destroy() {
        Log.i(TAG," destroy");
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    @Override
    public void onViewCreated() {
        Log.i(TAG," onViewCreated");
        if (viewCallBack != null) {
            viewCallBack.showProgress();
            if (!NetworkUtil.isNetworkAvailable(viewCallBack.getActivityContext())) {
                viewCallBack.showError(new Throwable("No Internet Connection"));
                viewCallBack.hideProgress();
            }
        }
        subscription = baseManager.searchOwners("android").subscribe(new Subscriber<BaseResponse<User>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,e.getMessage());
                if (viewCallBack != null) {
                    viewCallBack.showError(e);
                    viewCallBack.hideProgress();
                }
            }

            @Override
            public void onNext(BaseResponse<User> repositorieBaseResponse) {
                Log.d(TAG, String.valueOf(repositorieBaseResponse.getItems().size()));
                if (viewCallBack != null) {
                    viewCallBack.showSearchResults(repositorieBaseResponse.getItems());
                    viewCallBack.hideProgress();
                }
            }
        });
    }

    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewAttached(BaseView.View view) {
        this.viewCallBack = (OwnersViewModelContract.View) view;
    }

    @Override
    public void onViewDetached() {
        Log.i(TAG," onViewDetached");
        this.viewCallBack = null;
    }

    @Override
    public void onDestroy() {

    }
}
