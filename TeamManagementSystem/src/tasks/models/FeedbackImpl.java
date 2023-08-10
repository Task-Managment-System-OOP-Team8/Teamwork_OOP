package tasks.models;

import tasks.Comment;
import tasks.contracts.Feedback;
import tasks.models.enums.StatusEnums;

import java.util.ArrayList;

public class  FeedbackImpl extends TaskImpl implements Feedback {

    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final String INVALID_DESCRIPTION_LENGTH = String.format(
            "Description must be between %d and %d symbols", DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH);
    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 50;
    public static final String INVALID_TITLE_LENGTH = String.format(
            "Title must be between %d and %d symbols", TITLE_MIN_LENGTH, TITLE_MAX_LENGTH);

    private int rating;
    private final StatusEnums status;




    public FeedbackImpl(String title, String description, int rating) {
        super(title,description);
       setRating(rating);
        this.status=StatusEnums.NEW;

    }

    private void setRating(int rating) {
        this.rating = rating;
    }
//TODO
    @Override
    public ArrayList<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public int getRating() {
        return rating;
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
}
