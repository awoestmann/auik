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

package de.bielefeld.umweltamt.aui.mappings.oberflgw;

import de.bielefeld.umweltamt.aui.mappings.DatabaseAccess;
import de.bielefeld.umweltamt.aui.mappings.DatabaseClassToString;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.DatabaseSerialVersionUID;
import de.bielefeld.umweltamt.aui.mappings.basis.Adresse;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import java.util.List;

/**
 * A class that represents a row in the ZBetriebMassnahme database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class ZBetriebMassnahme  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forZBetriebMassnahme;
    
    /* Primary key, foreign keys (relations) and table columns */
    private ZBetriebMassnahmeId id;
    private Adresse adresse;
    private Massnahme massnahme;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public ZBetriebMassnahme() {
        // This place is intentionally left blank.
    }


    /** Full constructor */
    public ZBetriebMassnahme(
        ZBetriebMassnahmeId id, Adresse adresse, Massnahme massnahme) {
        this.id = id;
        this.adresse = adresse;
        this.massnahme = massnahme;
    }

    /* Setter and getter methods */
    public ZBetriebMassnahmeId getId() {
        return this.id;
    }

    public void setId(ZBetriebMassnahmeId id) {
        this.id = id;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Massnahme getMassnahme() {
        return this.massnahme;
    }

    public void setMassnahme(Massnahme massnahme) {
        this.massnahme = massnahme;
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
        //TODO
        return "";
    }

    /**
     * Get a string representation for debugging
     * @return String
     */
    public String toDebugString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append(getClass().getSimpleName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
        buffer.append("id").append("='").append(getId()).append("' ");			
        buffer.append("adresse").append("='").append(getAdresse()).append("' ");			
        buffer.append("massnahme").append("='").append(getMassnahme()).append("' ");			
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
        if (!(other instanceof ZBetriebMassnahme)) return false;
        return (this.getId().equals(
            ((ZBetriebMassnahme) other).getId()));
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
     * @return <code>ZBetriebMassnahme</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static ZBetriebMassnahme merge(ZBetriebMassnahme detachedInstance) {
        log.debug("Merging ZBetriebMassnahme instance " + detachedInstance);
        return (ZBetriebMassnahme) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        ZBetriebMassnahme saved = ZBetriebMassnahme.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this ZBetriebMassnahme with its new values.<br>
     * This is meant to be used after merging!
     * @param copy ZBetriebMassnahme
     */
    private void copy(ZBetriebMassnahme copy) {
        this.id = copy.getId();            
        this.adresse = copy.getAdresse();            
        this.massnahme = copy.getMassnahme();            
    }    

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(ZBetriebMassnahme detachedInstance) {
        log.debug("Deleting ZBetriebMassnahme instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return ZBetriebMassnahme.delete(this);
    }

    /**
     * Find an <code>ZBetriebMassnahme</code> instance by its primary key
     * @param id the primary key value
     * @return <code>ZBetriebMassnahme</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static ZBetriebMassnahme findById(de.bielefeld.umweltamt.aui.mappings.oberflgw.ZBetriebMassnahmeId id) {
        log.debug("Getting ZBetriebMassnahme instance with id: " + id);
        return (ZBetriebMassnahme)
            new DatabaseAccess().get(ZBetriebMassnahme.class, id);
    }

    /**
     * Get a list of all <code>ZBetriebMassnahme</code>
     * @return <code>List&lt;ZBetriebMassnahme&gt;</code>
     *         all <code>ZBetriebMassnahme</code>
     */
    public static List<ZBetriebMassnahme> getAll() {
        return DatabaseQuery.getAll(new ZBetriebMassnahme());
    }

    /* Custom code goes below here! */

}
