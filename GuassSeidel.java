public class GuassSeidel{
    
    public static Matrix GS(Matrix A, Matrix x,Matrix F){
        Matrix A0=A.copy(A);
        Matrix x0=x.copy(x);
        Matrix F0=F.copy(F);

        for (Integer i=0;i<A0.rows();i++){
            for (Integer j=0;j<F0.cols();j++){
                    Double ans=0.0;
                    for (Integer k=0;k<A0.rows();k++){
                        if (i!=k){
                            ans+=A0.get(i,k)*x0.get(k,j);
                        } else{
                            ans+=0;
                        }
                    }
                    x0.set(i,j,(F0.get(i,j)-ans)/A0.get(i,i));
                }
            }
        return x0;
        }

    public static void check(Matrix A, Matrix x,Matrix F){
        if (A.rows()!=F.rows() || x.cols()!=F.cols()){
            System.err.println("Incompatible matrix dimensions");
        } else {
            System.out.println("Everything normal, please go ahead");
        }
    }

    public static void main(String[] args){
        Integer n=3;
        Matrix A = Matrix.zeros(n,n);
        for (Integer i=0;i<n;i++){
            for (Integer j=0;j<n;j++){
                A.set(i,j,1/(i+j+1.0));
            }
        }
        Matrix b= Matrix.eye(n);
        Matrix x=Matrix.zeros(n,n);

        check(A, x, b);

        Double err=1.0;
        Double tol=1e-6;
        Integer it=0;
        Integer maxit=1000;
        while (err>tol && it<maxit){
            Matrix x1=GS(A,x,b);
            err=0.0;
            for (Integer i=0;i<n;i++){
                for (Integer j=0;j<n;j++){
                    err+=Math.abs(x1.get(i,j)-x.get(i,j));
                }
            }
            x=x1.copy(x1);
            it+=1;
        }
        System.out.println("A^-1: ");
        System.out.println(x);
    }
}