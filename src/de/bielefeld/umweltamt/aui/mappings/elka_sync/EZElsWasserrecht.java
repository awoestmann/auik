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

// Generated by Hibernate Tools 5.0.0.Final

package de.bielefeld.umweltamt.aui.mappings.elka_sync;

import de.bielefeld.umweltamt.aui.mappings.DatabaseAccess;
import de.bielefeld.umweltamt.aui.mappings.DatabaseClassToString;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.DatabaseSerialVersionUID;
import de.bielefeld.umweltamt.aui.mappings.elka.Einleitungsstelle;
import de.bielefeld.umweltamt.aui.mappings.elka.Wasserrecht;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import java.util.List;

/**
 * A class that represents a row in the ZElsWasserrecht database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class EZElsWasserrecht  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forZElsWasserrecht;
    
    /* Primary key, foreign keys (relations) and table columns */
    private EZElsWasserrechtId id;
    private Einleitungsstelle einleitungsstelle;
    private Wasserrecht wasserrecht;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public EZElsWasserrecht() {
        // This place is intentionally left blank.
    }


    /** Full constructor */
    public EZElsWasserrecht(
        EZElsWasserrechtId id, Einleitungsstelle einleitungsstelle, Wasserrecht wasserrecht) {
        this.id = id;
        this.einleitungsstelle = einleitungsstelle;
        this.wasserrecht = wasserrecht;
    }

    /* Setter and getter methods */
    public EZElsWasserrechtId getId() {
        return this.id;
    }

    public void setId(EZElsWasserrechtId id) {
        this.id = id;
    }

    public Einleitungsstelle getEinleitungsstelle() {
        return this.einleitungsstelle;
    }

    public void setEinleitungsstelle(Einleitungsstelle einleitungsstelle) {
        this.einleitungsstelle = einleitungsstelle;
    }

    public Wasserrecht getWasserrecht() {
        return this.wasserrecht;
    }

    public void setWasserrecht(Wasserrecht wasserrecht) {
        this.wasserrecht = wasserrecht;
    }

    /**
     * To implement custom toString methods, jump to not generated code.<br>
     * Basically we either call on <code>toDebugString</code> for a debug
     * string, call on <code>toGuiString</code> for a gui representation or do
     * something completely different.
     * @return String
     */
    @Override
    public String toString() {
        return DatabaseClassToString.toStringForClass(this); 
    }

    /**
     * Get a string representation for debugging
     * @return String
     */
    public String toDebugString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("id").append("='").append(getId()).append("' ");			
        buffer.append("einleitungsstelle").append("='").append(getEinleitungsstelle()).append("' ");			
        buffer.append("wasserrecht").append("='").append(getWasserrecht()).append("' ");			
        buffer.append("]");

        return buffer.toString();
    }

    /**
     * @param other
     * @return <code>true</code>, if this and other are equal,
     *         <code>false</code> otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof EZElsWasserrecht)) return false;
        return (this.getId().equals(
            ((EZElsWasserrecht) other).getId()));
    }

    /**
     * Calculate a unique hashCode
     * @return <code>int</code>
     */
    @Override
    public int hashCode() {
        int result = 17;
        int idValue = this.getId() == null ?
            0 : this.getId().hashCode();
        result = result * 37 + idValue;
        return result;
    }
    
    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>ZElsWasserrecht</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static EZElsWasserrecht merge(EZElsWasserrecht detachedInstance) {
        log.debug("Merging ZElsWasserrecht instance " + detachedInstance);
        return (EZElsWasserrecht) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        EZElsWasserrecht saved = EZElsWasserrecht.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this ZElsWasserrecht with its new values.<br>
     * This is meant to be used after merging!
     * @param copy ZElsWasserrecht
     */
    private void copy(EZElsWasserrecht copy) {
        this.id = copy.getId();            
        this.einleitungsstelle = copy.getEinleitungsstelle();            
        this.wasserrecht = copy.getWasserrecht();            
    }    

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(EZElsWasserrecht detachedInstance) {
        log.debug("Deleting ZElsWasserrecht instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return EZElsWasserrecht.delete(this);
    }

    /**
     * Find an <code>ZElsWasserrecht</code> instance by its primary key
     * @param id the primary key value
     * @return <code>ZElsWasserrecht</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static EZElsWasserrecht findById(de.bielefeld.umweltamt.aui.mappings.elka.ZElsWasserrechtId id) {
        log.debug("Getting ZElsWasserrecht instance with id: " + id);
        return (EZElsWasserrecht)
            new DatabaseAccess().get(EZElsWasserrecht.class, id);
    }

    /**
     * Get a list of all <code>ZElsWasserrecht</code>
     * @return <code>List&lt;ZElsWasserrecht&gt;</code>
     *         all <code>ZElsWasserrecht</code>
     */
    public static List<EZElsWasserrecht> getAll() {
        return DatabaseQuery.getAll(new EZElsWasserrecht());
    }

    /* Custom code goes below here! */

}