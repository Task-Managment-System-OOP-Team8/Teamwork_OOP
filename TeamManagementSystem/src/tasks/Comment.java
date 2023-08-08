package tasks;

import tasks.contracts.Commentable;
import java.util.ArrayList;
//TODO
public class Comment implements Commentable {

private final String comments;
private String author;


    public Comment(String author, String comments) {
        setAuthor(author);
        this.comments=comments;
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
