package fr.devops.mediareview.ui.principale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import fr.devops.mediareview.composants.avis.AvisView;
import fr.devops.mediareview.databinding.FragmentPrincipaleBinding;
import fr.devops.mediareview.ui.principale.composants.MediasPopulairesView;

public class PrincipaleFragment extends Fragment {

    private FragmentPrincipaleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PrincipaleViewModel principaleViewModel =
                new ViewModelProvider(this).get(PrincipaleViewModel.class);

        binding = FragmentPrincipaleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final MediasPopulairesView mediasPopulairesView = binding.principaleMediaPopulaire;

        final AvisView avisViewTest = binding.principaleAvisTest;

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
