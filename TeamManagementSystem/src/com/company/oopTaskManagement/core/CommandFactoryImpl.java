package com.company.oopTaskManagement.core;

import com.company.oopTaskManagement.Utils.ParsingHelpers;
import com.company.oopTaskManagement.commands.*;
import com.company.oopTaskManagement.commands.Enums.CommmandType;
import com.company.oopTaskManagement.commands.contracts.Command;
import com.company.oopTaskManagement.core.contracts.CommandFactory;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.commands.listing.ListBugCommand;
import com.company.oopTaskManagement.commands.listing.ListFeedbackCommand;
import com.company.oopTaskManagement.commands.listing.ListStoryCommand;
import com.company.oopTaskManagement.commands.listing.ListTaskCommand;


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
            case LISTBUG:
                return new ListBugCommand(taskManagementRepository);
            case LISTSTORIES:
                return new ListStoryCommand(taskManagementRepository);
            case LISTFEEDBACKS:
                return new ListFeedbackCommand(taskManagementRepository);
            case LISTTASKS:
                return new ListTaskCommand(taskManagementRepository);
            case ADDCOMMENTTOTASK:
                return new AddCommentToTaskCommand(taskManagementRepository);
            case SHOWALLMEMBERSTEAM:
                return new ShowAllTeamMembersCommand(taskManagementRepository);


            default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND,commmandType));

        }

    }
}
