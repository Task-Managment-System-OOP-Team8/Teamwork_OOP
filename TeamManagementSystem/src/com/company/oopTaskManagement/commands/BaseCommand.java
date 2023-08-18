package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.commands.contracts.Command;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import java.util.List;
public abstract class BaseCommand implements Command {
    private final static String USER_NOT_LOGGED = "You are not logged in! Please login first!";

  private TaskManagementRepository taskManagementRepository;

    protected BaseCommand(TaskManagementRepository taskManagementRepository) {
        this.taskManagementRepository = taskManagementRepository;
    }

    protected TaskManagementRepository getTaskManagementRepository() {
        return taskManagementRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        if (requiresLogin() && !taskManagementRepository.hasLoggedInUser()) {
            throw new IllegalArgumentException(USER_NOT_LOGGED);
        }
        return executeCommand(parameters);
    }
    protected abstract boolean requiresLogin();

    protected abstract String executeCommand(List<String> parameters);
}
