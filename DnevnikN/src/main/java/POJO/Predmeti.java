package POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bigme on 06.06.2017.
 */
public class Predmeti {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("prepod")
    @Expose
    private String prepod;
    @SerializedName("predmet")
    @Expose
    private String predmet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrepod() {
        return prepod;
    }

    public void setPrepod(String prepod) {
        this.prepod = prepod;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }
}
