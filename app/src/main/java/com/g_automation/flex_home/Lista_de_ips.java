package com.g_automation.flex_home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lista_de_ips extends AppCompatActivity {

    //Variavel Endereço (NOME_APARELHO)
    int n_ips = 10;
    static String IP_PASSADO = null;
    String[] ip = new String[n_ips];
    String[] habita = new String[n_ips];
    Boolean[] mostraip = new Boolean[n_ips];

    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lista_de_ips );

        ListView Listadeip = (ListView)findViewById(R.id.Listadeip);

        //mostra no edit as atuas edições
        SharedPreferences sharedservidor = getApplicationContext().getSharedPreferences("Config_IPS", Context.MODE_PRIVATE);
        for(int i = 0; i < n_ips; i++) {
            ip[i] = sharedservidor.getString( "IPS" + i, "http://192.168.1.1");
            habita[i] = sharedservidor.getString("checkIPS" + i, "0");
            if (habita[i].contains( "1" ))
                mostraip[i] = true;

            else if (habita[i].contains( "0" ))

                mostraip[i] = false;
        }

//       } if(preenncherDados() == null){
////            Toast.makeText(getApplicationContext(), "Não tem servidores habilitados", Toast.LENGTH_LONG).show();
////

        final ArrayList<String> ips = preenncherDados();



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ips);
        Listadeip.setAdapter(arrayAdapter);


        Listadeip.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
               // mesagemselecquandoclicar();
                String IPselecionado = ips.get(position).toString();
                //IPselecionado = IPselecionado.substring(0,5);// Envia os dois primeiros caracter
                //substring

                Intent retornaip = new Intent(Lista_de_ips.this, Confugurar_btns.class);
                retornaip.putExtra(IP_PASSADO, IPselecionado);
                setResult(RESULT_OK, retornaip);
                finish();

            }

        });


    }
        private ArrayList<String> preenncherDados(){
        ArrayList<String> dados = new ArrayList<String>();
            for(int i = 0; i < n_ips; i++) {
                n = 1 + i;
                if(mostraip[i]) {
                    dados.add( "IP" + n + " : " + ip[i] );
                }else if (!mostraip[i]) {
                    //dados.add( "IP " + n + " : " + ip[i] );
                }
            }
        return dados;

    }


}
