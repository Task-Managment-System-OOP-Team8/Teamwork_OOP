package com.company.oopTaskManagement.tasks.contracts;

import com.company.oopTaskManagement.tasks.models.enums.BugEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;

import java.util.ArrayList;


public interface Bug extends Assignable,Task {
    ArrayList<String> getSteps();
    SeverityEnums getSeverity();

    BugEnums getStatus();

}
