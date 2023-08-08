package tasks.models;

import jdk.jshell.Snippet;
import tasks.Comment;
import tasks.contracts.Bug;
import tasks.contracts.Commentable;
import tasks.models.enums.BugStatusEnums;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SeverityEnums;
import teams.Member;

import java.util.ArrayList;

public class BugImpl extends TaskImpl implements Bug {


      private String title;
    private String description;
    private ArrayList<String> steps;
    private SeverityEnums severity;
    private BugStatusEnums status;
    private Member assignee;
    private PriorityEnums priority;
    private ArrayList<Comment> comments;
    private ArrayList<String> history;

        public BugImpl(String title, String description, ArrayList<String> steps, SeverityEnums severity, BugStatusEnums status,
                   Member assignee, PriorityEnums priority) {
        this.title = title;
        this.description = description;
        this.steps =steps;
        this.severity = severity;
        this.status = status;
        this.assignee = assignee;
        this.priority = priority;
        this.comments = new ArrayList<>();
        this.history = new ArrayList<>();
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
    public String getAuthor() {
        return null;
    }

    @Override
    public ArrayList<String> getComments() {
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
//TODO





}