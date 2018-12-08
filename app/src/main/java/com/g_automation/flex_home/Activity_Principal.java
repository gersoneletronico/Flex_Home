package com.g_automation.flex_home;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.os.Message;
import android.os.SystemClock;
import android.speech.RecognizerIntent;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;
import java.util.ArrayList;
public class Activity_Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SensorEventListener{

    int n_botoes = 20;
    int n_ips = 10;

    private ProgressDialog progress;
    boolean volormais = false;
    boolean volormenos = false;
    int conta = 0;
    boolean flag[] = new boolean[23];
    boolean estado1[] = new boolean[n_botoes];
    boolean estado2[] = new boolean[n_botoes];
    boolean estado3[] = new boolean[n_botoes];
    String Comando[] = new String[n_botoes];
    String IP[] = new String[n_botoes];
    String[] IP_do_btn = new String[n_botoes];
    String[] IP_Compreto = new String[n_botoes];
    Button[] btn = new Button[n_botoes];
    Button[] btng = new Button[3];
    SeekBar[] dimmer = new SeekBar[n_botoes];
    LinearLayout[] laydimmer = new LinearLayout[n_botoes];
    String[] rotulo = new String[n_botoes];
    String[] habilita = new String[n_botoes];
    String[] habita = new String[n_ips];
    Boolean[] IP_HAB = new Boolean[n_ips];
    String[] Texto_Voz = new String[n_botoes];
    String[] habG1 = new String[n_botoes];
    String[] habG2 = new String[n_botoes];
    String[] habG3 = new String[n_botoes];
    String[] checkGrupo1 = new String[n_botoes];
    String[] checkGrupo2 = new String[n_botoes];
    String[] checkGrupo3 = new String[n_botoes];
    String[] rotulosgrupos = new String[3];
    String[] habcrupos = new String[3];
    String[] Fala_grupos = new String[3];
    boolean flagacelerometro = false;


    int contaip = 0;
    int chamaip[] = new int[n_botoes];

    final Handler handler = new Handler();
    private SensorManager sensorManager;
    private Sensor acelerometro;


    String ipenviadonomomento = "";

    String Modos;
    TTSManager ttsManager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );

        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        //instancia da classe sensormanager através do metodo abaixo
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //definição do tipo de sensor que sera utilizado
        acelerometro = sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER);

        //int width = 0;
        //int height = 0;
        //LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( width, height);

        btn[0] = findViewById(R.id.btnl);
        btn[1] = findViewById(R.id.btn2);
        btn[2] = findViewById(R.id.btn3);
        btn[3] = findViewById(R.id.btn4);
        btn[4] = findViewById(R.id.btn5);
        btn[5] = findViewById(R.id.btn6);
        btn[6] = findViewById(R.id.btn7);
        btn[7] = findViewById(R.id.btn8);
        btn[8] = findViewById(R.id.btn9);
        btn[9] = findViewById(R.id.btnl0);
        btn[10] = findViewById(R.id.btnl1);
        btn[11] = findViewById(R.id.btnl2);
        btn[12] = findViewById(R.id.btnl3);
        btn[13] = findViewById(R.id.btnl4);
        btn[14] = findViewById(R.id.btnl5);
        btn[15] = findViewById(R.id.btnl6);
        btn[16] = findViewById(R.id.btnl7);
        btn[17] = findViewById(R.id.btnl8);
        btn[18] = findViewById(R.id.btnl9);
        btn[19] = findViewById(R.id.btn20);

        btng[0] = findViewById(R.id.btng1);
        btng[1] = findViewById(R.id.btng2);
        btng[2] = findViewById(R.id.btng3);

        dimmer[0] = findViewById(R.id.dimmer1);
        dimmer[1] = findViewById(R.id.dimmer2);
        dimmer[2] = findViewById(R.id.dimmer3);
        dimmer[3] = findViewById(R.id.dimmer4);

        laydimmer[0] = findViewById( R.id.laydimmer1 );
        laydimmer[1] = findViewById( R.id.laydimmer2 );
        laydimmer[2] = findViewById( R.id.laydimmer3 );
        laydimmer[3] = findViewById( R.id.laydimmer4 );


        //mostra no edit as atuas edições
        SharedPreferences sharedbotao = getApplicationContext().getSharedPreferences("Config_Btns", Context.MODE_PRIVATE);
        for(int i = 0; i < n_botoes; i++) {
            rotulo[i] = sharedbotao.getString( "rotulo" + i, "Dispositivo "+i );
            IP[i] = sharedbotao.getString("IP"+i, "IP1:http://192.168.1.1");
            Comando[i] = sharedbotao.getString("Comando"+i, "S1");
            habilita[i] = sharedbotao.getString("checar"+i, "1");
            btn[i].setText( rotulo[i] );
            if (habilita[i].contains( "1" ))

                btn[i].setVisibility(View.VISIBLE);

            else if (habilita[i].contains( "0" ))
                btn[i].setVisibility(View.GONE);
                //btn[i].setLayoutParams( lp );

        }
        for(int i = 0; i < 3; i++) {
            rotulosgrupos[i] = sharedbotao.getString("rotuloGrupo"+i, "Grupo"+i);
            btng[i].setText( rotulosgrupos[i] );
        }
        //mostra no edit as atuas edições
        SharedPreferences sharedservidor = getApplicationContext().getSharedPreferences("Config_IPS", Context.MODE_PRIVATE);
        for(int i = 0; i < n_ips; i++) {
            IP_Compreto[i] = sharedservidor.getString( "IPS" + i, "http://192.168.1.1");
            habita[i] = sharedservidor.getString("checkIPS" + i, "0");
            if (habita[i].contains( "1" ))
                IP_HAB[i] = true;
            else if (habita[i].contains( "0" ))
                IP_HAB[i] = false;
        }
        for(int i = 0; i < n_botoes; i++) {
            for(int r = 1; r < n_ips+1; r++) {
                if (IP[i].contains( "IP"+r )) {
                    IP_do_btn[i] = IP_Compreto[r-1];
                    chamaip[i] = r-1;

                }
            }
        }
        //mostra no edit as atuas edições
        SharedPreferences configura_voz = getApplicationContext().getSharedPreferences( "Config_voz", Context.MODE_PRIVATE );
        for (int i = 0; i < n_botoes; i++) {
            Texto_Voz[i] = configura_voz.getString( "Texto_voz" + i, "Fala" + i );
        }
        for(int i = 0; i < 3; i++) {
            Fala_grupos[i] = configura_voz.getString("Texto_Vos_Grupo"+i, "Grupo"+i);
        }
        //mostra no edit as atuas edições
        SharedPreferences Config_grupos = getApplicationContext().getSharedPreferences("Config_grupos", Context.MODE_PRIVATE);
        for(int i = 0; i < 3; i++) {
            habcrupos[i] = Config_grupos.getString("gruposhab"+i, "1");
            if (habcrupos[i].contains( "1" ))
                btng[i].setVisibility(View.VISIBLE);
            else if (habcrupos[i].contains( "0" ))
                //btng[i].setLayoutParams( lp );
                btng[i].setVisibility(View.GONE);
        }
        for(int i = 0; i < n_botoes; i++) {
            habG1[i] = Config_grupos.getString("abG1"+i, "0");
            habG2[i] = Config_grupos.getString("abG2"+i, "0");
            habG3[i] = Config_grupos.getString("abG3"+i, "0");

            if (habG1[i].contains( "1" )) {
                checkGrupo1[i] = "1";
            }else if (habG1[i].contains( "0" )) {
                checkGrupo1[i] = "0";
            }if (habG2[i].contains( "1" )) {
                checkGrupo2[i] = "1";
            }else if (habG2[i].contains( "0" )) {
                checkGrupo2[i] = "0";
            }if (habG3[i].contains( "1" )) {
                checkGrupo3[i] = "1";
            }else if (habG3[i].contains( "0" )){
                checkGrupo3[i] = "0";
                }

        }
        SharedPreferences modosdeacionamento = getApplicationContext().getSharedPreferences("modosdeacionamento", Context.MODE_PRIVATE);
        Modos = modosdeacionamento.getString( "Modo", "Modo 1" );

      //====================================================================
        btng[0].setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresso (0);
                imagensBTNGrupos(1, Modos);
                //comandovoz(); // Foi pra testes
            }
        } );
        btng[1].setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresso (1);
                imagensBTNGrupos(2, Modos);
            }
        } );
        btng[2].setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progresso (2);
                imagensBTNGrupos(3, Modos);
            }
        } );

        btn[0].setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs( 0, 1 );
                mesagem(IP_do_btn[0],Comando[0],"");
                contaip = chamaip[0];
                //laydimmer[0].setVisibility( View.GONE );
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        } );
        btn[0].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                laydimmer[0].setVisibility( View.VISIBLE );
                return false;
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,2);
                mesagem(IP_do_btn[1],Comando[1], "");
                contaip = chamaip[1];
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[1].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                laydimmer[1].setVisibility( View.VISIBLE );
                return false;
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,3);
                mesagem(IP_do_btn[2],Comando[2], "");
                contaip = chamaip[2];
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[2].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                laydimmer[2].setVisibility( View.VISIBLE );
                return false;
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,4);
                mesagem(IP_do_btn[3],Comando[3], "");
                contaip = chamaip[3];
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[3].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                laydimmer[3].setVisibility( View.VISIBLE );
                return false;
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,5);
                mesagem(IP_do_btn[4],Comando[4], "");
                contaip = chamaip[4];
                //Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,6);
                mesagem(IP_do_btn[5],Comando[5], "");
                contaip = chamaip[5];
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,7);
                mesagem(IP_do_btn[6],Comando[6], "");
                contaip = chamaip[6];
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,8);
                mesagem(IP_do_btn[7],Comando[7], "");
                contaip = chamaip[7];
             //   Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,9);
                mesagem(IP_do_btn[8],Comando[8], "");
                contaip = chamaip[8];
             //   Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,10);
                mesagem(IP_do_btn[9],Comando[9], "");
                contaip = chamaip[9];
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,11);
                mesagem(IP_do_btn[10],Comando[10], "");
                contaip = chamaip[10];
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,12);
                mesagem(IP_do_btn[11],Comando[11], "");
                contaip = chamaip[11];
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,13);
                mesagem(IP_do_btn[12],Comando[12], "");
                contaip = chamaip[12];
              //  Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,14);
                mesagem(IP_do_btn[13],Comando[13], "");
                contaip = chamaip[13];
              //  Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,15);
                mesagem(IP_do_btn[14],Comando[14], "");
               // Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,16);
                mesagem(IP_do_btn[15],Comando[15], "");
                contaip = chamaip[15];
              //  Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,17);
                mesagem(IP_do_btn[16],Comando[16], "");
                contaip = chamaip[16];
             //   Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,18);
                mesagem(IP_do_btn[17],Comando[17], "");
                contaip = chamaip[17];
              //  Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,19);
                mesagem(IP_do_btn[18],Comando[18], "");
                contaip = chamaip[18];
              //  Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });
        btn[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagensBTNs(0,20);
                mesagem(IP_do_btn[19],Comando[19], "");
                contaip = chamaip[19];
              //  Toast.makeText(getApplicationContext(), String.valueOf( contaip ), Toast.LENGTH_LONG).show();
            }
        });

        dimmer[0].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                {
                    //imagensBTNs(0,1);
                    mesagem(IP_do_btn[0],Comando[0], "p"+String.valueOf(progress));
                    contaip = chamaip[0];
                    //valor.setText(String.valueOf(progress));
                    //enviamensagembrue(String.valueOf(progress));
                    Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_SHORT).show();

                }
                //Toast.makeText(getApplicationContext(), "onProgressChanged", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "onStartTrackingTouch", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               // Toast.makeText(getApplicationContext(), "onStopTrackingTouch", Toast.LENGTH_LONG).show();
            }
        });
        dimmer[1].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                {
                    //imagensBTNs(0,1);
                    mesagem(IP_do_btn[1],Comando[1], "p"+String.valueOf(progress));
                    contaip = chamaip[1];
                    //valor.setText(String.valueOf(progress));
                    //enviamensagembrue(String.valueOf(progress));
                    Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_SHORT).show();

                }
                //Toast.makeText(getApplicationContext(), "onProgressChanged", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "onStartTrackingTouch", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Toast.makeText(getApplicationContext(), "onStopTrackingTouch", Toast.LENGTH_LONG).show();
            }
        });
        dimmer[2].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                {
                    //imagensBTNs(0,1);
                    mesagem(IP_do_btn[2],Comando[2], "p"+String.valueOf(progress));
                    contaip = chamaip[2];
                    //valor.setText(String.valueOf(progress));
                    //enviamensagembrue(String.valueOf(progress));
                    Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_SHORT).show();

                }
                //Toast.makeText(getApplicationContext(), "onProgressChanged", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "onStartTrackingTouch", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Toast.makeText(getApplicationContext(), "onStopTrackingTouch", Toast.LENGTH_LONG).show();
            }
        });
        dimmer[3].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                {
                    //imagensBTNs(0,1);
                    mesagem(IP_do_btn[3],Comando[3], "p"+String.valueOf(progress));
                    contaip = chamaip[3];
                    //valor.setText(String.valueOf(progress));
                    //enviamensagembrue(String.valueOf(progress));
                    Toast.makeText(getApplicationContext(), String.valueOf(progress), Toast.LENGTH_SHORT).show();

                }
                //Toast.makeText(getApplicationContext(), "onProgressChanged", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "onStartTrackingTouch", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Toast.makeText(getApplicationContext(), "onStopTrackingTouch", Toast.LENGTH_LONG).show();
            }
        });

        ttsManager=new TTSManager();
        ttsManager.init(this);

//=================================================================================================
    }// Fim do On Create

    //=================Executa toda vez que uma activity e alterada========================
    @Override
    protected void onResume() {
        super.onResume();
      // Parametro SENSOR_DELAY_NORMAL define a velocidade da captura das informações
        sensorManager.registerListener( this,acelerometro,SensorManager.SENSOR_DELAY_NORMAL);
        handler.postDelayed(atualizaStatus, 0);
       // Toast.makeText(getApplicationContext(), "onResume ", Toast.LENGTH_LONG).show();
    }
    //============Método que atualiza status da tela======================
    private Runnable atualizaStatus = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, 1500);
            conta = 0;
            if(contaip < n_ips){ // So envia mensgem para os ips habilitados
                if(IP_HAB[contaip]) {
                    //SystemClock.sleep(10000 );
                    mesagem( IP_Compreto[contaip], "" , "");
                }
                contaip++;
            }else{
                contaip = 0;
            }
        }
    };
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.activity__principal, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.grupo1) {


            return true;
        }
        if (id == R.id.grupo2) {

            return true;
        }
        if (id == R.id.grupo3) {

            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.config_modulos) {
            //chama a proxima tela
            Intent configmodulos=new Intent(Activity_Principal.this,Config_Modulos.class);
            startActivity(configmodulos);
            finish();


        }else if (id == R.id.Configuracaobtns) {
            //chama a proxima tela
            Intent configurabtns=new Intent(Activity_Principal.this,Confugurar_btns.class);
            startActivity(configurabtns);
            finish();


        } else if (id == R.id.Config_IPs) {
            //chama a proxima tela
            Intent configuraserv=new Intent(Activity_Principal.this,Configurar_servidores.class);
            startActivity(configuraserv);
            finish();


        } else if (id == R.id.config_voz) {
            //chama a proxima tela
            Intent configuraserv=new Intent(Activity_Principal.this,Activity_Config_Voz.class);
            startActivity(configuraserv);
            finish();

        } else if (id == R.id.config_grupos) {
            //chama a proxima tela
            Intent configuraserv=new Intent(Activity_Principal.this,Activity_Config_Grupos.class);
            startActivity(configuraserv);
            finish();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }

    public void imagensBTNGrupos (int btngrupo, String modos){
        if(btngrupo == 1) {
            if (!flag[20]) { // No primeiro click
            for (int i = 0; i < n_botoes; i++) {
                if (habilita[i].contains( "1" )) { // se o botão estiver habilitado na tela de config
                        estado1[i] = flag[i];      // Memoriza o estados dos boatões
                    }
                }
            }
            for (int i = 0; i < n_botoes; i++) {
                if (habilita[i].contains( "1" )) { // se o botão estiver habilitado na tela de config
                    //SystemClock.sleep(5000 );
                    if (checkGrupo1[i].contains( "1" ) && !flag[20]) { // Se estiver ativado no crupo end for o primeiro click
                        if (!flag[i]) { // Se o botão estiver em OFF
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    } else if (checkGrupo1[i].contains( "0" ) && !flag[20] && modos.contains( "Modo 1" ) || modos.contains( "Modo 3" )) {
                        if (flag[i]) { // Se o botão estiver em ON
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    }
                    // ========================= No proximo click ================================================
                    if (estado1[i] && flag[20] && modos.contains( "Modo 1" )) {
                        if (!flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    }else if (!estado1[i] && flag[20] && modos.contains( "Modo 1" )) {
                        if (flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i], "" );
                        }
                    }
                    if (checkGrupo1[i].contains( "1" ) && flag[20] && modos.contains( "Modo 2" )) {
                        if (flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    } else if (checkGrupo1[i].contains( "0" ) && flag[20] &&  modos.contains( "Modo 3" )) {
                        if (!flag[i]) { // Se o botão estiver em OFF
                            mesagem( IP_do_btn[i], Comando[i], "" );

                        }
                    }

                }
            } // Fim do for
            if (flag[20]) {
                Drawable draw = getResources().getDrawable( R.mipmap.btn_off );
                btng[0].setCompoundDrawablesWithIntrinsicBounds( null, null, null, draw );
                flag[20] = false;
                contaip = chamaip[0];
            } else {
                Drawable draw = getResources().getDrawable( R.mipmap.btn_on );
                btng[0].setCompoundDrawablesWithIntrinsicBounds( null, null, null, draw );
                flag[20] = true;
                contaip = chamaip[0];
            }
            contaip = chamaip[0];
        }
        if(btngrupo == 2) {
            if (!flag[21]) {
                for (int i = 0; i < n_botoes; i++) {
                    if (habilita[i].contains( "1" )) { // se o botão estiver habilitado na tela de config
                        estado2[i] = flag[i];  // Memoriza o estados dos boatões
                    }
                }
            }
            for (int i = 0; i < n_botoes; i++) {
                if (habilita[i].contains( "1" )) { // se o botão estiver habilitado na tela de config
                    //SystemClock.sleep(5000 );
                    if (checkGrupo2[i].contains( "1" ) && !flag[21]) { // Se estiver ativado no crupo end for o primeiro click
                        if (!flag[i]) { // Se o botão estiver em OFF
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    } else if (checkGrupo2[i].contains( "0" ) && !flag[21] && modos.contains( "Modo 1" ) || modos.contains( "Modo 3" )) {
                        if (flag[i]) { // Se o botão estiver em ON
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    }
                    // ========================= No proximo click ================================================
                    if (estado2[i] && flag[21] && modos.contains( "Modo 1" )) {
                        if (!flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    }else if (!estado2[i] && flag[21] && modos.contains( "Modo 1" )) {
                        if (flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i], "" );
                        }
                    }
                    if (checkGrupo2[i].contains( "1" ) && flag[21] && modos.contains( "Modo 2" )) {
                        if (flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    } else if (checkGrupo2[i].contains( "0" ) && flag[21] &&  modos.contains( "Modo 3" )) {
                        if (!flag[i]) { // Se o botão estiver em OFF
                            mesagem( IP_do_btn[i], Comando[i], "" );

                        }
                    }

                }
            } // Fim do for
            if(flag[21]){
                Drawable draw = getResources().getDrawable( R.mipmap.btn_off );
                btng[1].setCompoundDrawablesWithIntrinsicBounds( null, null, null, draw );
                flag[21] = false;
                contaip = chamaip[0];
            }else{
                Drawable draw = getResources().getDrawable( R.mipmap.btn_on );
                btng[1].setCompoundDrawablesWithIntrinsicBounds( null, null, null, draw );
                flag[21] = true;
                contaip = chamaip[0];
            }
        }
        if(btngrupo == 3) {
            if (!flag[22]) {
                for (int i = 0; i < n_botoes; i++) {
                    if (habilita[i].contains( "1" )) { // se o botão estiver habilitado na tela de config
                        estado3[i] = flag[i];  // Memoriza o estados dos boatões
                    }
                }
            }
            for (int i = 0; i < n_botoes; i++) {
                if (habilita[i].contains( "1" )) { // se o botão estiver habilitado na tela de config
                    //SystemClock.sleep(5000 );
                    if (checkGrupo3[i].contains( "1" ) && !flag[22]) { // Se estiver ativado no crupo end for o primeiro click
                        if (!flag[i]) { // Se o botão estiver em OFF
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    } else if (checkGrupo3[i].contains( "0" ) && !flag[22] && modos.contains( "Modo 1" ) || modos.contains( "Modo 3" )) {
                        if (flag[i]) { // Se o botão estiver em ON
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    }
                    // ========================= No proximo click ================================================
                    if (estado3[i] && flag[22] && modos.contains( "Modo 1" )) {
                        if (!flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    }else if (!estado3[i] && flag[22] && modos.contains( "Modo 1" )) {
                        if (flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i], "" );
                        }
                    }
                    if (checkGrupo3[i].contains( "1" ) && flag[22] && modos.contains( "Modo 2" )) {
                        if (flag[i]) {
                            mesagem( IP_do_btn[i], Comando[i] , "");
                        }
                    } else if (checkGrupo3[i].contains( "0" ) && flag[22] &&  modos.contains( "Modo 3" )) {
                        if (!flag[i]) { // Se o botão estiver em OFF
                            mesagem( IP_do_btn[i], Comando[i], "" );

                        }
                    }

                }
            } // Fim do for
            if(flag[22]){
                Drawable draw = getResources().getDrawable( R.mipmap.btn_off );
                btng[2].setCompoundDrawablesWithIntrinsicBounds( null, null, null, draw );
                flag[22] = false;
                contaip = chamaip[0];
            }else{
                Drawable draw = getResources().getDrawable( R.mipmap.btn_on );
                btng[2].setCompoundDrawablesWithIntrinsicBounds( null, null, null, draw );
                flag[22] = true;
                contaip = chamaip[0];
            }
        }
    } // Fim imagensBTNGrupos

    // Solicitação ou envio de mansagem para o servidores
    public void mesagem(String IPdoBotao, String comando, String gradativo) {

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService( Context.CONNECTIVITY_SERVICE );

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        String url = "";


        url = IPdoBotao + "/?f=" + comando + "/" +gradativo;
        //Toast.makeText(getApplicationContext(), contaip+url, Toast.LENGTH_LONG).show();

         if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadWebpageTask().execute(url);

        } else {
            //Toast.makeText(getApplicationContext(), "Sem Conexão -;)", Toast.LENGTH_SHORT).show();

        }

        ipenviadonomomento = IPdoBotao;
    }

    //========================Atualizar Status na tela===============================================
    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            Conexao conexao = new Conexao();

            return conexao.GetArduino(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            if (result != null) {
//               String[] dados_recebidos = result.split("#");
//                Toast.makeText(getApplicationContext(), dados_recebidos[7], Toast.LENGTH_SHORT).show();
                for(int i = 0; i < 20; i++) {
                    if (result.contains( Comando[i] + " " + IP_do_btn[i] + " = ON" )) {
                        imagensBTNs( 1, i+1 );
                    } else if (result.contains( Comando[i] + " " + IP_do_btn[i] + " = OFF" )){
                        imagensBTNs( 2, i+1 );
                    }
                }
                //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            } else {
                 Toast.makeText(getApplicationContext(),ipenviadonomomento+" Sem Conexão", Toast.LENGTH_SHORT).show();
                //onRestart();
                ipenviadonomomento = "";

          }

        }
    }
    //===============================================================================================
    //====================================Mudança de estado do botões ===============================
    public void imagensBTNs (int estado, int btns){// Estado 0 automatico, 1 ligado, 2 desligado
        for(int i = 0; i < 20; i++)
        if(btns == i+1){
            if (flag[i] == false && estado == 0 || estado == 1) {
                    Drawable draw = getResources().getDrawable( R.mipmap.btn_on );
                    btn[i].setCompoundDrawablesWithIntrinsicBounds( null, null, draw, null );
                    flag[i] = true;
                } else if(estado == 2 || estado == 0){
                    Drawable draw = getResources().getDrawable( R.mipmap.btn_off );
                    btn[i].setCompoundDrawablesWithIntrinsicBounds( null, null, draw, null );
                    flag[i] = false;
                }
                break;
        }
    }
    //===============================================================================================
    // Acionado se houver mudança na precisão do sensor do acelerometro
    public void onAccuracyChanged(Sensor sensor, int accuracy){ }
    //Acionado sempre que tiver mudança na posição do dispositivo
    public void onSensorChanged(SensorEvent event){
       Float x = event.values[0];
       // Float y = event.values[1];
       // Float z = event.values[2];
        int valor = x.intValue();
        //btn[0].setText( String.valueOf( conta ) );

        if(!flagacelerometro) {

              if (valor > 1) {
                volormais = true;
              }
              if (valor < -1) {
                volormenos = true;
              }
              if (volormais && volormenos) {
                conta++;
                volormais = false;
                volormenos = false;
              }
              if (conta > 2) {
                  conta = 0;
                  comandovoz();
                  flagacelerometro = true;
              }

        }

        //btn[0].setText(Integer.toString(conta) +" b "+valor);

    }
    private void comandovoz (){

        Intent intent = new Intent( RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        try {
            startActivityForResult( intent, 0 );

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
        String[] textofaldoligar = new String[20];
        String[] textofaldodesligar = new String[20];
        String[] textofaldoligarvoz = new String[20];
        String[] textofaldodesligarvoz = new String[20];
        String[] textofaldoligarG = new String[3];
        String[] textofaldodesligarG = new String[3];
        String[] textofaldoligarvozG = new String[3];
        String[] textofaldodesligarvozG = new String[3];
        boolean entretrava =  false;
        boolean entretravaG = false;
            if(requestCode == 0){
                if (resultCode == Activity.RESULT_OK) {//=========Recebe o Nome do IP obtido a atividade anterior============.
                    ArrayList<String> text = data.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS );
//                    for(int i = 0; i < 3; i++){
//                        if(Fala_grupos[i].equals(text.get(0)) || rotulosgrupos[i].equals(text.get(0))) {
//                            imagensBTNGrupos(i+1, Modos);
//                            //Toast.makeText(getApplicationContext(), "Ok >"+Fala_grupos[i]+" ou "+rotulosgrupos[i]+"< Corresponde", Toast.LENGTH_SHORT).show();
//                            break;
//                        }else if( i == 2 ){
//                            //Toast.makeText(getApplicationContext(), "Você falou >"+text.get(0)+"< Não Corresponde a nem uma fala ", Toast.LENGTH_SHORT).show();
//                        }
//                    }
                    for(int i = 0; i < 3; i++){
                        textofaldoligarG[i] = "ligar grupo "+Fala_grupos[i];
                        textofaldodesligarG[i] = "desligar grupo "+Fala_grupos[i];
                        textofaldoligarvozG[i] = "ligar grupo "+rotulosgrupos[i];
                        textofaldodesligarvozG[i] = "desligar grupo "+rotulosgrupos[i];

                        if(textofaldoligarG[i].equalsIgnoreCase(text.get(0)) || textofaldodesligarG[i].equalsIgnoreCase(text.get(0)) || textofaldoligarvozG[i].equalsIgnoreCase(text.get(0)) || textofaldodesligarvozG[i].equalsIgnoreCase(text.get(0))) {
                            if(text.get(0).toLowerCase().contains( "desl" ) || text.get(0).toUpperCase().contains( "Desl" )) {
                                if (flag[20+i]) { // Se o botão estiver em OFF
                                    progresso (i);
                                    imagensBTNGrupos(i+1, Modos);
                                    ttsManager.initQueue( " OK, grupo," + rotulosgrupos[i] + ", Desligado" );
                                } else {
                                    ttsManager.initQueue( "desculpa,,, grupo,"+rotulosgrupos[i] + ",  Já, está Desligado" );
                                }
                            }else
                                /*if(text.get(0).toLowerCase().contains( "ligar" ) || text.get(0).toUpperCase().contains( "Ligar" ))*/ {
                                if (!flag[20+i]) { // Se o botão estiver em OFF
                                    progresso (i);
                                    imagensBTNGrupos(i+1, Modos);
                                    ttsManager.initQueue( " OK, grupo," + rotulosgrupos[i] + ", Ligado" );
                                } else {
                                    ttsManager.initQueue( "desculpa,,, grupo,"+rotulosgrupos[i] + ", Já, está Ligado" );
                                }
                            }


                            //Toast.makeText(getApplicationContext(), "Ok >"+Texto_Voz[i]+" ou "+rotulo[i]+"< Corresponde", Toast.LENGTH_SHORT).show();
                            entretrava = true;
                            break;
                        }else if( i == 2 ){

                            // Toast.makeText(getApplicationContext(), "Você falou >"+text.get(0)+"< Não Corresponde a nem uma fala ", Toast.LENGTH_SHORT).show();
                            if(!entretravaG) {
                                ttsManager.initQueue( "Desculpa, Voce falou,,, grupo, " + text.get( 0 ) + ", que não Corresponde a nem um comando de voz" );
                            }
                            //Toast.makeText(getApplicationContext(), textofaldoligarvozG[0]+text.get(0), Toast.LENGTH_LONG).show();

                        }

                    }
                    for(int i = 0; i < 20; i++){
                        textofaldoligar[i] = "ligar "+rotulo[i];
                        textofaldodesligar[i] = "desligar "+rotulo[i];
                        textofaldoligarvoz[i] = "ligar "+Texto_Voz[i];
                        textofaldodesligarvoz[i] = "desligar "+Texto_Voz[i];
                        if(textofaldoligar[i].equalsIgnoreCase(text.get(0)) || textofaldodesligar[i].equalsIgnoreCase(text.get(0)) || textofaldoligarvoz[i].equalsIgnoreCase(text.get(0)) || textofaldodesligarvoz[i].equalsIgnoreCase(text.get(0))) {
                            if(text.get(0).toLowerCase().contains( "desl" ) || text.get(0).toUpperCase().contains( "Desl" )) {
                                if (flag[i]) { // Se o botão estiver em OFF
                                    ttsManager.initQueue( " OK," + rotulo[i] + ", Desligada" );
                                    imagensBTNs( 0, i + 1 );
                                    mesagem( IP_do_btn[i], Comando[i], "" );
                                    contaip = chamaip[i];
                                } else {
                                    ttsManager.initQueue( "desculpa,,,"+rotulo[i] + ",  Já, está Desligada" );
                                }
                            }else
                            /*if(text.get(0).toLowerCase().contains( "ligar" ) || text.get(0).toUpperCase().contains( "Ligar" ))*/ {
                                if (!flag[i]) { // Se o botão estiver em OFF
                                    ttsManager.initQueue( " OK," + rotulo[i] + ", Ligada" );
                                    imagensBTNs( 0, i + 1 );
                                    mesagem( IP_do_btn[i], Comando[i], "" );
                                    contaip = chamaip[i];
                                } else {
                                    ttsManager.initQueue( "desculpa,,,"+rotulo[i] + ", Já, está Ligada" );
                                }
                           }


                            entretravaG = true;
                            //Toast.makeText(getApplicationContext(), "Ok >"+Texto_Voz[i]+" ou "+rotulo[i]+"< Corresponde", Toast.LENGTH_SHORT).show();
                          break;
                        }else if( i == 19 ){
                           // Toast.makeText(getApplicationContext(), "Você falou >"+text.get(0)+"< Não Corresponde a nem uma fala ", Toast.LENGTH_SHORT).show();
                            if(!entretrava) {
                                ttsManager.initQueue( "Desculpa, Voce falou,,, " + text.get( 0 ) + ", que não Corresponde a nem um comando de voz" );
                            }
                            //Toast.makeText(getApplicationContext(), textofaldoligar[0]+text.get(0), Toast.LENGTH_LONG).show();

                        }

                    }
                }
            }
        flagacelerometro = false;
    }// final onActivityResult
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(getApplicationContext(), "Stop ", Toast.LENGTH_SHORT).show();
//    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        //Toast.makeText(getApplicationContext(), "onTouchEvent ", Toast.LENGTH_SHORT).show();
//        return super.onTouchEvent(event);
//    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//
//    }
//        @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(getApplicationContext(), "onPause ", Toast.LENGTH_SHORT).show();
//        //sensorManager.unregisterListener( (SensorEventListener) this );
//    }
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(getApplicationContext(), "onRestart ", Toast.LENGTH_SHORT).show();
//
//    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ttsManager.shutDown();
       // Toast.makeText(getApplicationContext(), "onDestroy ", Toast.LENGTH_SHORT).show();
    }

    public void progresso (int Rotulo){
    progress = new ProgressDialog(Activity_Principal.this);
    progress.setMax(100);
    progress.setMessage("Grupo: "+rotulosgrupos[Rotulo]);
    progress.setTitle("Enviando Comandos");
    progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    progress.show();
    new Thread(new Runnable() {
        @Override
        public void run() {
            try{
                while(progress.getProgress() <= progress.getMax()){
                    Thread.sleep(40);
                    handle.sendMessage(handle.obtainMessage());
                    if(progress.getProgress() == progress.getMax())
                    {
                       progress.dismiss();
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }).start();


}
    Handler handle = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            progress.incrementProgressBy(1);
        }
    };
    public static String getNetworkClass(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        if(info==null || !info.isConnected())
            return "-"; //sem conexão
        if(info.getType() == ConnectivityManager.TYPE_WIFI)
            return "WIFI";
        if(info.getType() == ConnectivityManager.TYPE_MOBILE){
            int networkType = info.getSubtype();
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_CDMA:
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : troque por 11
                    return "2G";
                case TelephonyManager.NETWORK_TYPE_UMTS:
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : troque por 14
                case TelephonyManager.NETWORK_TYPE_EHRPD:  //api<11 : troque por 12
                case TelephonyManager.NETWORK_TYPE_HSPAP:  //api<13 : troque por 15
                    return "3G";
                case TelephonyManager.NETWORK_TYPE_LTE:    //api<11 : troque por 13
                    return "4G";
                default:
                    return "?";
            }
        }
        return "?";
    }
    /*/Salvando
    private void saveContactList(ArrayList<Contatos> listaDeContatos){
        SharedPreferences rotulodosbotoes = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = rotulodosbotoes.edit();

        Set<String> contactSet = new HashSet<>();
        contactSet.addAll(listaDeContatos);

        editor.putStringSet("lista_de_contatos_key", contactSet);
        editor.commit();
    }

    //Recuperando
    private ArrayList<Contatos> retrieveContactList(){
        SharedPreferences rotulodosbotoes = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Set<String> concatcSet = rotulodosbotoes.getStringSet("lista_de_contatos_key", null);

        return new ArrayList<Contatos>(contactSet);
    }
    */
}
