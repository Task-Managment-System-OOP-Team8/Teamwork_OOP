package tasks.contracts;

import tasks.models.enums.StatusEnums;
import tasks.models.enums.SeverityEnums;

import java.util.ArrayList;


public interface Bug extends Assignable {
    ArrayList<String> getSteps();
    SeverityEnums getSeverity();

}
