package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.BoardImpl;
import com.company.oopTaskManagement.teams.contracts.Board;

import java.util.List;

public class CreateBoardCommand extends BaseCommand {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    public CreateBoardCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String boardName = parameters.get(0);

        return createBoard(boardName);
    }

    private String createBoard(String boardName) {
        Board board = getTaskManagementRepository().createBoard(boardName);
        getTaskManagementRepository().addBoard(board);
        return String.format("Board %s created successfully", boardName);
    }
}
