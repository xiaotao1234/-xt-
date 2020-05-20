package 设计;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/4/13 20:12
 */
public class 设计推特 {

    public static void main(String[] args) {
        设计推特 s = new 设计推特();
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        List<?> list = new ArrayList();
        }

        static class Twitter {

            class User {
                int userId;
                Set<User> floowUer;
                List<Message> messages;

                public void addMessages(Message message) {
                    messages.add(message);
                    messages.sort((o1, o2) -> {
                        if (o1.index > o2.index) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });
                }

                public User(int userId) {
                    this.userId = userId;
                    this.floowUer = new HashSet<>();
                    this.messages = new ArrayList<>();
                    floowUer.add(this);
                }

                @Override
                public boolean equals(Object obj) {
                    User user = (User) obj;
                    return user.userId == this.userId;
                }

                @Override
                public int hashCode() {
                    return userId;
                }
            }

            class Message {
                int index;
                int user;
                int twitterId;

                public Message(int index, int user, int twitterId) {
                    this.index = index;
                    this.user = user;
                    this.twitterId = twitterId;
                }
            }

            int index;
            Map<Integer, User> userSet;

            /**
             * Initialize your data structure here.
             */
            public Twitter() {
                index = 0;
                userSet = new HashMap<>();
            }

            /**
             * Compose a new tweet.
             */
            public void postTweet(int userId, int tweetId) {
                if (userSet.containsKey(userId)) {
                    userSet.get(userId).addMessages(new Message(index, userId, tweetId));
                } else {
                    User user = new User(userId);
                    user.addMessages(new Message(index, userId, tweetId));
                    userSet.put(userId, user);
                }
                index++;
            }

            /**
             * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
             */
            public List<Integer> getNewsFeed(int userId) {
                if (userSet.containsKey(userId)) {
                    Set<User> floowUer = userSet.get(userId).floowUer;
                    List<Message> messageList = new ArrayList<>();
                    for (User user : floowUer) {
                        user = userSet.get(user.userId);
                        if (user != null) {
                            int num = 0;
                            for (Message message : user.messages) {
                                messageList.add(message);
                                if (num == 10) {
                                    break;
                                }
                            }
                        }
                    }
                    Collections.sort(messageList, (o1, o2) -> {
                        if (o1.index > o2.index) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });
                    List<Integer> list = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        if (i == messageList.size()) {
                            break;
                        }
                        list.add(messageList.get(i).twitterId);
                    }

                    return list;
                }
                return new ArrayList<>();
            }

            /**
             * Follower follows a followee. If the operation is invalid, it should be a no-op.
             */
            public void follow(int followerId, int followeeId) {
                if (userSet.containsKey(followerId)) {
                    userSet.get(followerId).floowUer.add(new User(followeeId));
                } else {
                    User user = new User(followerId);
                    user.floowUer.add(new User(followeeId));
                    userSet.put(followerId, user);
                }
            }

            /**
             * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
             */
            public void unfollow(int followerId, int followeeId) {
                if (followeeId != followerId && userSet.get(followerId) != null)
                    userSet.get(followerId).floowUer.remove(userSet.get(followeeId));
            }
        }
    }
