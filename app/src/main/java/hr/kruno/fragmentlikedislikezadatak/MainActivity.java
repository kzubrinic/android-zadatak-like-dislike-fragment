package hr.kruno.fragmentlikedislikezadatak;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends FragmentActivity implements LikeDislakeFragment.OnLikeDislikeChange {
    private FragmentManager fm;
    private LikeDislikeModel model;
    private LikeDislakeFragment ldF;
    private SredisnjiFragment srF;
    private StatistikaFragment stF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new ViewModelProvider(this).get(LikeDislikeModel.class);
        fm = getSupportFragmentManager();
        ldF = new LikeDislakeFragment();
        srF = new SredisnjiFragment();
        stF = new StatistikaFragment();
        // Započni transakciju
        FragmentTransaction ft = fm.beginTransaction();
        // Zamijeni sadržaj kontejnera aktivnosti drugim fragmentom
        // Ako je like/dislike već izabrano, ne prikazuje se gornji fragment
        if (!model.isIzabran()) {
            ft.replace(R.id.ld_fragment, ldF);
        }
        ft.replace(R.id.sred_fragment, srF);
        ft.replace(R.id.stat_fragment, stF);
        // Potvrdi promjenu
        ft.commit();

    }

    @Override
    public void onLikeDislikeChange() {
        model.setIzabran(true);
        stF.setBrojLajkova();
        stF.setBrojDislajkova();
        // ukloni fragment
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(ldF);
        ft.commit();
    }
}
