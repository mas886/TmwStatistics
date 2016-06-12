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
import tmwstatistics.StringActions.StringActions;
/**
 *
 * @author redrednose
 */
public class DailyTime {

    public boolean exist(String Name) {
        boolean res;
        String str = "";
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT date FROM `UserDailyTime` WHERE `characterId`=(SELECT characterId FROM Characters WHERE Name=\"" + Name + "\") AND date=CURRENT_DATE");
            while (rs.next()) {
                str = rs.getString("date");
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

    public String newDailyConnection(String Name, String dateTime) {
        StringActions gen=new StringActions();
        String res = "";
        String date=gen.genDate(dateTime);
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            s.executeUpdate("INSERT INTO UserDailyTime(characterId, date, minutes) VALUES((SELECT characterId FROM Characters WHERE Name=\"" + Name + "\"), '"+date+"', 0.5)");
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

    public String updateDailyConnection(String Name, String dateTime) {
        StringActions gen=new StringActions();
        String res = "";
        String date=gen.genDate(dateTime);
        try {
            db db = new db();
            Statement s = db.getConnection().createStatement();
            s.executeUpdate("UPDATE UserDailyTime SET minutes=minutes+0.5 WHERE date='"+date+"' AND characterId=(SELECT characterId FROM Characters WHERE Name=\"" + Name + "\")");
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
