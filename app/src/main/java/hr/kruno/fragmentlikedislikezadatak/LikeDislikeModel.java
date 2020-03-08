package hr.kruno.fragmentlikedislikezadatak;

import androidx.lifecycle.ViewModel;

public class LikeDislikeModel extends ViewModel {
    private int brojLajkova = 100;
    private int brojDislajkova = 100;
    private boolean izabran = false;

    public int getBrojLajkova() {
        return brojLajkova;
    }

    public void setBrojLajkova(int brojLajkova) {
        this.brojLajkova = brojLajkova;
    }

    public int getBrojDislajkova() {
        return brojDislajkova;
    }

    public void setBrojDislajkova(int brojDislajkova) {
        this.brojDislajkova = brojDislajkova;
    }

    public boolean isIzabran(){
        return izabran;
    }

    public void setIzabran(boolean i){
        izabran = i;
    }
}
