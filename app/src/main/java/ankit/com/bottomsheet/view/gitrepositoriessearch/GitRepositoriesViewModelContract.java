package ankit.com.bottomsheet.view.gitrepositoriessearch;

import java.util.List;

import ankit.com.bottomsheet.model.Repository;
import ankit.com.bottomsheet.view.BaseView;


public interface GitRepositoriesViewModelContract {

    interface View extends BaseView.View{
        void showSearchResults(List<Repository> repositories);
    }

    interface ViewModel extends BaseView.ViewModel{
        void destroy();
    }

}
