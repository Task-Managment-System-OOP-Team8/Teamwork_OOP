package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.contracts.Member;

import java.util.List;

public class LogInCommand extends BaseCommand {
    private final static String USER_LOGGED_IN = "User %s successfully logged in!";
    private final static String WRONG_USERNAME = "Wrong username!";
    public final static String USER_LOGGED_IN_ALREADY = "User %s is logged in! Please log out first!";

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    public LogInCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        throwIfUserLoggedIn();
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String username = parameters.get(0);

        return login(username);
    }

    private void throwIfUserLoggedIn() {
        if (getTaskManagementRepository().hasLoggedInUser()) {
            throw new IllegalArgumentException(
                    String.format(USER_LOGGED_IN_ALREADY, getTaskManagementRepository().getLoggedInUser().getName())
            );
        }
    }


    private String login(String username) {
        Member memberByUsername = getTaskManagementRepository().findMemberByUsername(username);

        if (!memberByUsername.getName().equals(username)) {
            getTaskManagementRepository().login(memberByUsername);
            throw new IllegalArgumentException(WRONG_USERNAME);

        }
        return String.format(USER_LOGGED_IN, username);

    }

}

