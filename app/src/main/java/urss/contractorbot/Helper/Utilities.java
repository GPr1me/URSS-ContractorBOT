package urss.contractorbot.Helper;

public class Utilities {

    public static float cm2Topi2(float number){
        //cm2 to m2
        number /= (float)10000;

        //m2 to pi2
        number /= (float)0.09290304;

        return number;
    }
}
