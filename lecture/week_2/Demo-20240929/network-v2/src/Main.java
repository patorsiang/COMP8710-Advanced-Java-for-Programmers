public class Main {
    public static void main(String[] args) throws InterruptedException {
        var messagePost = new MessagePost("Joe", "Hello");
        var photoPost = new PhotoPost("Sam", "london.jpg", "London");

        var newsfeed = new NewsFeed();
        newsfeed.addPost(messagePost);
        newsfeed.addPost(photoPost);
        newsfeed.show();
        Thread.sleep(1000);
        messagePost.like();
        photoPost.addComment("Great!");
        newsfeed.show();
    }
}
