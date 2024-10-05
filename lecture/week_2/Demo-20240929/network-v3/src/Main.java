public class Main {
    public static void main(String[] args) throws InterruptedException {
        var messagePost = new MessagePost("Joe", "Hello");
        var phtoPost = new PhotoPost("Sam", "london.jpg", "London");

        var newsfeed = new NewsFeed();
        newsfeed.addPost(messagePost);
        newsfeed.addPost(phtoPost);
        newsfeed.show();
        Thread.sleep(1000);
        messagePost.like();
        phtoPost.addComment("Great!");
        newsfeed.show();
    }
}
