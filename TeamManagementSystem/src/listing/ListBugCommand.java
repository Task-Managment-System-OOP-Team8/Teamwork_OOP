package listing;

import Utils.ListingHelpers;
import commands.contracts.Command;
import core.contracts.TaskManagementRepository;
import tasks.models.BugImpl;

import java.util.List;

public class ListBugCommand implements Command {

    public static final String NO_ADDED_BUGS = "There is no added bugs.";
    //TODO
    private final List<BugImpl> bugs;

    public ListBugCommand(TaskManagementRepository taskManagementRepository) {
      bugs = taskManagementRepository.getBugs();
    }

    @Override
    public String execute(List<String> parameters) {
        if (bugs.isEmpty()){
            return NO_ADDED_BUGS;
        }
        return ListingHelpers.elements(bugs);
    }
}
