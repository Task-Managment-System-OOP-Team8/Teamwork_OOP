package com.company.oopTaskManagement.tasks.contracts;

import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;

public interface Assignable {
    PriorityEnums getPriority();

String getAssignee();


}
