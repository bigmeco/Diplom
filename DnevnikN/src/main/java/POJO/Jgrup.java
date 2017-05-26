
package POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jgrup {

    @SerializedName("info")
    @Expose
    private InfoP info;

    public InfoP getInfo() {
        return info;
    }

    public void setInfo(InfoP info) {
        this.info = info;
    }

}
