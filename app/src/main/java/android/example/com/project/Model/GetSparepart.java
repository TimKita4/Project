package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSparepart {


    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Sparepart> sparepartList;
    @SerializedName("message")
    String message;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Sparepart> getSparepartList() {
        return sparepartList;
    }

    public void setSparepartList(List<Sparepart> sparepartList) {
        this.sparepartList = sparepartList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
