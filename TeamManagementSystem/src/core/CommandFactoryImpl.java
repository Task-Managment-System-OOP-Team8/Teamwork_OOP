package core;

import Utils.ParsingHelpers;
import commands.CreateBugCommand;
import commands.Enums.CommmandType;
import commands.contracts.Command;
import core.contracts.CommandFactory;
import core.contracts.TaskManagementRepository;


public class CommandFactoryImpl implements CommandFactory {
    private static final String INVALID_COMMAND = "Invalid command name: %s!";
    @Override
    public Command createCommandFromCommandName(
            String commandTypeAsString, TaskManagementRepository taskManagementRepository) {
        CommmandType commmandType = ParsingHelpers.tryParseEnum(
                commandTypeAsString, CommmandType.class);
        switch (commmandType) {
            case CREATEBUG:
                return new CreateBugCommand(taskManagementRepository);

        }
        return null;
    }
}
