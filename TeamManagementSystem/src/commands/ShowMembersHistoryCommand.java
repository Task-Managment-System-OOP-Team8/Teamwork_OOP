package commands;

import core.contracts.TaskManagementRepository;
import teams.MemberImpl;

import java.util.ArrayList;
import java.util.List;

public class ShowMembersHistoryCommand extends BaseCommand {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 0;


    protected ShowMembersHistoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return null;
    }

    private String showMembersHistory(){


        return null;
    }
}
