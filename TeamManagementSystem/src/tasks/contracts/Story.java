package tasks.contracts;

import tasks.models.enums.SizeEnums;

public interface Story extends Assignable {

    SizeEnums getSize();

}
