package android.example.com.project.Model;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("id_user")
    private String id_user;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;

    public Login(){}
    public Login(String id_user, String username, String password, String email){
        this.id_user=id_user;
        this.username=username;
        this.password=password;
        this.email=email;

    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
