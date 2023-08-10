package commands;

import core.contracts.TaskManagementRepository;

import java.util.List;

public class ShowAllMembers extends BaseCommand {
    protected ShowAllMembers(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    public String execute(List<String> parameters) {
        return null;
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        return null;
    }
}
