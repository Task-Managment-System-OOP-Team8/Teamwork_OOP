package core;

import Utils.ParsingHelpers;
import commands.*;
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
            case SHOWBOARDSACTIVITY:
                return new ShowBoardsActivityCommand(taskManagementRepository);
            case CREATEANEWBOARD:
                return new CreateBoardCommand(taskManagementRepository);
            case CREATEFEEDBACK:
                return new CreateFeedbackCommand(taskManagementRepository);
            case CREATEMEMBER:
                return new CreateMemberCommand(taskManagementRepository);
            case CREATESTORY:
                return new CreateStoryCommand(taskManagementRepository);
            case CREATETEAM:
                return new CreateTeamCommand(taskManagementRepository);
            case SHOWMEMBERSACTIVITY:
                return new ShowMemberActivityCommand(taskManagementRepository);
            case SHOWALLTEAMS:
                return new ShowAllTeamsCommand(taskManagementRepository);
            case ADDMEMBERTOTEAM:
                return new AddMemberToTeamCommand(taskManagementRepository);
            case SHOWALLTEAMBOARDS:
                return new ShowAllTeamBoardsCommand(taskManagementRepository);
            case SHOWALLMEMBERS:
                return new ShowAllMembersCommand(taskManagementRepository);
            default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND,commmandType));

        }

    }
}
