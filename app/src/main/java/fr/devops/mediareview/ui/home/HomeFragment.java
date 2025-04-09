package fr.devops.mediareview.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.io.Console;

import fr.devops.mediareview.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;

        // Appeler la méthode pour récupérer les détails du jeu
        homeViewModel.fetchGameDetails("1942");

        // Observer les détails du jeu et mettre à jour l'interface utilisateur
        // La méthode .observe() est utilisée pour observer les changements dans les données contenues dans le LiveData. Lorsque les données changent, le code à l'intérieur du bloc est exécuté.
        // getViewLifecycleOwner() fournit un LifecycleOwner, qui est nécessaire pour observer les LiveData. Dans ce cas, il s'agit du Fragment (HomeFragment), qui est responsable du cycle de vie de la vue. Cela garantit que l'observation est liée au cycle de vie du fragment, ce qui signifie que l'observateur sera automatiquement nettoyé lorsque le fragment sera détruit.
        // game -> { ... } est une expression lambda qui définit ce qui se passe lorsque les données observées changent. game est l'objet qui contient les nouvelles données (dans ce cas, un objet Game).
        homeViewModel.getGameDetails().observe(getViewLifecycleOwner(), game -> {
            if (game != null) {
                // On change le texte avec le nom du jeu
                textView.setText(game.getName());
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