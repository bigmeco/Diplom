
package POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("midlename")
    @Expose
    private String midlename;

    @SerializedName("gruppa")
    @Expose
    private String gruppa;

    public String getGruppa() {
        return gruppa;
    }

    public void setGruppa(String gruppa) {
        this.gruppa = gruppa;
    }

    public Users(Integer id, String type, String name, String lastname, String midlename) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.lastname = lastname;
        this.midlename = midlename;
    }

    public Users(Integer id, String type, String name, String lastname, String midlename, String gruppa) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.lastname = lastname;
        this.midlename = midlename;
        this.gruppa = gruppa;
    }

    public Users(Integer id, String name, String lastname, String midlename) {

        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.midlename = midlename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMidlename() {
        return midlename;
    }

    public void setMidlename(String midlename) {
        this.midlename = midlename;
    }

}
