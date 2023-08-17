package com.company.oopTaskManagement.commands.listing;

import com.company.oopTaskManagement.Utils.ListingHelpers;
import com.company.oopTaskManagement.commands.contracts.Command;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.contracts.Story;
import java.util.List;
//TODO
public class ListStoryCommand implements Command {

    public static final String NO_ADDED_STORIES = "There is no added stories.";
    private final List<Story> stories;

    public ListStoryCommand(TaskManagementRepository taskManagementRepository) {
        stories= taskManagementRepository.getStories();
    }


    @Override
    public String execute(List<String> parameters) {
        if (stories.isEmpty()){
            return NO_ADDED_STORIES;
        }
        return ListingHelpers.elements(stories);
    }
}
