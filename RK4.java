import java.util.Arrays;
import java.io.PrintWriter;
import java.io.IOException;

public class RK4{

    public static void main(String[] arg){
        Double a=0.0;
        Double b=3.0;
        Integer N=100;
        Double x0=0.5;
        Double[] tpts=time(a,b,N);
        Double[] xpts=rk4(a,b,N,x0);

        //Write array to csv file, try and catch
        try (PrintWriter writer=new PrintWriter("C:/Users/chius/OneDrive/codes/python codes/RK4_java.csv")){ 
            writer.println("t,x");
            for (int i=0;i<tpts.length;i++){
                writer.println(tpts[i]+","+xpts[i]);
            }
            System.out.println("Data written to RK4_java.csv");
        } catch (IOException e){
            System.out.println("Error writing to file: "+e.getMessage());
        }
        //System.out.println("tpts: ");   
        //System.out.println(Arrays.toString(tpts));
        //System.out.println("xpts: ");
        //System.out.println(Arrays.toString(xpts));
    }

    public static Double f(Double t,Double x){
        Double ans=2*t+Math.pow(x,2);
        return ans;
    }

    public static Double dt(Double a, Double b, Integer N){
        Double h=(b-a)/N;
        return h;
    }

    public static Double[] time(Double a, Double b, Integer N){
        Double[] tpts=new Double [N+1];
        Double h=dt(a,b,N);
        Arrays.setAll(tpts,i->i*h);
        return tpts;
    }

    public static Double[] rk4(Double a, Double b, Integer N, Double x0){
        Double[] xpts=new Double [N+1];
        xpts[0]=x0;
        Double h=dt(a,b,N);
        Double[] tpts=time(a,b,N);
        for(int i=0;i<N; i++){
            Double k1=h*f(tpts[i],x0);
            Double k2=h*f(tpts[i]+0.5*h,x0+0.5*k1);
            Double k3=h*f(tpts[i]+0.5*h,x0+0.5*k2);
            Double k4=h*f(tpts[i]+h,x0+k3);
            x0=x0+(k1+2*k2+2*k3+k4)/6;
            xpts[i+1]=x0;
        }
        return xpts;
    } 
}