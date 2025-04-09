package fr.devops.mediareview.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import fr.devops.mediareview.composants.mediaImage.MediaImageView;
import fr.devops.mediareview.composants.notes.NotesEtoilesView;
import fr.devops.mediareview.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        final MediaImageView mediaImageView = binding.imageMedia;
        galleryViewModel.getTitreMedia().observe(getViewLifecycleOwner(), mediaImageView::setTitreMedia);
        mediaImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    mediaImageView.toggleVisibility();
                }
        });
        final NotesEtoilesView notesEtoilesView = binding.note;
        galleryViewModel.getNote().observe(getViewLifecycleOwner(), notesEtoilesView::setEvaluation);
        notesEtoilesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                notesEtoilesView.setCoeur(true);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}