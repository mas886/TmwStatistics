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
public class LastUpdate {

    public boolean exist() {
        boolean res;
        String str = "";
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT dateTime FROM `LastUpdate` WHERE `Id`=1");
            while (rs.next()) {
                str = rs.getString("dateTime");
            }
            try {
                db.closeDB();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.length() >= 1;
    }

    public String newLastUpdate() {
        String res = "";
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            s.executeUpdate("INSERT INTO `LastUpdate`(`Id`, `dateTime`) VALUES (1,CURRENT_TIMESTAMP)");
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

    public String updateLastUpdate() {
        String res = "";
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            s.executeUpdate("UPDATE `LastUpdate` SET `dateTime`=CURRENT_TIMESTAMP WHERE Id=1");
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