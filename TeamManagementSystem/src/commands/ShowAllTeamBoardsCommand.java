package commands;

import core.contracts.TaskManagementRepository;
import teams.BoardImpl;

import java.util.List;

public class ShowAllTeamBoardsCommand extends BaseCommand{

    public static final String NO_BOARDS_AVAILABLE = "There are currently no boards available";

    protected ShowAllTeamBoardsCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return null;
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
