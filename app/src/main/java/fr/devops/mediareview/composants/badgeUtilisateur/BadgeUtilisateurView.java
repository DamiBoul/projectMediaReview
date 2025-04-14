package fr.devops.mediareview.composants.badgeUtilisateur;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import fr.devops.mediareview.R;

public class BadgeUtilisateurView extends FrameLayout {

    private ImageView imageUtilisateur;

    private TextView nomUtilisateur;

    public BadgeUtilisateurView(Context context) {
        super(context);
        this.init(context);
    }

    public BadgeUtilisateurView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.badge_layout, this);
        this.nomUtilisateur = findViewById(R.id.badge_username);
        this.imageUtilisateur = findViewById(R.id.imageView_user);
    }

    public void setNomUtilisateur(String nomUtilisateur){
        this.nomUtilisateur.setText(nomUtilisateur);
    }

    public void setImageUtilisateur(@DrawableRes Integer res){
        this.imageUtilisateur.setImageResource(res);
    }
}
