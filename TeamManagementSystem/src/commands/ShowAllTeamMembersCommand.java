package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import teams.MemberImpl;
import teams.TeamImpl;

import java.util.List;

public class ShowAllTeamMembersCommand extends BaseCommand{
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    protected ShowAllTeamMembersCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String teamName = parameters.get(0);

        TeamImpl team = getTaskManagementRepository().findTeamByName(teamName);
        List<MemberImpl> teamMembers = team.getMembers();
        StringBuilder sb = new StringBuilder();
        for(MemberImpl member : teamMembers) {
            sb.append(member.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
