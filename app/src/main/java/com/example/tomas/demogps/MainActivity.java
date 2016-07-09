package com.example.tomas.demogps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://www.google.cl", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("INFOCODE","PAGINA EXITOSA");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        //SE conecta al servidor RES de Twitter
        try{
            TwitterRestClientUsage clase = new TwitterRestClientUsage();
            clase.getPublicTimeline();
        }catch (JSONException e){
            Log.d("ERROR","NO CARGA");
        }
    }
}
