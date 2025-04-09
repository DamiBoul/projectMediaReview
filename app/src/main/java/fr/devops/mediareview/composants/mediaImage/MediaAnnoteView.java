package fr.devops.mediareview.composants.mediaImage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.Objects;

import fr.devops.mediareview.R;
import fr.devops.mediareview.composants.notes.NotesEtoilesView;
import fr.devops.mediareview.composants.notes.NotesMoyenneView;

public class MediaAnnoteView extends FrameLayout {

    private MediaImageView mediaImageView;

    private NotesEtoilesView notesEtoilesView;

    private NotesMoyenneView notesMoyenneView;

    public MediaAnnoteView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle){
        inflate(context, R.layout.media_annote_layout, this);

        this.mediaImageView = findViewById(R.id.mediaImageView);
        this.notesEtoilesView = findViewById(R.id.notesEtoilesView);
        this.notesMoyenneView = findViewById(R.id.notesMoyenneView);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MediaAnnoteView, defStyle, 0);

        String str = a.getString(R.styleable.MediaAnnoteView_type_note);
        if(Objects.equals(str, "ETOILES")){
            this.notesMoyenneView.setVisibility(INVISIBLE);
        } else {
            this.notesEtoilesView.setVisibility(VISIBLE);
        }

        a.recycle();
    }

    public void setMoyenne(Float moy){
        this.notesMoyenneView.setMoyenne(moy);
    }

    public void setEvaluation(Integer eval){
        this.notesEtoilesView.setEvaluation(eval);
    }

    public void setCoeur(Boolean bool){
        this.notesEtoilesView.setCoeur(bool);
    }

}