package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.BoardImpl;

import java.util.List;

public class ShowAllTeamBoardsCommand extends BaseCommand{

    public static final String NO_BOARDS_AVAILABLE = "There are currently no boards available";
    public static final int EXPECTED_NUMBER_OF_PARAMETERS = 1;

    public ShowAllTeamBoardsCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_PARAMETERS);
        String teamName = parameters.get(0);

        TeamImpl team = getTaskManagementRepository().findTeamByName(teamName);
        List<BoardImpl> teamBoards = team.getBoards();
        StringBuilder sb = new StringBuilder();
        for (BoardImpl board : teamBoards) {
            sb.append(board.toString());
        }
        return sb.toString();
    }
}
