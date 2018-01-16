package ankit.com.bottomsheet.network;
import java.net.HttpRetryException;

import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class ApiCallHandler {

    public static final String TAG = ApiCallHandler.class.getName();

    protected <T> Observable<T> handleApiObservable(final Observable<Response<T>> t) {
        return t.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends Response<T>>>() {
                    @Override
                    public Observable<? extends Response<T>> call(Throwable throwable) {
                        return handleHttpError(throwable);
                    }
                })
                .filter(new Func1<Response<T>, Boolean>() {
                    @Override
                    public Boolean call(Response<T> responseServerResponse) {
                        return (responseServerResponse.isSuccessful() && responseServerResponse.body() != null);
                    }
                })
                .map(new Func1<Response<T>, T>() {
                    @Override
                    public T call(Response<T> serverResponseResponse) {
                        return serverResponseResponse.body();
                    }
                });
    }


    private <T>Observable<T> handleHttpError(Throwable throwable) throws RuntimeException {
        if (throwable instanceof HttpException) {
            int status = ((HttpRetryException) throwable).responseCode();
            if (status >= 400 && status < 500)
                throw new RuntimeException("Url Not Found. Status : " + status);
            else
                throw new RuntimeException("Server runtime exception");
        } else {
            throw new RuntimeException("Something went wrong. Please try again" /*+ throwable.toString()*/);
        }
    }


}
