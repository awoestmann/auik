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
import java.util.List;

import de.bielefeld.umweltamt.aui.utils.DatabaseAccess;

/**
 * A class that represents a row in the 'VAWS_STANDORTGGHWSG' table. This class
 * may be customized as it is never re-generated after being created.
 */
/* Is that a class name or did someone drop their head on the keyboard...? */
public class VawsStandortgghwsg extends AbstractVawsStandortgghwsg implements
    Serializable {
    private static final long serialVersionUID = 1741294639861761005L;

    /**
     * Simple constructor of VawsStandortgghwsg instances.
     */
    public VawsStandortgghwsg() {
    }

    /**
     * Constructor of VawsStandortgghwsg instances given a simple primary key.
     * @param standortggid
     */
    public VawsStandortgghwsg(java.lang.Integer standortggid) {
        super(standortggid);
    }

    /* Add customized code below */

    @Override
    public String toString() {
        return super.getStandortgg();
    }

    /**
     * Liefert alle vorhandenen VAWS-Standortgeg.
     * @return Alle vorhandenen VawsStandortgghwsg
     */
    public static VawsStandortgghwsg[] getStandortGg() {
        String suchString = "FROM VawsStandortgghwsg vsgg "
            + "ORDER BY vsgg.standortggid";

        List<?> list;
        list = new DatabaseAccess().createQuery(suchString)
            .setCacheable(true)
            .setCacheRegion("standortggliste")
            .list();

        VawsStandortgghwsg[] result;
        result = new VawsStandortgghwsg[list.size()];
        result = (VawsStandortgghwsg[]) list.toArray(result);

        return result;
    }
}
