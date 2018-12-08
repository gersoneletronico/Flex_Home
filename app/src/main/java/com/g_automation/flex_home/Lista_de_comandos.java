package com.g_automation.flex_home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista_de_comandos extends AppCompatActivity {

    //Variavel Endereço (NOME_APARELHO)
    static String COMANDO_PASSADO = null;
    String com1, com2, com3, com4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lista_de_coman );

        ListView Listadecoman = (ListView)findViewById(R.id.Listadecoman);



        final ArrayList<String> ips = preenncherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ips);
        Listadecoman.setAdapter(arrayAdapter);


        Listadecoman.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
               // mesagemselecquandoclicar();
                String NomedoAparelho = ips.get(position).toString();
                //NomedoAparelho = NomedoAparelho.substring(0,2);// Envia os dois primeiros caracter
                //substring


                Intent retornaMac = new Intent(Lista_de_comandos.this, Confugurar_btns.class);
                retornaMac.putExtra(COMANDO_PASSADO, NomedoAparelho);
                setResult(RESULT_OK, retornaMac);
                finish();

            }

        });


    }
        private ArrayList<String> preenncherDados(){
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("S1");
        dados.add("S2");
        dados.add("S3");
        dados.add("S4");

        return dados;

    }


}
