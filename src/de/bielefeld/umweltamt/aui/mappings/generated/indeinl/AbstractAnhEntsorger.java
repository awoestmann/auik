/**
 * Copyright 2005-2011, Stadt Bielefeld
 *
 * This file is part of AUIK (Anlagen- und Indirekteinleiter-Kataster).
 *
 * AUIK is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 2 of the License, or (at your
 * option) any later version.
 *
 * AUIK is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with AUIK. If not, see <http://www.gnu.org/licenses/>.
 *
 * AUIK has been developed by Stadt Bielefeld and Intevation GmbH.
 */

// Generated 17.07.2012 18:33:28 by Hibernate Tools 3.3.0.GA

package de.bielefeld.umweltamt.aui.mappings.generated.indeinl;


import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a row in a database table.
 * You can customize the behavior of this class by editing the class,
 * {@link AnhEntsorger}.
 */
public abstract class AbstractAnhEntsorger  implements java.io.Serializable {

     private int id;
     private String entsorger;
     private String strasse;
     private Integer hausnr;
     private String plz;
     private String ort;
     private String ansprechpartner;
     private String telefon;
     private Set<Anh50Fachdaten> anh50Fachdatens = new HashSet<Anh50Fachdaten>(0);

    public AbstractAnhEntsorger() {
    }

    public AbstractAnhEntsorger(
    	int id) {
        this.id = id;
    }

    public AbstractAnhEntsorger(
    	int id, String entsorger, String strasse, Integer hausnr, String plz, String ort, String ansprechpartner, String telefon, Set<Anh50Fachdaten> anh50Fachdatens) {
        this.id = id;
        this.entsorger = entsorger;
        this.strasse = strasse;
        this.hausnr = hausnr;
        this.plz = plz;
        this.ort = ort;
        this.ansprechpartner = ansprechpartner;
        this.telefon = telefon;
        this.anh50Fachdatens = anh50Fachdatens;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEntsorger() {
        return this.entsorger;
    }
    public void setEntsorger(String entsorger) {
        this.entsorger = entsorger;
    }

    public String getStrasse() {
        return this.strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public Integer getHausnr() {
        return this.hausnr;
    }
    public void setHausnr(Integer hausnr) {
        this.hausnr = hausnr;
    }

    public String getPlz() {
        return this.plz;
    }
    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return this.ort;
    }
    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getAnsprechpartner() {
        return this.ansprechpartner;
    }
    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public String getTelefon() {
        return this.telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Set<Anh50Fachdaten> getAnh50Fachdatens() {
        return this.anh50Fachdatens;
    }
    public void setAnh50Fachdatens(Set<Anh50Fachdaten> anh50Fachdatens) {
        this.anh50Fachdatens = anh50Fachdatens;
    }

}

