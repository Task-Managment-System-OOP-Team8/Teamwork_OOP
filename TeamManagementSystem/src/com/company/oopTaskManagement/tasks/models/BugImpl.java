package com.company.oopTaskManagement.tasks.models;

import com.company.oopTaskManagement.tasks.contracts.Bug;
import com.company.oopTaskManagement.tasks.models.enums.BugEnums;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;
import com.company.oopTaskManagement.tasks.Comment;


import java.util.ArrayList;
import java.util.List;

public class BugImpl extends TaskImpl implements Bug {


    private ArrayList<String> steps;
    private SeverityEnums severity;
    private BugEnums status;
    private PriorityEnums priority;
    private String assignee;


    public BugImpl(String title, String description, List<String> steps,
                   PriorityEnums priority, SeverityEnums severity,String assignee) {
        super(title, description);
        this.steps = new ArrayList<>();
        this.priority=priority;
        this.severity=severity;
       this.status = BugEnums.ACTIVE;
      setAssignee(assignee);

    }

    private void setAssignee(String assignee) {
        this.assignee=assignee;
    }

    @Override
    public ArrayList<String> getSteps() {
        return new ArrayList<>(steps);
    }

    @Override
    public SeverityEnums getSeverity() {
        return severity;
    }


    @Override
    public BugEnums getStatus() {
        return status;
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
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    private void setSeverity(SeverityEnums severity) {
        this.severity = severity;
    }
    private void setPriority(PriorityEnums priority) {
        this.priority = priority;
    }
//TODO
    @Override
    public String getAsString() {

        return String.format("BUG:\n" +
                "Title: %s\n" +
                "Description %s\n" +
                "Priority: %s\n" +
                "Severity: %s\n" +
                "Assignee: %s\n", title,description,priority,severity,assignee);
    }
//TODO - Comments!
    @Override
    public ArrayList<Comment> getComment() {
        return new ArrayList<>();
    }
}