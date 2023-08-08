package tasks;

import tasks.contracts.Commentable;

import java.util.ArrayList;
//TODO
public class Comment implements Commentable {

private final String comments;
private String author;


    public Comment(String comments, String author) {
        this.comments=comments;
       setAuthor(author);
    }

    @Override
    public ArrayList<Comment> getComments() {
        return new ArrayList<>();
    }

    @Override
    public String getAuthor() {
        return author;
    }



//    public void setComments(String comments) {
//        this.comments = comments;
//    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
