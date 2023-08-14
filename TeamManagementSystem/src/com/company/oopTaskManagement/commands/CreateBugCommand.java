package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ParsingHelpers;
import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.models.BugImpl;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;

import java.util.List;

public class CreateBugCommand extends BaseCommand {
    public static final String BUG_S_CREATED_SUCCESSFULLY = "Bug %s created successfully";
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;

    public CreateBugCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }
    @Override
    protected String executeCommand(List<String> parameters) {

        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String bugTitle = parameters.get(0);
        String description = parameters.get(1);
        PriorityEnums priority = ParsingHelpers.tryParseEnum(parameters.get(2), PriorityEnums.class);
        SeverityEnums severity = ParsingHelpers.tryParseEnum(parameters.get(3), SeverityEnums.class);
        String assignee = parameters.get(4);

        return createBug(bugTitle, description, priority, severity, assignee);
    }
    private String createBug(String bugTitle, String description, PriorityEnums priority,
                             SeverityEnums severity, String assignee) {
        BugImpl bug = getTaskManagementRepository().createBug(bugTitle, description, priority, severity, assignee);
        getTaskManagementRepository().addBug(bug);
        return String.format(BUG_S_CREATED_SUCCESSFULLY, bugTitle);
    }
}

