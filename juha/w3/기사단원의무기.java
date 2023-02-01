class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] measure = new int[number];
        for(int i = 1; i<=number; i++){
            measure[i-1] = addMeasure(i);
            if(measure[i-1]>limit){
                measure[i-1] = power;
            }
            answer += measure[i-1];
        }
        
        return answer;
    }
    
    public int addMeasure(int n){
        int cnt = 0;
        for(int i = 1;i*i<=n;i++)
        {
            if(i*i == n) cnt++;
            else if(n % i == 0) cnt += 2;
        }
        return cnt;
    }
}
