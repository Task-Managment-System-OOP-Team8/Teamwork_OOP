package com.company.oopTaskManagement.tasks.models;

import com.company.oopTaskManagement.tasks.contracts.Comment;
import com.company.oopTaskManagement.tasks.contracts.Story;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import com.company.oopTaskManagement.tasks.models.enums.StoryEnums;


import java.util.List;

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
    @Override
    public SizeEnums getSize() {
        return size;
    }
//TODO
    @Override
    public String getAsString() {
        return null;
    }

    private void setAssignee(String assignee) {
        this.assignee = assignee;
    }
}
