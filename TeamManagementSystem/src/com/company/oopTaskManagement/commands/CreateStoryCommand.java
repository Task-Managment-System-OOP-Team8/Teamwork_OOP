package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ParsingHelpers;
import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.contracts.Story;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import java.util.List;

public class CreateStoryCommand extends BaseCommand {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    public CreateStoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }

    @Override
    protected String executeCommand(List<String> parameters) {

        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String storyTitle = parameters.get(1);
        String description = parameters.get(0);
        PriorityEnums priority = ParsingHelpers.tryParseEnum(parameters.get(2), PriorityEnums.class);
        SizeEnums size = ParsingHelpers.tryParseEnum(parameters.get(3), SizeEnums.class);
        String assignee = parameters.get(4);

        return createStory(storyTitle, description, priority, size, assignee);
    }

    private String createStory(String title, String description, PriorityEnums priority, SizeEnums size, String assignee) {
        Story story = getTaskManagementRepository().createStory(title, description, priority, size, assignee);
        getTaskManagementRepository().addStory(story);
        return String.format("Story %s created successfully", title);
    }
}
