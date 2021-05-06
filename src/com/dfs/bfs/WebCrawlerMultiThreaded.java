package com.dfs.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WebCrawlerMultiThreaded {
    public static void main(String[] args) {

    }

    public List<String> crawl(String startUrl, WebCrawler.HtmlParser htmlParser) {

        // find hostname
        int index = startUrl.indexOf('/', 7); //first occurrence of '/' in string, after 7th position
        String hostname = (index != -1) ? startUrl.substring(0, index) : startUrl;

        // multi-thread
        Crawler crawler = new Crawler(startUrl, hostname, htmlParser);
        crawler.map = new ConcurrentHashMap<>(); // reset result as static property belongs to class, it will pass
        crawler.result = crawler.map.newKeySet();// The newKeySet() method of ConcurrentHashMap class Creates a new
        Thread thread = new Thread(crawler);     // set backed by a ConcurrentHashMap
        thread.start();

        crawler.joinThread(thread); // wait for thread to complete
        return new ArrayList<>(crawler.result); // convert set to array list and return
    }
}

class Crawler implements Runnable {
    String startUrl;
    String hostname;
    WebCrawler.HtmlParser htmlParser;
    public static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    public static Set<String> result = map.newKeySet();

    public Crawler(String startUrl, String hostname, WebCrawler.HtmlParser htmlParser) {
        this.startUrl = startUrl;
        this.hostname = hostname;
        this.htmlParser = htmlParser;
    }

    @Override
    public void run() {
        if (this.startUrl.startsWith(hostname) && !this.result.contains(this.startUrl)) {
            this.result.add(this.startUrl);
            List<Thread> threads = new ArrayList<>();
            for (String s : htmlParser.getUrls(startUrl)) {
                if(result.contains(s)) continue;
                Crawler crawler = new Crawler(s, hostname, htmlParser);
                Thread thread = new Thread(crawler);
                thread.start();
                threads.add(thread);
            }
            for (Thread t : threads) {
                joinThread(t); // wait for all threads to complete
            }
        }
    }

    public static void joinThread(Thread thread) {
        try {
            thread.join();// When we invoke join() method on a thread, the calling thread goes into waiting state.
        } catch (InterruptedException e) {  // It remains in a waiting state until the referenced thread terminates.
            e.printStackTrace();
        }
    }
}
