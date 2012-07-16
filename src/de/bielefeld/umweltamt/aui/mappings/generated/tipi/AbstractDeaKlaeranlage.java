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

package de.bielefeld.umweltamt.aui.mappings.generated.tipi;


import java.util.Date;

/**
 * A class that represents a row in a database table.
 * You can customize the behavior of this class by editing the class,
 * {@link DeaKlaeranlage}.
 */
public abstract class AbstractDeaKlaeranlage  implements java.io.Serializable {

     private DeaKlaeranlageId id;
     private String herkunft;
     private Date inkaGueltigVon;
     private Date inkaGueltigBis;
     private short istAktuellTog;
     private Date erfassungsDatum;
     private Date aenderungsDatum;
     private String kartenId;
     private Integer tk25Version;
     private Date stilllegungsDatum;
     private Integer stuaNr;
     private Integer stuaVersion;
     private String gemeindeId;
     private Integer gemeindeVersion;
     private String behoerdenId;
     private Integer behoerdenVersion;
     private String name;
     private String kurzname;
     private Integer anlagentypOpt;
     private Integer rechtswert;
     private Integer hochwert;
     private Integer e32;
     private Integer n32;
     private int zustandsNr;
     private Date gueltigVon;
     private Date igStichtag;
     private Date gueltigBis;
     private Date erstellDat;
     private Date aktualDat;
     private int versionsnr;
     private Date zeitstempel;

    public AbstractDeaKlaeranlage() {
    }

    public AbstractDeaKlaeranlage(
    	DeaKlaeranlageId id, String herkunft, Date inkaGueltigVon, short istAktuellTog, Date erfassungsDatum, int zustandsNr, Date gueltigVon, Date erstellDat, Date aktualDat, int versionsnr) {
        this.id = id;
        this.herkunft = herkunft;
        this.inkaGueltigVon = inkaGueltigVon;
        this.istAktuellTog = istAktuellTog;
        this.erfassungsDatum = erfassungsDatum;
        this.zustandsNr = zustandsNr;
        this.gueltigVon = gueltigVon;
        this.erstellDat = erstellDat;
        this.aktualDat = aktualDat;
        this.versionsnr = versionsnr;
    }

    public AbstractDeaKlaeranlage(
    	DeaKlaeranlageId id, String herkunft, Date inkaGueltigVon, Date inkaGueltigBis, short istAktuellTog, Date erfassungsDatum, Date aenderungsDatum, String kartenId, Integer tk25Version, Date stilllegungsDatum, Integer stuaNr, Integer stuaVersion, String gemeindeId, Integer gemeindeVersion, String behoerdenId, Integer behoerdenVersion, String name, String kurzname, Integer anlagentypOpt, Integer rechtswert, Integer hochwert, Integer e32, Integer n32, int zustandsNr, Date gueltigVon, Date igStichtag, Date gueltigBis, Date erstellDat, Date aktualDat, int versionsnr, Date zeitstempel) {
        this.id = id;
        this.herkunft = herkunft;
        this.inkaGueltigVon = inkaGueltigVon;
        this.inkaGueltigBis = inkaGueltigBis;
        this.istAktuellTog = istAktuellTog;
        this.erfassungsDatum = erfassungsDatum;
        this.aenderungsDatum = aenderungsDatum;
        this.kartenId = kartenId;
        this.tk25Version = tk25Version;
        this.stilllegungsDatum = stilllegungsDatum;
        this.stuaNr = stuaNr;
        this.stuaVersion = stuaVersion;
        this.gemeindeId = gemeindeId;
        this.gemeindeVersion = gemeindeVersion;
        this.behoerdenId = behoerdenId;
        this.behoerdenVersion = behoerdenVersion;
        this.name = name;
        this.kurzname = kurzname;
        this.anlagentypOpt = anlagentypOpt;
        this.rechtswert = rechtswert;
        this.hochwert = hochwert;
        this.e32 = e32;
        this.n32 = n32;
        this.zustandsNr = zustandsNr;
        this.gueltigVon = gueltigVon;
        this.igStichtag = igStichtag;
        this.gueltigBis = gueltigBis;
        this.erstellDat = erstellDat;
        this.aktualDat = aktualDat;
        this.versionsnr = versionsnr;
        this.zeitstempel = zeitstempel;
    }

    public DeaKlaeranlageId getId() {
        return this.id;
    }
    public void setId(DeaKlaeranlageId id) {
        this.id = id;
    }

    public String getHerkunft() {
        return this.herkunft;
    }
    public void setHerkunft(String herkunft) {
        this.herkunft = herkunft;
    }

    public Date getInkaGueltigVon() {
        return this.inkaGueltigVon;
    }
    public void setInkaGueltigVon(Date inkaGueltigVon) {
        this.inkaGueltigVon = inkaGueltigVon;
    }

    public Date getInkaGueltigBis() {
        return this.inkaGueltigBis;
    }
    public void setInkaGueltigBis(Date inkaGueltigBis) {
        this.inkaGueltigBis = inkaGueltigBis;
    }

    public short getIstAktuellTog() {
        return this.istAktuellTog;
    }
    public void setIstAktuellTog(short istAktuellTog) {
        this.istAktuellTog = istAktuellTog;
    }

    public Date getErfassungsDatum() {
        return this.erfassungsDatum;
    }
    public void setErfassungsDatum(Date erfassungsDatum) {
        this.erfassungsDatum = erfassungsDatum;
    }

    public Date getAenderungsDatum() {
        return this.aenderungsDatum;
    }
    public void setAenderungsDatum(Date aenderungsDatum) {
        this.aenderungsDatum = aenderungsDatum;
    }

    public String getKartenId() {
        return this.kartenId;
    }
    public void setKartenId(String kartenId) {
        this.kartenId = kartenId;
    }

    public Integer getTk25Version() {
        return this.tk25Version;
    }
    public void setTk25Version(Integer tk25Version) {
        this.tk25Version = tk25Version;
    }

    public Date getStilllegungsDatum() {
        return this.stilllegungsDatum;
    }
    public void setStilllegungsDatum(Date stilllegungsDatum) {
        this.stilllegungsDatum = stilllegungsDatum;
    }

    public Integer getStuaNr() {
        return this.stuaNr;
    }
    public void setStuaNr(Integer stuaNr) {
        this.stuaNr = stuaNr;
    }

    public Integer getStuaVersion() {
        return this.stuaVersion;
    }
    public void setStuaVersion(Integer stuaVersion) {
        this.stuaVersion = stuaVersion;
    }

    public String getGemeindeId() {
        return this.gemeindeId;
    }
    public void setGemeindeId(String gemeindeId) {
        this.gemeindeId = gemeindeId;
    }

    public Integer getGemeindeVersion() {
        return this.gemeindeVersion;
    }
    public void setGemeindeVersion(Integer gemeindeVersion) {
        this.gemeindeVersion = gemeindeVersion;
    }

    public String getBehoerdenId() {
        return this.behoerdenId;
    }
    public void setBehoerdenId(String behoerdenId) {
        this.behoerdenId = behoerdenId;
    }

    public Integer getBehoerdenVersion() {
        return this.behoerdenVersion;
    }
    public void setBehoerdenVersion(Integer behoerdenVersion) {
        this.behoerdenVersion = behoerdenVersion;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getKurzname() {
        return this.kurzname;
    }
    public void setKurzname(String kurzname) {
        this.kurzname = kurzname;
    }

    public Integer getAnlagentypOpt() {
        return this.anlagentypOpt;
    }
    public void setAnlagentypOpt(Integer anlagentypOpt) {
        this.anlagentypOpt = anlagentypOpt;
    }

    public Integer getRechtswert() {
        return this.rechtswert;
    }
    public void setRechtswert(Integer rechtswert) {
        this.rechtswert = rechtswert;
    }

    public Integer getHochwert() {
        return this.hochwert;
    }
    public void setHochwert(Integer hochwert) {
        this.hochwert = hochwert;
    }

    public Integer getE32() {
        return this.e32;
    }
    public void setE32(Integer e32) {
        this.e32 = e32;
    }

    public Integer getN32() {
        return this.n32;
    }
    public void setN32(Integer n32) {
        this.n32 = n32;
    }

    public int getZustandsNr() {
        return this.zustandsNr;
    }
    public void setZustandsNr(int zustandsNr) {
        this.zustandsNr = zustandsNr;
    }

    public Date getGueltigVon() {
        return this.gueltigVon;
    }
    public void setGueltigVon(Date gueltigVon) {
        this.gueltigVon = gueltigVon;
    }

    public Date getIgStichtag() {
        return this.igStichtag;
    }
    public void setIgStichtag(Date igStichtag) {
        this.igStichtag = igStichtag;
    }

    public Date getGueltigBis() {
        return this.gueltigBis;
    }
    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public Date getErstellDat() {
        return this.erstellDat;
    }
    public void setErstellDat(Date erstellDat) {
        this.erstellDat = erstellDat;
    }

    public Date getAktualDat() {
        return this.aktualDat;
    }
    public void setAktualDat(Date aktualDat) {
        this.aktualDat = aktualDat;
    }

    public int getVersionsnr() {
        return this.versionsnr;
    }
    public void setVersionsnr(int versionsnr) {
        this.versionsnr = versionsnr;
    }

    public Date getZeitstempel() {
        return this.zeitstempel;
    }
    public void setZeitstempel(Date zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

}

