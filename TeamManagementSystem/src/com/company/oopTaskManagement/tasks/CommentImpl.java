package com.company.oopTaskManagement.tasks;

import com.company.oopTaskManagement.tasks.contracts.Comment;

public class CommentImpl implements Comment {

    private String content;
    private final String author;


    public CommentImpl(String content, String author) {
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
