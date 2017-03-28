package fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import fr.univ_lille1.iut_info.behaguec.obarbecue.R;
import fr.univ_lille1.iut_info.behaguec.obarbecue.Save;

/**
 * Created by behaguec on 22/03/17.
 */

public class ProduitAdapter extends BaseAdapter implements ListAdapter {
    private LayoutInflater mInflater;
    private Context context;
    ListeProduit listeProduit;

    public ProduitAdapter(Context context, ListeProduit listeProduit) {
        super();
        this.listeProduit = listeProduit;
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listeProduit.getCount();
    }

    @Override
    public Object getItem(int position) {
        return listeProduit.getProduit(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
  /* We inflate the xml which gives us a view */
        view = mInflater.inflate(R.layout.produit_layout, parent, false);

  /* Get the widget with id name which is defined in the xml of the row */
        TextView tv = (TextView) view.findViewById(R.id.nomProduit);
        tv.setText(listeProduit.getProduit(position).nom);

        tv = (TextView) view.findViewById(R.id.descriptionProduit);
        tv.setText(listeProduit.getProduit(position).description);

        tv = (TextView) view.findViewById(R.id.prix);
        tv.setText("" + listeProduit.getProduit(position).prix);

        Button b=(Button) view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AfficherProduitsActivity.confirmationCommande(position);

                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setMessage("Ajouter "+listeProduit.getProduit(position).nom+" au panier ?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Oui",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Save.getInstance().addProduit(listeProduit.getProduit(position));
                                Toast.makeText(context, listeProduit.getProduit(position).nom + "ajouté(e) au panier", Toast.LENGTH_LONG).show();

                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Non",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

        notifyDataSetChanged();
        return view;
    }
}