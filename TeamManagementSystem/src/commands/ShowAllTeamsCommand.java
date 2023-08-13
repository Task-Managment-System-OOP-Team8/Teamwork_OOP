package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import teams.TeamImpl;

import java.util.List;

public class ShowAllTeamsCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 0;
    public static final String THERE_IS_NO_REGISTERED_TEAMS = "There is no registered teams";

    public ShowAllTeamsCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return showTeamsCommand();
    }

    private String showTeamsCommand() {
        List<TeamImpl> teams = getTaskManagementRepository().getTeams();
        if (teams.isEmpty()) {
            throw new IllegalArgumentException(THERE_IS_NO_REGISTERED_TEAMS);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (TeamImpl team : teams) {
            stringBuilder.append(team.toString());
        }
        return stringBuilder.toString();
    }
}
