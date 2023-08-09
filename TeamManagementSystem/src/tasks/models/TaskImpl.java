package tasks.models;

import Utils.ValidationHelpers;
import tasks.Comment;
import tasks.History;
import tasks.contracts.Task;
import tasks.models.enums.StatusEnums;

import java.util.ArrayList;

public abstract class TaskImpl implements Task {
    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 50;
    public static final String INVALID_TITLE = String.format(
            "Title must be between %d and %d symbols", TITLE_MIN_LENGTH, TITLE_MAX_LENGTH);
    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final String INVALID_DESCRIPTION = String.format(
            "Description must be between %d and %d symbols", DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH);
    protected String title;
    private final int id;
    protected String description;
    protected ArrayList<Comment> comments;
    protected ArrayList<History> history;

    private StatusEnums status;

//TODO
    public TaskImpl(int id,String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.comments = new ArrayList<>();
        this.history = new ArrayList<>();

    }

    private void setTitle(String title) {
        ValidationHelpers.ValidateIntRange(title.length(), TITLE_MIN_LENGTH, TITLE_MAX_LENGTH, INVALID_TITLE);
        this.title = title;
    }

    private void setStatus(StatusEnums status) {
        this.status = status;
    }

    public abstract StatusEnums getStatus();

    @Override
    public abstract String getAuthor();

    public void addComment(String author, String message) {
        comments.add(new Comment(author, message));
    }

    public void addHistoryEntry(History input) {
        history.add(input);
    }

    @Override
    public abstract String getTitle();

    @Override
    public abstract String getDescription();

    @Override
    public int getId() {
        return this.id;
    }

    public void displayHistory() {
        for (History log : history) {
            System.out.println(log.viewInfo());
        }
    }
}
