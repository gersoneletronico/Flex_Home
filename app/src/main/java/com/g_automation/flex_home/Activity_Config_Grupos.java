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
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Config_Grupos extends AppCompatActivity {

    int n_botoes = 20;
    TableRow[] TablesRow = new TableRow[n_botoes];
    TextView[] txtnomes = new TextView[n_botoes];
    CheckBox[] checkG1 = new CheckBox[n_botoes];
    CheckBox[] checkG2 = new CheckBox[n_botoes];
    CheckBox[] checkG3 = new CheckBox[n_botoes];

    CheckBox[] checkGrupos = new CheckBox[3];

    String[] habG1 = new String[n_botoes];
    String[] habG2 = new String[n_botoes];
    String[] habG3 = new String[n_botoes];

    String[] habcrupos = new String[3];

    String[] rotulo = new String[n_botoes];
    String[] checkGrupo1 = new String[n_botoes];
    String[] checkGrupo2 = new String[n_botoes];
    String[] checkGrupo3 = new String[n_botoes];

    String[] checkGSalvar = new String[3];

    String[] habilita = new String[n_botoes];


    int comandos = 0;
    int in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_config_grupos );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

//        int width = 0;
//        int height = 0;
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( width, height);

        txtnomes[0] = (TextView)findViewById( R.id.txtnome1 );
        txtnomes[1] = (TextView)findViewById( R.id.txtnome2 );
        txtnomes[2] = (TextView)findViewById( R.id.txtnome3 );
        txtnomes[3] = (TextView)findViewById( R.id.txtnome4 );
        txtnomes[4] = (TextView)findViewById( R.id.txtnome5 );
        txtnomes[5] = (TextView)findViewById( R.id.txtnome6 );
        txtnomes[6] = (TextView)findViewById( R.id.txtnome7 );
        txtnomes[7] = (TextView)findViewById( R.id.txtnome8 );
        txtnomes[8] = (TextView)findViewById( R.id.txtnome9 );
        txtnomes[9] = (TextView)findViewById( R.id.txtnome10 );
        txtnomes[10] = (TextView)findViewById( R.id.txtnome11 );
        txtnomes[11] = (TextView)findViewById( R.id.txtnome12 );
        txtnomes[12] = (TextView)findViewById( R.id.txtnome13 );
        txtnomes[13] = (TextView)findViewById( R.id.txtnome14 );
        txtnomes[14] = (TextView)findViewById( R.id.txtnome15 );
        txtnomes[15] = (TextView)findViewById( R.id.txtnome16 );
        txtnomes[16] = (TextView)findViewById( R.id.txtnome17 );
        txtnomes[17] = (TextView)findViewById( R.id.txtnome18 );
        txtnomes[18] = (TextView)findViewById( R.id.txtnome19 );
        txtnomes[19] = (TextView)findViewById( R.id.txtnome20 );

        TablesRow[0] = (TableRow)findViewById( R.id.TableRow1 );
        TablesRow[1] = (TableRow)findViewById( R.id.TableRow2 );
        TablesRow[2] = (TableRow)findViewById( R.id.TableRow3 );
        TablesRow[3] = (TableRow)findViewById( R.id.TableRow4 );
        TablesRow[4] = (TableRow)findViewById( R.id.TableRow5 );
        TablesRow[5] = (TableRow)findViewById( R.id.TableRow6 );
        TablesRow[6] = (TableRow)findViewById( R.id.TableRow7 );
        TablesRow[7] = (TableRow)findViewById( R.id.TableRow8 );
        TablesRow[8] = (TableRow)findViewById( R.id.TableRow9 );
        TablesRow[9] = (TableRow)findViewById( R.id.TableRow10 );
        TablesRow[10] = (TableRow)findViewById( R.id.TableRow11 );
        TablesRow[11] = (TableRow)findViewById( R.id.TableRow12 );
        TablesRow[12] = (TableRow)findViewById( R.id.TableRow13 );
        TablesRow[13] = (TableRow)findViewById( R.id.TableRow14 );
        TablesRow[14] = (TableRow)findViewById( R.id.TableRow15 );
        TablesRow[15] = (TableRow)findViewById( R.id.TableRow16 );
        TablesRow[16] = (TableRow)findViewById( R.id.TableRow17 );
        TablesRow[17] = (TableRow)findViewById( R.id.TableRow18 );
        TablesRow[18] = (TableRow)findViewById( R.id.TableRow19 );
        TablesRow[19] = (TableRow)findViewById( R.id.TableRow20 );

        checkG1[0] = (CheckBox) findViewById( R.id.check1g1 );
        checkG1[1] = (CheckBox) findViewById( R.id.check2g1 );
        checkG1[2] = (CheckBox) findViewById( R.id.check3g1 );
        checkG1[3] = (CheckBox) findViewById( R.id.check4g1 );
        checkG1[4] = (CheckBox) findViewById( R.id.check5g1 );
        checkG1[5] = (CheckBox) findViewById( R.id.check6g1 );
        checkG1[6] = (CheckBox) findViewById( R.id.check7g1 );
        checkG1[7] = (CheckBox) findViewById( R.id.check8g1 );
        checkG1[8] = (CheckBox) findViewById( R.id.check9g1 );
        checkG1[9] = (CheckBox) findViewById( R.id.check10g1 );
        checkG1[10] = (CheckBox) findViewById( R.id.check11g1 );
        checkG1[11] = (CheckBox) findViewById( R.id.check12g1 );
        checkG1[12] = (CheckBox) findViewById( R.id.check13g1 );
        checkG1[13] = (CheckBox) findViewById( R.id.check14g1 );
        checkG1[14] = (CheckBox) findViewById( R.id.check15g1 );
        checkG1[15] = (CheckBox) findViewById( R.id.check16g1 );
        checkG1[16] = (CheckBox) findViewById( R.id.check17g1 );
        checkG1[17] = (CheckBox) findViewById( R.id.check18g1 );
        checkG1[18] = (CheckBox) findViewById( R.id.check19g1 );
        checkG1[19] = (CheckBox) findViewById( R.id.check20g1 );

        checkG2[0] = (CheckBox) findViewById( R.id.check1g2 );
        checkG2[1] = (CheckBox) findViewById( R.id.check2g2 );
        checkG2[2] = (CheckBox) findViewById( R.id.check3g2 );
        checkG2[3] = (CheckBox) findViewById( R.id.check4g2 );
        checkG2[4] = (CheckBox) findViewById( R.id.check5g2 );
        checkG2[5] = (CheckBox) findViewById( R.id.check6g2 );
        checkG2[6] = (CheckBox) findViewById( R.id.check7g2 );
        checkG2[7] = (CheckBox) findViewById( R.id.check8g2 );
        checkG2[8] = (CheckBox) findViewById( R.id.check9g2 );
        checkG2[9] = (CheckBox) findViewById( R.id.check10g2 );
        checkG2[10] = (CheckBox) findViewById( R.id.check11g2 );
        checkG2[11] = (CheckBox) findViewById( R.id.check12g2 );
        checkG2[12] = (CheckBox) findViewById( R.id.check13g2 );
        checkG2[13] = (CheckBox) findViewById( R.id.check14g2 );
        checkG2[14] = (CheckBox) findViewById( R.id.check15g2 );
        checkG2[15] = (CheckBox) findViewById( R.id.check16g2 );
        checkG2[16] = (CheckBox) findViewById( R.id.check17g2 );
        checkG2[17] = (CheckBox) findViewById( R.id.check18g2 );
        checkG2[18] = (CheckBox) findViewById( R.id.check19g2 );
        checkG2[19] = (CheckBox) findViewById( R.id.check20g2 );

        checkG3[0] = (CheckBox) findViewById( R.id.check1g3 );
        checkG3[1] = (CheckBox) findViewById( R.id.check2g3 );
        checkG3[2] = (CheckBox) findViewById( R.id.check3g3 );
        checkG3[3] = (CheckBox) findViewById( R.id.check4g3 );
        checkG3[4] = (CheckBox) findViewById( R.id.check5g3 );
        checkG3[5] = (CheckBox) findViewById( R.id.check6g3 );
        checkG3[6] = (CheckBox) findViewById( R.id.check7g3 );
        checkG3[7] = (CheckBox) findViewById( R.id.check8g3 );
        checkG3[8] = (CheckBox) findViewById( R.id.check9g3 );
        checkG3[9] = (CheckBox) findViewById( R.id.check10g3 );
        checkG3[10] = (CheckBox) findViewById( R.id.check11g3 );
        checkG3[11] = (CheckBox) findViewById( R.id.check12g3 );
        checkG3[12] = (CheckBox) findViewById( R.id.check13g3 );
        checkG3[13] = (CheckBox) findViewById( R.id.check14g3 );
        checkG3[14] = (CheckBox) findViewById( R.id.check15g3 );
        checkG3[15] = (CheckBox) findViewById( R.id.check16g3 );
        checkG3[16] = (CheckBox) findViewById( R.id.check17g3 );
        checkG3[17] = (CheckBox) findViewById( R.id.check18g3 );
        checkG3[18] = (CheckBox) findViewById( R.id.check19g3 );
        checkG3[19] = (CheckBox) findViewById( R.id.check20g3 );

        checkGrupos[0] = (CheckBox) findViewById( R.id.habg1 );
        checkGrupos[1] = (CheckBox) findViewById( R.id.habg2 );
        checkGrupos[2] = (CheckBox) findViewById( R.id.habg3 );

        //mostra no edit as atuas edições
        SharedPreferences Config_grupos = getApplicationContext().getSharedPreferences("Config_grupos", Context.MODE_PRIVATE);

        for(int i = 0; i < 3; i++) {
            habcrupos[i] = Config_grupos.getString("gruposhab"+i, "1");
            if (habcrupos[i].contains( "1" ))
                checkGrupos[i].setChecked( true );
            else if (habcrupos[i].contains( "0" ))
                checkGrupos[i].setChecked( false );
        }
        for(int i = 0; i < n_botoes; i++) {
            habG1[i] = Config_grupos.getString("abG1"+i, "0");
            habG2[i] = Config_grupos.getString("abG2"+i, "0");
            habG3[i] = Config_grupos.getString("abG3"+i, "0");

            if (habG1[i].contains( "1" ))
                checkG1[i].setChecked( true );
            else if (habG1[i].contains( "0" ))
                checkG1[i].setChecked( false );
            if (habG2[i].contains( "1" ))
                checkG2[i].setChecked( true );
            else if (habG2[i].contains( "0" ))
                checkG2[i].setChecked( false );
            if (habG3[i].contains( "1" ))
                checkG3[i].setChecked( true );
            else if (habG3[i].contains( "0" ))
                checkG3[i].setChecked( false );

        }
        //mostra no edit as atuas edições
        SharedPreferences sharedbotao = getApplicationContext().getSharedPreferences("Config_Btns", Context.MODE_PRIVATE);
        for(int i = 0; i < n_botoes; i++) {
             rotulo[i] = sharedbotao.getString( "rotulo" + i, "Dispositivo "+i );
             habilita[i] = sharedbotao.getString("checar"+i, "1");
             txtnomes[i].setText( rotulo[i] );

            if (habilita[i].contains( "1" ))

                TablesRow[i].setVisibility(View.VISIBLE);
                //TablesRow[i].setMinimumHeight( 0 );

            else if (habilita[i].contains( "0" ))

                //TablesRow[i].setLayoutParams( lp );
                TablesRow[i].setVisibility(View.GONE);

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
            for(int i = 0; i < n_botoes; i++) {

                if (checkG1[i].isChecked()) {
                    checkGrupo1[i] = "1";
                } else if (!checkG1[i].isChecked()){
                    checkGrupo1[i] = "0";
                }
                if (checkG2[i].isChecked()){
                    checkGrupo2[i] = "1";

                }else if (!checkG2[i].isChecked()) {
                    checkGrupo2[i] = "0";
                }

                if (checkG3[i].isChecked()) {
                    checkGrupo3[i] = "1";

                }else if (!checkG3[i].isChecked()) {
                    checkGrupo3[i] = "0";

                }


            }
            for(int i = 0; i < 3; i++) {
                if (checkGrupos[i].isChecked( ))
                    checkGSalvar[i] = "1";
                else if (!checkGrupos[i].isChecked( ))
                    checkGSalvar[i] = "0";
            }

            String[] salvar = {checkGrupo1[0], checkGrupo1[1], checkGrupo1[2], checkGrupo1[3], checkGrupo1[4]
                    , checkGrupo1[5], checkGrupo1[6], checkGrupo1[7], checkGrupo1[8], checkGrupo1[9], checkGrupo1[10]
                    , checkGrupo1[11], checkGrupo1[12], checkGrupo1[13], checkGrupo1[14], checkGrupo1[15]
                    , checkGrupo1[16], checkGrupo1[17], checkGrupo1[18], checkGrupo1[19]
                    ,checkGrupo2[0], checkGrupo2[1], checkGrupo2[2], checkGrupo2[3], checkGrupo2[4]
                    , checkGrupo2[5], checkGrupo2[6], checkGrupo2[7], checkGrupo2[8], checkGrupo2[9], checkGrupo2[10]
                    , checkGrupo2[11], checkGrupo2[12], checkGrupo2[13], checkGrupo2[14], checkGrupo2[15]
                    , checkGrupo2[16], checkGrupo2[17], checkGrupo2[18], checkGrupo2[19]
                    ,checkGrupo3[0], checkGrupo3[1], checkGrupo3[2], checkGrupo3[3], checkGrupo3[4]
                    , checkGrupo3[5], checkGrupo3[6], checkGrupo3[7], checkGrupo3[8], checkGrupo3[9], checkGrupo3[10]
                    , checkGrupo3[11], checkGrupo3[12], checkGrupo3[13], checkGrupo3[14], checkGrupo3[15]
                    , checkGrupo3[16], checkGrupo3[17], checkGrupo3[18], checkGrupo3[19], checkGSalvar[0], checkGSalvar[1], checkGSalvar[2]
           };





            Salvar_no_sharad(salvar);

            return true;
        }
        if (id == R.id.grupo2) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
    public void Salvar_no_sharad (String[] valor){

        SharedPreferences Config_grupos = getApplicationContext().getSharedPreferences("Config_grupos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Config_grupos.edit();
        for(int i = 0; i < n_botoes; i++){
            editor.putString("abG1"+i, valor[i]);
            editor.putString("abG2"+i, valor[i+20]);
            editor.putString("abG3"+i, valor[i+40]);
        }
        for(int i = 0; i < 3; i++){
            editor.putString("gruposhab"+i, valor[i+60]);
        }

        editor.commit();

        //chama a proxima tela
        Intent configurabtns = new Intent( Activity_Config_Grupos.this, Activity_Principal.class );
        startActivity( configurabtns );
        finish();
        Toast.makeText(getApplicationContext(), "Configuração Salvas:)", Toast.LENGTH_SHORT).show();
    }

       //===============================================================================================
    public void Clickconfigatuacao(View view){
        Intent modoacionamentos=new Intent(Activity_Config_Grupos.this,Activity_Config_Acio_Grupos.class);
        startActivity(modoacionamentos);
        finish();
    }

}
