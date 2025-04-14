package fr.devops.mediareview.composants.avis;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

import fr.devops.mediareview.R;
import fr.devops.mediareview.composants.badgeUtilisateur.BadgeUtilisateurView;
import fr.devops.mediareview.composants.mediaImage.MediaImageView;
import fr.devops.mediareview.composants.notes.NotesEtoilesView;

public class AvisView extends FrameLayout {

    private MediaImageView mediaView;

    private BadgeUtilisateurView utilisateurView;

    private NotesEtoilesView noteView;

    private TextView corpsAvisView;

    private TextView deplierView;

    private Boolean deplierBool = false;

    public AvisView(Context context) {
        super(context);
        this.initViews(context);
        this.initObs();
    }

    public AvisView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.initViews(context);
        this.initObs();
    }

    private void initViews(Context context){
        inflate(context, R.layout.avis, this);
        this.mediaView = findViewById(R.id.avis_media_image);
        this.utilisateurView = findViewById(R.id.avis_badge_utilisateur);
        this.noteView = findViewById(R.id.avis_note);
        this.corpsAvisView = findViewById(R.id.avis_corps_de_texte);
        this.deplierView = findViewById(R.id.avis_deplier);
    }

    private void initObs(){
        this.deplierView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                toggleDeplier();
            }
        });
    }

    public void setTitreMedia(String titreMedia){
        this.mediaView.setTitreMedia(titreMedia);
    }

    public void setMediaImageResource(@DrawableRes int resId){this.mediaView.setImageResource(resId);}

    public void setEvaluation(Integer eval){
        this.noteView.setEvaluation(eval);
    }

    public void setCoeur(Boolean bool){
        this.noteView.setCoeur(bool);
    }

    public void setNomUtilisateur(String nomUtilisateur){
        this.utilisateurView.setNomUtilisateur(nomUtilisateur);
    }

    public void setImageUtilisateur(@DrawableRes Integer res){
        this.utilisateurView.setImageUtilisateur(res);
    }

    public void setCorpsAvis(String corpsAvis){
        this.corpsAvisView.setText(corpsAvis);
    }

    private void toggleDeplier(){
        if(deplierBool){
            this.deplierView.setText(R.string.avis_deplier);
        } else {
            this.deplierView.setText(R.string.avis_replier);
        }
        this.deplierBool = !this.deplierBool;
    }
}
