package tasks.models;

import tasks.Comment;
import tasks.contracts.Commentable;
import tasks.contracts.Task;
import tasks.models.enums.PriorityEnums;
import teams.Member;

import java.util.ArrayList;

public abstract class TaskImpl implements Task {

    protected String title;
    protected int id;
    protected String description;
    protected ArrayList<Comment> comments;
    protected ArrayList<String> history;

    protected Member assignee;

//TODO

//    public TaskImpl(String title, int id, String description, Member assignee) {
//        this.title = title;
//        this.id = id;
//        this.description = description;
//        this.assignee = assignee;
//        this.comments = new ArrayList<>();
//        this.history = new ArrayList<>();
//    }
    public abstract Member getMember() ;


    @Override
    public abstract String getAuthor() ;

 //   @Override
   // public abstract ArrayList<Commentable> getComments() ;

    @Override
    public abstract String getTitle() ;

    @Override
    public abstract String getDescription() ;
    @Override
    public  int getId() {
        return this.id;
    }
}
