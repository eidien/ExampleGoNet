package com.example.adangutierrez.examengonet.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class Marcas extends RealmObject {

    @PrimaryKey
    public int id;
    public int idResourceImagen;
    public String name;
    public String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdResourceImagen() {
        return idResourceImagen;
    }

    public void setIdResourceImagen(int idResourceImagen) {
        this.idResourceImagen = idResourceImagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
