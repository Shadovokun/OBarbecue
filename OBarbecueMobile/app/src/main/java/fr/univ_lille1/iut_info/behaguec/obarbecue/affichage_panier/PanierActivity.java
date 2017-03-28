package fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_panier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import fr.univ_lille1.iut_info.behaguec.obarbecue.LoginActivity;
import fr.univ_lille1.iut_info.behaguec.obarbecue.MainActivity;
import fr.univ_lille1.iut_info.behaguec.obarbecue.R;
import fr.univ_lille1.iut_info.behaguec.obarbecue.Save;
import fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit.ListeProduit;

/**
 * Created by behaguec on 23/03/17.
 */

public class PanierActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panier);


        ListView listView = (ListView) findViewById(R.id.listViewPanier);

        listView.setAdapter(new PanierAdapter(PanierActivity.this, new ListeProduit(Save.getInstance().panier)));

        Button button2 =(Button) findViewById(R.id.continuer);

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(PanierActivity.this, LoginActivity.class);
                startActivity(i);
                // do something
            }
        });

         button2 =(Button) findViewById(R.id.toAccueil);

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(PanierActivity.this, MainActivity.class);
                startActivity(i);
                // do something
            }
        });
    }
}