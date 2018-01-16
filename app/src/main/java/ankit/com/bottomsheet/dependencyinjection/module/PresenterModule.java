package ankit.com.bottomsheet.dependencyinjection.module;

import ankit.com.bottomsheet.view.gitownersearch.OwnersPresenter;
import ankit.com.bottomsheet.view.gitrepositoriessearch.GitRepositoriesPresenter;
import dagger.Module;
import dagger.Provides;


@Module
public class PresenterModule {

    @Provides
    public GitRepositoriesPresenter provideGitRepositoriesPresenter() {
        return new GitRepositoriesPresenter();
    }

    @Provides
    public OwnersPresenter provideOwnersPresenter() {
        return new OwnersPresenter();
    }
}
