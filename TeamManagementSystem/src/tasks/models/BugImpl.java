package tasks.models;

import tasks.Comment;
import tasks.contracts.Bug;
import tasks.models.enums.StatusEnums;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SeverityEnums;

import java.util.ArrayList;

public class BugImpl extends TaskImpl implements Bug {


    private ArrayList<String> steps;
    private SeverityEnums severity;
    private StatusEnums status;
    private String assignee;
    private PriorityEnums priority;


    public BugImpl(int id, String title, String description, ArrayList<String> steps, PriorityEnums priority,
                   SeverityEnums severity, StatusEnums status, String assignee, ArrayList<Comment>comments,
                   ArrayList<String> getHistory) {
        super(id,title, description);
        this.steps = new ArrayList<>();
        this.priority=priority;
        this.severity=severity;
       this.status = StatusEnums.ACTIVE;
      setAssignee(assignee);

    }

    private void setAssignee(String assignee) {
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
    public StatusEnums getStatus() {
        return status;
    }

    @Override
    public String getAssignee() {
        return null;
    }

    @Override
    public PriorityEnums getPriority() {
        return priority;
    }

//    @Override
//    public String getAssignee() {
//        return assignee;
//    }


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