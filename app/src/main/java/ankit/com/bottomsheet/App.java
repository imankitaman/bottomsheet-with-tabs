package ankit.com.bottomsheet;

import android.app.Application;

import ankit.com.bottomsheet.dependencyinjection.component.ApplicationComponent;
import ankit.com.bottomsheet.dependencyinjection.component.DaggerApplicationComponent;
import ankit.com.bottomsheet.dependencyinjection.module.AppModule;

/**
 * Created by ankit on 22/04/17.
 */
public class App extends Application {
    private ApplicationComponent component;
    private static App application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        component = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component().inject(this);

    }
    public static App getInstance() {
        return application;
    }
    public ApplicationComponent component() {
        return component;
    }
}
