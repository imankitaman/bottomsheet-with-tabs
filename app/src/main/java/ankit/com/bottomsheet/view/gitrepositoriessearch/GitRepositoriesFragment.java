package ankit.com.bottomsheet.view.gitrepositoriessearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import ankit.com.bottomsheet.model.Repository;
import ankit.com.bottomsheet.uiutils.SnackBarUtil;
import ankit.com.bottomsheet.uiutils.SpaceItemDecoration;
import ankit.com.bottomsheet.view.BaseFragment;
import ankit.com.bottomsheet.view.BaseView;
import butterknife.Bind;
import butterknife.ButterKnife;


public class GitRepositoriesFragment extends BaseFragment implements GitRepositoriesViewModelContract.View {

    private static final String TAG = GitRepositoriesFragment.class.getName();

    private GitRepositoriesAdapter gitRepositoriesAdapter;

    @Inject
    GitRepositoriesPresenter presenter;

    @Bind(R.id.pbRepo)
    ProgressBar pbRepo;
    @Bind(R.id.recyclerVwRepo)
    RecyclerView recyclerVwRepo;
    @Bind(R.id.coordinatorlayoutParent)
    CoordinatorLayout coordinatorlayoutParent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().component().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_git_repositories, container, false);
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
    public BaseView.ViewModel getViewModel() {
        return presenter;
    }

    @Override
    public Context getActivityContext() {
        return getActivity();
    }

    @Override
    public void showProgress() {
        pbRepo.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
     pbRepo.setVisibility(View.GONE);

    }

    @Override
    public void showError(Throwable e) {
        Log.e(TAG, e.getMessage());
        SnackBarUtil.showSnackBar(coordinatorlayoutParent, getActivity(), e.getMessage());
    }

    @Override
    public void showSearchResults(List<Repository> repositories) {
        gitRepositoriesAdapter.addData(repositories);
    }

    private void initRecyclerView() {
        gitRepositoriesAdapter = new GitRepositoriesAdapter();
        recyclerVwRepo.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerVwRepo.addItemDecoration(new SpaceItemDecoration(8));
        recyclerVwRepo.setAdapter(gitRepositoriesAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
