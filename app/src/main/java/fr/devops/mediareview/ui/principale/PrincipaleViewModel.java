package fr.devops.mediareview.ui.principale;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrincipaleViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PrincipaleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ceci est la page principale");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
