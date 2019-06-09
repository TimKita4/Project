package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetLogin {


    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Login> loginList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Login> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<Login> loginList) {
        this.loginList = loginList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
