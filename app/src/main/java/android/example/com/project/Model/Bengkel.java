package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

public class Bengkel {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("no_hp")
    private String no_hp;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("deskripsi")
    private String deskripsi;
   @SerializedName("jenis_perbaiki")
    private String jenis_perbaiki;
    @SerializedName("kondisi")
    private String kondisi;
    @SerializedName("waktu")
    private String waktu;
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("LatLong")
    private String LatLong;


    public Bengkel(){}




    public Bengkel(String id, String nama, String no_hp, String alamat, String deskripsi, String jenis_perbaiki, String kondisi, String waktu, String tanggal, String LatLong){
    this.id=id;
    this.nama=nama;
    this.no_hp=no_hp;
    this.alamat=alamat;
    this.deskripsi=deskripsi;
    this.jenis_perbaiki=jenis_perbaiki;
    this.kondisi=kondisi;
    this.waktu=waktu;
    this.tanggal=tanggal;
    this.LatLong=LatLong;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

   public String getJenis_perbaiki() {
        return jenis_perbaiki;
    }
    public void setJenis_perbaiki(String jenis_perbaiki) {
        this.jenis_perbaiki = jenis_perbaiki;
    }
    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLatLong() {
        return LatLong;
    }

    public void setLatLong(String latLong) {
        LatLong = latLong;
    }
}



