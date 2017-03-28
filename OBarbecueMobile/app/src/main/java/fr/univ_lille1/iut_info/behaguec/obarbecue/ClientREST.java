package fr.univ_lille1.iut_info.behaguec.obarbecue;

import android.content.Context;
import android.util.Base64;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univ_lille1.iut_info.behaguec.obarbecue.ProduitBDD;

import static android.provider.Telephony.Carriers.PASSWORD;

/**
 * Created by behaguec on 24/03/17.
 */

public class ClientREST {

    private String url;
    private RequestQueue queue;
    private Context context;
    private List<ProduitBDD> produitBDDList;

    public ClientREST(Context context){
      //  System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
        // System.setProperty("http.proxyPort", "3128");
        this.context=context;
        this.url = "http://10.0.2.2:8080/";
        this.queue = Volley.newRequestQueue(context);
    }

    public void GET(String localisation, Response.Listener listener, Response.ErrorListener errorListener) {
        String url = this.url + localisation;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, listener, errorListener);
        queue.add(stringRequest);
    }

    public void POST(String localisation, final String username, final String passwd, Response.Listener listener, Response.ErrorListener errorListener){
        String url = this.url+localisation;
         StringRequest stringRequest = new StringRequest(Request.Method.POST, url, listener, errorListener){
             @Override
             protected Map<String, String> getParams() throws AuthFailureError {
                 Map<String, String> params = new HashMap<String, String>();
                 //add params <key,value>
                 return params;
             }

             @Override
             public Map<String, String> getHeaders() throws AuthFailureError {
                 Map<String,String> headers=new HashMap<>(); //= Constants.getHeaders(context);
                 // add headers <key,value>
                 String credentials = username+":"+passwd;
                 String auth = "Basic "
                         + Base64.encodeToString(credentials.getBytes(),
                         Base64.NO_WRAP);
                 headers.put("Authorization", auth);
                 return headers;
             }
         };
        queue.add(stringRequest);
    }
}