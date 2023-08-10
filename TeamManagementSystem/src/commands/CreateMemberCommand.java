package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import teams.MemberImpl;

import java.util.List;

public class CreateMemberCommand extends BaseCommand{

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final static String MEMBER_REGISTERED = "Member %s registered successfully!";
    protected CreateMemberCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String username = parameters.get(0);

        return registerUser(username);

    }

    private String registerUser(String username) {
        MemberImpl member = getTaskManagementRepository().createMember(username);
        getTaskManagementRepository().addMember(member);
        return String.format(MEMBER_REGISTERED, username);
    }
}
