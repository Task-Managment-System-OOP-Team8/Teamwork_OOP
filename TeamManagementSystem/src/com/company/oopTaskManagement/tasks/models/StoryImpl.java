package com.company.oopTaskManagement.tasks.models;

import com.company.oopTaskManagement.tasks.contracts.Story;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import com.company.oopTaskManagement.tasks.models.enums.StoryEnums;
import com.company.oopTaskManagement.tasks.Comment;
import tasks.models.enums.*;

import java.util.ArrayList;

public class StoryImpl extends TaskImpl implements Story {
    public static final int TITLE_MAX_LENGTH = 50;
    public static final int TITLE_MIN_LENGTH = 10;
    public static final String INVALID_TITLE_LENGTH = String.format(
            "Title must be between %d and %d symbols", TITLE_MIN_LENGTH, TITLE_MAX_LENGTH);
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final String INVALID_DESCRIPTION_LENGTH = String.format(
            "Description must be between %d and %d symbols", DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH);

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


    public ArrayList<Comment> getComments() {
        return new ArrayList<>(comments);
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
}
