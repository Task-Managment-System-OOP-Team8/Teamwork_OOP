package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.BoardImpl;

import java.util.List;

public class ShowBoardsActivityCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public static final String NO_VALID_BOARD_NAME = "There is no board with name %s";

    public ShowBoardsActivityCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }
    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters,EXPECTED_NUMBER_OF_ARGUMENTS);
        String boardName = parameters.get(0);
        BoardImpl board = getTaskManagementRepository().findBoardByName(boardName);
        if (board.getName().isEmpty()){
            return String.format(NO_VALID_BOARD_NAME,board.getName());
        }
        return board.getHistory().stream().toList().toString();
    }
}
