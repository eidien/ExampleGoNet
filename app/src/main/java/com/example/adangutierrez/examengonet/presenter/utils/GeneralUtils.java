package com.example.adangutierrez.examengonet.presenter.utils;

import com.example.adangutierrez.examengonet.App;
import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.data.model.Marcas;

import java.util.ArrayList;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class GeneralUtils {

    public static boolean isTablet() {
        String mType = App.getContext().getString(R.string.type_device);
        return mType.equalsIgnoreCase("Tablet");
    }

    public static ArrayList<Marcas> getDefaultInfo() {
        ArrayList<Marcas> marcasArrayList = new ArrayList<>();
        Marcas marcas = new Marcas();
        marcas.id = 1;
        marcas.idResourceImagen = 1;
        marcas.name = "Claro";
        marcas.type = "Tiempo aire";
        marcasArrayList.add(marcas);

        marcas = new Marcas();
        marcas.id = 2;
        marcas.idResourceImagen = 1;
        marcas.name = "Claro";
        marcas.type = "Megas";
        marcasArrayList.add(marcas);

        marcas = new Marcas();
        marcas.id = 3;
        marcas.idResourceImagen = 2;
        marcas.name = "Tuenti";
        marcas.type = "Tiempo aire";
        marcasArrayList.add(marcas);

        marcas = new Marcas();
        marcas.id = 4;
        marcas.idResourceImagen = 2;
        marcas.name = "Tuenti";
        marcas.type = "Megas";
        marcasArrayList.add(marcas);

        marcas = new Marcas();
        marcas.id = 5;
        marcas.idResourceImagen = 3;
        marcas.name = "Entel";
        marcas.type = "Tiempo aire";
        marcasArrayList.add(marcas);

        marcas = new Marcas();
        marcas.id = 6;
        marcas.idResourceImagen = 3;
        marcas.name = "Entel";
        marcas.type = "Megas";
        marcasArrayList.add(marcas);

        return marcasArrayList;
    }

    public static int getResourceMarca(int id) {
        switch (id) {
            case 1:
                return R.drawable.ic_claro;
            case 2:
                return R.drawable.ic_tuenti;
            case 3:
                return R.drawable.ic_entel;
            default:
                return -1;
        }
    }
}
