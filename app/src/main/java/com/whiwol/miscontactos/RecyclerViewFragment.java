package com.whiwol.miscontactos;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jmdra on 17/06/2016.
 */
public class RecyclerViewFragment extends Fragment {
    //1.- Creando el Fragment Sobreescribiendo el metodo

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return v;
    }
}
