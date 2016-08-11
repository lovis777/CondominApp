package com.condominio.proy.condominapp.activity.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.condominio.proy.condominapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lazar on 10/08/2016.
 */
public class Inicializacion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_inicializacion);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent();
                intent.setClass(Inicializacion.this, LoginSistema.class);
                startActivity(intent);
            }
        }, 2000);
    }

}
