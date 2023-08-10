package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import teams.MemberImpl;
import java.util.List;

public class ShowAllMembersCommand extends BaseCommand {
    public static final String THERE_IS_NO_REGISTERED_MEMBERS = "There is no registered members";
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 0;

    protected ShowAllMembersCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        return showMembersCommand();
    }

    private String showMembersCommand() {
        List<MemberImpl> members = getTaskManagementRepository().getMembers();
        if (members.isEmpty()) {
            throw new IllegalArgumentException(THERE_IS_NO_REGISTERED_MEMBERS);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (MemberImpl member : members) {
            stringBuilder.append(member.toString());
        }
        return stringBuilder.toString();
    }
}
