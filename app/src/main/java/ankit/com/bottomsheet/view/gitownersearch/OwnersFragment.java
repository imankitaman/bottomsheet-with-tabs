package ankit.com.bottomsheet.view.gitownersearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import ankit.com.bottomsheet.App;
import ankit.com.bottomsheet.R;
import ankit.com.bottomsheet.model.User;
import ankit.com.bottomsheet.uiutils.SnackBarUtil;
import ankit.com.bottomsheet.uiutils.SpaceItemDecoration;
import ankit.com.bottomsheet.view.BaseFragment;
import ankit.com.bottomsheet.view.BaseView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ankit on 23/04/17.
 */

public class OwnersFragment extends BaseFragment implements OwnersViewModelContract.View {

    private static final String TAG = OwnersFragment.class.getName();
    @Bind(R.id.recyclerVwOwner)
    RecyclerView recyclerVwRepo;
    @Bind(R.id.coordinatorlayoutParent)
    CoordinatorLayout coordinatorlayoutParent;
    @Bind(R.id.pbOwners)
    ProgressBar pbOwners;

    private OwnersAdapter ownersAdapter;

    @Inject
    OwnersPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().component().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_git_owners, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            initRecyclerView();
        presenter.onViewCreated();
    }

    @Override
    public Context getActivityContext() {
        return getActivity();
    }

    @Override
    public void showProgress() {
       pbOwners.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
     pbOwners.setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable e) {
        Log.e(TAG, e.getMessage());
        SnackBarUtil.showSnackBar(coordinatorlayoutParent, getActivity(), e.getMessage());
    }

    @Override
    public BaseView.ViewModel getViewModel() {
        return presenter;
    }

    @Override
    public void showSearchResults(List<User> userList) {
        ownersAdapter.addUsers(userList);
    }

    private void initRecyclerView() {
        ownersAdapter = new OwnersAdapter();
        recyclerVwRepo.setAdapter(ownersAdapter);
        recyclerVwRepo.addItemDecoration(new SpaceItemDecoration(8));
        recyclerVwRepo.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
