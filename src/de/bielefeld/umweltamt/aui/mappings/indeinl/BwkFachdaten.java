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

package de.bielefeld.umweltamt.aui.mappings.indeinl;

import de.bielefeld.umweltamt.aui.HibernateSessionFactory;
import de.bielefeld.umweltamt.aui.mappings.DatabaseAccess;
import de.bielefeld.umweltamt.aui.mappings.DatabaseClassToString;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.DatabaseSerialVersionUID;
import de.bielefeld.umweltamt.aui.mappings.basis.Objekt;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * A class that represents a row in the BwkFachdaten database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class BwkFachdaten  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forBwkFachdaten;
    
    /* Primary key, foreign keys (relations) and table columns */
    private Integer id;
    private Objekt objekt;
    private String branche;
    private String KHersteller;
    private String KTyp;
    private String KBrennmittel;
    private Integer KLeistung;
    private Date datumG;
    private Boolean aba;
    private String WBrenner;
    private String WWaermetauscher;
    private String WAbgasleitung;
    private String WKondensableitung;
    private String abnahme;
    private String bemerkungen;
    private Date anschreiben;
    private Integer erfassung;
    private Boolean genehmigung;
    private Boolean genehmigungspflicht;
    private boolean enabled;
    private boolean deleted;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public BwkFachdaten() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public BwkFachdaten(
        Integer id, Objekt objekt, boolean enabled, boolean deleted) {
        this.id = id;
        this.objekt = objekt;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public BwkFachdaten(
        Integer id, Objekt objekt, String branche, String KHersteller, String KTyp, String KBrennmittel, Integer KLeistung, Date datumG, Boolean aba, String WBrenner, String WWaermetauscher, String WAbgasleitung, String WKondensableitung, String abnahme, String bemerkungen, Date anschreiben, Integer erfassung, Boolean genehmigung, Boolean genehmigungspflicht, boolean enabled, boolean deleted) {
        this.id = id;
        this.objekt = objekt;
        this.branche = branche;
        this.KHersteller = KHersteller;
        this.KTyp = KTyp;
        this.KBrennmittel = KBrennmittel;
        this.KLeistung = KLeistung;
        this.datumG = datumG;
        this.aba = aba;
        this.WBrenner = WBrenner;
        this.WWaermetauscher = WWaermetauscher;
        this.WAbgasleitung = WAbgasleitung;
        this.WKondensableitung = WKondensableitung;
        this.abnahme = abnahme;
        this.bemerkungen = bemerkungen;
        this.anschreiben = anschreiben;
        this.erfassung = erfassung;
        this.genehmigung = genehmigung;
        this.genehmigungspflicht = genehmigungspflicht;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /* Setter and getter methods */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Objekt getObjekt() {
        return this.objekt;
    }

    public void setObjekt(Objekt objekt) {
        this.objekt = objekt;
    }

    public String getBranche() {
        return this.branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public String getKHersteller() {
        return this.KHersteller;
    }

    public void setKHersteller(String KHersteller) {
        this.KHersteller = KHersteller;
    }

    public String getKTyp() {
        return this.KTyp;
    }

    public void setKTyp(String KTyp) {
        this.KTyp = KTyp;
    }

    public String getKBrennmittel() {
        return this.KBrennmittel;
    }

    public void setKBrennmittel(String KBrennmittel) {
        this.KBrennmittel = KBrennmittel;
    }

    public Integer getKLeistung() {
        return this.KLeistung;
    }

    public void setKLeistung(Integer KLeistung) {
        this.KLeistung = KLeistung;
    }

    public Date getDatumG() {
        return this.datumG;
    }

    public void setDatumG(Date datumG) {
        this.datumG = datumG;
    }

    public Boolean getAba() {
        return this.aba;
    }

    public void setAba(Boolean aba) {
        this.aba = aba;
    }

    public String getWBrenner() {
        return this.WBrenner;
    }

    public void setWBrenner(String WBrenner) {
        this.WBrenner = WBrenner;
    }

    public String getWWaermetauscher() {
        return this.WWaermetauscher;
    }

    public void setWWaermetauscher(String WWaermetauscher) {
        this.WWaermetauscher = WWaermetauscher;
    }

    public String getWAbgasleitung() {
        return this.WAbgasleitung;
    }

    public void setWAbgasleitung(String WAbgasleitung) {
        this.WAbgasleitung = WAbgasleitung;
    }

    public String getWKondensableitung() {
        return this.WKondensableitung;
    }

    public void setWKondensableitung(String WKondensableitung) {
        this.WKondensableitung = WKondensableitung;
    }

    public String getAbnahme() {
        return this.abnahme;
    }

    public void setAbnahme(String abnahme) {
        this.abnahme = abnahme;
    }

    public String getBemerkungen() {
        return this.bemerkungen;
    }

    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    public Date getAnschreiben() {
        return this.anschreiben;
    }

    public void setAnschreiben(Date anschreiben) {
        this.anschreiben = anschreiben;
    }

    public Integer getErfassung() {
        return this.erfassung;
    }

    public void setErfassung(Integer erfassung) {
        this.erfassung = erfassung;
    }

    public Boolean getGenehmigung() {
        return this.genehmigung;
    }

    public void setGenehmigung(Boolean genehmigung) {
        this.genehmigung = genehmigung;
    }

    public Boolean getGenehmigungspflicht() {
        return this.genehmigungspflicht;
    }

    public void setGenehmigungspflicht(Boolean genehmigungspflicht) {
        this.genehmigungspflicht = genehmigungspflicht;
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
        buffer.append("objekt").append("='").append(getObjekt()).append("' ");			
        buffer.append("branche").append("='").append(getBranche()).append("' ");			
        buffer.append("KHersteller").append("='").append(getKHersteller()).append("' ");			
        buffer.append("KTyp").append("='").append(getKTyp()).append("' ");			
        buffer.append("KBrennmittel").append("='").append(getKBrennmittel()).append("' ");			
        buffer.append("KLeistung").append("='").append(getKLeistung()).append("' ");			
        buffer.append("datumG").append("='").append(getDatumG()).append("' ");			
        buffer.append("aba").append("='").append(getAba()).append("' ");			
        buffer.append("WBrenner").append("='").append(getWBrenner()).append("' ");			
        buffer.append("WWaermetauscher").append("='").append(getWWaermetauscher()).append("' ");			
        buffer.append("WAbgasleitung").append("='").append(getWAbgasleitung()).append("' ");			
        buffer.append("WKondensableitung").append("='").append(getWKondensableitung()).append("' ");			
        buffer.append("abnahme").append("='").append(getAbnahme()).append("' ");			
        buffer.append("bemerkungen").append("='").append(getBemerkungen()).append("' ");			
        buffer.append("anschreiben").append("='").append(getAnschreiben()).append("' ");			
        buffer.append("erfassung").append("='").append(getErfassung()).append("' ");			
        buffer.append("genehmigung").append("='").append(getGenehmigung()).append("' ");			
        buffer.append("genehmigungspflicht").append("='").append(getGenehmigungspflicht()).append("' ");			
        buffer.append("enabled").append("='").append(isEnabled()).append("' ");			
        buffer.append("deleted").append("='").append(isDeleted()).append("' ");			
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
        if (!(other instanceof BwkFachdaten)) return false;
        return (this.getId().equals(
            ((BwkFachdaten) other).getId()));
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
     * @return <code>BwkFachdaten</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static BwkFachdaten merge(BwkFachdaten detachedInstance) {
        log.debug("Merging BwkFachdaten instance " + detachedInstance);
        return (BwkFachdaten) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        BwkFachdaten saved = BwkFachdaten.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this BwkFachdaten with its new values.<br>
     * This is meant to be used after merging!
     * @param copy BwkFachdaten
     */
    private void copy(BwkFachdaten copy) {
        this.id = copy.getId();            
        this.objekt = copy.getObjekt();            
        this.branche = copy.getBranche();            
        this.KHersteller = copy.getKHersteller();            
        this.KTyp = copy.getKTyp();            
        this.KBrennmittel = copy.getKBrennmittel();            
        this.KLeistung = copy.getKLeistung();            
        this.datumG = copy.getDatumG();            
        this.aba = copy.getAba();            
        this.WBrenner = copy.getWBrenner();            
        this.WWaermetauscher = copy.getWWaermetauscher();            
        this.WAbgasleitung = copy.getWAbgasleitung();            
        this.WKondensableitung = copy.getWKondensableitung();            
        this.abnahme = copy.getAbnahme();            
        this.bemerkungen = copy.getBemerkungen();            
        this.anschreiben = copy.getAnschreiben();            
        this.erfassung = copy.getErfassung();            
        this.genehmigung = copy.getGenehmigung();            
        this.genehmigungspflicht = copy.getGenehmigungspflicht();            
        this.enabled = copy.isEnabled();            
        this.deleted = copy.isDeleted();            
    }    

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(BwkFachdaten detachedInstance) {
        log.debug("Deleting BwkFachdaten instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return BwkFachdaten.delete(this);
    }

    /**
     * Find an <code>BwkFachdaten</code> instance by its primary key
     * @param id the primary key value
     * @return <code>BwkFachdaten</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static BwkFachdaten findById(java.lang.Integer id) {
        log.debug("Getting BwkFachdaten instance with id: " + id);
        return (BwkFachdaten)
            new DatabaseAccess().get(BwkFachdaten.class, id);
    }

    /**
     * Get a list of all <code>BwkFachdaten</code>
     * @return <code>List&lt;BwkFachdaten&gt;</code>
     *         all <code>BwkFachdaten</code>
     */
    public static List<BwkFachdaten> getAll() {
        return DatabaseQuery.getAll(new BwkFachdaten());
    }

    /* Custom code goes below here! */

    public static BwkFachdaten findByObjektId(java.lang.Integer id) {
        log.debug("Getting AnhBwkFachdaten instance with connected Objekt with id: " + id);
        /*List<AnhBwkFachdaten> all = AnhBwkFachdaten.getAll();
        for(AnhBwkFachdaten i : all){
            if(i.getBasisObjekt().getId().equals(id)){
                return (AnhBwkFachdaten) new DatabaseAccess().get(AnhBwkFachdaten.class, i.getId());
            }
        }
        return null;*/
        Objekt objekt = (Objekt) HibernateSessionFactory.currentSession().createQuery("from Objekt where id= " + id).list().get(0);
        //BasisObjekt.findById(id);
        Set<BwkFachdaten> list = objekt.getBwkFachdatens();
        return list.iterator().next();
    }
}