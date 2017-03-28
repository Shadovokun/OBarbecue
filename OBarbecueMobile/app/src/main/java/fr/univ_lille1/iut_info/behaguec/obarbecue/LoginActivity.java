package fr.univ_lille1.iut_info.behaguec.obarbecue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit.AfficherProduitsActivity;
import fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit.ListeProduit;
import fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit.ProduitAdapter;

/**
 * Created by behaguec on 27/03/17.
 */

public class LoginActivity extends Activity{
    ClientREST clientREST;
    EditText email, modpass;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button button =(Button) findViewById(R.id.signin);
        email=(EditText) findViewById(R.id.email);
        modpass=(EditText) findViewById(R.id.password);
        textView=(TextView) findViewById(R.id.textView);

        clientREST=new ClientREST(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientREST.POST("secure/who/", email.getText().toString(), modpass.getText().toString(), new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) { // Si la requete réussit
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
            }
        });
    }
}
