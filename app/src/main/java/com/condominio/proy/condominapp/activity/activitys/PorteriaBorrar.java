package com.condominio.proy.condominapp.activity.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.dao.porteriaDAO;
import com.condominio.proy.condominapp.activity.objetos.porteriaO;

/**
 * Created by lazar on 01/08/2016.
 */
public class PorteriaBorrar extends Activity {

    private int ID = 0;
    private Button btnBorrarVis;
    private Button btnTerminarVis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_porteria_eliminar);
        Intent it = getIntent();
        ID = it.getIntExtra("codigo", 1);

        final porteriaDAO dao = new porteriaDAO(getBaseContext());
        final porteriaO vo = dao.getById(ID);
        btnBorrarVis = (Button) findViewById(R.id.btnBorrarVis);
        btnTerminarVis = (Button) findViewById(R.id.btnTerminarVis);


        btnBorrarVis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(PorteriaBorrar.this);
                msg.setMessage("¿Quieres eliminar esta visita ?");
                msg.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dao.delete(vo)) {
                            Toast.makeText(getBaseContext(), "Exito!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
                msg.setNegativeButton("NO", null);
                msg.show();
            }
        });

        btnTerminarVis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(PorteriaBorrar.this);
                msg.setMessage("¿ Desea finalizar esta visita ?");
                msg.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dao.delete(vo)) {
                            Toast.makeText(getBaseContext(), "Exito!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
                msg.setNegativeButton("NO", null);
                msg.show();

            }
        });
    }

}
