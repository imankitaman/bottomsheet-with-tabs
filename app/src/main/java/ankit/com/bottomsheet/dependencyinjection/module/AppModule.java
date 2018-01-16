package ankit.com.bottomsheet.dependencyinjection.module;

import android.content.Context;

import javax.inject.Singleton;

import ankit.com.bottomsheet.App;
import ankit.com.bottomsheet.network.ApiCallHandler;
import ankit.com.bottomsheet.network.manager.BaseManager;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule extends ApiCallHandler {

    private App app;

    public AppModule(App ap) {
        this.app = ap;
    }

    @Provides
    @Singleton
    BaseManager provideBaseManager() {
        return new BaseManager();
    }



}
