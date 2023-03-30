package w11;

import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Genre> map = new HashMap<>();
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) 
                map.put(genres[i], new Genre(genres[i], new PriorityQueue<>()));
            
            map.get(genres[i]).addSum(plays[i]);
            map.get(genres[i]).songs.add(new Song(i, plays[i]));
        }
        
        for (String key : map.keySet()) {
            pq.add(map.get(key));
        }
        
        while(!pq.isEmpty()) {
            Genre g = pq.poll();
            answer.add(g.songs.poll().num);
            if (!g.songs.isEmpty()) answer.add(g.songs.poll().num);
        }
        
        return answer;
    }
    
    static class Genre implements Comparable<Genre> {
        String name;
        int sum = 0;
        PriorityQueue<Song> songs;
        
        public Genre(String name, PriorityQueue<Song> songs) {
            this.name = name;
            this.songs = songs;
        }
        
        public void addSum(int num) {
            this.sum += num;
        }
        
        @Override
		public int compareTo(Genre o) {
            return o.sum - this.sum;
		}
    }
    
    static class Song implements Comparable<Song> {
        int num, plays;
        
        public Song(int num, int plays) {
            this.num = num;
            this.plays = plays;
        }

		@Override
		public int compareTo(Song o) {
            if (this.plays == o.plays) return this.num - o.num;
			return o.plays - this.plays;
		}
        
    }
}
