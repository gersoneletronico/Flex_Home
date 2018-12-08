package com.g_automation.flex_home;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Configurar_servidores extends AppCompatActivity {
    int n_ips = 10;
    String[] ip = new String[n_ips];
    String[] ips = new String[n_ips];
    String[] habita = new String[n_ips];
    String[] habilitas = new String[n_ips];
    EditText[] editips = new EditText[n_ips];
    CheckBox[] checkips = new CheckBox[n_ips];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_confugurar_servidores );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar);
        setSupportActionBar( toolbar );

        editips[0] = (EditText) findViewById( R.id.editip1 );
        editips[1] = (EditText) findViewById( R.id.editip2 );
        editips[2] = (EditText) findViewById( R.id.editip3 );
        editips[3] = (EditText) findViewById( R.id.editip4 );
        editips[4] = (EditText) findViewById( R.id.editip5 );
        editips[5] = (EditText) findViewById( R.id.editip6 );
        editips[6] = (EditText) findViewById( R.id.editip7 );
        editips[7] = (EditText) findViewById( R.id.editip8 );
        editips[8] = (EditText) findViewById( R.id.editip9 );
        editips[9] = (EditText) findViewById( R.id.editip10 );

        checkips[0] = (CheckBox) findViewById( R.id.checkIP1 );
        checkips[1] = (CheckBox) findViewById( R.id.checkIP2 );
        checkips[2] = (CheckBox) findViewById( R.id.checkIP3 );
        checkips[3] = (CheckBox) findViewById( R.id.checkIP4 );
        checkips[4] = (CheckBox) findViewById( R.id.checkIP5 );
        checkips[5] = (CheckBox) findViewById( R.id.checkIP6 );
        checkips[6] = (CheckBox) findViewById( R.id.checkIP7 );
        checkips[7] = (CheckBox) findViewById( R.id.checkIP8 );
        checkips[8] = (CheckBox) findViewById( R.id.checkIP9 );
        checkips[9] = (CheckBox) findViewById( R.id.checkIP10 );

        //mostra no edit as atuas edições
        SharedPreferences sharedservidor = getApplicationContext().getSharedPreferences("Config_IPS", Context.MODE_PRIVATE);
        for(int i = 0; i < n_ips; i++) {
            ip[i] = sharedservidor.getString( "IPS" + i, "http://192.168.1.1");
            habita[i] = sharedservidor.getString("checkIPS" + i, "0");

            editips[i].setText(ip[i]);

            if (habita[i].contains( "1" ))

                checkips[i].setChecked( true );

            else if (habita[i].contains( "0" ))

                checkips[i].setChecked( false );

        }


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
            for(int i = 0; i < n_ips; i++) {
                ips[i] = editips[i].getText().toString();
                if (!ips[i].contains("http://")){
                    ips[i] = "http://" + ips[i];
                }
                if(checkips[i].isChecked()){
                    habilitas[i] = "1";

                }else if(!checkips[i].isChecked()){
                    habilitas[i] = "0";
                }
            }


            //String[] salvar = new String[n_botoes];
            String[] salvar = {ips[0],ips[1],ips[2],ips[3],ips[4],ips[5],ips[6],ips[7],ips[8],ips[9],
                    habilitas[0],habilitas[1],habilitas[2],habilitas[3],habilitas[4],habilitas[5],
                    habilitas[6],habilitas[7],habilitas[8],habilitas[9]
            };
            Salvar_no_sharad(salvar);

            return true;
        }

        return super.onOptionsItemSelected( item );
    }
    public void Salvar_no_sharad (String[] valor){

        SharedPreferences sharedservidor = getApplicationContext().getSharedPreferences("Config_IPS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedservidor.edit();
        for(int i = 0; i < n_ips; i++){
            editor.putString("IPS"+i, valor[i]);
            // Toast.makeText(getApplicationContext(), valor[i] +" rot", Toast.LENGTH_LONG).show();
            editor.putString("checkIPS"+i, valor[i+10]);
            // Toast.makeText(getApplicationContext(), valor[i+20] +" ch", Toast.LENGTH_LONG).show();
        }

        editor.commit();

        //chama a proxima tela
        Intent trocatela=new Intent(Configurar_servidores.this,Activity_Principal.class);
        startActivity(trocatela);
        finish();
        Toast.makeText(getApplicationContext(), "Configuração Salvas:)", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(getApplicationContext(), "Stop ", Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Toast.makeText(getApplicationContext(), "onTouchEvent ", Toast.LENGTH_LONG).show();
        return super.onTouchEvent(event);
    }
    @Override
    protected void onStart() {
        super.onStart();


    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
        //Toast.makeText(getApplicationContext(), "onPause ", Toast.LENGTH_LONG).show();

    }

}
