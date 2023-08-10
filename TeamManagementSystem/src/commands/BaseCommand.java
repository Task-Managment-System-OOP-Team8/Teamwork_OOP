package commands;

import commands.contracts.Command;
import core.TaskManagementRepositoryImpl;
import core.contracts.TaskManagementRepository;

import java.util.List;

public abstract class BaseCommand implements Command {

  private final TaskManagementRepository taskManagementRepository;


    protected BaseCommand(TaskManagementRepository taskManagementRepository) {
        this.taskManagementRepository = taskManagementRepository;
    }

    public TaskManagementRepository getTaskManagementRepository() {
        return taskManagementRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        return executeCommand(parameters);
    }

    protected abstract String executeCommand(List<String> parameters);
}
