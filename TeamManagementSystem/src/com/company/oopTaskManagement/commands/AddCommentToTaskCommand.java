package commands;

import Utils.ValidationHelpers;
import commands.contracts.Command;
import core.contracts.TaskManagementRepository;
import tasks.Comment;
import tasks.contracts.Task;
import tasks.models.TaskImpl;

import java.util.List;

public class AddCommentToTaskCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    public static final String A_COMMENT_HAS_BEEN_ADDED_TO_THE_LIST_OF_COMMENTS = "A comment has been added to the list of comments";


    private final TaskManagementRepository taskManagementRepository;

    public AddCommentToTaskCommand(TaskManagementRepository taskManagementRepository) {
        this.taskManagementRepository = taskManagementRepository;
    }

//TODO
    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);

        String author = parameters.get(0);
        String comment = parameters.get(1);
        String task = parameters.get(2);

        TaskImpl task1 = taskManagementRepository.findTaskByName(task);
        task1.addComment(author, comment);

        return A_COMMENT_HAS_BEEN_ADDED_TO_THE_LIST_OF_COMMENTS;
    }
}
