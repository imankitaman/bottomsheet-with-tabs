package ankit.com.bottomsheet.network.service;

import ankit.com.bottomsheet.model.BaseResponse;
import ankit.com.bottomsheet.model.Repository;
import ankit.com.bottomsheet.model.User;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface ApiService {

    @GET("search/repositories")
    Observable<Response<BaseResponse<Repository>>> searchRepos(@Query("q") String q);

    @GET("search/users")
    Observable<Response<BaseResponse<User>>> searchOwners(@Query("q") String q);


}
