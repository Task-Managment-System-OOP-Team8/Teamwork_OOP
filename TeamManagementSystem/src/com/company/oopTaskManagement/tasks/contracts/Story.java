package com.company.oopTaskManagement.tasks.contracts;

import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import com.company.oopTaskManagement.tasks.models.enums.StoryEnums;

public interface Story extends Assignable,Task {

    SizeEnums getSize();

    StoryEnums getStatus();

}
