package android.example.com.project.Model;

public class Perbaikan {
    private String id;
    private String nama;
    private String no_hp;
    private String alamat;



    private String deskripsi;
    public Perbaikan(){}

    public Perbaikan(String id,String nama,String no_hp,String alamat,String deskripsi){
    this.id=id;
    this.nama=nama;
    this.no_hp=no_hp;
    this.alamat=alamat;
    this.deskripsi=deskripsi;

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
}



