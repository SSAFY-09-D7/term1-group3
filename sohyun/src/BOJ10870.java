import java.util.Scanner;

public class BOJ10870{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fibonacci(N));
    }
    private static int fibonacci(int num){
        if(num<=1) return num;
        else
            return fibonacci(num-1)+fibonacci(num-2);
        
    }
}