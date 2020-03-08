package hr.kruno.fragmentlikedislikezadatak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


public class SredisnjiFragment extends Fragment {
     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sredisnji, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView iv = view.findViewById(R.id.slika);
        iv.setImageDrawable(getResources().getDrawable(R.drawable.android02));
    }

    @Override
    public void onDetach() {
        super.onDetach();



    }
}
