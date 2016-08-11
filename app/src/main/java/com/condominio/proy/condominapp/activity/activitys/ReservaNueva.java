package com.condominio.proy.condominapp.activity.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.dao.notificacionDAO;
import com.condominio.proy.condominapp.activity.dao.personaDAO;
import com.condominio.proy.condominapp.activity.dao.reservaDAO;
import com.condominio.proy.condominapp.activity.objetos.personaO;
import com.condominio.proy.condominapp.activity.objetos.reservaO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lazar on 9/08/2016.
 */
public class ReservaNueva extends ActionBarActivity {

    private DatePicker dataRes;
    private Button btnRegistrarRes;
    private Spinner spPeriodoRes;
    private Spinner spLocalRes;
    private Spinner spNombreRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_reserva_nueva);

        dataRes = (DatePicker) findViewById(R.id.dataRes);
        btnRegistrarRes = (Button) findViewById(R.id.btnRegistrarRes);
        spPeriodoRes = (Spinner) findViewById(R.id.spPeriodoRes);
        spLocalRes = (Spinner) findViewById(R.id.spLocalRes);
        spNombreRes = (Spinner) findViewById(R.id.spNombreRes);

        final int dia = dataRes.getDayOfMonth();
        final int mes = dataRes.getMonth() + 1;
        final int ano = dataRes.getYear();
        //Llenar lista de Personas
        notificacionDAO daoPersona = new notificacionDAO(getBaseContext());
        List<personaO> listaNombres = daoPersona.getNombreTodos();
        List<String> datos = new ArrayList<String>();
        for (personaO dato : listaNombres) {
            datos.add(dato.getNombre());
        }
        spNombreRes.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, datos));
        //llenar lista de locales
        ArrayAdapter adapterLocal = ArrayAdapter.createFromResource(this, R.array.spLugar, R.layout.spinner_item);
        spLocalRes.setAdapter(adapterLocal);
        //Preencher lista Periodo
        ArrayAdapter adapterPeriodo = ArrayAdapter.createFromResource(this, R.array.spPeriodo, R.layout.spinner_item);
        spPeriodoRes.setAdapter(adapterPeriodo);

        btnRegistrarRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservaO vo = new reservaO();
                int periodo = 0;
                String periodoSpinner = spPeriodoRes.getSelectedItem().toString();
                if (periodoSpinner.equals("Mañana")) {
                    periodo = 1;
                } else if (periodoSpinner.equals("Tarde")) {
                    periodo = 2;
                } else if (periodoSpinner.equals("Noche")) {
                    periodo = 3;
                }

                personaDAO daoPersona = new personaDAO(getBaseContext());
                String itemSelecionado = spNombreRes.getSelectedItem().toString();
                int idItem = daoPersona.getidentificador(itemSelecionado);

                vo.setPeriodo(periodo);
                vo.setLocal(spLocalRes.getSelectedItem().toString());
                vo.setData(new Date(ano, mes, dia));
                vo.setId_persona(idItem);

                reservaDAO dao = new reservaDAO(getBaseContext());
                if (dao.insert(vo)) {
                    Toast.makeText(getBaseContext(), "Exito!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reserva_nueva, menu);
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
