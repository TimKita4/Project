package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelLogin {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Perbaikan mLogin;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Perbaikan getmLogin() {
        return mLogin;
    }

    public void setmLogin(Perbaikan mLogin) {
        this.mLogin = mLogin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
