package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.contracts.Member;
import java.util.List;

public class CreateMemberCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final static String MEMBER_REGISTERED = "Member %s registered successfully!";
    public CreateMemberCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    public String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String username = parameters.get(0);

        return registerUser(username);

    }
    private String registerUser(String username) {
        Member member = getTaskManagementRepository().createMember(username);
        getTaskManagementRepository().addMember(member);
        return String.format(MEMBER_REGISTERED, username);
    }
}
