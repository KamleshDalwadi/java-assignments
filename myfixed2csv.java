import java.lang.Math;
import java.text.DecimalFormat;
import java.math.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Spliterator;

class myfixed2csv {

    public static void main(String []args) {
        //validate and usage
        if (args.length<2) {
            System.out.println("Invalid arguments");
            usage();
            return;
        }
        int nCol = 0;
        ArrayList<Integer> lengths = new ArrayList<>();
        try {
            nCol = Integer.parseInt(args[1]);
            if (args.length != nCol+2) {
                usage();
                return;
            }
            for (int i=0; i<nCol; i++) {
                lengths.add(Integer.parseInt(args[i+2]));
            }
        } catch (Exception e) {
            usage();
            return;
        }

        try  
        {  
            //the file to be opened for reading  
            FileInputStream fis=new FileInputStream(args[0]);       
            Scanner sc=new Scanner(fis);    //file to be scanned  
            //returns true if there is another line to read  
            while(sc.hasNextLine())  
            {  
                int x=0;
                String input = sc.nextLine();
                StringBuffer output = new StringBuffer();
                for (int i=0;i<nCol;i++) {
                    output.append("\"");
                    String a = input.substring(x, x+lengths.get(i)).trim();
                    output.append(removeLeadingZeroes(a));
                    output.append("\"");
                    if (i+1!=nCol) {
                        output.append(",");
                    }
                    x += lengths.get(i);
                }
                System.out.printf("%s\n", output);
            }  
            sc.close();     //closes the scanner  
        }  
        catch(IOException e)  
        {  
            e.printStackTrace();  
        }  
    }

    private static void usage() {
        System.out.println("Usage: ");
        System.out.println("    i.e.: myfixed2csv file1 4 10 4 4 15");
        System.out.println("    WHERE: ");
        System.out.println("        - fixed-width-file is name of file, in above case file1");
        System.out.println("        - n-columns - number of columns, in above case, 4");
        System.out.println("        - length1 - length1 of 1st field, in above case 10, with trailing spaces");
        System.out.println("        - length2 - length of 2nd field, in above case 4, with leading zeros");
        System.out.println("        - length3 - length of 2nd field, in above case 4, with leading zeros");
        System.out.println("        - length4 - length of 2nd field, in above case 15, with leading spaces");
    }

    public static String removeLeadingZeroes(String num){
        int i=0;
        StringBuffer buffer = new StringBuffer(num);
        while(i<num.length() && num.charAt(i)=='0')
        i++;
        buffer.replace(0, i, "");
        return buffer.toString();
     }
}
