package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPerbaikan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Perbaikan> perbaikanList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Perbaikan> getPerbaikanList() {
        return perbaikanList;
    }

    public void setPerbaikanList(List<Perbaikan> perbaikanList) {
        this.perbaikanList = perbaikanList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
