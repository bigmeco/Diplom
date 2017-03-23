
package sample.Link;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jregistr {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("info")
    @Expose
    private InfoR info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InfoR getInfo() {
        return info;
    }

    public void setInfo(InfoR info) {
        this.info = info;
    }

}
