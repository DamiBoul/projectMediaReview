package fr.devops.mediareview.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    private final MutableLiveData<String> nomUtilisateur;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        nomUtilisateur = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
        nomUtilisateur.setValue("Toto");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getUsername(){ return nomUtilisateur; }
}