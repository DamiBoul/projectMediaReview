package fr.devops.mediareview.composants.notes;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Locale;

import fr.devops.mediareview.R;

public class NotesMoyenneView extends FrameLayout {

    private TextView moyenneView;

    public NotesMoyenneView(@NonNull Context context) {
        super(context);
        this.init(context);
    }

    public NotesMoyenneView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.notes_moyenne, this);
        moyenneView = findViewById(R.id.note_moyenne);
    }

    public void setMoyenne(Float moy){
        moyenneView.setText(String.format(Locale.FRANCE,moy.toString()));
    }
}
