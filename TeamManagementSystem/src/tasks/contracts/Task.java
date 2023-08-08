package tasks.contracts;

public interface Task extends Commentable {
    String getTitle();
    String getDescription();
    int getId();


}
