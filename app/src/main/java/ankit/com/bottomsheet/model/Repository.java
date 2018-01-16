package ankit.com.bottomsheet.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ankit on 23/04/17.
 */

public class Repository {

    private int id;
    private String name;
    @SerializedName("full_name")
    private String fullName;
    private String language;
    private String description;
    private int watchers;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return fullName;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    public int getWatchers() {
        return watchers;
    }
}
