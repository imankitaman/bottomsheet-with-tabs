package ankit.com.bottomsheet.view.gitownersearch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ankit.com.bottomsheet.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class OwnersViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.imgAvatar)
    public ImageView imgAvatar;
    @Bind(R.id.txtLogin)
    public TextView txtLogin;

    public OwnersViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
