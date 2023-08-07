package tasks.models;

import Utils.ValidationHelpers;

import tasks.Comment;
import tasks.contracts.Bug;
import tasks.models.enums.BugStatusEnums;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SeverityEnums;
import teams.Member;

import java.util.ArrayList;

public class BugImpl extends TaskImpl implements Bug {

    public static final int TITLE_MAX_LENGTH = 50;

    public static final int TITLE_MIN_LENGTH = 10;
    public static final String INVALID_TITLE_LENGTH = String.format(
            "Title must be between %d and %d symbols", TITLE_MIN_LENGTH, TITLE_MAX_LENGTH);
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final String INVALID_DESCRIPTION_LENGTH = String.format(
            "Description must be between %d and %d symbols", DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH);


    private ArrayList<String> steps;
    private SeverityEnums severity;
    private BugStatusEnums status;
    private Member assignee;
    private PriorityEnums priority;


    public BugImpl(String title, int id, String description, ArrayList<String> steps, SeverityEnums severity, BugStatusEnums status, PriorityEnums priority) {
        super(title, id, description);
        this.steps = steps;
        this.severity = severity;
        this.status = status;
        this.priority = priority;
    }

    private void setTitle(String title) {
        ValidationHelpers.ValidateIntRange(title.length(), TITLE_MIN_LENGTH, TITLE_MAX_LENGTH, INVALID_TITLE_LENGTH);
        this.title = title;
    }

    private void setDescription(String description) {
        ValidationHelpers.ValidateIntRange(
                description.length(), DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH, INVALID_DESCRIPTION_LENGTH);
        this.description = description;
    }

    private void setAssignee(Member assignee) {
        this.assignee = assignee;
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

    //TODO
    @Override
    public String getAuthor() {
        return null;
    }

    //TODO
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