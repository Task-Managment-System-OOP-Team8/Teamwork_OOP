package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.commands.contracts.Command;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.Comment;
import com.company.oopTaskManagement.tasks.contracts.Task;

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
