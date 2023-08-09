package tasks.models;

import Utils.ValidationHelpers;
import tasks.Comment;
import tasks.contracts.Story;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SizeEnums;
import tasks.models.enums.StatusEnums;

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

    private PriorityEnums priority;
    private SizeEnums size;
    private StatusEnums status;
    private String assignee;


    public StoryImpl(int id,String title, String description,PriorityEnums priority,SizeEnums size,String assignee) {
        super(id,title,description);
        this.priority=priority;
        this.size=size;
        this.status = StatusEnums.NOT_DONE;
       setAssignee(assignee);

    }

    protected void setDescription(String description) {
        ValidationHelpers.ValidateIntRange(description.length(), DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH, INVALID_DESCRIPTION_LENGTH);
        this.description = description;
    }
    //TODO
    private void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
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
    public StatusEnums getStatus() {
        return status;
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

    @Override
    public SizeEnums getSize() {
        return size;
    }
}
