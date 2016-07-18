package com.condominio.proy.condominapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void fnShowInfoP(View view) {
        Intent intent = new Intent(getApplicationContext(),InfoPersonalActivity.class);
        startActivity(intent);
    }

    public void fnShowAmbC(View view) {
        Intent intent = new Intent(getApplicationContext(),AmbCompartidoActivity.class);
        startActivity(intent);
    }

    public void fnShowOblig(View view) {
        Intent intent = new Intent(getApplicationContext(),ObligacionesActivity.class);
        startActivity(intent);
    }
}
