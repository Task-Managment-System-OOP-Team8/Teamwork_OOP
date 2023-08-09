package tasks.models;

import tasks.Comment;
import tasks.contracts.Bug;
import tasks.models.enums.BugStatusEnums;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SeverityEnums;
import teams.Member;

import java.util.ArrayList;

public class BugImpl extends TaskImpl implements Bug {


    private ArrayList<String> steps;
    private SeverityEnums severity;
    private BugStatusEnums status;
    private String assignee;
    private PriorityEnums priority;


    public BugImpl(int id,String title, String description, ArrayList<String> steps, PriorityEnums priority,
                   SeverityEnums severity, BugStatusEnums status,String assignee,ArrayList<Comment>comments,
                   ArrayList<String> getHistory) {
        super(id,title, description);
        this.steps = new ArrayList<>();
        this.priority=priority;
        this.severity=severity;
       setStatus(BugStatusEnums.ACTIVE);
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
    public BugStatusEnums getBugStatus() {
        return status;
    }

    @Override
    public PriorityEnums getPriority() {
        return priority;
    }

    @Override
    public String getMember() {
        return null;
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

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public void setSeverity(SeverityEnums severity) {
        this.severity = severity;
    }

    public void setStatus(BugStatusEnums status) {
        this.status = status;
    }


    public void setPriority(PriorityEnums priority) {
        this.priority = priority;
    }
}