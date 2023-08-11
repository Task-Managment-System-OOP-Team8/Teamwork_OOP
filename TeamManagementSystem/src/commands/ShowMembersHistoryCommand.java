package commands;

import Utils.ListingHelpers;
import core.contracts.TaskManagementRepository;
import tasks.History;
import teams.MemberImpl;
import teams.Teams;

import java.util.ArrayList;
import java.util.List;

public class ShowMembersHistoryCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public static final String NO_ACTIVITY = "There is no registered activity";
    private static List<Teams> teamList;
    private static List<MemberImpl> membersList;


    protected ShowMembersHistoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
        teamList = taskManagementRepository.getTeams();
        membersList = taskManagementRepository.getMembers();


    }

    //TODO
    @Override
    protected String executeCommand(List<String> parameters) {

        return null;
    }

    private String showMembersHistory() {
        for (Teams team : teamList) {
            for (MemberImpl member : membersList) {

            }
        }
        return null;
    }
}
