package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.MemberImpl;
import com.company.oopTaskManagement.teams.contracts.Member;

import java.util.List;
import java.util.stream.Collectors;

public class ShowAllMembersCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_PARAMETERS = 0;
    public static final String NO_REGISTERED_MEMBERS = "There are no registered members";

    public ShowAllMembersCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_PARAMETERS);
        return showAllMembersCommand();
    }

    public String showAllMembersCommand() {
        List<Member> members = getTaskManagementRepository().getMembers();
        if (members.isEmpty()) {
            throw new IllegalArgumentException(NO_REGISTERED_MEMBERS);
        }

        return members.stream()
                .map(Member::toString)
                .collect(Collectors.joining());
    }
}
