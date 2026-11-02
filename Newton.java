public class Newton{

    public static void main(String[] args){
        Double init=200.0;
        Double fin=newton(init);
        System.out.println(fin);
    }

    public static Double f(double x){
        return Math.pow(x,2)+2*x+1;
    }
    
    public static Double df(double x){
        return 2*x+2;
    }

    public static Double newton(double x){
        Double tol=1e-6;
        Double err=1.0;
        while  (err>tol){
            Double fx=f(x);
            Double dfx=df(x);

            if(dfx==0){
                break;

            }
            Double x2= x-(fx/dfx);
            err=Math.abs(x2-x);
            x=x2;
        }
        return x;
    }
}