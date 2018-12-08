package com.g_automation.flex_home;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Config_Voz extends AppCompatActivity {

    int n_botoes = 20;
    Button[] btn = new Button[n_botoes];
    String[] Texto_Voz = new String[n_botoes];
    String[] Texto_VozS = new String[n_botoes];
    String[] Texto_VozGruposS = new String[n_botoes];
    String[] habilita = new String[n_botoes];
    String[] Fala_grupos = new String[3];
    Button[] btng = new Button[3];
    String[] habcrupos = new String[3];




    int comandos = 0;
    int in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_config_voz );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

//        int width = 0;
//        int height = 0;
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( width, height);


        btn[0] = (Button) findViewById( R.id.btnl );
        btn[1] = (Button) findViewById( R.id.btn2 );
        btn[2] = (Button) findViewById( R.id.btn3 );
        btn[3] = (Button) findViewById( R.id.btn4 );
        btn[4] = (Button) findViewById( R.id.btn5 );
        btn[5] = (Button) findViewById( R.id.btn6 );
        btn[6] = (Button) findViewById( R.id.btn7 );
        btn[7] = (Button) findViewById( R.id.btn8 );
        btn[8] = (Button) findViewById( R.id.btn9 );
        btn[9] = (Button) findViewById( R.id.btnl0 );
        btn[10] = (Button) findViewById( R.id.btnl1 );
        btn[11] = (Button) findViewById( R.id.btnl2 );
        btn[12] = (Button) findViewById( R.id.btnl3 );
        btn[13] = (Button) findViewById( R.id.btnl4 );
        btn[14] = (Button) findViewById( R.id.btnl5 );
        btn[15] = (Button) findViewById( R.id.btnl6 );
        btn[16] = (Button) findViewById( R.id.btnl7 );
        btn[17] = (Button) findViewById( R.id.btnl8 );
        btn[18] = (Button) findViewById( R.id.btnl9 );
        btn[19] = (Button) findViewById( R.id.btn20 );

        btng[0] = (Button) findViewById(R.id.btng1);
        btng[1] = (Button) findViewById(R.id.btng2);
        btng[2] = (Button) findViewById(R.id.btng3);

        //mostra no edit as atuas edições
        SharedPreferences configura_voz = getApplicationContext().getSharedPreferences( "Config_voz", Context.MODE_PRIVATE );
        for (int i = 0; i < n_botoes; i++) {
            Texto_Voz[i] = configura_voz.getString( "Texto_voz" + i, "Fala" + i );
            btn[i].setText( Texto_Voz[i] );
        }
        for(int i = 0; i < 3; i++) {
            Fala_grupos[i] = configura_voz.getString("Texto_Vos_Grupo"+i, "Grupo"+i);
            btng[i].setText( Fala_grupos[i] );
        }

        //mostra no edit as atuas edições
        SharedPreferences sharedbotao = getApplicationContext().getSharedPreferences("Config_Btns", Context.MODE_PRIVATE);
        for(int i = 0; i < n_botoes; i++) {
             habilita[i] = sharedbotao.getString("checar"+i, "1");

            if (habilita[i].contains( "1" ))

                btn[i].setVisibility(View.VISIBLE);

            else if (habilita[i].contains( "0" ))
               // btn[i].setLayoutParams( lp );
                btn[i].setVisibility(View.GONE);
        }
//        for(int i = 0; i < 3; i++) {
//            rotulosgrupos[i] = sharedbotao.getString("rotuloGrupo"+i, "Grupo"+i);
//            btng[i].setText( rotulosgrupos[i] );
//        }

        //mostra no edit as atuas edições
        SharedPreferences Config_grupos = getApplicationContext().getSharedPreferences("Config_grupos", Context.MODE_PRIVATE);
        for(int i = 0; i < 3; i++) {
            habcrupos[i] = Config_grupos.getString("gruposhab"+i, "1");
            if (habcrupos[i].contains( "1" ))
                btng[i].setVisibility(View.VISIBLE);
            else if (habcrupos[i].contains( "0" ))
               // btng[i].setLayoutParams( lp );
                btng[i].setVisibility(View.GONE);
        }



 //====================================================================
            btn[0].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(0);
            }
            } );
            btn[1].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(1);

                }
            } );
            btn[2].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(2);

                }
            } );
            btn[3].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(3);

                }
            } );
            btn[4].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(4);

                }
            } );
            btn[5].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(5);

                }
            } );
            btn[6].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(6);

                }
            } );
            btn[7].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(7);

                }
            } );
            btn[8].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(8);

                }
            } );
            btn[9].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(9);

                }
            } );
            btn[10].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(10);

                }
            } );
            btn[11].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(11);

                }
            } );
            btn[12].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(12);

                }
            } );
            btn[13].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(13);

                }
            } );
            btn[14].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(14);

                }
            } );
            btn[15].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(15);

                }
            } );
            btn[16].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(16);

                }
            } );
            btn[17].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(17);

                }
            } );
            btn[18].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(18);

                }
            } );
            btn[19].setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comandovoz(19);

                }
            } );
        btng[0].setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comandovoz(20);

            }
        } );
        btng[1].setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comandovoz(21);

            }
        } );
        btng[2].setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comandovoz(22);

            }
        } );
//=================================================================================================

    }
    public void comandovoz (int comando){

        comandos = comando;

        Intent intent = new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        try {
                 startActivityForResult( intent, comando );

        } catch (ActivityNotFoundException a) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Opps! Seu dispositivo não suporta fala para texto",
                    Toast.LENGTH_SHORT);
            t.show();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        for(int i = 0; i < n_botoes+3; i++){
            if(requestCode == i){
                if (resultCode == Activity.RESULT_OK) {
                    ArrayList<String> text = data.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS );
                    //IP_mostra[0] = IPS.substring(8);
                    if(i < n_botoes) {
                        btn[i].setText( text.get( 0 ) );
                    }else{
                        btng[i-20].setText( text.get(0) );
                    }

                    break;
                }
            }

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
            for(int i = 0; i < n_botoes+3; i++) {
                if(i < n_botoes) {
                    Texto_VozS[i] = btn[i].getText().toString();
                }else{
                    Texto_VozGruposS[i-20] = btng[i-20].getText().toString();
                }

            }
            String[] salvar = {Texto_VozS[0],Texto_VozS[1],Texto_VozS[2],Texto_VozS[3],Texto_VozS[4]
                    ,Texto_VozS[5],Texto_VozS[6],Texto_VozS[7],Texto_VozS[8],Texto_VozS[9],Texto_VozS[10]
                    ,Texto_VozS[11],Texto_VozS[12],Texto_VozS[13],Texto_VozS[14],Texto_VozS[15]
                    ,Texto_VozS[16],Texto_VozS[17],Texto_VozS[18],Texto_VozS[19],Texto_VozGruposS[0]
                    ,Texto_VozGruposS[1],Texto_VozGruposS[2]
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

        SharedPreferences configura_voz = getApplicationContext().getSharedPreferences("Config_voz", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = configura_voz.edit();
        for(int i = 0; i < n_botoes+3; i++){
            if(i < n_botoes) {
                editor.putString( "Texto_voz" + i, valor[i] );
            }else {
                editor.putString( "Texto_Vos_Grupo0", valor[20] );
                editor.putString( "Texto_Vos_Grupo1", valor[21] );
                editor.putString( "Texto_Vos_Grupo2", valor[22] );
            }
        }

        editor.commit();

        //chama a proxima tela
        Intent configurabtns = new Intent( Activity_Config_Voz.this, Activity_Principal.class );
        startActivity( configurabtns );
        finish();
        Toast.makeText(getApplicationContext(), "Configuração Salvas:)", Toast.LENGTH_SHORT).show();
    }

       //===============================================================================================
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
        //Toast.makeText(getApplicationContext(), "onPause ", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(getApplicationContext(), "onRestart ", Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        //Toast.makeText(getApplicationContext(), "onDestroy ", Toast.LENGTH_LONG).show();
    }


}
