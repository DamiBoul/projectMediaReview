package fr.devops.mediareview.composants.notes;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import fr.devops.mediareview.R;

public class NotesEtoilesView extends FrameLayout {

    private List<ImageView> etoilesList;

    private ImageView coeur;

    public NotesEtoilesView(Context context) {
        super(context);
        this.init(context);
    }

    public NotesEtoilesView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.notes_etoiles, this);
        etoilesList = new ArrayList<>(5);
        etoilesList.add(findViewById(R.id.etoile_1));
        etoilesList.add(findViewById(R.id.etoile_2));
        etoilesList.add(findViewById(R.id.etoile_3));
        etoilesList.add(findViewById(R.id.etoile_4));
        etoilesList.add(findViewById(R.id.etoile_5));
        this.coeur = findViewById(R.id.coeur);
    }

    public void setEvaluation(Integer eval){
        for (int i=0;i<5;i++){
            if(eval / 2 > i){
                etoilesList.get(i).setImageResource(R.drawable.etoile_pleine);
            }
            else{
                etoilesList.get(i).setImageResource(R.drawable.etoile_vide);
            }
        }
        if(eval % 2 == 1) etoilesList.get(eval / 2).setImageResource(R.drawable.etoile_demi);
    }

    public void setCoeur(Boolean bool){
        if (bool) {
            coeur.setVisibility(VISIBLE);
        } else {
            coeur.setVisibility(INVISIBLE);
        }
    }

}
