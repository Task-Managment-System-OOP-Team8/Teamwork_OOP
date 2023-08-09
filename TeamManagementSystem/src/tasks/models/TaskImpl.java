package tasks.models;

import tasks.Comment;
import tasks.contracts.Task;
import java.util.ArrayList;
public abstract class TaskImpl implements Task {
    protected String title;
    protected int id;
    protected String description;
    protected ArrayList<Comment> comments;
    protected ArrayList<String> history;



//TODO

    public TaskImpl( int id,String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.comments = new ArrayList<>();
        this.history = new ArrayList<>();
    }


    @Override
    public abstract String getAuthor() ;

    public void addComment (String author, String message) {
        comments.add(new Comment(author, message));
    }

    public void addHistoryEntry (String input) {
        history.add(input);
    }

    @Override
    public abstract String getTitle() ;

    @Override
    public abstract String getDescription() ;
    @Override
    public  int getId() {
        return this.id;
    }
}
