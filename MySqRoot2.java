import java.lang.Math;
import java.text.DecimalFormat;
import java.math.*;
import java.io.*;
import java.util.Scanner;

class mysqroot2 {

    private static final DecimalFormat df = new DecimalFormat("###0.0000");
    public static void main(String []args) {
        if (args.length!=1) {
            System.out.println("number not provided");
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
                float x=0;
                String input = sc.nextLine();
                try {
                    x = Float.parseFloat(input);
                } catch (Exception e) {
                    System.out.printf("%s Incorrect number\n", input);
                    continue;
                }
                if (x<0) {
                    System.out.printf("%s Incorrect number\n", String.valueOf(x));
                    continue;
                }
                df.setRoundingMode(RoundingMode.DOWN);
                System.out.printf("%s %s\n", input, df.format(sqrt(x)));
            }  
            sc.close();     //closes the scanner  
        }  
        catch(IOException e)  
        {  
            e.printStackTrace();  
        }  
    }

    private static double sqrt(float x) {
        double z = 1, val=0, limit = 0.001f;
        for (int i=1;i<=25;i++) {
            val = z-((z*z-x)/(2*z));
            if (Math.abs(val-z) < limit) {
                return val;
            }
            z = val;
        }
        return z;
    }
}
