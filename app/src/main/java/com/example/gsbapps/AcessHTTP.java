package com.example.gsbapps;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class AcessHTTP extends AsyncTask<String, Integer, Long> {
    public String ret = "";
    private ArrayList<NameValuePair> parametres;

    public AcessHTTP() {
        parametres = new ArrayList<NameValuePair>();
    }

    public void addParam(String nom, String valeur) {
        parametres.add(new BasicNameValuePair(nom, valeur));
    }

    @Override
    protected Long doInBackground(String... urls) {
        // TODO Auto-generated method stub

        HttpClient cnxHttp = new DefaultHttpClient();
        HttpPost paramCnx = new HttpPost(urls[0]);

        try {
            paramCnx.setEntity(new UrlEncodedFormEntity(parametres));
            HttpResponse reponse = cnxHttp.execute(paramCnx);
            ret = EntityUtils.toString(reponse.getEntity());

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        return null;
    }

    @Override
    protected void onPostExecute(Long result) {

    }

}
