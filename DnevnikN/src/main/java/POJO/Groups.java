package POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bigme on 08.06.2017.
 */
public class Groups {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("prepod")
    @Expose
    private String prepod;
    @SerializedName("gruppa")
    @Expose
    private String gruppa;
    @SerializedName("predmeti")
    @Expose
    private String predmeti;

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

    public String getGruppa() {
        return gruppa;
    }

    public void setGruppa(String gruppa) {
        this.gruppa = gruppa;
    }

    public String getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(String predmeti) {
        this.predmeti = predmeti;
    }
}
