package com.company.oopTaskManagement.commands.listing;

import com.company.oopTaskManagement.Utils.ListingHelpers;
import com.company.oopTaskManagement.commands.contracts.Command;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.contracts.Bug;
import java.util.List;

public class ListBugCommand implements Command {

    public static final String NO_ADDED_BUGS = "There is no added bugs.";
    //TODO
    private final List<Bug> bugs;

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
