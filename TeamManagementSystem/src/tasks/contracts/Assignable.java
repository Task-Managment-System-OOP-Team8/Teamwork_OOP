package tasks.contracts;

import tasks.models.enums.PriorityEnums;

public interface Assignable {

    PriorityEnums getPriority();

String getAssignee();


}
