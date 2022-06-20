package BO.Tp.eu.unareil.bo;

import java.util.ArrayList;
import java.util.List;

public class Achat {
    List<Ligne> listAchat= new ArrayList<>();
    Double Montant;

    public Achat(List<Ligne> listAchat) {
        this.listAchat = listAchat;
    }
}
