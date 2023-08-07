package tasks.contracts;

import tasks.models.enums.PriorityEnums;
import teams.Member;

public interface Assignable {

    PriorityEnums getPriority();

   Member getMember();

}
