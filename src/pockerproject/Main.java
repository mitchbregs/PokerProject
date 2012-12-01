
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pockerproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        BufferedReader in;
        BufferedWriter out;
//        Hashtable hashtable = new Hashtable();
        SortedMap hashtable = new TreeMap();
        int PreviousKey=0;
        int PatMoney=0;
        ArrayList PatUsers = new ArrayList();
        String user;

        String line;
        String name;
        String chips;
        int i = 0;
        int max = 0;
        boolean iEndFile = false;

        try {
//            in = new BufferedReader(new FileReader("C:\\Users\\Mitchell\\Documents\\Program\\Poker\\Input.txt"));  // chained readers
            in = new BufferedReader(new FileReader("C:\\Input.txt"));  // chained readers
            while (!iEndFile) {

                line = in.readLine();
                if (line == null) {
                    iEndFile = true;
                    break;
                }
                System.out.println(line);
                StringTokenizer ExtractRecord = new StringTokenizer(line, ",");
                name = ExtractRecord.nextToken();
                chips = ExtractRecord.nextToken();

//                System.out.println(name + " and" + chips);

                int IntChips = Integer.parseInt(chips.trim()); //convert string that hold number to number

                hashtable.put(IntChips, name); // adding value into hashtable

            }
            max = i;
            in.close();

//            out = new BufferedWriter(new FileWriter("C:\\Users\\Mitchell\\Documents\\Program\\Poker\\OutputTwo.txt", false));
            out = new BufferedWriter(new FileWriter("C:\\Output.txt", false));
            i = 0;

//            System.out.println("Retriving all keys from the Hashtable");

            ArrayList alKeys = new ArrayList(hashtable.keySet());
//            System.out.println("The ArrayList keys is:\n" + alKeys);

            Collections.sort(alKeys, Collections.reverseOrder());
//            System.out.println("The ArrayList keys in reverse order is:\n" + alKeys);

            ListIterator litrKeys = alKeys.listIterator();
//            System.out.print(" map in order of keys backwards: ");
            System.out.println();

            int IntKey=0;
            boolean bFirstKey= true;  //
            while (litrKeys.hasNext()) {
                Object CurrentKey = litrKeys.next();
                user = (String) hashtable.get(CurrentKey);
  //              System.out.println("key : " + CurrentKey + " value :" + user);
                IntKey = (Integer) CurrentKey;
             if(!bFirstKey){
                  PatMoney = (PreviousKey - IntKey)*PatUsers.size();
//                PatMoney = PreviousKey - IntKey;
                System.out.println("PotMoney: " + PatMoney + " UserNames :" + PatUsers);
             }
                bFirstKey=false;
                PreviousKey = IntKey;
                PatUsers.add(user);
                
            }
             if(!bFirstKey){
                PatMoney = IntKey*PatUsers.size();
                System.out.println("PotMoney: " + PatMoney + " UserNames :" + PatUsers);
             }

           out.close();

        } catch (Exception exc) {
            System.out.println("exception :" + exc);

        }
    }
}
