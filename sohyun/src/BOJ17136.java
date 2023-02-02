import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class BOJ17136 {
    public static void main(String[] args) throws Exception{
     // 다섯 종류 5개
     // 겹치면 X 경계밖 X 0이 적힌 칸에 있으면 안됨
     // 색종이 최소개수??

     //map만들기
        int oneCount = 0;
        int answer = 0;
        int[][] map = new int[10][10];
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        HashMap<int[],Integer> square = new HashMap<>();
        for(int i=0;i<10;i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            
            for(int j=0;j<10;j++){
                map[i][j] = Integer.valueOf(st.nextToken());
                if(map[i][j]==1) oneCount++;
            }
        }

        // 다 0이면 0
        if(oneCount==0) System.out.println(answer);
        else{
            //첨에 1갯수로 시작
            
            answer = oneCount; 
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    if(map[i][j]==1){
                        //i,j
                        int squareNt = findSquare(map,i,j);
                        int[] oneMap = new int[2];
                        oneMap[0] = i;
                        oneMap[1] = j;
                        square.put(oneMap,squareNt);
                    }
                }
            }

            List<Map.Entry<int[], Integer>> entryList = new LinkedList<>(square.entrySet());
            entryList.sort(new Comparator<Map.Entry<int[], Integer>>() {

                @Override
                public int compare(Entry<int[], Integer> o1, Entry<int[], Integer> o2) {

                    return o2.getValue()-o1.getValue();
                }
            });
            int maxSquare= entryList.get(0).getValue();
            
            if(maxSquare==1){
                //1인 경우, 사각형 개수가 5개 이상이면 -1
                int cntSum = 0;
                for(Map.Entry<int[], Integer> entry : entryList){
                    cntSum+=entry.getValue();
                }
                if(cntSum>5) {
                    answer = -1;
                }
                else{
                    answer = cntSum;
                }
                System.out.println(answer);

            }
            else{
                //
                for(Map.Entry<int[], Integer> entry : entryList){
                    int[] start = entry.getKey();
                    int sqCnt = entry.getValue();
                    int x = start[0];
                    int y = start[1];


                    //copyMap 만들기
                    int[][] copyMap = new int[map.length][map[0].length];
                    for(int i=0;i<10;i++){
                        for(int j=0;j<10;j++){
                            copyMap[i][j] = map[i][j];
                        }
                    }
                    // zero로 채우기??
                    int[] storage = zeroFill(copyMap,x,y,sqCnt,entryList);
                    //다 0이 될때 까지 zerofill?
                    System.out.println(Arrays.toString(storage));
                    // System.out.println("copyMap");
                    // System.out.println(Arrays.deepToString(copyMap));
                    // System.out.println(Arrays.deepToString(zeroMap));
                    //zero로 채우고, findSquare 해서 -? 다시 hashMap으로 뽑아보기
                    HashMap<int[],Integer> copySquare = new HashMap<>();
                    for(int i=0;i<10;i++){
                        for(int j=0;j<10;j++){
                            if(map[i][j]==1){
                                //i,j
                                int squareNt = findSquare(copyMap,i,j);
                                int[] oneMap = new int[2];
                                oneMap[0] = i;
                                oneMap[1] = j;
                                copySquare.put(oneMap,squareNt);
                            }
                        }
                    }
                    System.out.printf("%d %d\n",x,y);
                    ArrayList<Integer> tempArr = new ArrayList<>();
                    for (Entry<int[], Integer> pair : copySquare.entrySet()) {
                        // System.out.println(Arrays.toString(pair.getKey()));
                        tempArr.add(pair.getValue());
                    }
                    // System.out.println(tempArr);

                }
            }
            
            
        }
    }

    private static int[] zeroFill(int[][] copyMap,int x, int y,int sqCnt,List<Map.Entry<int[], Integer>> entryList){
        List<Map.Entry<int[], Integer>> tempList = entryList;
        int tempCnt = 0;
        int[][] tempMap = new int[10][10];

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                tempMap[i][j] = copyMap[i][j];
            }
        }

        int[] cntStorag = new int[6]; //1,2,3,4,5
        for(int start=x;start<entryList.size();start++){

            int tempSQ = entryList.get(start).getValue();
            int[] tempXY = entryList.get(start).getKey();
            int tempX = tempXY[0];
            int tempY = tempXY[1];
            

            boolean isFill = true;
            for(int k=tempX;k<tempX+tempSQ;k++){
                //하나라도 0이면 채울 수 없음
                for(int m=tempY;m<tempY+tempSQ;m++){
                    if(tempMap[k][m]==0){
                        isFill = false;
                        break;
                    }
                    else{
                        tempMap[k][m]=0;
                    }
                } 
                if(isFill==false) break;
            }
            if(isFill==true){
                //0으로 채웠으면
                cntStorag[tempSQ]++;
                continue;
            }
        }
        //다하고 1이 남아있는지 확인
        for(int h=0;h<10;h++){
            for(int w=0;w<10;w++){
                if(tempMap[h][w]==1) cntStorag[1]++;
            }
        }

        return cntStorag;
    }

    private static int findSquare(int[][] map, int i,int j){
       int[][] arr =new int[5][5];
       boolean isSquare = true;
       int maxLen = 0;
        for(int k=j;k<j+5;k++){
            if(k>=0 && k<10 && map[i][k]==1){
                maxLen +=1;
            }
            else break;
        }

        //
        int colLen = 0;
        for(int m=i;m<i+5;m++){
            if(m>=0 && m<10 && map[m][j]==1){
                colLen++;
            }
            else break;
        }

        // System.out.printf("좌표 %d %d\n",i,j);
        
        return Math.min(maxLen,colLen);
    }
}
