/*
 * The MIT License
 *
 * Copyright 2016 redrednose.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tmwstatistics.entity;

import java.sql.ResultSet;
import java.sql.Statement;
import tmwstatistics.db.db;

/**
 *
 * @author redrednose
 */
public class Characters {

    public boolean exist(String Name) {
        boolean res;
        String str = "";
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT Name FROM `Characters` WHERE Name='" + Name + "'");
            while (rs.next()) {
                str = rs.getString("Name");
            }
            try {
                db.closeDB();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return exist(Name);
        }
        return str.length() >= 1;
    }

    public String newChar(String Name) {
        String res = "";
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            s.executeUpdate("INSERT INTO Characters(Name, lastConnection, firstConnection) VALUES('" + Name + "',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)");
            res = "Canvis efectuats correctament.";
            try {
                db.closeDB();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = "Error.";
        }
        return res;
    }

    public String updateChar(String Name) {
        String res = "";
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            s.executeUpdate("UPDATE `Characters` SET `lastConnection` = CURRENT_TIMESTAMP WHERE `Characters`.`Name` = '" + Name + "'");
            res = "Canvis efectuats correctament.";
            try {
                db.closeDB();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = "Error.";
        }
        return res;
    }

}
