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
        etoilesList.set(0, findViewById(R.id.etoile_1));
        etoilesList.set(1, findViewById(R.id.etoile_2));
        etoilesList.set(2, findViewById(R.id.etoile_3));
        etoilesList.set(3, findViewById(R.id.etoile_4));
        etoilesList.set(4, findViewById(R.id.etoile_5));
        this.coeur = findViewById(R.id.coeur);
    }

}
