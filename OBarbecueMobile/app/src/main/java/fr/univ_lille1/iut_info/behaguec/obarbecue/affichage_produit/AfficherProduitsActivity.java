package fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fr.univ_lille1.iut_info.behaguec.obarbecue.ClientREST;
import fr.univ_lille1.iut_info.behaguec.obarbecue.MainActivity;
import fr.univ_lille1.iut_info.behaguec.obarbecue.ProduitBDD;
import fr.univ_lille1.iut_info.behaguec.obarbecue.R;
import fr.univ_lille1.iut_info.behaguec.obarbecue.Save;

import fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_panier.PanierActivity;

/**
 * Created by behaguec on 22/03/17.
 */

public class AfficherProduitsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_produits);


        ClientREST clientREST=new ClientREST(this);
        clientREST.GET("v1/produit/",new Response.Listener<String>() {

            @Override
            public void onResponse(String response) { // Si la requete réussit

                List<ProduitBDD> produits =  new Gson().fromJson(response,new TypeToken<List<ProduitBDD>>(){}.getType());

                if(!produits.isEmpty()) {
                    ListeProduit listeProduits=new ListeProduit();
                    listeProduits.getProduitsFromDb(produits);

                    ListView listView = (ListView) findViewById(R.id.myLV);
                    listView.setAdapter(new ProduitAdapter(AfficherProduitsActivity.this,listeProduits));
                } else {

                }


            }
        },new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) { // en cas d'erreur
                //tV.setText("ERREUR");
                System.out.println("Ca marche pas");
                System.out.println(error.getMessage());
            }
        });






        Button iv=(Button) findViewById(R.id.toAccueil);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AfficherProduitsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        iv=(Button) findViewById(R.id.toPanier);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AfficherProduitsActivity.this, PanierActivity.class);
                startActivity(i);
            }
        });
    }

}
