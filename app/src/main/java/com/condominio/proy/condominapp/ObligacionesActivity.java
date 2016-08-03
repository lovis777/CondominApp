package com.condominio.proy.condominapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ObligacionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obligaciones);
    }

    public void fnShowLuz(View view) {
        Intent intent = new Intent(getApplicationContext(),LuzActivity.class);
        startActivity(intent);
    }

    public void fnShowAgua(View view) {
        Intent intent = new Intent(getApplicationContext(),AguaActivity.class);
        startActivity(intent);
    }

    public void fnShowMant(View view) {
        Intent intent = new Intent(getApplicationContext(),MantenimientoActivity.class);
        startActivity(intent);
    }
    public void fnShowCuotaD(View view){
        Intent intent = new Intent(getApplicationContext(),CuotaDepaActivity.class);
        startActivity(intent);
    }
    public void fnShowPena(View view){
        Intent intent = new Intent(getApplicationContext(),PenalidadesActivity.class);
        startActivity(intent);
    }
}
