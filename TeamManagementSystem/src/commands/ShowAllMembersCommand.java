package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import teams.MemberImpl;
import java.util.List;

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
        List<MemberImpl> members = getTaskManagementRepository().getMembers();
        if (members.isEmpty()) {
            throw new IllegalArgumentException(NO_REGISTERED_MEMBERS);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (MemberImpl member : members) {
            stringBuilder.append(member.toString());
        }
        return stringBuilder.toString();
    }
}
