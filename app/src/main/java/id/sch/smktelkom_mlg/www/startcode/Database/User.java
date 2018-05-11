package id.sch.smktelkom_mlg.www.startcode.Database;

/**
 * Created by Meytha Bethany Putri on 10/05/2018.
 */

public class User {
    private int nisn;
    private String name;
    private String email;
    private String telp;
    private String sekolah;
    private String password;

    public int getNisn() {
        return nisn;
    }

    public void setNisn(int nisn) {
        this.nisn = nisn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getSekolah() {
        return sekolah;
    }

    public void setSekolah(String sekolah) {
        this.sekolah = sekolah;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

