package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.contracts.Board;
import com.company.oopTaskManagement.teams.contracts.Team;
import java.util.List;

public class ShowAllTeamBoardsCommand extends BaseCommand{

    public static final String NO_BOARDS_AVAILABLE = "There are currently no boards available";
    public static final int EXPECTED_NUMBER_OF_PARAMETERS = 1;

    public ShowAllTeamBoardsCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    //todo- грешка в toString
    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_PARAMETERS);
        String teamName = parameters.get(0);

        Team team = getTaskManagementRepository().findTeamByName(teamName);
        List<Board> teamBoards = team.getBoards();
        StringBuilder sb = new StringBuilder();
        for (Board board : teamBoards) {
            sb.append(board.toString());
        }
        return sb.toString();
    }
}
