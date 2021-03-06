
package sample.Link.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoP {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("text")
    @Expose
    private String text;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
