package hr.kruno.fragmentlikedislikezadatak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


public class StatistikaFragment extends Fragment {
    private TextView bL, bD;
    private LikeDislikeModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistika, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Registrira se promjene izbora na komponenti
        bL = view.findViewById(R.id.brojLajkova);
        bD = view.findViewById(R.id.brojDislajkova);
        model = new ViewModelProvider(requireActivity()).get(LikeDislikeModel.class);
        setBrojLajkova();
        setBrojDislajkova();

    }
    public void setBrojLajkova(){
        bL.setText(String.valueOf(model.getBrojLajkova()));
    }
    public void setBrojDislajkova(){
        bD.setText(String.valueOf(model.getBrojDislajkova()));
    }
}
