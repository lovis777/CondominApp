package com.condominio.proy.condominapp.activity.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.dao.personaDAO;
import com.condominio.proy.condominapp.activity.dao.veiculoDAO;
import com.condominio.proy.condominapp.activity.objetos.personaO;
import com.condominio.proy.condominapp.activity.objetos.veiculoO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lazar on 9/08/2016.
 */
public class RegistroVeiculo extends ActionBarActivity {

    private Spinner spPropietario;
    private Button btnRegVei;
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCor;
    private EditText txtPlaca;
    private RadioGroup rgTipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_registro_veiculo);

        spPropietario = (Spinner) findViewById(R.id.spPropietario);
        btnRegVei = (Button) findViewById(R.id.btnRegVei);
        txtMarca = (EditText) findViewById(R.id.txtMarca);
        txtCor = (EditText) findViewById(R.id.txtCor);
        txtModelo = (EditText) findViewById(R.id.txtModelo);
        txtPlaca = (EditText) findViewById(R.id.txtPlaca);
        rgTipo = (RadioGroup) findViewById(R.id.rgTipo);

        personaDAO dao = new personaDAO(getBaseContext());
        List<personaO> listaNombres = dao.getNombre();
        List<String> dados = new ArrayList<String>();
        for (personaO dado : listaNombres) {
            dados.add(dado.getNombre());
        }
        spPropietario.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, dados));

        btnRegVei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veiculoDAO daoVei = new veiculoDAO(getBaseContext());
                veiculoO vo = new veiculoO();

                String nombreProp = spPropietario.getSelectedItem().toString();
                int idprop = daoVei.getidentificador(nombreProp);

                String tipo = null;
                if (rgTipo.getCheckedRadioButtonId() == R.id.rbCarro) {
                    tipo = "Carro";
                } else if (rgTipo.getCheckedRadioButtonId() == R.id.rbMoto) {
                    tipo = "Moto";
                }

                vo.setPlaca(txtPlaca.getText().toString());
                vo.setTipo(tipo);
                vo.setId_propietario(idprop);
                vo.setModelo(txtModelo.getText().toString());
                vo.setMarca(txtMarca.getText().toString());
                vo.setCor(txtCor.getText().toString());

                if (daoVei.insert(vo)) {
                    Toast.makeText(getBaseContext(), "Exito!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro_veiculo, menu);
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
