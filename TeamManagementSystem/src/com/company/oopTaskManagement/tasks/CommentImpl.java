package com.company.oopTaskManagement.tasks;

import com.company.oopTaskManagement.tasks.contracts.Comment;

public class CommentImpl implements Comment {

    private String content;
    private final String author;


    public CommentImpl(String author, String content) {
        this.author = author;
        setContent(content);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getAuthor() {
        return author;
    }


    private void setContent(String content) {
        this.content = content;
    }


}
