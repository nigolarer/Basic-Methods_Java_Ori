package intv.util;

public class RandomNum {
   public static int getRandom(int n) {
        int num = (int)(Math.random()*1000%n);
        return num;
    }

    public static float getRandom(float n) {
        float num = (float)(Math.random()*n);
        return num;
    }

    public static double getRandom(double n) {
        double num = Math.random()*n;
        return num;
    }
}
