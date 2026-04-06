import java.util.*;

public class PrimeFibonacciSeries {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter terms: ");
        int n = sc.nextInt();

        int a = 0, b = 1;
        int num = 2;

        for(int i=1;i<=n;i++){

            if(i % 2 != 0){   // prime number

                while(true){
                    boolean prime = true;

                    for(int j=2;j<=num/2;j++){
                        if(num % j == 0){
                            prime = false;
                            break;
                        }
                    }

                    if(prime){
                        System.out.print(num + " ");
                        num++;
                        break;
                    }
                    num++;
                }

            } else {   // fibonacci

                int c = a + b;
                System.out.print(c + " ");
                a = b;
                b = c;
            }
        }
    }
}
    
