import java.util.*;
import java.util.stream.Collectors;

class Solution {

    // Song 정보를 담는 클래스
    private static class Song implements Comparable<Song> {
        private final int id;
        private final int plays;

        public Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }

        // 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬
        @Override
        public int compareTo(Song other) {
            if (this.plays != other.plays) {
                return Integer.compare(other.plays, this.plays);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장하는 맵
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 노래 목록을 저장하는 맵
        Map<String, List<Song>> genreSongList = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 횟수 업데이트
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            // 장르별 노래 목록에 현재 노래 추가
            genreSongList.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
        }

        // 장르별 총 재생 횟수를 기준으로 내림차순 정렬
        List<String> sortedGenres = genrePlayCount.keySet().stream()
                .sorted((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1))
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        
        // 정렬된 장르 순서대로 노래를 결과에 추가
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongList.get(genre);
            
            // 장르 내 노래들을 정렬 기준에 따라 정렬
            Collections.sort(songs);
            
            // 재생 횟수가 가장 많은 두 곡을 결과에 추가
            result.add(songs.get(0).id);
            if (songs.size() > 1) {
                result.add(songs.get(1).id);
            }
        }

        // ArrayList를 int 배열로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}