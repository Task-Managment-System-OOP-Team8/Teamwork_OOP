package tasks.contracts;

import tasks.Comment;

import java.util.ArrayList;

public interface Commentable {
  ArrayList<Comment> getComments();

    String getAuthor();
}
