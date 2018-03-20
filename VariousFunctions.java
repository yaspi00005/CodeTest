/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class VariousFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("dd: "+calculate_dday("2008-12-31"));
        System.out.println("d: "+calculate_mFraction("2008-6-31","20 South"));
        System.out.println(indexJ_from_S(60)+" "+indexJ_from_S(215)+ "  et  "+ indexJ_from_S(160)+"  "+indexJ_from_S(275));
        
        /*  Test for squert  */
        double d = Math.sqrt(13.0/16);
        double p = Math.pow(2, 3);
        System.out.println(" "+d);
        
        /* Test for while stop */
        int i=0, j=5;
        do{
            System.out.println("i="+i);
            i++;
            j--;
        } 
        while(i<10 || j>0);
        
        while(i>0) {
            System.out.println("i="+i);
            i--;
        }
    }
    
    static public int indexJ_from_S(int j) {
        int periode = j / 4;
        int reste = j % 4;
        j = periode * 5;
        switch (reste) {
            case 1: { j += 1; break; }
            case 2: { j += 3; break; }
            case 3: { j += 4; break; }
            default:{ break; }
        }
        return j;
    }
    
    public static int calculate_dday(String date) {
        int dd=0;
        if(!date.isEmpty()) {
            String[] str = date.split("-");
            int y = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int d = Integer.parseInt(str[2]);
            y = y%2;
            if(m==1) dd = d;
            else if(m==2) dd = 31+d;
            else if(m<=7) dd = 31*m/2 + 30*(m-1)/2 + 28*y + 29*(1-y) + d;
            else dd = 31*(4+(m-7)/2) + 30*(2+(m-8)/2) + 28*y + 29*(1-y) + d;
        }
        return dd;
    }
    
    public static double calculate_mFraction(String date, String lattitude) {
        /*     North |Jan|Fev|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec
         *     Soudth|Jul|Aug|Sep|Oct|Nov|Dec|Jan|Fev|Mar|Apr|May|Jun
         * 60°        .15 .20 .26 .32                             .13
         * :
         * :
         * 0°         .27 .27                                     .27
         */
        
        double data[][] = {
            { 12,  1,   2,   3,   4,   5,   6,   7,   8,   9,  10,  11,   1},
            {  6,  7,   8,   9,  10,  11,  12,   1,   2,   3,   4,   5,  -1},
            {.13, .15, .20, .26, .32, .38, .41, .40, .34, .28, .22, .17, 60},
            {.16, .17, .21, .26, .32, .36, .39, .38, .33, .28, .23, .18, 55},
            {.18, .19, .23, .27, .31, .34, .36, .35, .32, .28, .24, .20, 50},
            {.20, .20, .23, .27, .30, .34, .35, .34, .32, .28, .24, .21, 45},
            {.21, .22, .24, .27, .30, .32, .34, .33, .31, .28, .25, .22, 40},
            {.22, .23, .25, .27, .29, .31, .32, .32, .30, .28, .25, .23, 35},
            {.23, .24, .25, .27, .29, .31, .32, .31, .30, .28, .26, .24, 30},
            {.24, .24, .26, .27, .29, .30, .31, .31, .29, .28, .26, .25, 25},
            {.25, .25, .26, .27, .28, .29, .30, .30, .29, .28, .26, .25, 20},
            {.25, .26, .26, .27, .28, .29, .29, .29, .28, .28, .27, .26, 15},
            {.26, .26, .27, .27, .28, .28, .29, .29, .28, .28, .27, .26, 10},
            {.27, .27, .27, .27, .28, .28, .28, .28, .28, .28, .27, .27,  5},
            {.27, .27, .27, .27, .27, .27, .27, .27, .27, .27, .27, .27,  0}};
        
        double d=0;
        if(!date.isEmpty() && !lattitude.isEmpty()) {
            String[] str = date.split("-");
            int m = Integer.parseInt(str[1]);
            int mu = m>6?0:1;
            str = lattitude.split(" ");
            double l = Double.parseDouble(str[0]);
            if(0<=l && l<5) 
                if(str[1].equals("North")) d = data[14][m%12];
                else d = data[14][(m+6)%12];
            else if(0<=5 && l<10) 
                if(str[1].equals("North")) d = data[13][m%12];
                else d = data[13][(m+6)%12];
            else if(0<=10 && l<15) 
                if(str[1].equals("North")) d = data[12][m%12];
                else d = data[12][(m+6)%12];
            else if(0<=15 && l<20) 
                if(str[1].equals("North")) d = data[11][m%12];
                else d = data[11][(m+6)%12];
            else if(0<=20 && l<25) 
                if(str[1].equals("North")) d = data[10][m%12];
                else d = data[10][(m+6)%12];
            else if(0<=25 && l<30) 
                if(str[1].equals("North")) d = data[9][m%12];
                else d = data[9][(m+6)%12];
            else if(0<=30 && l<35) 
                if(str[1].equals("North")) d = data[8][m%12];
                else d = data[8][(m+6)%12];
            else if(0<=35 && l<40) 
                if(str[1].equals("North")) d = data[7][m%12];
                else d = data[7][(m+6)%12];
            else if(0<=40 && l<45) 
                if(str[1].equals("North")) d = data[6][m%12];
                else d = data[6][(m+6)%12];
            else if(0<=45 && l<50) 
                if(str[1].equals("North")) d = data[5][m%12];
                else d = data[5][(m+6)%12];
            else if(0<=50 && l<55) 
                if(str[1].equals("North")) d = data[4][m%12];
                else d = data[4][(m+6)%12];
            else if(0<=55 && l<60) 
                if(str[1].equals("North")) d = data[3][m%12];
                else d = data[3][(m+6)%12];
            else if(l>=60) 
                if(str[1].equals("North")) d = data[2][m%12];
                else d = data[2][(m+6)%12];
        }
        return d;
    }
}
