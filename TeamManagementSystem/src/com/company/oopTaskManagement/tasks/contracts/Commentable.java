package com.company.oopTaskManagement.tasks.contracts;

import com.company.oopTaskManagement.tasks.Comment;

import java.util.ArrayList;

public interface Commentable {
  ArrayList<Comment> getComments();

    String getAuthor();
}
