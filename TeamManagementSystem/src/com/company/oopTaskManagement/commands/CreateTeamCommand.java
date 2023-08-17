package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.contracts.Team;
import java.util.List;

public class CreateTeamCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    private final static String TEAM_REGISTERED = "Team %s registered successfully!";

    public CreateTeamCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String teamName = parameters.get(0);
        return registerTeam(teamName);
    }
    private String registerTeam(String teamName) {
        Team teams = getTaskManagementRepository().createTeam(teamName);
        return String.format(TEAM_REGISTERED, teams);
    }
}
