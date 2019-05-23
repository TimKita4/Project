package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMontir {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Montir> montirList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Montir> getMontirList() {
        return montirList;
    }

    public void setMontirList(List<Montir> montirList) {
        this.montirList = montirList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
