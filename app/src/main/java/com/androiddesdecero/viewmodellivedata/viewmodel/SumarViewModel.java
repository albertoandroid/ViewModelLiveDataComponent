package com.androiddesdecero.viewmodellivedata.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.androiddesdecero.viewmodellivedata.ui.ViewModelSumarActivity;

/**
 * Created by albertopalomarrobledo on 18/4/18.
 */

public class SumarViewModel extends ViewModel {

    private int resultado;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
