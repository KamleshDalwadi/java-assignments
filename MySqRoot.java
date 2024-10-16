import java.lang.Math;
import java.text.DecimalFormat;
import java.math.*;

class mysqroot {

    private static final DecimalFormat df = new DecimalFormat("###0.0000");
    public static void main(String []args) {
        if (args.length!=1) {
            System.out.println("number not provided");
            return;
        }
        float x=0;
        try {
            x = Float.parseFloat(args[0]);
        } catch (Exception e) {
            System.out.printf("%s Incorrect number\n", args[0]);
            return;
        }
        if (x<0) {
            System.out.printf("%s Incorrect number\n", String.valueOf(x));
            return;
        }
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.printf("%s %s\n", args[0], df.format(sqrt(x)));
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
