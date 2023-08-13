package commands;

import Utils.ValidationHelpers;
import commands.contracts.Command;
import core.contracts.TaskManagementRepository;
import tasks.Comment;
import tasks.contracts.Task;

import java.util.List;

public class AddCommentToTaskCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;


    private final TaskManagementRepository taskManagementRepository;

    public AddCommentToTaskCommand(TaskManagementRepository taskManagementRepository) {
        this.taskManagementRepository = taskManagementRepository;
    }


    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);

        String author = parameters.get(0);
        String comment = parameters.get(1);
        String task = parameters.get(2);

        Comment comment1 = taskManagementRepository.createComment(author,comment);
        Task task1 = taskManagementRepository.findTaskByName(task);



        return null;
    }
}
