package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.commands.contracts.Command;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import java.util.List;
public abstract class BaseCommand implements Command {

  private TaskManagementRepository taskManagementRepository;

    protected BaseCommand(TaskManagementRepository taskManagementRepository) {
        this.taskManagementRepository = taskManagementRepository;
    }

    protected TaskManagementRepository getTaskManagementRepository() {
        return taskManagementRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        return executeCommand(parameters);
    }

    protected abstract String executeCommand(List<String> parameters);
}
