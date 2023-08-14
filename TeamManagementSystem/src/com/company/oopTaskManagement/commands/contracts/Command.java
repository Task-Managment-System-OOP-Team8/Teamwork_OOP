package com.company.oopTaskManagement.commands.contracts;

import java.util.List;

public interface Command {
    String execute(List<String> parameters);

}