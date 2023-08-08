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
    private Member assignee;
    private PriorityEnums priority;


        public BugImpl(String title,int id, String description, ArrayList<String> steps, SeverityEnums severity,
                       BugStatusEnums status, PriorityEnums priority) {
            super(title,id,description);
        this.steps =steps;
        this.severity = severity;
        this.status = BugStatusEnums.ACTIVE;
        this.priority = priority;

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
    public Member getMember() {
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
}