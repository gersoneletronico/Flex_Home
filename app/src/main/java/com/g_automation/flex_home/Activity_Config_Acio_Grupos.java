package com.g_automation.flex_home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Config_Acio_Grupos extends AppCompatActivity {


    String Modos;

    private RadioGroup radioGroup;
    private RadioButton modo1;
    private RadioButton modo2;
    private RadioButton modo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_config_modo_atu_g );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        radioGroup =  findViewById(R.id.radioGroup);
        modo1 =  findViewById(R.id.modo1);
        modo2 =  findViewById(R.id.modo2);
        modo3 =  findViewById(R.id.modo3);
//========================================================================================

        SharedPreferences modosdeacionamento = getApplicationContext().getSharedPreferences("modosdeacionamento", Context.MODE_PRIVATE);
        Modos = modosdeacionamento.getString( "Modo", "Modo 1" );
        switch (Modos){
            case "Modo 1":
                modo1.setChecked( true );
                break;
            case "Modo 2":
                modo2.setChecked( true );
                break;
            case "Modo 3":
                modo3.setChecked( true );
                break;
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.modo1:
                        Modos = "Modo 1";
                        break;
                    case R.id.modo2:
                        Modos = "Modo 2";
                        break;
                    case R.id.modo3:
                        Modos = "Modo 3";
                        break;


                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.salvar, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sairesalvar) {

            Salvar_no_sharad(Modos);

            return true;
        }

        return super.onOptionsItemSelected( item );
    }
    public void Salvar_no_sharad (String Modo){

        SharedPreferences modosdeacionamento = getApplicationContext().getSharedPreferences("modosdeacionamento", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = modosdeacionamento.edit();

        editor.putString("Modo", Modo);


        editor.commit();

        //chama a proxima tela
        Intent configuragrupos = new Intent( Activity_Config_Acio_Grupos.this, Activity_Config_Grupos.class );
        startActivity( configuragrupos );
        finish();
        Toast.makeText(getApplicationContext(), "Configuração Salvas:)", Toast.LENGTH_SHORT).show();
    }



}
