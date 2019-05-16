package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelPerbaikan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Perbaikan mPerbaikan;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Perbaikan getmPerbaikan() {
        return mPerbaikan;
    }

    public void setmPerbaikan(Perbaikan mPerbaikan) {
        this.mPerbaikan = mPerbaikan;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
