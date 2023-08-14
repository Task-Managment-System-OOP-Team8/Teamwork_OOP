package tasks.contracts;

import tasks.models.enums.BugEnums;
import tasks.models.enums.SeverityEnums;

import java.util.ArrayList;


public interface Bug extends Assignable,Task {
    ArrayList<String> getSteps();
    SeverityEnums getSeverity();

    BugEnums getStatus();

}
