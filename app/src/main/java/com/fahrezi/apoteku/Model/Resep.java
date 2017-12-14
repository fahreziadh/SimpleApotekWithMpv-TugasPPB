package com.fahrezi.apoteku.Model;

/**
 * Created by fahreziadh on 12/12/2017.
 */

public class Resep {
    String id_resep;
    String user;
    String status;

    public String getId_resep() {
        return id_resep;
    }

    public void setId_resep(String id_resep) {
        this.id_resep = id_resep;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Resep(String id_resep, String user, String status) {
        this.status=status;
        this.id_resep = id_resep;
        this.user = user;
    }


}
