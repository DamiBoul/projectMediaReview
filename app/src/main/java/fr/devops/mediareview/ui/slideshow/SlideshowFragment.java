package fr.devops.mediareview.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import fr.devops.mediareview.composants.badgeUtilisateur.BadgeUtilisateurView;
import fr.devops.mediareview.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        try {
            binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        } catch (Exception e){
            Log.e("SlideshowFragment","onCreateView",e);
            throw e;
        }
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        final BadgeUtilisateurView usernameView = binding.badge;
        slideshowViewModel.getUsername().observe(getViewLifecycleOwner(), usernameView::setNomUtilisateur);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}