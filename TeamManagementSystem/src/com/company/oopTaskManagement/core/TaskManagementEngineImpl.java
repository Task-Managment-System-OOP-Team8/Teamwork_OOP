package com.company.oopTaskManagement.core;

import com.company.oopTaskManagement.core.contracts.TaskManagementEngine;
import com.company.oopTaskManagement.commands.contracts.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskManagementEngineImpl implements TaskManagementEngine {


    private static final String EMPTY_COMMAND_ERROR = "Command cannot be empty.";
    private static final String TERMINATION_COMMAND = "Exit";
    private static final String COMMENT_OPEN_SYMBOL = "{{";
    private static final String MAIN_SPLIT_SYMBOL = " ";
    private static final String COMMENT_CLOSE_SYMBOL = "}}";
    private static final String REPORT_SEPARATOR = "==================" ;


    private final CommandFactoryImpl commandFactory;
    private final TaskManagementRepositoryImpl taskManagementRepository;
    public TaskManagementEngineImpl() {

        commandFactory = new CommandFactoryImpl();
        taskManagementRepository = new TaskManagementRepositoryImpl();

    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String inputLine = scanner.nextLine();
                if (inputLine.isBlank()) {
                    print(EMPTY_COMMAND_ERROR);
                    continue;
                }
                if (inputLine.equalsIgnoreCase(TERMINATION_COMMAND)) {
                    break;
                }
                processCommand(inputLine);
            } catch (Exception ex) {
                if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
                    print(ex.getMessage());
                } else {
                    print(ex.toString());
                }
            }
        }

    }

    private void processCommand(String inputLine) {
        String commandName = extractCommandName(inputLine);
        List<String> parameters = extractCommandParameters(inputLine);
        Command command = commandFactory.createCommandFromCommandName(commandName, taskManagementRepository);
        String executionResult = command.execute(parameters);
        print(executionResult);
    }

    private String extractCommandName(String inputLine) {
        return inputLine.split(" ")[0];
    }
    private List<String> extractCommandParameters(String inputLine) {
        if (inputLine.contains(COMMENT_OPEN_SYMBOL)) {
            return extractDescriptionParameters(inputLine);
        }
        String[] commandParts = inputLine.split(" ");
        List<String> parameters = new ArrayList<>();
        for (int i = 1; i < commandParts.length; i++) {
            parameters.add(commandParts[i]);
        }
        return parameters;
    }
    public List<String> extractDescriptionParameters(String fullCommand) {
        int indexOfFirstSeparator = fullCommand.indexOf(MAIN_SPLIT_SYMBOL);

        List<String> parameters = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{\\{(.+?)}}");
        Matcher matcher = pattern.matcher(fullCommand);

// Step 1: Extract content within "{{ }}" tags using regular expression
        while (matcher.find()) {
            parameters.add(matcher.group(1));
        }
// Step 2: Remove the extracted description parts from the fullCommand

        fullCommand = fullCommand.replaceAll("\\{\\{.+?}}", "");

// Step 3: Split the remaining string using MAIN_SPLIT_SYMBOL
        List<String> result = new ArrayList<>(Arrays.asList(fullCommand
                .substring(indexOfFirstSeparator + 1)
                .split(MAIN_SPLIT_SYMBOL)));

// Step 4: Remove empty, null, or whitespace elements from the result list
        result.removeAll(Arrays.asList(" ", "", null));

// Step 5: Combine the description parameters and the split result
        parameters.addAll(result);
        return parameters;
    }

    private void print(String result) {
        System.out.println(result);
        System.out.println(REPORT_SEPARATOR);
    }
}
