package fr.devops.mediareview.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    private final MutableLiveData<String> titreMedia;

    private final MutableLiveData<Integer> noteEtoile;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        titreMedia = new MutableLiveData<>();
        noteEtoile = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
        titreMedia.setValue("SuperMario64");
        noteEtoile.setValue(3);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getTitreMedia(){ return titreMedia;}

    public LiveData<Integer> getNote(){ return noteEtoile;}
}