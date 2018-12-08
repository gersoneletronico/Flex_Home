package com.g_automation.flex_home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;

public class Confugurar_btns extends AppCompatActivity {

    int n_botoes = 20;
    //String[] tags = {"edit1", "edit2", "edit3"};
    EditText[] editrotulo = new EditText[n_botoes];
    EditText[] editgrupos = new EditText[3];
    String[] rotulo = new String[n_botoes];
    String[] rotulos = new String[n_botoes];
    String[] rotulosgrupos = new String[3];
    String[] rotulosgruposalvar = new String[3];
    String[] IP = new String[n_botoes];
    String[] IPS = new String[n_botoes];
    String[] Comando = new String[n_botoes];
    String[] Comandos = new String[n_botoes];
    String[] habilita = new String[n_botoes];
    String[] habilitas = new String[n_botoes];
    CheckBox[] checkbtn = new CheckBox[n_botoes];
    TextView[] txtips = new TextView[n_botoes];
    TextView[] txtsaidas = new TextView[n_botoes];

    private static String Pega_IPS = null;
    private static String COMANDOS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_confugurar_btns );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        editrotulo[0] = (EditText) findViewById( R.id.editrotulo1 );
        editrotulo[1] = (EditText) findViewById( R.id.editrotulo2 );
        editrotulo[2] = (EditText) findViewById( R.id.editrotulo3 );
        editrotulo[3] = (EditText) findViewById( R.id.editrotulo4 );
        editrotulo[4] = (EditText) findViewById( R.id.editrotulo5 );
        editrotulo[5] = (EditText) findViewById( R.id.editrotulo6 );
        editrotulo[6] = (EditText) findViewById( R.id.editrotulo7 );
        editrotulo[7] = (EditText) findViewById( R.id.editrotulo8 );
        editrotulo[8] = (EditText) findViewById( R.id.editrotulo9 );
        editrotulo[9] = (EditText) findViewById( R.id.editrotulo10 );
        editrotulo[10] = (EditText) findViewById( R.id.editrotulo11 );
        editrotulo[11] = (EditText) findViewById( R.id.editrotulo12 );
        editrotulo[12] = (EditText) findViewById( R.id.editrotulo13 );
        editrotulo[13] = (EditText) findViewById( R.id.editrotulo14 );
        editrotulo[14] = (EditText) findViewById( R.id.editrotulo15 );
        editrotulo[15] = (EditText) findViewById( R.id.editrotulo16 );
        editrotulo[16] = (EditText) findViewById( R.id.editrotulo17 );
        editrotulo[17] = (EditText) findViewById( R.id.editrotulo18 );
        editrotulo[18] = (EditText) findViewById( R.id.editrotulo19 );
        editrotulo[19] = (EditText) findViewById( R.id.editrotulo20 );

        editgrupos[0] = (EditText) findViewById( R.id.editG1 );
        editgrupos[1] = (EditText) findViewById( R.id.editG2 );
        editgrupos[2] = (EditText) findViewById( R.id.editG3 );

        txtips[0] = (TextView) findViewById( R.id.txtipbtn1 );
        txtips[1] = (TextView) findViewById( R.id.txtipbtn2 );
        txtips[2] = (TextView) findViewById( R.id.txtipbtn3 );
        txtips[3] = (TextView) findViewById( R.id.txtipbtn4 );
        txtips[4] = (TextView) findViewById( R.id.txtipbtn5 );
        txtips[5] = (TextView) findViewById( R.id.txtipbtn6 );
        txtips[6] = (TextView) findViewById( R.id.txtipbtn7 );
        txtips[7] = (TextView) findViewById( R.id.txtipbtn8 );
        txtips[8] = (TextView) findViewById( R.id.txtipbtn9 );
        txtips[9] = (TextView) findViewById( R.id.txtipbtn10 );
        txtips[10] = (TextView) findViewById( R.id.txtipbtn11 );
        txtips[11] = (TextView) findViewById( R.id.txtipbtn12 );
        txtips[12] = (TextView) findViewById( R.id.txtipbtn13 );
        txtips[13] = (TextView) findViewById( R.id.txtipbtn14 );
        txtips[14] = (TextView) findViewById( R.id.txtipbtn15 );
        txtips[15] = (TextView) findViewById( R.id.txtipbtn16 );
        txtips[16] = (TextView) findViewById( R.id.txtipbtn17 );
        txtips[17] = (TextView) findViewById( R.id.txtipbtn18 );
        txtips[18] = (TextView) findViewById( R.id.txtipbtn19 );
        txtips[19] = (TextView) findViewById( R.id.txtipbtn20 );

        txtsaidas[0] = (TextView) findViewById( R.id.txtsaidabtn1 );
        txtsaidas[1] = (TextView) findViewById( R.id.txtsaidabtn2 );
        txtsaidas[2] = (TextView) findViewById( R.id.txtsaidabtn3 );
        txtsaidas[3] = (TextView) findViewById( R.id.txtsaidabtn4 );
        txtsaidas[4] = (TextView) findViewById( R.id.txtsaidabtn5 );
        txtsaidas[5] = (TextView) findViewById( R.id.txtsaidabtn6 );
        txtsaidas[6] = (TextView) findViewById( R.id.txtsaidabtn7 );
        txtsaidas[7] = (TextView) findViewById( R.id.txtsaidabtn8 );
        txtsaidas[8] = (TextView) findViewById( R.id.txtsaidabtn9 );
        txtsaidas[9] = (TextView) findViewById( R.id.txtsaidabtn10 );
        txtsaidas[10] = (TextView) findViewById( R.id.txtsaidabtn11 );
        txtsaidas[11] = (TextView) findViewById( R.id.txtsaidabtn12 );
        txtsaidas[12] = (TextView) findViewById( R.id.txtsaidabtn13 );
        txtsaidas[13] = (TextView) findViewById( R.id.txtsaidabtn14 );
        txtsaidas[14] = (TextView) findViewById( R.id.txtsaidabtn15 );
        txtsaidas[15] = (TextView) findViewById( R.id.txtsaidabtn16 );
        txtsaidas[16] = (TextView) findViewById( R.id.txtsaidabtn17 );
        txtsaidas[17] = (TextView) findViewById( R.id.txtsaidabtn18 );
        txtsaidas[18] = (TextView) findViewById( R.id.txtsaidabtn19 );
        txtsaidas[19] = (TextView) findViewById( R.id.txtsaidabtn20 );

        checkbtn[0] = (CheckBox) findViewById( R.id.checkbtn1 );
        checkbtn[1] = (CheckBox) findViewById( R.id.checkbtn2 );
        checkbtn[2] = (CheckBox) findViewById( R.id.checkbtn3 );
        checkbtn[3] = (CheckBox) findViewById( R.id.checkbtn4 );
        checkbtn[4] = (CheckBox) findViewById( R.id.checkbtn5 );
        checkbtn[5] = (CheckBox) findViewById( R.id.checkbtn6 );
        checkbtn[6] = (CheckBox) findViewById( R.id.checkbtn7 );
        checkbtn[7] = (CheckBox) findViewById( R.id.checkbtn8 );
        checkbtn[8] = (CheckBox) findViewById( R.id.checkbtn9 );
        checkbtn[9] = (CheckBox) findViewById( R.id.checkbtn10 );
        checkbtn[10] = (CheckBox) findViewById( R.id.checkbtn11 );
        checkbtn[11] = (CheckBox) findViewById( R.id.checkbtn12 );
        checkbtn[12] = (CheckBox) findViewById( R.id.checkbtn13 );
        checkbtn[13] = (CheckBox) findViewById( R.id.checkbtn14 );
        checkbtn[14] = (CheckBox) findViewById( R.id.checkbtn15 );
        checkbtn[15] = (CheckBox) findViewById( R.id.checkbtn16 );
        checkbtn[16] = (CheckBox) findViewById( R.id.checkbtn17 );
        checkbtn[17] = (CheckBox) findViewById( R.id.checkbtn18 );
        checkbtn[18] = (CheckBox) findViewById( R.id.checkbtn19 );
        checkbtn[19] = (CheckBox) findViewById( R.id.checkbtn20 );


        //mostra no edit as atuas edições
        SharedPreferences sharedbotao = getApplicationContext().getSharedPreferences("Config_Btns", Context.MODE_PRIVATE);
        for(int i = 0; i < n_botoes; i++) {
            rotulo[i] = sharedbotao.getString( "rotulo" + i, "Dispositivo "+i );
            IP[i] = sharedbotao.getString("IP"+i, "IP1");
            Comando[i] = sharedbotao.getString("Comando"+i, "S1");
            habilita[i] = sharedbotao.getString("checar"+i, "1");
            editrotulo[i].setText(rotulo[i]);
            txtips[i].setText( IP[i]);
            txtsaidas[i].setText( Comando[i] );

            if (habilita[i].contains( "1" ))

                checkbtn[i].setChecked( true );

            else if (habilita[i].contains( "0" ))

                checkbtn[i].setChecked( false );

        }
        for(int i = 0; i < 3; i++) {
            rotulosgrupos[i] = sharedbotao.getString("rotuloGrupo"+i, "Grupo"+i);
            editgrupos[i].setText( rotulosgrupos[i] );
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
                rotulos[i] = editrotulo[i].getText().toString();
                IPS[i] = txtips[i].getText().toString();
                Comandos[i] = txtsaidas[i].getText().toString();
                //IP_CompretoS[i] = IP_Compreto[i];
                if(checkbtn[i].isChecked()){
                    habilitas[i] = "1";

                }else if(!checkbtn[i].isChecked()){
                    habilitas[i] = "0";

                }
            }

            for(int i = 0; i < 3; i++) {
                rotulosgruposalvar[i] = editgrupos[i].getText().toString();
            }

            String[] salvar = {rotulos[0],rotulos[1],rotulos[2],rotulos[3],rotulos[4]
                    ,rotulos[5],rotulos[6],rotulos[7],rotulos[8],rotulos[9],rotulos[10]
                    ,rotulos[11],rotulos[12],rotulos[13],rotulos[14],rotulos[15]
                    ,rotulos[16],rotulos[17],rotulos[18],rotulos[19],IPS[0],IPS[1]
                    ,IPS[2],IPS[3],IPS[4],IPS[5],IPS[6],IPS[7],IPS[8],IPS[9],IPS[10]
                    ,IPS[11],IPS[12],IPS[13],IPS[14],IPS[15],IPS[16],IPS[17],IPS[18]
                    ,IPS[19],Comandos[0],Comandos[1],Comandos[2],Comandos[3],Comandos[4]
                    ,Comandos[5],Comandos[6],Comandos[7],Comandos[8],Comandos[9],Comandos[10]
                    ,Comandos[11],Comandos[12],Comandos[13],Comandos[14],Comandos[15]
                    ,Comandos[16],Comandos[17],Comandos[18],Comandos[19],habilitas[0]
                    ,habilitas[1],habilitas[2],habilitas[3],habilitas[4],habilitas[5]
                    ,habilitas[6],habilitas[7],habilitas[8],habilitas[9],habilitas[10]
                    ,habilitas[11],habilitas[12],habilitas[13],habilitas[14],habilitas[15]
                    ,habilitas[16],habilitas[17],habilitas[18],habilitas[19],rotulosgruposalvar[0]
                    ,rotulosgruposalvar[1],rotulosgruposalvar[2]
            };

            Salvar_no_sharad(salvar);
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
    public void Salvar_no_sharad (String[] valor){


        SharedPreferences sharedbotao = getApplicationContext().getSharedPreferences("Config_Btns", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedbotao.edit();
        for(int i = 0; i < n_botoes; i++){
            editor.putString("rotulo"+i, valor[i]);
            editor.putString("IP"+i, valor[i+20]);
            editor.putString("Comando"+i, valor[i+40]);
            editor.putString("checar"+i, valor[i+60]);
            for(int e = 0; e < 3; e++){
                editor.putString("rotuloGrupo"+e, valor[e+80]);
            }
        }

        editor.commit();


        //chama a proxima tela
        Intent trocatela=new Intent(Confugurar_btns.this,Activity_Principal.class);
        startActivity(trocatela);
        finish();
        Toast.makeText(getApplicationContext(), "Configuração Salvas:)", Toast.LENGTH_SHORT).show();
    }

    public void clicktxtip1(View view){chamalista(0);}
    public void clicktxtip2(View view){chamalista(1);}
    public void clicktxtip3(View view){chamalista(2);}
    public void clicktxtip4(View view){chamalista(3);}
    public void clicktxtip5(View view){chamalista(4);}
    public void clicktxtip6(View view){chamalista(5);}
    public void clicktxtip7(View view){chamalista(6);}
    public void clicktxtip8(View view){chamalista(7);}
    public void clicktxtip9(View view){chamalista(8);}
    public void clicktxtip10(View view){chamalista(9);}
    public void clicktxtip11(View view){chamalista(10);}
    public void clicktxtip12(View view){chamalista(11);}
    public void clicktxtip13(View view){chamalista(12);}
    public void clicktxtip14(View view){chamalista(13);}
    public void clicktxtip15(View view){chamalista(14);}
    public void clicktxtip16(View view){chamalista(15);}
    public void clicktxtip17(View view){chamalista(16);}
    public void clicktxtip18(View view){chamalista(17);}
    public void clicktxtip19(View view){chamalista(18);}
    public void clicktxtip20(View view){chamalista(19);}

    public void clicksidas1(View view){chamalistasaidas(20);}
    public void clicksidas2(View view){chamalistasaidas(21);}
    public void clicksidas3(View view){chamalistasaidas(22);}
    public void clicksidas4(View view){chamalistasaidas(23);}
    public void clicksidas5(View view){chamalistasaidas(24);}
    public void clicksidas6(View view){chamalistasaidas(25);}
    public void clicksidas7(View view){chamalistasaidas(26);}
    public void clicksidas8(View view){chamalistasaidas(27);}
    public void clicksidas9(View view){chamalistasaidas(28);}
    public void clicksidas10(View view){chamalistasaidas(29);}
    public void clicksidas11(View view){chamalistasaidas(30);}
    public void clicksidas12(View view){chamalistasaidas(31);}
    public void clicksidas13(View view){chamalistasaidas(32);}
    public void clicksidas14(View view){chamalistasaidas(33);}
    public void clicksidas15(View view){chamalistasaidas(34);}
    public void clicksidas16(View view){chamalistasaidas(35);}
    public void clicksidas17(View view){chamalistasaidas(36);}
    public void clicksidas18(View view){chamalistasaidas(37);}
    public void clicksidas19(View view){chamalistasaidas(38);}
    public void clicksidas20(View view){chamalistasaidas(39);}

    public void chamalistasaidas (int request){
        Intent abrelistadeips = new Intent(Confugurar_btns.this,Lista_de_comandos.class);
        startActivityForResult(abrelistadeips, request);
    }
    public void chamalista (int request){
        Intent abrelistadeips = new Intent(Confugurar_btns.this,Lista_de_ips.class);
        startActivityForResult(abrelistadeips, request);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        for(int i = 0; i < n_botoes; i++){
            if(requestCode == i){
                if (resultCode == Activity.RESULT_OK) {//=========Recebe o Nome do IP obtido a atividade anterior============.
                    Pega_IPS = data.getExtras().getString(Lista_de_ips.IP_PASSADO);
                    //IP_mostra[0] = IPS.substring(8);
                    txtips[i].setText( Pega_IPS.substring(0,3));
                    break;
                }
            }

        }
        for(int i = 20; i < n_botoes+20; i++){
            if(requestCode == i){
                if (resultCode == Activity.RESULT_OK) {//=========Recebe o Nome do IP obtido a atividade anterior============.
                    COMANDOS = data.getExtras().getString(Lista_de_comandos.COMANDO_PASSADO);
                    txtsaidas[i-20].setText( COMANDOS );
                    break;
                }
            }

        }
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
        //finish();
        //Toast.makeText(getApplicationContext(), "onPause ", Toast.LENGTH_LONG).show();

    }


}
