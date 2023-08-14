package com.company.oopTaskManagement.commands.listing;

import com.company.oopTaskManagement.Utils.ListingHelpers;
import com.company.oopTaskManagement.commands.contracts.Command;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.models.TaskImpl;

import java.util.List;
//TODO
public class ListTaskCommand implements Command {

    public static final String NO_TASKS_AVAILABLE = "There are no tasks available.";
    private final List<TaskImpl> tasks;

    public ListTaskCommand(TaskManagementRepository taskManagementRepository) {
       tasks = taskManagementRepository.getTasks();
    }




    @Override
    public String execute(List<String> parameters) {
        if (tasks.isEmpty()){
            return NO_TASKS_AVAILABLE;
        }
        return ListingHelpers.elements(tasks);
    }
}
