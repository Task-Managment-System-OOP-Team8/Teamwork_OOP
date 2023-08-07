package tasks;

import tasks.contracts.Commentable;

import java.util.ArrayList;

public class Comment implements Commentable {

private String comments;
private String author;


    public Comment(String comments, String author) {
        this.comments = comments;
        this.author = author;
    }
//TODO
    @Override
    public ArrayList<String> getComments() {
        return new ArrayList<>();
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
