package com.condominio.proy.condominapp.activity.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.dao.notificacionDAO;
import com.condominio.proy.condominapp.activity.dao.personaDAO;
import com.condominio.proy.condominapp.activity.objetos.notificacionO;
import com.condominio.proy.condominapp.activity.objetos.personaO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lazar on 9/08/2016.
 */
public class NotificacionNueva extends ActionBarActivity {

    private EditText txvNotificacion;
    private Button btnRegNot;
    private Spinner spPersNotificacion;
    private Date data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_notificacion_nueva);

        txvNotificacion = (EditText) findViewById(R.id.txvNotificacion);
        btnRegNot = (Button) findViewById(R.id.btnRegNot);
        spPersNotificacion = (Spinner) findViewById(R.id.spPersNotificacion);


        notificacionDAO daoPersona = new notificacionDAO(getBaseContext());
        List<personaO> listaNombres = daoPersona.getNombreTodos();
        List<String> datos = new ArrayList<String>();
        for (personaO dado : listaNombres) {
            datos.add(dado.getNombre());
        }
        spPersNotificacion.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, datos));

        btnRegNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personaDAO dao = new personaDAO(getBaseContext());
                String itemSelecionado = spPersNotificacion.getSelectedItem().toString();
                int idItem = dao.getidentificador(itemSelecionado);

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                notificacionO vo = new notificacionO();
                vo.setData(formato.format(new Date().getTime()));
                vo.setDescripcion(txvNotificacion.getText().toString());
                vo.setId_persona(idItem);

                notificacionDAO daoNot = new notificacionDAO(getBaseContext());
                if (daoNot.insert(vo)) {
                    Toast.makeText(getBaseContext(), "Exito !", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notificacion_nueva, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
