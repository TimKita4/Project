package android.example.com.project.adapter;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class EndangeredItem {
    private String mName;
    private String mdeskripsi;
    private int mThumbnail;

    public String getDeskripsi() {
        return mdeskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.mdeskripsi = deskripsi;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }
}

