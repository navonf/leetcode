class Twitter {
    public static final int FEEDLIMIT = 10;
    public HashMap<Integer, User> data;
    public int time;
    
    /** Initialize your data structure here. */
    public Twitter() {
        this.data = new HashMap<Integer, User>();
        this.time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // we dont have the user in our data.
        if(!hasUser(userId)) {
            User newUser = new User(userId);
            data.put(userId, newUser);
        }
        
        Tweet currentTweet = new Tweet(tweetId, ++time);
        data.get(userId).tweets.add(currentTweet);
        System.out.println("user: " +userId+ ", posted tweet: " + tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // we dont have the user in our data.
        if(!hasUser(userId)) {
            User newUser = new User(userId);
            data.put(userId, newUser);
        }
        
        List<Integer> currFeed = new LinkedList<Integer>();
        
        PriorityQueue<Tweet> copy = new PriorityQueue<Tweet>(data.get(userId).tweets);
        int count = 0;
        
        if(hasFollowings(userId)) {
            // add the followers tweets to the feed.
            List<Integer> peopleFollowed = data.get(userId).follows;

            for(int id : peopleFollowed) {
                PriorityQueue<Tweet> temp = new PriorityQueue<Tweet>(data.get(id).tweets);
                while(!temp.isEmpty()) {
                    copy.offer(temp.poll());
                }
            }
        }
        
        while(!copy.isEmpty() && count < FEEDLIMIT) {
            currFeed.add(copy.poll().tweetId);
            count++;
        }
        
        System.out.println("got feed: " + currFeed);
        
        return currFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!hasUser(followerId)) {
            User newUser = new User(followerId);
            data.put(followerId, newUser);
        }
        
        if(!hasUser(followeeId)) {
            User newUser = new User(followeeId);
            data.put(followeeId, newUser);
        }
        
        if(followerId != followeeId && !data.get(followerId).hasFollow(followeeId)) {
            data.get(followerId).follows.add(followeeId);
        }
        
        System.out.println(followerId + " follows " + followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!hasUser(followerId)) {
            User newUser = new User(followerId);
            data.put(followerId, newUser);
        }
        
        if(!hasUser(followeeId)) {
            User newUser = new User(followeeId);
            data.put(followeeId, newUser);
        }
        
        if(followerId != followeeId) {
            data.get(followerId).follows.remove(Integer.valueOf(followeeId));
        }
        System.out.println(followerId + " follows " + followeeId);
    }
    
    public boolean hasUser(int u) {
        return data.containsKey(u);
    }
    
    public boolean hasFollowings(int u) {
        return data.get(u).follows.size() > 0;
    }
}

class User {
    public int userId;
    public List<Integer> follows;
    public PriorityQueue<Tweet> tweets;
    
    User(int id) {
        this.userId    = id;
        this.follows = new ArrayList<Integer>();
        this.tweets    = new PriorityQueue<Tweet>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return Integer.compare(t2.time, t1.time);
            }
        });
    }
    
    // we already have the follower check
    public boolean hasFollow(int followeeId) {
        return follows.contains(followeeId);
    }
}

class Tweet {
    public int time;
    public int tweetId;
    
    Tweet(int id, int time) {
        this.tweetId = id;
        this.time    = time;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
