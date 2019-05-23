package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelMontir {
    @SerializedName("status")
    String status;
    @SerializedName("ressult")
    String mMontir;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getmMontir() {
        return mMontir;
    }

    public void setmMontir(String mMontir) {
        this.mMontir = mMontir;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}


