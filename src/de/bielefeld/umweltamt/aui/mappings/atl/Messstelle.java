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

package de.bielefeld.umweltamt.aui.mappings.atl;

import de.bielefeld.umweltamt.aui.HibernateSessionFactory;
import de.bielefeld.umweltamt.aui.mappings.DatabaseAccess;
import de.bielefeld.umweltamt.aui.mappings.DatabaseClassToString;
import de.bielefeld.umweltamt.aui.mappings.DatabaseQuery;
import de.bielefeld.umweltamt.aui.mappings.DatabaseSerialVersionUID;
import de.bielefeld.umweltamt.aui.mappings.basis.Objekt;
import de.bielefeld.umweltamt.aui.mappings.basis.Sachbearbeiter;
import de.bielefeld.umweltamt.aui.mappings.elka.Referenz;
import de.bielefeld.umweltamt.aui.mappings.oberflgw.MsstBerichtspflicht;
import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class that represents a row in the Messstelle database table.<br>
 * This class is meant to serve as a model and should be copied into the
 * appropriate package and may be customized below the given mark.
 */
public class Messstelle  implements java.io.Serializable {

    /** Generated serialVersionUID for Serializable interface */
    private static final long serialVersionUID =
        DatabaseSerialVersionUID.forMessstelle;

    /* Primary key, foreign keys (relations) and table columns */
    private Integer id;
    private Objekt objekt;
    private Sachbearbeiter sachbearbeiter;
    private Klaeranlage klaeranlage;
    private Probeart probeart;
    private String beschreibung;
    private Integer nrProbepkt;
    private Integer firmenId;
    private String branche;
    private boolean enabled;
    private boolean deleted;
    private Set<Probenahme> probenahmes = new HashSet<Probenahme>(0);
    private Set<MsstBerichtspflicht> msstBerichtspflichts = new HashSet<MsstBerichtspflicht>(0);
    private Set<Referenz> referenzsForQMsstNr = new HashSet<Referenz>(0);
    private Set<Referenz> referenzsForZMsstNr = new HashSet<Referenz>(0);
    private Set<Sielhaut> sielhauts = new HashSet<Sielhaut>(0);

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /** Default constructor */
    public Messstelle() {
        // This place is intentionally left blank.
    }

    /** Minimal constructor */
    public Messstelle(
        Integer id, Objekt objekt, boolean enabled, boolean deleted) {
        this.id = id;
        this.objekt = objekt;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    /** Full constructor */
    public Messstelle(
        Integer id, Objekt objekt, Sachbearbeiter sachbearbeiter, Klaeranlage klaeranlage, Probeart probeart, String beschreibung, Integer nrProbepkt, Integer firmenId, String branche, boolean enabled, boolean deleted, Set<Probenahme> probenahmes, Set<MsstBerichtspflicht> msstBerichtspflichts, Set<Referenz> referenzsForQMsstNr, Set<Referenz> referenzsForZMsstNr, Set<Sielhaut> sielhauts) {
        this.id = id;
        this.objekt = objekt;
        this.sachbearbeiter = sachbearbeiter;
        this.klaeranlage = klaeranlage;
        this.probeart = probeart;
        this.beschreibung = beschreibung;
        this.nrProbepkt = nrProbepkt;
        this.firmenId = firmenId;
        this.branche = branche;
        this.enabled = enabled;
        this.deleted = deleted;
        this.probenahmes = probenahmes;
        this.msstBerichtspflichts = msstBerichtspflichts;
        this.referenzsForQMsstNr = referenzsForQMsstNr;
        this.referenzsForZMsstNr = referenzsForZMsstNr;
        this.sielhauts = sielhauts;
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

    public Sachbearbeiter getSachbearbeiter() {
        return this.sachbearbeiter;
    }

    public void setSachbearbeiter(Sachbearbeiter sachbearbeiter) {
        this.sachbearbeiter = sachbearbeiter;
    }

    public Klaeranlage getKlaeranlage() {
        return this.klaeranlage;
    }

    public void setKlaeranlage(Klaeranlage klaeranlage) {
        this.klaeranlage = klaeranlage;
    }

    public Probeart getProbeart() {
        return this.probeart;
    }

    public void setProbeart(Probeart probeart) {
        this.probeart = probeart;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Integer getNrProbepkt() {
        return this.nrProbepkt;
    }

    public void setNrProbepkt(Integer nrProbepkt) {
        this.nrProbepkt = nrProbepkt;
    }

    public Integer getFirmenId() {
        return this.firmenId;
    }

    public void setFirmenId(Integer firmenId) {
        this.firmenId = firmenId;
    }

    public String getBranche() {
        return this.branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
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

    public Set<Probenahme> getProbenahmes() {
        return this.probenahmes;
    }

    public void setProbenahmes(Set<Probenahme> probenahmes) {
        this.probenahmes = probenahmes;
    }

    public Set<MsstBerichtspflicht> getMsstBerichtspflichts() {
        return this.msstBerichtspflichts;
    }

    public void setMsstBerichtspflichts(Set<MsstBerichtspflicht> msstBerichtspflichts) {
        this.msstBerichtspflichts = msstBerichtspflichts;
    }

    public Set<Referenz> getReferenzsForQMsstNr() {
        return this.referenzsForQMsstNr;
    }

    public void setReferenzsForQMsstNr(Set<Referenz> referenzsForQMsstNr) {
        this.referenzsForQMsstNr = referenzsForQMsstNr;
    }

    public Set<Referenz> getReferenzsForZMsstNr() {
        return this.referenzsForZMsstNr;
    }

    public void setReferenzsForZMsstNr(Set<Referenz> referenzsForZMsstNr) {
        this.referenzsForZMsstNr = referenzsForZMsstNr;
    }

    public Set<Sielhaut> getSielhauts() {
        return this.sielhauts;
    }

    public void setSielhauts(Set<Sielhaut> sielhauts) {
        this.sielhauts = sielhauts;
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
        buffer.append("sachbearbeiter").append("='").append(getSachbearbeiter()).append("' ");
        buffer.append("klaeranlage").append("='").append(getKlaeranlage()).append("' ");
        buffer.append("probeart").append("='").append(getProbeart()).append("' ");
        buffer.append("beschreibung").append("='").append(getBeschreibung()).append("' ");
        buffer.append("nrProbepkt").append("='").append(getNrProbepkt()).append("' ");
        buffer.append("firmenId").append("='").append(getFirmenId()).append("' ");
        buffer.append("branche").append("='").append(getBranche()).append("' ");
        buffer.append("enabled").append("='").append(isEnabled()).append("' ");
        buffer.append("deleted").append("='").append(isDeleted()).append("' ");
        buffer.append("probenahmes").append("='").append(getProbenahmes()).append("' ");
        buffer.append("msstBerichtspflichts").append("='").append(getMsstBerichtspflichts()).append("' ");
        buffer.append("referenzsForQMsstNr").append("='").append(getReferenzsForQMsstNr()).append("' ");
        buffer.append("referenzsForZMsstNr").append("='").append(getReferenzsForZMsstNr()).append("' ");
        buffer.append("sielhauts").append("='").append(getSielhauts()).append("' ");
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
        if (!(other instanceof Messstelle)) return false;
        return (this.getId().equals(
            ((Messstelle) other).getId()));
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
     * @return <code>Messstelle</code> the merged instance,
     *         if everything went okay,
     *         <code>null</code> otherwise
     */
    public static Messstelle merge(Messstelle detachedInstance) {
        log.debug("Merging Messstelle instance " + detachedInstance);
        return (Messstelle) new DatabaseAccess().merge(detachedInstance);
    }

    /**
     * Merge (save or update) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean merge() {
        Messstelle saved = Messstelle.merge(this);
        if (saved == null) {
            return false;
        } else {
            this.copy(saved);
            return true;
        }
    }

    /**
     * Update this Messstelle with its new values.<br>
     * This is meant to be used after merging!
     * @param copy Messstelle
     */
    private void copy(Messstelle copy) {
        this.id = copy.getId();
        this.objekt = copy.getObjekt();
        this.sachbearbeiter = copy.getSachbearbeiter();
        this.klaeranlage = copy.getKlaeranlage();
        this.probeart = copy.getProbeart();
        this.beschreibung = copy.getBeschreibung();
        this.nrProbepkt = copy.getNrProbepkt();
        this.firmenId = copy.getFirmenId();
        this.branche = copy.getBranche();
        this.enabled = copy.isEnabled();
        this.deleted = copy.isDeleted();
        this.probenahmes = copy.getProbenahmes();
        this.msstBerichtspflichts = copy.getMsstBerichtspflichts();
        this.referenzsForQMsstNr = copy.getReferenzsForQMsstNr();
        this.referenzsForZMsstNr = copy.getReferenzsForZMsstNr();
        this.sielhauts = copy.getSielhauts();
    }

    /**
     * Delete (mark as deleted) a detached instance
     * @param detachedInstance the instance to delete
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public static boolean delete(Messstelle detachedInstance) {
        log.debug("Deleting Messstelle instance " + detachedInstance);
        return new DatabaseAccess().delete(detachedInstance);
    }

    /**
     * Delete (mark as deleted) this instance
     * @return <code>true</code>, if everything went okay,
     *         <code>false</code> otherwise
     */
    public boolean delete() {
        return Messstelle.delete(this);
    }

    /**
     * Find an <code>Messstelle</code> instance by its primary key
     * @param id the primary key value
     * @return <code>Messstelle</code> the requested instance,
     *         if one exists,
     *         <code>null</code> otherwise
     */
    public static Messstelle findById(java.lang.Integer id) {
        log.debug("Getting Messstelle instance with id: " + id);
        return (Messstelle)
            new DatabaseAccess().get(Messstelle.class, id);
    }

    /**
     * Get a list of all <code>Messstelle</code>
     * @return <code>List&lt;Messstelle&gt;</code>
     *         all <code>Messstelle</code>
     */
    public static List<Messstelle> getAll() {
        return DatabaseQuery.getAll(new Messstelle());
    }

    /* Custom code goes below here! */
    public static Messstelle findByObjektId(java.lang.Integer id){
        log.debug("Getting AtlProbepkt instance with connected Objekt with id: " + id);
        Objekt objekt = (Objekt) HibernateSessionFactory.currentSession().createQuery("from Objekt o where o.id= " + id).list().get(0);
        Set<Messstelle> list = objekt.getMessstelles();
        return list.iterator().next();
    }

}
