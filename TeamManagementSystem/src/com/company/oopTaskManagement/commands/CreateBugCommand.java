package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ParsingHelpers;
import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.contracts.Bug;
import com.company.oopTaskManagement.tasks.contracts.Task;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;
import com.company.oopTaskManagement.teams.MemberImpl;
import com.company.oopTaskManagement.teams.contracts.Board;
import com.company.oopTaskManagement.teams.contracts.Member;
import com.company.oopTaskManagement.teams.contracts.Team;

import java.util.Arrays;
import java.util.List;

public class CreateBugCommand extends BaseCommand {
    public static final String BUG_CREATED_SUCCESSFULLY ="Bug %s created successfully in %s";
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;

    public CreateBugCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }
    @Override
    protected boolean requiresLogin() {
        return true;
    }
    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        String bugTitle = parameters.get(2);
        String description = parameters.get(0);
        List<String> steps = Arrays.asList(parameters.get(1).split("; "));
        PriorityEnums priority = ParsingHelpers.tryParseEnum(parameters.get(3), PriorityEnums.class);
        SeverityEnums severity = ParsingHelpers.tryParseEnum(parameters.get(4), SeverityEnums.class);
        String assignee = parameters.get(5);

        return createBug(bugTitle, description, steps, priority, severity, assignee);
    }



 private String createBug(String bugTitle, String description, List<String> steps, PriorityEnums priority,
                           SeverityEnums severity, String assignee) {
       Bug bug = getTaskManagementRepository().createBug(bugTitle, description, steps.toString(), priority, severity, assignee);
       getTaskManagementRepository().addBug(bug);


        return String.format(BUG_CREATED_SUCCESSFULLY, bugTitle);
   }

}

