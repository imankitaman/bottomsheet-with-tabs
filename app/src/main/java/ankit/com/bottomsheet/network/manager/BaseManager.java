package ankit.com.bottomsheet.network.manager;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import ankit.com.bottomsheet.App;
import ankit.com.bottomsheet.model.BaseResponse;
import ankit.com.bottomsheet.model.Repository;
import ankit.com.bottomsheet.model.User;
import ankit.com.bottomsheet.network.ApiCallHandler;
import ankit.com.bottomsheet.network.service.ApiService;
import retrofit2.Response;
import rx.Observable;


public class BaseManager extends ApiCallHandler {

    @Inject
    ApiService service;

    public BaseManager(){
        App.getInstance().component().inject(this);
    }

    public Observable<BaseResponse<Repository>> searchRepos(@NonNull String query) {
        Observable<Response<BaseResponse<Repository>>> searchData = service.searchRepos(query);
        return handleApiObservable(searchData);
    }

    public Observable<BaseResponse<User>> searchOwners(@NonNull String query) {
        Observable<Response<BaseResponse<User>>> searchData = service.searchOwners(query);
        return handleApiObservable(searchData);
    }

}


