package com.example.tomas.demogps;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.*;

import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;

/**
 * Created by tomas on 08/07/2016.
 */

class TwitterRestClientUsage extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void getPublicTimeline() throws JSONException {
        //TwitterRestClient.get("statuses/public_timeline.json", null, new JsonHttpResponseHandler() {
        TwitterRestClient.get("", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray

                Log.d("info", String.valueOf(response.toString()));

                try {
                    JSONArray jArray = response.getJSONArray("data");

                    for(int i=0;i<jArray.length();i++){
                        JSONObject valor = jArray.getJSONObject(i);
                        Log.d("INFO",valor.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                    /*
                    try{
                        JSONObject firstEvent = timeline.get(0);
                        String tweetText = firstEvent.getString("text");
                    }catch (JSONException e){
                        Log.d("INFOCODE","dsdd");
                    }
                    */

                // Do something with the response
            }

        });

    }
}
