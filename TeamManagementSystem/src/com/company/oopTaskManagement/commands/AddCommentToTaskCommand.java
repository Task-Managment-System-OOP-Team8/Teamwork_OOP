package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.commands.contracts.Command;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.contracts.Comment;
import com.company.oopTaskManagement.tasks.contracts.Task;

import java.util.List;

public class AddCommentToTaskCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    public static final String ADD_COMMENT_TO_TASK_S = "Successfully add comment to task %s";
    public static final String THIS_COMMENT_ALREADY_EXIST = "This comment already exist!";


    private final TaskManagementRepository taskManagementRepository;

    public AddCommentToTaskCommand(TaskManagementRepository taskManagementRepository) {
        this.taskManagementRepository = taskManagementRepository;
    }


    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String content = parameters.get(0);
        String author = parameters.get(1);
        String task = parameters.get(2);

        return addComment(content, author, task);
    }
    private String addComment(String content,String author,String task){

        Comment comment1 = taskManagementRepository.createComment(content,author);
        Task task1 = taskManagementRepository.findTaskByName(task);

        if (task1.equals(comment1)){
            throw new IllegalArgumentException(THIS_COMMENT_ALREADY_EXIST);
        }else{
            task1.addComment(comment1);
        }

    //проверка дали автора е от отбора, ако не е хвърляме грешка

        return String.format(ADD_COMMENT_TO_TASK_S,task1);
    }
}
