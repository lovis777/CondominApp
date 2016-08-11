package com.condominio.proy.condominapp.activity.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.dao.porteriaDAO;
import com.condominio.proy.condominapp.activity.objetos.porteriaO;

/**
 * Created by lazar on 1/08/2016.
 */
public class Porteria_NuevaVisita extends ActionBarActivity {
    private TextView txtNombre;
    private TextView txtObservacion;
    private TextView txtData;
    private TextView txtHora;
    private Spinner spTipo;
    private Spinner spAcompanhantes;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.porteria_nueva_visita);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spTipoVis, R.layout.spinner_item);
        spTipo = (Spinner) findViewById(R.id.spTipoVis);
        spTipo.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spAcompanhantesVis, R.layout.spinner_item);
        spAcompanhantes = (Spinner) findViewById(R.id.spAcompanhantesVis);
        spAcompanhantes.setAdapter(adapter2);

        txtData = (TextView) findViewById(R.id.txtDataVis);
        txtHora = (TextView) findViewById(R.id.txtHoraVis);
        txtNombre = (TextView) findViewById(R.id.txtNombreVis);
        txtObservacion = (TextView) findViewById(R.id.txtObservacionVis);
        spAcompanhantes = (Spinner) findViewById(R.id.spAcompanhantesVis);
        spTipo = (Spinner) findViewById(R.id.spTipoVis);
        btnEnviar = (Button) findViewById(R.id.btnEnviarVis);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                porteriaO vo = new porteriaO();
                vo.setTipo(spTipo.getSelectedItem().toString());
                vo.setNombre(txtNombre.getText().toString());
                vo.setData(txtData.getText().toString());
                vo.setHora(txtHora.getText().toString());
                vo.setAcompanhantes(Integer.parseInt(spAcompanhantes.getSelectedItem().toString()));
                vo.setObservacion(txtObservacion.getText().toString());
                vo.setStatus(1);

                porteriaDAO dao = new porteriaDAO(getBaseContext());
                if (dao.insert(vo)) {
                    Toast.makeText(getBaseContext(), txtNombre.getText().toString() + " Registro con Exito!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_porteria_nueva_visita, menu);
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
