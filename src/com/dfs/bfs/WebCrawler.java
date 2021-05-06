package com.dfs.bfs;
/**
 * Input:
 * urls = [
 *   "http://news.yahoo.com",
 *   "http://news.yahoo.com/news",
 *   "http://news.yahoo.com/news/topics/",
 *   "http://news.google.com",
 *   "http://news.yahoo.com/us"
 * ]
 * edges = [[2,0],[2,1],[3,2],[3,1],[0,4]]
 * startUrl = "http://news.yahoo.com/news/topics/"
 * Output: [
 *   "http://news.yahoo.com",
 *   "http://news.yahoo.com/news",
 *   "http://news.yahoo.com/news/topics/",
 *   "http://news.yahoo.com/us"
 */

import java.util.*;

public class WebCrawler<result> {
 interface HtmlParser {
      public List<String> getUrls(String url) ;
  }

    public static void main(String[] args) {
        WebCrawler w = new WebCrawler();
        String startUrl = "http://news.yahoo.com/news/topics/";//"http://news.google.com";//
        HtmlParser htmlParser = null;
    /*   List<String> res = w.crawlBFS(startUrl, new HtmlParser() {
           @Override
           public List<String> getUrls(String url) {
               return null;
           }
       });

       System.out.println(res);*/

        List<String> res = w.crawlDFS(startUrl, new HtmlParser() {
            @Override
            public List<String> getUrls(String url) {
                return null;
            }
        });

        System.out.println(res);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();

        String split[] = startUrl.split("/");
        String domain = split[0] + "//" + split[2];
        queue.offer(startUrl);
        visitedSet.add(startUrl);

        while (!queue.isEmpty()) {
            String u = queue.poll();
            result.add(u);
            for (String v : htmlParser.getUrls(u)) {
                if (v.startsWith(domain) && !visitedSet.contains(v)) {
                    queue.offer(v);
                    visitedSet.add(v);
                }
            }
        }
        return result;
    }


    public List<String> crawlBFS(String startUrl, HtmlParser htmlParser) {
        Queue<String> queue = new LinkedList<>();
        queue.add(startUrl);
        String[] split = startUrl.split("/");
        String hostname = split[2];
        List<String> res = new ArrayList<>();
        res.add(startUrl);
        Set<String> set = new HashSet<>();
        set.add(startUrl);

        while(!queue.isEmpty()) {
            String currUrl = queue.poll();
            List<String> list = Arrays.asList("http://news.yahoo.com",
                    "http://news.yahoo.com/news",
                    "http://news.yahoo.com/news/topics/",
                    "http://news.google.com",
                    "http://news.yahoo.com/us");//htmlParser.getUrls(currUrl);
            for(String s : list) {
                if(!set.contains(s) && s.split("/")[2].equals(hostname)) {
                    res.add(s);
                    queue.add(s);
                }
                set.add(s);
            }
        }

        return res;
    }


    public List<String> crawlDFS(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet<>(Arrays.asList(startUrl));
        String hostName = startUrl.split("/")[2];
        dfs(set,htmlParser,hostName,startUrl);
        return new ArrayList<String>(set);
    }

    public void dfs(Set<String> visited, HtmlParser hp, String hostName, String currentUrl){
        for (String url : hp.getUrls(currentUrl)) {
            if (url.contains(hostName) && visited.add(url)) {
                dfs(visited,hp,hostName,url);
            }
        }
    }
}
