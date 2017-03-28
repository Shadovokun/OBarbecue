package fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_panier;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import fr.univ_lille1.iut_info.behaguec.obarbecue.R;
import fr.univ_lille1.iut_info.behaguec.obarbecue.Save;
import fr.univ_lille1.iut_info.behaguec.obarbecue.affichage_produit.ListeProduit;

/**
 * Created by behaguec on 23/03/17.
 */

public class PanierAdapter extends BaseAdapter implements ListAdapter {
    private LayoutInflater mInflater;
    private Context context;
    ListeProduit listeProduit;

    public PanierAdapter(Context context, ListeProduit listeProduit) {
        super();
        this.listeProduit= new ListeProduit(Save.getInstance().panier);
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
        this.listeProduit= new ListeProduit(Save.getInstance().panier);
        View view;
  /* We inflate the xml which gives us a view */
        view = mInflater.inflate(R.layout.produit_panier, parent, false);

  /* Get the widget with id name which is defined in the xml of the row */
        TextView tv = (TextView) view.findViewById(R.id.nomProduit);
        tv.setText(listeProduit.getProduit(position).nom);

        tv = (TextView) view.findViewById(R.id.quantite);
        tv.setText("Quantité : " + listeProduit.getProduit(position).quantite);

        Button b=(Button) view.findViewById(R.id.plus);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save.getInstance().addProduit(listeProduit.getProduit(position));
                notifyDataSetChanged();
            }
        });

        b=(Button) view.findViewById(R.id.moins);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save.getInstance().removeProduit(listeProduit.getProduit(position));
                notifyDataSetChanged();
            }
        });

        b=(Button) view.findViewById(R.id.supprimer);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save.getInstance().deleteProduit(listeProduit.getProduit(position));
                notifyDataSetChanged();
            }
        });

        notifyDataSetChanged();
        return view;
    }
}