package com.g_automation.flex_home;

import android.content.Intent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Config_Modulos extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_modulos);

        // Web view para mostrar tabela na tela
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://192.168.4.1");
        //webView.loadUrl("file:///android_asset/foxboro.pdf");
        webView.setWebViewClient(new WebViewClient(){
         public boolean shouldOverrideUrlLoanding(WebView view, String url){
             return false;
         }
        });

        // Web view para mostrar tabela na tela
    }
    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(getApplicationContext(), "onPause ", Toast.LENGTH_LONG).show();
        Intent configmodulos=new Intent(Config_Modulos.this,Activity_Principal.class);
        startActivity(configmodulos);
        finish();

    }

}

