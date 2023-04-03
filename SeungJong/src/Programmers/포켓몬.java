package Programmers;

import java.util.*;
public class 포켓몬 {
    public int solution(int[] nums) {
        Set<Integer> list = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) list.add(nums[i]);
        return list.size()>nums.length/2?nums.length/2:list.size();
    }
}