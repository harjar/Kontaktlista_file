/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontaktlista;

import java.io.Serializable;

/**
 *
 * @author jarhar
 */
public class Kontakt implements Serializable {

    private int id = 0;
    private String efternamn;
    private String förnamn;
    private String telefon;

    public Kontakt(String förnamn, String efternamn, String telefon) {
        this.förnamn = förnamn;
        this.efternamn = efternamn;
        this.telefon = telefon;
    }

    public String getFörnamn() {
        return this.förnamn;
    }

    public String getEfternamn() {
        return this.efternamn;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
