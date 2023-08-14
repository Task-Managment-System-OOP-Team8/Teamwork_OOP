package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.BoardImpl;

import java.util.List;

public class ShowAllTeamBoardsCommand extends BaseCommand{

    public static final String NO_BOARDS_AVAILABLE = "There are currently no boards available";
    public static final int EXPECTED_NUMBER_OF_PARAMETERS = 0;

    public ShowAllTeamBoardsCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_PARAMETERS);
        return showAllTeamBoardsCommand();
    }
    private String showAllTeamBoardsCommand() {
        List<BoardImpl> board = getTaskManagementRepository().getBoards();
        if (board.isEmpty()) {
            throw new IllegalArgumentException(NO_BOARDS_AVAILABLE);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (BoardImpl boards : board) {
            stringBuilder.append(boards.toString());
        }
        return stringBuilder.toString();
    }
}
