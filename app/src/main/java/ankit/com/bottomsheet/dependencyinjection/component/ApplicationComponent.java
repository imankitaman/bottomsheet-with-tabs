package ankit.com.bottomsheet.dependencyinjection.component;


import javax.inject.Singleton;

import ankit.com.bottomsheet.App;
import ankit.com.bottomsheet.dependencyinjection.module.AppModule;
import ankit.com.bottomsheet.dependencyinjection.module.NetworkModule;
import ankit.com.bottomsheet.dependencyinjection.module.PresenterModule;
import ankit.com.bottomsheet.network.manager.BaseManager;
import ankit.com.bottomsheet.view.MainActivity;
import ankit.com.bottomsheet.view.gitrepositoriessearch.GitRepositoriesPresenter;
import ankit.com.bottomsheet.view.gitrepositoriessearch.GitRepositoriesFragment;
import ankit.com.bottomsheet.view.gitownersearch.OwnersFragment;
import ankit.com.bottomsheet.view.gitownersearch.OwnersPresenter;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, PresenterModule.class})
public interface ApplicationComponent {

    void inject(App application);

    void inject(BaseManager baseManager);

    void inject(MainActivity mainActivity);

    void inject(GitRepositoriesPresenter gitRepositoriesPresenter);

    void inject(GitRepositoriesFragment gitRepositoriesFragment);

    void inject(OwnersFragment ownersFragment);

    void inject(OwnersPresenter ownersPresenter);



}
