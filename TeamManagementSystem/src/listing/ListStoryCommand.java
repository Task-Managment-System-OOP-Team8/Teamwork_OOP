package listing;

import Utils.ListingHelpers;
import commands.contracts.Command;
import core.contracts.TaskManagementRepository;
import tasks.models.StoryImpl;

import java.util.List;
//TODO
public class ListStoryCommand implements Command {

    public static final String NO_ADDED_STORIES = "There is no added stories.";
    private final List<StoryImpl> stories;

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
