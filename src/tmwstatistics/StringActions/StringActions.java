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

/**
 *
 * @author redrednose
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
                if((f==28)&&((users[c].charAt(f) == ')')&&(users[c].charAt(f-1) == 'M')&&(users[c].charAt(f-2) == 'G')&&(users[c].charAt(f-3) == '('))){
                    f=f-3;
                }else if ((users[c].charAt(f) != ' ')) {
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
}