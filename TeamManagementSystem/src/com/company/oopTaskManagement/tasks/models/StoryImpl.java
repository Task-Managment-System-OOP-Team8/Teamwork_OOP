package com.company.oopTaskManagement.tasks.models;

import com.company.oopTaskManagement.tasks.contracts.Story;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import com.company.oopTaskManagement.tasks.models.enums.StoryEnums;
import com.company.oopTaskManagement.tasks.Comment;


import java.util.ArrayList;

public class StoryImpl extends TaskImpl implements Story {

    private final PriorityEnums priority;
    private final SizeEnums size;
    private StoryEnums status;
    private String assignee;


    public StoryImpl(String title, String description,PriorityEnums priority,SizeEnums size,String assignee) {
        super(title,description);
        this.priority=priority;
        this.size=size;
        this.status = StoryEnums.NOT_DONE;
       setAssignee(assignee);

    }

    //TODO
    private void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public PriorityEnums getPriority() {
        return priority;
    }

    @Override
    public String getAssignee() {
        return assignee;
    }

    @Override
    public StoryEnums getStatus() {
        return status;
    }

    //TODO

    public String getAuthor() {
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public SizeEnums getSize() {
        return size;
    }
//TODO
    @Override
    public String getAsString() {
        return null;
    }

    @Override
    public ArrayList<Comment> getComment() {
        return null;
    }
}
