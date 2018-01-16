package ankit.com.bottomsheet.view.gitownersearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ankit.com.bottomsheet.R;
import ankit.com.bottomsheet.model.User;
import butterknife.Bind;
import butterknife.ButterKnife;


public class OwnersAdapter extends RecyclerView.Adapter<OwnersViewHolder> {

    private List<User> userData;
    private Context mContext;

    public OwnersAdapter() {
        userData = new ArrayList<>();
    }

    public void addUsers(List<User> userList) {
        this.userData = userList;
        notifyDataSetChanged();
    }

    @Override
    public OwnersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_owners, parent, false);
        mContext = parent.getContext();
        return new OwnersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OwnersViewHolder holder, int position) {
        User user = userData.get(holder.getAdapterPosition());
        holder.txtLogin.setText(user.getLogin());
        if (user.getAvatar_url() == null || !user.getAvatar_url().equals("")) {
            Glide.with(mContext).load(user.getAvatar_url()).centerCrop().placeholder(R.drawable.ic_person_black_24dp)
                    .into(holder.imgAvatar);
        }
    }

    @Override
    public int getItemCount() {
        return userData == null ? 0 : userData.size();
    }

}
