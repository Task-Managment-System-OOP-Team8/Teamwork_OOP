package com.company.oopTaskManagement.core.contracts;

import com.company.oopTaskManagement.commands.contracts.Command;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandTypeAsString, TaskManagementRepository taskManagementRepository);

}
