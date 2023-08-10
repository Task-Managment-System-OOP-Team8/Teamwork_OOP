package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import teams.BoardImpl;
import java.util.List;

public class CreateBoardCommand extends BaseCommand {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

    protected CreateBoardCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String boardName = parameters.get(0);

        return createBoard(boardName);
    }



    private String createBoard(String boardName) {
        BoardImpl board = getTaskManagementRepository().createBoard(boardName);
        getTaskManagementRepository().addBoard(board);
        return String.format("Board %s created successfully", boardName);
    }
}
