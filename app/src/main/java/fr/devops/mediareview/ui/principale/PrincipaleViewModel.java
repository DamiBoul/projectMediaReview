package fr.devops.mediareview.ui.principale;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrincipaleViewModel extends ViewModel {

    private final MutableLiveData<Float> moyenne;

    private final MutableLiveData<Integer> evaluation;

    public PrincipaleViewModel() {
        moyenne = new MutableLiveData<>();
        evaluation = new MutableLiveData<>();
        moyenne.setValue(3.6F);
        evaluation.setValue(8);
    }

    public LiveData<Float> getMoyenne(){return moyenne;}

    public LiveData<Integer> getEval(){return evaluation;}
}
