package commands;

import Utils.ParsingHelpers;
import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import tasks.models.StoryImpl;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SeverityEnums;
import tasks.models.enums.SizeEnums;

import java.util.List;

public class CreateStoryCommand extends BaseCommand {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    protected CreateStoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {

        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String storyTitle = parameters.get(0);
        String description = parameters.get(1);
        PriorityEnums priority = ParsingHelpers.tryParseEnum(parameters.get(2), PriorityEnums.class);
        SizeEnums size = ParsingHelpers.tryParseEnum(parameters.get(3), SizeEnums.class);
        String assignee = parameters.get(4);

        return createStory(storyTitle, description, priority, size, assignee);
    }

    private String createStory(String title, String description, PriorityEnums priority, SizeEnums size, String assignee) {
        StoryImpl story = getTaskManagementRepository().createStory(title, description, priority, size, assignee);
        getTaskManagementRepository().addStory(story);
        return String.format("Story %s created successfully", title);
    }
}
