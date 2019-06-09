package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

public class Sparepart {


    @SerializedName("id_part")
    private String id_part;
    @SerializedName("nama")
    private String nama;
    @SerializedName("harga")
    private String harga;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("stok")
    private String stok;
    @SerializedName("foto")
    private String foto;

    public Sparepart(){}

    public Sparepart(String id_part, String nama, String harga, String deskripsi, String stok, String foto) {
        this.id_part = id_part;
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.stok = stok;
        this.foto = foto;
    }

    public String getId_part() {
        return id_part;
    }

    public void setId_part(String id_part) {
        this.id_part = id_part;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


}
