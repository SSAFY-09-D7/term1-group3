import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFind = false;
        ArrayList<Integer> nan = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<9;i++){
            //키의 합이 100이 되는 난쟁이 출력
            nan.add(sc.nextInt()) ;
            sum+=nan.get(i);
        }
        // System.out.println(sum);
        Collections.sort(nan);
        int diff = sum-100;

        for(int i=0;i<8;i++){
            int find = diff-nan.get(i);
            for(int j=i;j<9;j++){
                if(nan.get(j)==find){
                    isFind = true;
                    nan.remove(nan.get(j));
                    nan.remove(nan.get(i));
                    break;
                }
            }
            if(isFind==true) break;
        }
        
        for(int i=0;i<nan.size();i++){
            System.out.println(nan.get(i));
        }
        
    }
}
