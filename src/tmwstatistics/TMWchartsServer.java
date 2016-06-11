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
package tmwstatistics;

import tmwstatistics.net.dbConnection;
import tmwstatistics.net.WebConnection;
import tmwstatistics.StringActions.StringActions;

/**
 *
 * @author redrednose
 */
public class TMWchartsServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebConnection connect = new WebConnection();
        StringActions act = new StringActions();
        dbConnection db = new dbConnection();
        while (true) {
            try {
                String[] users = connect.getUsers();
                users = act.cleanString(users);
                act.printUsers(users);
                db.updateDB(users);
                Thread.sleep(30000);//If the sleeping time is changed increment of the user time in minutes must be changed aswell
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
