package com.fb;

import java.util.*;

/**
 * /*
 *  * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.
 *
 * Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.
 *
 * The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.
 *
 * Example 1:
 *
 * Input:
 * userSongs = {
 *    "David": ["song1", "song2", "song3", "song4", "song8"],
 *    "Emma":  ["song5", "song6", "song7"]
 * },
 * songGenres = {
 *    "Rock":    ["song1", "song3"],
 *    "Dubstep": ["song7"],
 *    "Techno":  ["song2", "song4"],
 *    "Pop":     ["song5", "song6"],
 *    "Jazz":    ["song8", "song9"]
 * }
 *
 * Output: {
 *    "David": ["Rock", "Techno"],
 *    "Emma":  ["Pop"]
 * }
 *
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 * Example 2:
 *
 * Input:
 * userSongs = {
 *    "David": ["song1", "song2"],
 *    "Emma":  ["song3", "song4"]
 * },
 * songGenres = {}
 *
 * Output: {
 *    "David": [],
 *    "Emma":  []
 * }
 *  *
 *
 * /*
  *  * Time Complexity:
  *
  * (songToGenre) Mapping Song to Genre :O(G x S)
  * For each user-> mapping Song to Genre and finding max frequency Genre
  * For each user: O(U)
  * Mapping Song to the Genre :
  * - Going through all list of songs and mapping to Genre: O(S) and finding Genre will take O(1)
  * - Finding favoriteGenre loop: the worst case will take O(S), where every song belong to different Genre
  * Total: O(G x S) + O(U x (S + S))
  *
 * @author swamy on 12/31/20
 */
public class    FavoriteGenres {
    public static void main(String[] args) {

        FavoriteGenres f = new FavoriteGenres();
        Map<String, List<String>> userMap = new HashMap<>();
        userMap.put("David",new ArrayList<String>(Arrays.asList("song1", "song2", "song3", "song4", "song8")));
        userMap.put("Emma", new ArrayList<String>(Arrays.asList("song5", "song6", "song7")));

        Map<String, List<String>> genreMap = new HashMap<>();
        genreMap.put("Rock",new ArrayList<String>(Arrays.asList("song1", "song3")));
        genreMap.put("Dubstep",new ArrayList<String>(Arrays.asList("song7")));
        genreMap.put("Techno",new ArrayList<String>(Arrays.asList("song2", "song4")));
        genreMap.put("Pop",new ArrayList<String>(Arrays.asList("song5", "song6")));
        genreMap.put("Jazz",new ArrayList<String>(Arrays.asList("song8", "song9")));

	 /*   Map<String, List<String>> userMap = new HashMap<>();
			List<String> list1 = Arrays.asList("song1", "song2");
			List<String> list2 = Arrays.asList("song3", "song4");
			userMap.put("David", list1);
			userMap.put("Emma", list2);

			Map<String, List<String>> genreMap = new HashMap<>();*/

        Map<String, List<String>>  res = f.favoriteGenre(userMap,genreMap);
        System.out.println(res);

    }

    private Map<String, List<String>> favoriteGenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, String>sonGenres = new HashMap<>();
        genreMap.forEach((genre, songs)-> songs.forEach((song -> sonGenres.put(song, genre))) );

        Map<String, List<String>> favoriteGenre = new HashMap<>();
        userMap.forEach((user, songs) -> favoriteGenre.put(user, calculateFavGenre(songs, sonGenres)));
        return favoriteGenre;
    }

    private List<String> calculateFavGenre(List<String> songs, Map<String, String> songGenres) {
        Map<String, Integer> genreFreq = new HashMap<>();
        List<String> favoriteGenre = new ArrayList<>();
        int maxFreq = 0;
        for(String song: songs){
            String genre = songGenres.get(song);
            Integer freq = genreFreq.merge(genre, 1, (ov, nv) -> ov +1);
            maxFreq = Math.max(maxFreq, freq);

        }
        for(Map.Entry<String, Integer> entry: genreFreq.entrySet()){
            if(entry.getKey()!=null && entry.getValue() == maxFreq){
                favoriteGenre.add(entry.getKey());
            }
        }
        return favoriteGenre;

    }
}
