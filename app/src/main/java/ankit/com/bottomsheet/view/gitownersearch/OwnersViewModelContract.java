package ankit.com.bottomsheet.view.gitownersearch;

import java.util.List;

import ankit.com.bottomsheet.model.User;
import ankit.com.bottomsheet.view.BaseView;


public interface OwnersViewModelContract {

    interface View extends BaseView.View{
        void showSearchResults(List<User> userList);
    }

    interface ViewModel extends BaseView.ViewModel{
        void destroy();
    }
}
