package ankit.com.bottomsheet.view.gitrepositoriessearch;

import android.util.Log;

import javax.inject.Inject;

import ankit.com.bottomsheet.App;
import ankit.com.bottomsheet.model.BaseResponse;
import ankit.com.bottomsheet.model.Repository;
import ankit.com.bottomsheet.network.manager.BaseManager;
import ankit.com.bottomsheet.utility.NetworkUtil;
import ankit.com.bottomsheet.view.BaseView;
import rx.Subscriber;
import rx.Subscription;


public class GitRepositoriesPresenter implements GitRepositoriesViewModelContract.ViewModel {

    private static final String TAG = GitRepositoriesPresenter.class.getSimpleName();

    @Inject
    BaseManager baseManager;

    private GitRepositoriesViewModelContract.View viewCallBack;
    private Subscription subscription;

    public GitRepositoriesPresenter() {
        App.getInstance().component().inject(this);
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

        subscription = baseManager.searchRepos("android").subscribe(new Subscriber<BaseResponse<Repository>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
                if (viewCallBack != null) {
                    viewCallBack.showError(e);
                    viewCallBack.hideProgress();
                }
            }

            @Override
            public void onNext(BaseResponse<Repository> repositorieBaseResponse) {
                Log.i(TAG, String.valueOf(repositorieBaseResponse.getItems().size()));
                if (viewCallBack != null) {
                    viewCallBack.hideProgress();
                    viewCallBack.showSearchResults(repositorieBaseResponse.getItems());
                }
            }
        });
    }


    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewAttached(BaseView.View view) {
        this.viewCallBack = (GitRepositoriesViewModelContract.View) view;
    }

    @Override
    public void onViewDetached() {
        this.viewCallBack = null;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void destroy() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
