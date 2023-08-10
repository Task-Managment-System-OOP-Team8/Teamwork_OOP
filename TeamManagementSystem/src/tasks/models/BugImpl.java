package tasks.models;

import tasks.Comment;
import tasks.contracts.Bug;
import tasks.models.enums.*;

import java.util.ArrayList;

public class BugImpl extends TaskImpl implements Bug {


    private ArrayList<String> steps;
    private SeverityEnums severity;
    private  BugEnums status;
    private String assignee;
    private PriorityEnums priority;


    public BugImpl( String title, String description, PriorityEnums priority,
                   SeverityEnums severity, String assignee) {
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
    public ArrayList<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    //TODO
    @Override
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

    private void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    private void setSeverity(SeverityEnums severity) {
        this.severity = severity;
    }
    private void setPriority(PriorityEnums priority) {
        this.priority = priority;
    }
}