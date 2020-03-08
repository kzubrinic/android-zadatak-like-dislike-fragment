package hr.kruno.fragmentlikedislikezadatak;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class LikeDislakeFragment extends Fragment {
    private RadioButton like, dislike;
    private LikeDislikeModel model;
    private OnLikeDislikeChange sucelje;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_like_dislake, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        like = view.findViewById(R.id.buttonLike);
        dislike = view.findViewById(R.id.buttonDislike);
        model = new ViewModelProvider(requireActivity()).get(LikeDislikeModel.class);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                if (checked) {
                    // Promijeni model
                    model.setBrojLajkova(model.getBrojLajkova()+1);
                    if (sucelje != null)
                        sucelje.onLikeDislikeChange();
                }
            }
        });
        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((RadioButton) view).isChecked();
                if (checked) {
                    // Promijeni model
                    model.setBrojDislajkova(model.getBrojDislajkova()+1);
                    if (sucelje != null)
                        sucelje.onLikeDislikeChange();
                }
            }
        });
    }

    // registriraju se listeneri
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLikeDislikeChange) {
            sucelje = (OnLikeDislikeChange) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLikeDislikeChange");
        }
     }

    @Override
    public void onDetach() {
        super.onDetach();
        sucelje = null;
    }
    // Sve klase koje koriste ovaj fragment moraju implkementirati ova dva sučelja
    public interface OnLikeDislikeChange {
        void onLikeDislikeChange();
    }

}
