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

/*
 * Datei:
 * $Id: MD5Password.java,v 1.1 2008-06-05 11:38:33 u633d Exp $
 *
 * Erstellt am 15.08.2005 von David Klotz
 *
 * CVS-Log:
 * $Log: not supported by cvs2svn $
 * Revision 1.1  2005/08/24 08:42:52  u633d
 * - Auswertungen und anderes
 *
 *
 */
package de.bielefeld.umweltamt.aui.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
 * Simple Methods for converting and testing MD5-Encoded
 * Passwords.
 * @author Trygve Isaacson. <http://www.bombaydigital.com>
 */

public class MD5Password
{
    /**
     * Encodes a password into a md5-String.
     * @param clearTextPassword The clear-text password.
     * @return A hexadecimal md5-encoded representation of the password.
     */
    public static String getEncodedPassword(String clearTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(clearTextPassword.getBytes());

            return new String(Hex.encodeHex(md.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cant use MD5-algorithm!", e);
        }
    }

    /**
     * Checks if a given clear-text password matches a stored md5-password.
     * @param clearTextTestPassword The clear-text password to try.
     * @param encodedActualPassword The stored, md5-encoded password.
     * @return <code>true</code>, if the passwords match, <code>false</code> otherwise.
     */
    public static boolean testPassword(String clearTextTestPassword,
            String encodedActualPassword) {
        String encodedTestPassword = MD5Password.getEncodedPassword(
                clearTextTestPassword);

        return (encodedTestPassword.equals(encodedActualPassword));
    }
}
