package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;


import java.util.List;

public class AddMemberToTeamCommand extends BaseCommand {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    protected AddMemberToTeamCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String member = parameters.get(0);
        return addMemberToTeamCommand(member);
    }

    private String addMemberToTeamCommand(String member) {
        return member;


    }
}
