package tasks.contracts;

import tasks.models.enums.BugStatusEnums;
import tasks.models.enums.SeverityEnums;

import java.util.ArrayList;


public interface Bug extends Assignable {
    ArrayList<String> getSteps();
    SeverityEnums getSeverity();
    BugStatusEnums getBugStatus();

}
