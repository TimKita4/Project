package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelBengkel {
    @SerializedName("status")
    String status;



    @SerializedName("result")
    Bengkel mBengkel;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bengkel getmBengkel() {
        return mBengkel;
    }

    public void setmBengkel(Bengkel mBengkel) {
        this.mBengkel = mBengkel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
