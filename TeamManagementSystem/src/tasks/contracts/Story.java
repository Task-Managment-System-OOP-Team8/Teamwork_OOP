package tasks.contracts;

import tasks.models.enums.SizeEnums;
import tasks.models.enums.StoryEnums;

public interface Story extends Assignable,Task {

    SizeEnums getSize();

    StoryEnums getStatus();

}
