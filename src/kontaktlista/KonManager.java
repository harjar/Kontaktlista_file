/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontaktlista;

import java.util.ArrayList;

/**
 *
 * @author jarhar
 */
public class KonManager {
    ArrayList<Kontakt> kontakter;

    @SuppressWarnings("unchecked")
    public KonManager() {
        this.kontakter = new ArrayList();
    }

    public void addKontakt(Kontakt kon) {
        this.kontakter.add(kon);
    }

    public ArrayList<Kontakt> getLista() {
        return this.kontakter;
    }

    public void createNewList(ArrayList<Kontakt> kon) {
        this.kontakter = kon;
    }
}
