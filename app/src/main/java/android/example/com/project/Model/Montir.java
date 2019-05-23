package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

public class Montir {
    @SerializedName("id_montir")
    private String id_montir;
    @SerializedName("nama_montir")
    private String nama_montir;
    @SerializedName("no_hp")
    private String no_hp;
    @SerializedName("email")
    private String email;
    @SerializedName("foto")
    private String foto;

    public Montir(){}


    public String getId_montir() {
        return id_montir;
    }

    public void setId_montir(String id_montir) {
        this.id_montir = id_montir;
    }

    public String getNama() {
        return nama_montir;
    }

    public void setNama(String nama_montir) {
        this.nama_montir = nama_montir;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Montir(String id_montir, String nama_montir, String no_hp, String email, String foto){
        this.id_montir=id_montir;
        this.nama_montir=nama_montir;
        this.no_hp=no_hp;
        this.email=email;
        this.foto=foto;
    }
}
