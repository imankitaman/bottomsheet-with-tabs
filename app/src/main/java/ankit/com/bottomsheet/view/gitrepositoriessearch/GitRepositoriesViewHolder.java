package ankit.com.bottomsheet.view.gitrepositoriessearch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ankit.com.bottomsheet.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ankit on 23/04/17.
 */

class GitRepositoriesViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.txtFullName)
    public TextView txtFullName;
    @Bind(R.id.txtRepoDescription)
    public TextView txtRepoDescription;
    @Bind(R.id.txtLanguage)
    public TextView txtLanguage;
    @Bind(R.id.txtStarts)
    public TextView txtStarts;



    public GitRepositoriesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
