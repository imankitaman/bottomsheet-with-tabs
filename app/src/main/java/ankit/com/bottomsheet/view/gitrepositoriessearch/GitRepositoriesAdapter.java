package ankit.com.bottomsheet.view.gitrepositoriessearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ankit.com.bottomsheet.R;
import ankit.com.bottomsheet.model.Repository;


public class GitRepositoriesAdapter extends RecyclerView.Adapter<GitRepositoriesViewHolder> {

    private static final String TAG = GitRepositoriesAdapter.class.getName();

    private List<Repository> data;
    private Context mContext;

    public GitRepositoriesAdapter() {
        data = new ArrayList<>();
    }

    public void addData(List<Repository> repositories) {
        this.data = repositories;
        notifyDataSetChanged();
        Log.i(TAG, " addData " + data.size());
    }

    @Override
    public GitRepositoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_git_repositories, parent, false);
        mContext = parent.getContext();
        return new GitRepositoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GitRepositoriesViewHolder holder, int position) {
        Repository repository = data.get(position);
        Log.i(TAG, +position + "" + repository.getFull_name());
        holder.txtFullName.setText(repository.getFull_name());
        holder.txtLanguage.setText(repository.getLanguage());
        holder.txtStarts.setText(String.valueOf(repository.getWatchers()));
        holder.txtRepoDescription.setText(repository.getDescription());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

}
