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
package tmwstatistics.net;

import tmwstatistics.entity.LastUpdate;
import tmwstatistics.entity.DailyTime;
import tmwstatistics.entity.Characters;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tmwstatistics.db.db;

/**
 *
 * @author redrednose
 */
public class dbConnection {

    public void updateDB(String[] users) {
        insertCharacters(users);
        updateDailyTime(users);
        updateLastUpdate(users[1]);
    }

    private void insertCharacters(String[] users) {
        Characters character = new Characters();
        for (int c = 5; c < users.length - 2; c++) {
            if (!character.exist(users[c])) {
                character.newChar(users[c],users[1]);
            } else {
                character.updateChar(users[c],users[1]);
            }
        }
    }

    private void updateDailyTime(String[] users) {
        DailyTime DailyConnection = new DailyTime();
        for (int c = 5; c < users.length - 2; c++) {
            if (!DailyConnection.exist(users[c])) {
                DailyConnection.newDailyConnection(users[c],users[1]);
            } else {
                DailyConnection.updateDailyConnection(users[c],users[1]);
            }
        }

    }

    private void updateLastUpdate(String dateTime) {
        LastUpdate update = new LastUpdate();
        if (!update.exist()) {
            update.newLastUpdate(dateTime);
        } else {
            update.updateLastUpdate(dateTime);
        }
    }

}
