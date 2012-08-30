/**
 * Copyright 2005-2042, Stadt Bielefeld
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

// Generated by Hibernate Tools 3.3.0.GA

package de.bielefeld.umweltamt.aui.mappings.tipi;


/**
 * A class that represents a row in the InkaAnfallstMessstId database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class InkaAnfallstMessstId  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID = -1256631272831575070L;
    /* Primary key, foreign keys (relations) and table columns */
    private Integer anfallstelleNr;
    private Integer messstelleLfdNr;

    /** Default constructor */
    public InkaAnfallstMessstId() {
        // This place is intentionally left blank.
    }


    /** Full constructor */
    public InkaAnfallstMessstId(
        Integer anfallstelleNr, Integer messstelleLfdNr) {
        this.anfallstelleNr = anfallstelleNr;
        this.messstelleLfdNr = messstelleLfdNr;
    }

    /* Setter and getter methods */
    public Integer getAnfallstelleNr() {
        return this.anfallstelleNr;
    }

    public void setAnfallstelleNr(Integer anfallstelleNr) {
        this.anfallstelleNr = anfallstelleNr;
    }

    public Integer getMessstelleLfdNr() {
        return this.messstelleLfdNr;
    }

    public void setMessstelleLfdNr(Integer messstelleLfdNr) {
        this.messstelleLfdNr = messstelleLfdNr;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other )) return true;
        if ((other == null )) return false;
        if (!(other instanceof InkaAnfallstMessstId) ) return false;
        InkaAnfallstMessstId castOther = ( InkaAnfallstMessstId ) other;
        return ( (this.getAnfallstelleNr()==castOther.getAnfallstelleNr()) || ( this.getAnfallstelleNr()!=null && castOther.getAnfallstelleNr()!=null && this.getAnfallstelleNr().equals(castOther.getAnfallstelleNr()) ) )
 && ( (this.getMessstelleLfdNr()==castOther.getMessstelleLfdNr()) || ( this.getMessstelleLfdNr()!=null && castOther.getMessstelleLfdNr()!=null && this.getMessstelleLfdNr().equals(castOther.getMessstelleLfdNr()) ) );
   }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + ( getAnfallstelleNr() == null ? 0 : this.getAnfallstelleNr().hashCode() );
        result = 37 * result + ( getMessstelleLfdNr() == null ? 0 : this.getMessstelleLfdNr().hashCode() );
        return result;
    }
    /* Custom code goes below here! */

}