package commands;

import core.contracts.TaskManagementRepository;

import java.util.List;

public class ShowMembersHistoryCommand extends BaseCommand {


    protected ShowMembersHistoryCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return null;
    }
}