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
import de.bielefeld.umweltamt.aui.mappings.elka_sync.EWasserrecht;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.mappings.oberflgw.ZEntwaessgrAbwasbehverf;
import de.bielefeld.umweltamt.aui.mappings.oberflgw.AfsNiederschlagswasser;
import de.bielefeld.umweltamt.aui.mappings.oberflgw.Entwaesserungsgrundstueck;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * A class that represents a row in the EEntwaesserungsgrundstueck database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class EEntwaesserungsgrundstueck  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forEEntwaesserungsgrundstueck;

    /* Primary key, foreign keys (relations) and table columns */
    private Integer nr;
    private EStandort standort;
    private EAdresse adresse;
    private Integer origNr;
    private Boolean erlFreiElTog;
    private BigDecimal regenspende;
    private BigDecimal regenhaeufigkeit;
    private String beschreibung;
    private Integer regendauer;
    private Integer grEntwGebiet;
    private BigDecimal dtvWert;
    private Integer wasserableitungsstreckeOpt;
    private String nameEtwGebiet;
    private Date erstellDat;
    private Integer einlBereichOpt;
    private String abwbeskonnr;
    private Integer einbauartOpt;
    private Date aktualDat;
    private EWasserrecht wasserrecht;
    private String herkunft;
    private String externalNr;

    /** Default constructor */
    public EEntwaesserungsgrundstueck() {
        // This place is intentionally left blank.
    }

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Full constructor */
    public EEntwaesserungsgrundstueck(
        Integer nr, EStandort standort, EAdresse adresse, Boolean erlFreiElTog, BigDecimal regenspende, BigDecimal regenhaeufigkeit, String beschreibung, Integer regendauer, Integer grEntwGebiet, BigDecimal dtvWert, Integer wasserableitungsstreckeOpt, String nameEtwGebiet, Date erstellDat, Integer einlBereichOpt, String abwbeskonNr, Integer einbauartOpt, Date aktualDat, EWasserrecht wasserecht, String herkunft, String externalNr) {
        this.nr = nr;
        this.standort = standort;
        this.adresse = adresse;
        this.erlFreiElTog = erlFreiElTog;
        this.regenspende = regenspende;
        this.regenhaeufigkeit = regenhaeufigkeit;
        this.beschreibung = beschreibung;
        this.regendauer = regendauer;
        this.grEntwGebiet = grEntwGebiet;
        this.dtvWert = dtvWert;
        this.wasserableitungsstreckeOpt = wasserableitungsstreckeOpt;
        this.nameEtwGebiet = nameEtwGebiet;
        this.erstellDat = erstellDat;
        this.einlBereichOpt = einlBereichOpt;
        this.abwbeskonnr = abwbeskonNr;
        this.einbauartOpt = einbauartOpt;
        this.aktualDat = aktualDat;
        this.wasserrecht = wasserecht;
        this.herkunft = herkunft;
        this.externalNr = externalNr;
    }

    @JsonIgnore
	public Integer getOrigNr() {
		return this.origNr;
	}
	
	@JsonIgnore
	public void setOrigNr(Integer origNr) {
		this.origNr = origNr;
	}

    /* Setter and getter methods */
    public Integer getNr() {
        return this.nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public EStandort getStandort() {
        return this.standort;
    }

    public void setStandort(EStandort standort) {
        this.standort = standort;
    }

    public EAdresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(EAdresse adresse) {
        this.adresse = adresse;
    }

    public Boolean getErlFreiElTog() {
        return this.erlFreiElTog;
    }

    public void setErlFreiElTog(Boolean erlFreiElTog) {
        this.erlFreiElTog = erlFreiElTog;
    }

    public BigDecimal getRegenspende() {
        return this.regenspende;
    }

    public void setRegenspende(BigDecimal regenspende) {
        this.regenspende = regenspende;
    }

    public BigDecimal getRegenhaeufigkeit() {
        return this.regenhaeufigkeit;
    }

    public void setRegenhaeufigkeit(BigDecimal regenhaeufigkeit) {
        this.regenhaeufigkeit = regenhaeufigkeit;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Integer getRegendauer() {
        return this.regendauer;
    }

    public void setRegendauer(Integer regendauer) {
        this.regendauer = regendauer;
    }

    public Integer getGrEntwGebiet() {
        return this.grEntwGebiet;
    }

    public void setGrEntwGebiet(Integer grEntwGebiet) {
        this.grEntwGebiet = grEntwGebiet;
    }

    public BigDecimal getDtvWert() {
        return this.dtvWert;
    }

    public void setDtvWert(BigDecimal dtvWert) {
        this.dtvWert = dtvWert;
    }

    public Integer getWasserableitungsstreckeOpt() {
        return this.wasserableitungsstreckeOpt;
    }

    public void setWasserableitungsstreckeOpt(Integer wasserableitungsstreckeOpt) {
        this.wasserableitungsstreckeOpt = wasserableitungsstreckeOpt;
    }

    public String getNameEtwGebiet() {
        return this.nameEtwGebiet;
    }

    public void setNameEtwGebiet(String nameEtwGebiet) {
        this.nameEtwGebiet = nameEtwGebiet;
    }

    public Date getErstellDat() {
        return this.erstellDat;
    }

    public void setErstellDat(Date erstellDat) {
        this.erstellDat = erstellDat;
    }

    public Integer getEinlBereichOpt() {
        return this.einlBereichOpt;
    }

    public void setEinlBereichOpt(Integer einlBereichOpt) {
        this.einlBereichOpt = einlBereichOpt;
    }

    public String getAbwbeskonnr() {
        return this.abwbeskonnr;
    }

    public void setAbwbeskonnr(String abwbeskonNr) {
        this.abwbeskonnr = abwbeskonNr;
    }

    public Integer getEinbauartOpt() {
        return this.einbauartOpt;
    }

    public void setEinbauartOpt(Integer einbauartOpt) {
        this.einbauartOpt = einbauartOpt;
    }

    public Date getAktualDat() {
        return this.aktualDat;
    }

    public void setAktualDat(Date aktualDat) {
        this.aktualDat = aktualDat;
    }

    public EWasserrecht getWasserrecht() {
        return this.wasserrecht;
    }

    public void setWasserrecht(EWasserrecht wasserecht) {
        this.wasserrecht = wasserecht;
    }

    public String getHerkunft() {
        return this.herkunft;
    }

    public void setHerkunft(String herkunft) {
        this.herkunft = herkunft;
    }

    public String getExternalNr() {
        return this.externalNr;
    }

    public void setExternalNr(String externalNr) {
        this.externalNr = externalNr;
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
        buffer.append("nr").append("='").append(getNr()).append("' ");			
        buffer.append("erlFreiElTog").append("='").append(getErlFreiElTog()).append("' ");			
        buffer.append("regenspende").append("='").append(getRegenspende()).append("' ");			
        buffer.append("regenhaeufigkeit").append("='").append(getRegenhaeufigkeit()).append("' ");			
        buffer.append("beschreibung").append("='").append(getBeschreibung()).append("' ");			
        buffer.append("regendauer").append("='").append(getRegendauer()).append("' ");			
        buffer.append("grEntwGebiet").append("='").append(getGrEntwGebiet()).append("' ");			
        buffer.append("dtvWert").append("='").append(getDtvWert()).append("' ");			
        buffer.append("wasserableitungsstreckeOpt").append("='").append(getWasserableitungsstreckeOpt()).append("' ");			
        buffer.append("nameEtwGebiet").append("='").append(getNameEtwGebiet()).append("' ");			
        buffer.append("erstellDat").append("='").append(getErstellDat()).append("' ");			
        buffer.append("einlBereichOpt").append("='").append(getEinlBereichOpt()).append("' ");			
        buffer.append("abwbeskonNr").append("='").append(getAbwbeskonnr()).append("' ");			
        buffer.append("einbauartOpt").append("='").append(getEinbauartOpt()).append("' ");			
        buffer.append("aktualDat").append("='").append(getAktualDat()).append("' ");			
        buffer.append("wasserecht").append("='").append(getWasserrecht()).append("' ");			
        buffer.append("herkunft").append("='").append(getHerkunft()).append("' ");			
        buffer.append("externalNr").append("='").append(getExternalNr()).append("' ");			
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
        if (!(other instanceof EEntwaesserungsgrundstueck)) return false;
        return (this.getNr().equals(
            ((EEntwaesserungsgrundstueck) other).getNr()));
    }

    /**
     * Calculate a unique hashCode
     * @return <code>int</code>
     */
    @Override
    public int hashCode() {
        int result = 17;
        int idValue = this.getNr() == null ?
            0 : this.getNr().hashCode();
        result = result * 37 + idValue;
        return result;
    }
    
    /**
     * Merge (save or update) a detached instance
     * @param detachedInstance the instance to merge
     * @return <code>EEntwaesserungsgrundstueck</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static EEntwaesserungsgrundstueck merge(EEntwaesserungsgrundstueck detachedInstance) {
        log.debug("Merging EEntwaesserungsgrundstueck instance " + detachedInstance);
        return (EEntwaesserungsgrundstueck) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        EEntwaesserungsgrundstueck saved = EEntwaesserungsgrundstueck.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this EEntwaesserungsgrundstueck with its new values.<br>
     * This is meant to be used after merging!
     * @param copy EEntwaesserungsgrundstueck
     */
    private void copy(EEntwaesserungsgrundstueck copy) {
        this.nr = copy.getNr();            
    }    

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(EEntwaesserungsgrundstueck detachedInstance) {
        log.debug("Deleting EEntwaesserungsgrundstueck instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return EEntwaesserungsgrundstueck.delete(this);
    }

    /**
     * Find an <code>EEntwaesserungsgrundstueck</code> instance by its primary key
     * @param id the primary key value
     * @return <code>EEntwaesserungsgrundstueck</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static EEntwaesserungsgrundstueck findById(Integer id) {
        log.debug("Getting EEntwaesserungsgrundstueck instance with id: " + id);
        return (EEntwaesserungsgrundstueck)
            new DatabaseAccess().get(EEntwaesserungsgrundstueck.class, id);
    }

    /**
     * Get a list of all <code>EEntwaesserungsgrundstueck</code>
     * @return <code>List&lt;EEntwaesserungsgrundstueck&gt;</code>
     *         all <code>EEntwaesserungsgrundstueck</code>
     */
    public static List<EEntwaesserungsgrundstueck> getAll() {
        return DatabaseQuery.getAll(new EEntwaesserungsgrundstueck());
    }

    /* Custom code goes below here! */

    /**
     * Get ZEntwaessgrAbwasbehverf instances connected to the Entwasserungsgrundstueck table entry
     * on which this instance is based on.
     * @return The instances as set
     */
    @JsonIgnore
    public Set<ZEntwaessgrAbwasbehverf> getZEntwassergrAbwasbehverfs() {
        Entwaesserungsgrundstueck entwaesserungsgrundstueck = Entwaesserungsgrundstueck.findById(getNr());
        return entwaesserungsgrundstueck != null ? entwaesserungsgrundstueck.getZEntwaessgrAbwasbehverfs() : null;
    }

    /**
     * Get the AfsNiederschlagwasser instances connected to the Entwaesserungsgrundstueck table entry
     * on which this instance is based on.
     * @return The instances as set
     */
    @JsonIgnore
    public Set<AfsNiederschlagswasser> getAfsNiederschlagwassers () {
        Entwaesserungsgrundstueck entwaesserungsgrundstueck = Entwaesserungsgrundstueck.findById(getNr());
        return entwaesserungsgrundstueck != null ? entwaesserungsgrundstueck.getAfsNiederschlagswassers() : null;
    }

}
