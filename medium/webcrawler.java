/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    // instead of passing hostname around to isWebsiteFromHostname
    // everytime, just make it a class member.
    public String hostname;
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        hostname = getHostname(startUrl);
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        
        // initalize the bfs.
        q.offer(startUrl);
        set.add(startUrl);
        
        // bfs
        while (!q.isEmpty()) {
            // handle current url.
            String currentUrl = q.poll();
            
            // get all children nodes, aka all urls from the current url. 
            List<String> childrenUrls = htmlParser.getUrls(currentUrl);
            for (String site : childrenUrls) {
                // if we have not visited this site, add to queue.
                if (isWebsiteFromHostname(site) && !set.contains(site)) {
                    q.offer(site);
                    set.add(site);
                }
            }
        }
        
        return new LinkedList<String>(set);
    }
    
    // just determines the hostname, avoiding using string.split() functions
    // because in an interview that usually doesn't fly.
    public String getHostname(String startUrl) {
        // http:// will always be in the beginning, we can always start
        // at index 7.
        int end = startUrl.length();
        for (int i = 7; i < end; i++) {
            if (startUrl.charAt(i) == '/') {
                end = i;
                break;
            }
        }
        return startUrl.substring(7, end);
    }
    
    // I could've used string.contains, but what if we get a site like
    // startUrl: yahoo.com
    // and one of the urls within the search are google.com/is-yahoo.com-good?/
    // this way, we check the beginning of the string.
    public boolean isWebsiteFromHostname(String site) {
        int siteIndex = 7;
        for (int i = 0; i < hostname.length(); i++) {
            if (site.charAt(siteIndex) != hostname.charAt(i)) {
                return false;
            }
            siteIndex++;
        }
        return true;
    }
}
