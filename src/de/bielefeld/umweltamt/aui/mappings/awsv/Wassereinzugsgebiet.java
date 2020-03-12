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

package de.bielefeld.umweltamt.aui.mappings.awsv;

import de.bielefeld.umweltamt.aui.mappings.DatabaseAccess;
import de.bielefeld.umweltamt.aui.mappings.DatabaseClassToString;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.DatabaseSerialVersionUID;
import de.bielefeld.umweltamt.aui.mappings.basis.Lage;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class that represents a row in the Wassereinzugsgebiet database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class Wassereinzugsgebiet  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forWassereinzugsgebiet;
    
    /* Primary key, foreign keys (relations) and table columns */
    private Integer id;
    private String ezgbname;
    private boolean enabled;
    private boolean deleted;
    private Set<Lage> lages = new HashSet<Lage>(0);

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public Wassereinzugsgebiet() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public Wassereinzugsgebiet(
        Integer id, boolean enabled, boolean deleted) {
        this.id = id;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public Wassereinzugsgebiet(
        Integer id, String ezgbname, boolean enabled, boolean deleted, Set<Lage> lages) {
        this.id = id;
        this.ezgbname = ezgbname;
        this.enabled = enabled;
        this.deleted = deleted;
        this.lages = lages;
    }

    /* Setter and getter methods */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEzgbname() {
        return this.ezgbname;
    }

    public void setEzgbname(String ezgbname) {
        this.ezgbname = ezgbname;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @JsonBackReference
    public Set<Lage> getLages() {
        return this.lages;
    }

    public void setLages(Set<Lage> lages) {
        this.lages = lages;
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
        buffer.append("ezgbname").append("='").append(getEzgbname()).append("' ");			
        buffer.append("enabled").append("='").append(isEnabled()).append("' ");			
        buffer.append("deleted").append("='").append(isDeleted()).append("' ");			
        buffer.append("lages").append("='").append(getLages()).append("' ");			
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
        if (!(other instanceof Wassereinzugsgebiet)) return false;
        return (this.getId().equals(
            ((Wassereinzugsgebiet) other).getId()));
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
     * @return <code>Wassereinzugsgebiet</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static Wassereinzugsgebiet merge(Wassereinzugsgebiet detachedInstance) {
        log.debug("Merging Wassereinzugsgebiet instance " + detachedInstance);
        return (Wassereinzugsgebiet) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        Wassereinzugsgebiet saved = Wassereinzugsgebiet.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this Wassereinzugsgebiet with its new values.<br>
     * This is meant to be used after merging!
     * @param copy Wassereinzugsgebiet
     */
    private void copy(Wassereinzugsgebiet copy) {
        this.id = copy.getId();            
        this.ezgbname = copy.getEzgbname();            
        this.enabled = copy.isEnabled();            
        this.deleted = copy.isDeleted();            
        this.lages = copy.getLages();            
    }    

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(Wassereinzugsgebiet detachedInstance) {
        log.debug("Deleting Wassereinzugsgebiet instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return Wassereinzugsgebiet.delete(this);
    }

    /**
     * Find an <code>Wassereinzugsgebiet</code> instance by its primary key
     * @param id the primary key value
     * @return <code>Wassereinzugsgebiet</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static Wassereinzugsgebiet findById(java.lang.Integer id) {
        log.debug("Getting Wassereinzugsgebiet instance with id: " + id);
        return (Wassereinzugsgebiet)
            new DatabaseAccess().get(Wassereinzugsgebiet.class, id);
    }

    /**
     * Get a list of all <code>Wassereinzugsgebiet</code>
     * @return <code>List&lt;Wassereinzugsgebiet&gt;</code>
     *         all <code>Wassereinzugsgebiet</code>
     */
    public static List<Wassereinzugsgebiet> getAll() {
        return DatabaseQuery.getAll(new Wassereinzugsgebiet());
    }

	public String toGuiString() {
		return getEzgbname();
	}

    /* Custom code goes below here! */

}