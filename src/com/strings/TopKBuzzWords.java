package com.strings;

import java.util.*;

public class TopKBuzzWords {
    public static void main(String[] args) {
        TopKBuzzWords t = new TopKBuzzWords();
        String[] keyWords = {"virus", "carona", "vaccine", "COVID-19"};
        String[] quoteWords = {
                "Hey now a day the carona became popular, Carona is a pandemic",
                "Many people waiting for vaccine , but vaccine will take time",
                "COVID-19 is named after its starting year, vaccine can fix it",
                "carona virus finally ends" };
        String topBuzzWords = t.findTopBuzzWords(keyWords, quoteWords);
        System.out.println(topBuzzWords);

    }

    private String findTopBuzzWords(String[] keyWords, String[] quoteWords) {
        List<String> res = new ArrayList<>();
        int topLimit = 2;
        Map<String, Long> freqMap = new HashMap<>();
        //convert to lowercase and remove punctuations
        for(int i=0; i<quoteWords.length; i++){
            quoteWords[i] = quoteWords[i].toLowerCase();
            quoteWords[i] = quoteWords[i].replaceAll("\\p{Punct}", "");
        }

        //iterate over all the quote words and count the frequency with keywords
        for(String quotes: quoteWords){
            String[] quoteWord = quotes.split("[ ]");
            for(int i=0; i<keyWords.length; i++){
                String keyWord = keyWords[i];
                long freq = Arrays.stream(quoteWord)
                                .filter(s-> s.equals(keyWord))
                                .count();
                freqMap.merge(keyWords[i], freq, Long::sum);
            }
        }

        PriorityQueue<Map.Entry<String, Long>> que = new PriorityQueue<>((w1, w2) -> w1.getValue() == w2.getValue()?
                w1.getKey().compareTo(w2.getKey()) :
                Long.compare(w1.getValue(), w2.getValue()));
        for(Map.Entry<String, Long> topWord: freqMap.entrySet()){
            que.offer(topWord);
            if(que.size() > topLimit){
                que.poll();
            }
        }
        while(!que.isEmpty())
            res.add(0, que.poll().getKey());

        String delim = ",";
        return String.join(delim, res);
    }
}
