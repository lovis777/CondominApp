package com.condominio.proy.condominapp.activity.activitys;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.condominio.proy.condominapp.R;
import com.condominio.proy.condominapp.activity.dao.personaDAO;
import com.condominio.proy.condominapp.activity.objetos.personaO;

/**
 * Created by lazar on 9/08/2016.
 */
public class RegistroPersona extends ActionBarActivity {

    private EditText txtNombrePers;
    private EditText txtBloco_ap;
    private RadioGroup rgSexo;
    private RadioGroup rgStatus;
    private RadioGroup rgVeiculo;
    private Button btnRegPers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_registro_personas);

        txtBloco_ap = (EditText)findViewById(R.id.txtBloco_ap);
        txtNombrePers = (EditText)findViewById(R.id.txtNombrePers);
        rgSexo = (RadioGroup)findViewById(R.id.rgSexo);
        rgStatus = (RadioGroup)findViewById(R.id.rgstatus);
        rgVeiculo = (RadioGroup)findViewById(R.id.rgVeiculo);
        btnRegPers = (Button)findViewById(R.id.btnRegPers);

        btnRegPers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status=null;
                if (rgStatus.getCheckedRadioButtonId()== R.id.rbFuncionario){
                    status = "F";
                }else if(rgStatus.getCheckedRadioButtonId()==R.id.rbMorador){
                    status = "M";
                }
                String sexo=null;
                if(rgSexo.getCheckedRadioButtonId()==R.id.rbMasculino){
                    sexo = "M";
                }else if(rgSexo.getCheckedRadioButtonId()==R.id.rbFeminino){
                    sexo = "F";
                }
                String veiculo=null;
                if(rgVeiculo.getCheckedRadioButtonId()==R.id.rbSim){
                    veiculo = "S";
                }else if(rgVeiculo.getCheckedRadioButtonId()==R.id.rbNao){
                    veiculo = "N";
                }
                personaO vo = new personaO();
                vo.setNombre(txtNombrePers.getText().toString());
                vo.setBloco_ap(txtBloco_ap.getText().toString());
                vo.setVeiculo(veiculo);
                vo.setStatus(status);
                vo.setSexo(sexo);

                personaDAO dao = new personaDAO(getBaseContext());
                if(dao.insert(vo)){
                    Toast.makeText(getBaseContext(), vo.getNombre()+" Registro con exito", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro_persona, menu);
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
