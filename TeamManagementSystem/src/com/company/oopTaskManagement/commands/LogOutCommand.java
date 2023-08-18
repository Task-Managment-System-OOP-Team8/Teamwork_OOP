package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;

import java.util.List;

public class LogOutCommand extends BaseCommand {
    public final static String USER_LOGGED_OUT = "You logged out!";

    public LogOutCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        getTaskManagementRepository().logout();
        return USER_LOGGED_OUT;
    }
}
