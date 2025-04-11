package fr.devops.mediareview.composants.mediaImage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

import fr.devops.mediareview.R;

public class MediaImageView extends FrameLayout {

    private TextView titreMedia;

    private ImageView overlay;

    private ImageView jeu;

    public MediaImageView(Context context) {
        super(context);
        this.init(context);
    }

    public MediaImageView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.media_image_layout, this);
        this.titreMedia = findViewById(R.id.titre_media);
        this.overlay = findViewById(R.id.dark_overlay);
        this.jeu = findViewById(R.id.imageView_media);
    }

    public void toggleOverlayVisibility(){
        if(this.titreMedia.getVisibility() == INVISIBLE){
            this.titreMedia.setVisibility(VISIBLE);
        }
        else {
            this.titreMedia.setVisibility(INVISIBLE);
        }
        if(this.overlay.getVisibility() == INVISIBLE){
            this.overlay.setVisibility(VISIBLE);
        }
        else {
            this.overlay.setVisibility(INVISIBLE);
        }

    }

    public void setTitreMedia(String titreMedia){
        this.titreMedia.setText(titreMedia);
    }

    public void setImageResource(@DrawableRes int resId){this.jeu.setImageResource(resId);}
}
