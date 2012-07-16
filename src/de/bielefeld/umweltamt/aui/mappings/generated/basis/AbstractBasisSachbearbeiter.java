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

// Generated 16.07.2012 17:29:07 by Hibernate Tools 3.3.0.GA

package de.bielefeld.umweltamt.aui.mappings.generated.basis;


import de.bielefeld.umweltamt.aui.mappings.generated.atl.AtlProbenahmen;
import de.bielefeld.umweltamt.aui.mappings.generated.atl.AtlProbepkt;
import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a row in a database table.
 * You can customize the behavior of this class by editing the class,
 * {@link BasisSachbearbeiter}.
 */
public abstract class AbstractBasisSachbearbeiter  implements java.io.Serializable {

     private String kennummer;
     private String name;
     private String zeichen;
     private String zimmer;
     private String telefon;
     private String email;
     private String gehoertzuarbeitsgr;
     private boolean enabled;
     private boolean deleted;
     private Set<AtlProbepkt> atlProbepkts = new HashSet<AtlProbepkt>(0);
     private Set<BasisObjekt> basisObjekts = new HashSet<BasisObjekt>(0);
     private Set<AtlProbenahmen> atlProbenahmens = new HashSet<AtlProbenahmen>(0);

    public AbstractBasisSachbearbeiter() {
    }

    public AbstractBasisSachbearbeiter(
    	String kennummer, boolean enabled, boolean deleted) {
        this.kennummer = kennummer;
        this.enabled = enabled;
        this.deleted = deleted;
    }

    public AbstractBasisSachbearbeiter(
    	String kennummer, String name, String zeichen, String zimmer, String telefon, String email, String gehoertzuarbeitsgr, boolean enabled, boolean deleted, Set<AtlProbepkt> atlProbepkts, Set<BasisObjekt> basisObjekts, Set<AtlProbenahmen> atlProbenahmens) {
        this.kennummer = kennummer;
        this.name = name;
        this.zeichen = zeichen;
        this.zimmer = zimmer;
        this.telefon = telefon;
        this.email = email;
        this.gehoertzuarbeitsgr = gehoertzuarbeitsgr;
        this.enabled = enabled;
        this.deleted = deleted;
        this.atlProbepkts = atlProbepkts;
        this.basisObjekts = basisObjekts;
        this.atlProbenahmens = atlProbenahmens;
    }

    public String getKennummer() {
        return this.kennummer;
    }
    public void setKennummer(String kennummer) {
        this.kennummer = kennummer;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getZeichen() {
        return this.zeichen;
    }
    public void setZeichen(String zeichen) {
        this.zeichen = zeichen;
    }

    public String getZimmer() {
        return this.zimmer;
    }
    public void setZimmer(String zimmer) {
        this.zimmer = zimmer;
    }

    public String getTelefon() {
        return this.telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getGehoertzuarbeitsgr() {
        return this.gehoertzuarbeitsgr;
    }
    public void setGehoertzuarbeitsgr(String gehoertzuarbeitsgr) {
        this.gehoertzuarbeitsgr = gehoertzuarbeitsgr;
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

    public Set<AtlProbepkt> getAtlProbepkts() {
        return this.atlProbepkts;
    }
    public void setAtlProbepkts(Set<AtlProbepkt> atlProbepkts) {
        this.atlProbepkts = atlProbepkts;
    }

    public Set<BasisObjekt> getBasisObjekts() {
        return this.basisObjekts;
    }
    public void setBasisObjekts(Set<BasisObjekt> basisObjekts) {
        this.basisObjekts = basisObjekts;
    }

    public Set<AtlProbenahmen> getAtlProbenahmens() {
        return this.atlProbenahmens;
    }
    public void setAtlProbenahmens(Set<AtlProbenahmen> atlProbenahmens) {
        this.atlProbenahmens = atlProbenahmens;
    }

}

