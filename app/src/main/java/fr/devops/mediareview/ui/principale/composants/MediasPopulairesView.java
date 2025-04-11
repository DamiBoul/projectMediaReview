package fr.devops.mediareview.ui.principale.composants;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import fr.devops.mediareview.R;
import fr.devops.mediareview.composants.mediaImage.MediaAnnoteView;

public class MediasPopulairesView extends FrameLayout {

    private List<MediaAnnoteView> listeMediaPopulaire;

    public MediasPopulairesView(@NonNull Context context) {
        super(context);
        this.init(context);
    }

    public MediasPopulairesView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.principale_medias_populaires_layout, this);
        listeMediaPopulaire = new ArrayList<>(8);
        listeMediaPopulaire.add(findViewById(R.id.med_pop_1));
        listeMediaPopulaire.add(findViewById(R.id.med_pop_2));
        listeMediaPopulaire.add(findViewById(R.id.med_pop_3));
        listeMediaPopulaire.add(findViewById(R.id.med_pop_4));
        listeMediaPopulaire.add(findViewById(R.id.med_pop_5));
        listeMediaPopulaire.add(findViewById(R.id.med_pop_6));
        listeMediaPopulaire.add(findViewById(R.id.med_pop_7));
        listeMediaPopulaire.add(findViewById(R.id.med_pop_8));
    }

    public MediaAnnoteView getMediaByIdx(int idx){return listeMediaPopulaire.get(idx);}

    public void searchMediaPopulaire(){
        listeMediaPopulaire.iterator(); //TODO
    }
}
