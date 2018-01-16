package ankit.com.bottomsheet.uiutils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import ankit.com.bottomsheet.R;

/**
 * Created by ankit on 23/04/17.
 */

public class SnackBarUtil {

    public static void showSnackBar(View view, Context context, String msg) {
        Snackbar snackbar = Snackbar
                .make(view, msg, Snackbar.LENGTH_LONG);

// Changing message text color
//        snackbar.setActionTextColor(Color.RED);

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        sbView.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        textView.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        snackbar.show();
    }
}
