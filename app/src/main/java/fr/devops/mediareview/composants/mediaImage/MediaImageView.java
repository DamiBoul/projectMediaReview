package fr.devops.mediareview.composants.mediaImage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import fr.devops.mediareview.R;

public class MediaImageView extends FrameLayout {

    private TextView titreMedia;

    public MediaImageView(Context context) {
        super(context);
        this.init(context);
    }

    public MediaImageView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.badge_layout, this);
        this.titreMedia = findViewById(R.id.badge_username);
    }

    public void setTitreMedia(String titreMedia){
        this.titreMedia.setText(titreMedia);
    }
}
