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
package tmwstatistics.StringActions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mas886/redrednose/Arnau
 */
public class StringActions {

    public void printUsers(String[] users) {
        for (int c = 0; c < users.length; c++) {
            System.out.println(users[c]);
        }
    }

    public String[] cleanString(String[] users) {
        for (int c = 0; c < users.length; c++) {
            String reverse = "";
            for (int f = users[c].length() - 1; f >= 0; f--) {
                if ((c == 1) && (users[c].charAt(f) == '(')) {
                    for (int g = f + 1; users[c].charAt(g) != ')'; g++) {
                        reverse += users[c].charAt(g);
                    }
                    users[c] = reverse;
                    break;
                } else if ((f == 28) && ((users[c].charAt(f) == ')') && (users[c].charAt(f - 1) == 'M') && (users[c].charAt(f - 2) == 'G') && (users[c].charAt(f - 3) == '('))) {
                    f = f - 3;
                } else if ((users[c].charAt(f) != ' ') && (c != 1)) {
                    for (int g = 0; g < f + 1; g++) {
                        reverse += users[c].charAt(g);
                    }
                    users[c] = reverse;
                    break;
                }
            }

        }
        return users;
    }

    public String genDate(String dateTime) {
        String date = "";
        for (int c = 0; dateTime.charAt(c) != ' '; c++) {
            date += dateTime.charAt(c);
        }
        return date;
    }
    
    /*If dateTime1 is before dateTime2 returns true*/
    public boolean compareDateTime(String dateTime1, String dateTime2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(dateTime1).before(sdf.parse(dateTime2));
        } catch (ParseException ex) {
            Logger.getLogger(StringActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
