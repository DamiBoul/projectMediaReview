package fr.devops.mediareview.ui.principale;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrincipaleViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    private final MutableLiveData<Float> moyenne;

    private final MutableLiveData<Integer> evaluation;

    public PrincipaleViewModel() {
        mText = new MutableLiveData<>();
        moyenne = new MutableLiveData<>();
        evaluation = new MutableLiveData<>();
        mText.setValue("Ceci est la page principale");
        moyenne.setValue(3.6F);
        evaluation.setValue(8);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Float> getMoyenne(){return moyenne;}

    public LiveData<Integer> getEval(){return evaluation;}
}
