package models;

import com.company.oopTaskManagement.tasks.models.StoryImpl;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import com.company.oopTaskManagement.tasks.models.enums.StoryEnums;
import utils.TestUtilities;

public class StoryImplTests {
    private static final int TITLE_MIN_LENGTH = 10;
    private static final int TITLE_MAX_LENGTH = 50;

    private static final int DESCRIPTION_MIN_LENGTH = 10;
    private static final int DESCRIPTION_MAX_LENGTH = 500;

    private static final String VALID_TITLE = TestUtilities.getString(TITLE_MIN_LENGTH + 1);
    private static final String INVALID_TITLE = TestUtilities.getString(TITLE_MAX_LENGTH + 1);
    private static final String VALID_DESCRIPTION = TestUtilities.getString(DESCRIPTION_MIN_LENGTH + 1);

    private static final String INVALID_DESCRIPTION = TestUtilities.getString(DESCRIPTION_MAX_LENGTH + 1);




    private StoryImpl getStory(){
        return new StoryImpl(
                VALID_TITLE,
                VALID_DESCRIPTION,
                PriorityEnums.HIGH,
                SizeEnums.LARGE,
                "Assignee"
        );
    }

}
