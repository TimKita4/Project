package android.example.com.project.Model;

public class ModelData {
    String NIM,Nama_mahasiswa,Jenis_kel,Alamat;

    public ModelData() {
        this.NIM = NIM;
        this.Nama_mahasiswa = Nama_mahasiswa;
        this.Jenis_kel = Jenis_kel;
        this.Alamat = Alamat;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama_mahasiswa() {
        return Nama_mahasiswa;
    }

    public void setNama_mahasiswa(String Nama_mahasiswa) {
        this.Nama_mahasiswa = Nama_mahasiswa;
    }

    public String getJenis_kel() {
        return Jenis_kel;
    }

    public void setJenis_kel(String Jenis_kel) {
        this.Jenis_kel = Jenis_kel;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) { this.Alamat = Alamat; }
}
