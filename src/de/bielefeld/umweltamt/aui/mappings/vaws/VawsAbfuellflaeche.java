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

package de.bielefeld.umweltamt.aui.mappings.vaws;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.bielefeld.umweltamt.aui.utils.AuikLogger;
import de.bielefeld.umweltamt.aui.utils.DatabaseAccess;

/**
 * A class that represents a row in the 'VAWS_ABFUELLFLAECHE' table. This class
 * may be customized as it is never re-generated after being created.
 */
public class VawsAbfuellflaeche extends AbstractVawsAbfuellflaeche implements
    Serializable {
    private static final long serialVersionUID = -6210315335073840383L;

    /** Logging */
    private static final AuikLogger log = AuikLogger.getLogger();

    /**
     * Simple constructor of VawsAbfuellflaeche instances.
     */
    public VawsAbfuellflaeche() {
    }

    /**
     * Constructor of VawsAbfuellflaeche instances given a simple primary key.
     * @param id
     */
    public VawsAbfuellflaeche(java.lang.Integer id) {
        super(id);
    }

    /* Add customized code below */

    @Override
    public String toString() {
        return "[VawsAbfuellflaeche: " + getBehaelterid() + ", FD:"
            + getVawsFachdaten() + "]";
    }

    public static VawsAbfuellflaeche getAbfuellflaeche(VawsFachdaten fachdaten)
        throws IllegalArgumentException {
        VawsAbfuellflaeche flaeche;
        List<?> list;

        if (fachdaten == null
            || !fachdaten.getAnlagenart().equals("Abfüllfläche")) {
            throw new IllegalArgumentException(
                "Fachdaten-Objekt ist keine Abfüllfläche!");
        }

        if (fachdaten.getBehaelterId() == null) {
            list = new ArrayList<VawsAbfuellflaeche>();
        } else {
            list = new DatabaseAccess()
                .createQuery(
                    "from VawsAbfuellflaeche abff "
                        + "where abff.vawsFachdaten = :fachdaten ")
                .setEntity("fachdaten", fachdaten)
                .list();
        }

        if (list.size() > 0) {
            flaeche = (VawsAbfuellflaeche) list.get(0);
            log.debug("Fläche '" + flaeche + "' geladen!");
        } else {
            // Bei so ziemlich 95% aller Tankstellen gibts ein VawsFachdaten-
            // Objekt, aber kein VawsAbfuellflaechen-Objekt.
            // Seems like it's not a bug, it's a feature...

            // Also legen wir in diesen Füllen einfach ein neues
            // VawsAbfuellflaechen-Objekt an.

            // Das selbe tun wir bei einem noch ungespeicherten
            // neuen VawsFachdaten-Objekt.

            flaeche = new VawsAbfuellflaeche();
            flaeche.setVawsFachdaten(fachdaten);
            log.debug("Neue Fläche für '" + fachdaten + "' erzeugt!");
        }

        return flaeche;
    }

    /**
     * Speichert einen VAWS-Abfüllflächen-Datensatz in der Datenbank.
     * @param flaeche Der zu speichernde Datensatz.
     * @return <code>true</code>, falls beim Speichern kein Fehler auftritt,
     *         sonst <code>false</code>.
     */
    public static boolean saveAbfuellflaeche(VawsAbfuellflaeche flaeche)
        throws IllegalArgumentException {

        if (flaeche.getVawsFachdaten() == null) {
            throw new IllegalArgumentException(
                "Die VawsAbfuellflaeche muss einem VawsFachdaten-Objekt "
                + "zugeordnet sein!");
        }

        boolean saved = false;
        saved = new DatabaseAccess().saveOrUpdate(flaeche);
        return saved;
    }

    /**
     * Liefert alle Bodenflächen-Ausführungen. <br>
     * <b>ACHTUNG:</b> Liefert nicht alle VawsAbfuellflaechen, sondern alle in
     * der Spalte "BODENFLAECHENAUSF" benutzten Werte!
     * @return Ein Array mit den Namen aller Ausführungen.
     */
    public static String[] getBodenflaechenausfArray() {
        // FIXME: select distinct nicht die beste Lösung
        List<?> list;
        String suchString = "select distinct vabf.bodenflaechenausf "
            + "from VawsAbfuellflaeche vabf "
            + "order by vabf.bodenflaechenausf";

        list = new DatabaseAccess().createQuery(suchString)
            .setCacheable(true)
            .setCacheRegion("vawsabausfliste")
            .list();

        String[] result;
        result = new String[list.size()];
        result = (String[]) list.toArray(result);

        return result;
    }

    /**
     * Liefert alle Bodenflächen-Ausführungen. <br>
     * <b>ACHTUNG:</b> Liefert nicht alle VawsAbfuellflaechen, sondern alle in
     * der Spalte "BODENFLAECHENAUSF" benutzten Werte!
     * @return Ein Array mit den Namen aller Ausführungen.
     */
    public static String[] getNiederschlagschutzArray() {
        // FIXME: select distinct nicht die beste Lösung
        List<?> list;
        String suchString = "select distinct vabf.niederschlagschutz "
            + "from VawsAbfuellflaeche vabf "
            + "order by vabf.niederschlagschutz";

        list = new DatabaseAccess().createQuery(suchString)
            .setCacheable(true)
            .setCacheRegion("vawsabnieliste")
            .list();

        String[] result;
        result = new String[list.size()];
        result = (String[]) list.toArray(result);

        return result;
    }
}
