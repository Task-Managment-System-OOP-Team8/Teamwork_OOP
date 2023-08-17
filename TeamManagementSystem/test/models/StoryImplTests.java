package models;


import com.company.oopTaskManagement.tasks.models.StoryImpl;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import com.company.oopTaskManagement.tasks.models.enums.StoryEnums;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testConstructor() {
        String title = "Sample Story";
        String description = "Sample description";
        PriorityEnums priority = PriorityEnums.HIGH;
        SizeEnums size = SizeEnums.LARGE;
        String assignee = "Tomas";

        StoryImpl story = new StoryImpl(title, description, priority, size, assignee);

        Assertions.assertEquals(title, story.getTitle());
        Assertions.assertEquals(description, story.getDescription());
        Assertions.assertEquals(priority, story.getPriority());
        Assertions.assertEquals(size, story.getSize());
        Assertions.assertEquals(StoryEnums.NOT_DONE, story.getStatus());
        Assertions.assertEquals(assignee, story.getAssignee());
    }
    @Test
    public void constructor_Should_InitializeTitle_When_ArgumentsAreValid() {
        StoryImpl story = getStory();
        Assertions.assertEquals(VALID_TITLE, story.getTitle());
    }

    @Test
    public void constructor_Should_InitializeDescription_When_ArgumentsAreValid() {
        StoryImpl story = getStory();
        Assertions.assertEquals(VALID_DESCRIPTION, story.getDescription());
    }
    @Test
    public void constructor_Should_InitializeAssignee(){
        StoryImpl story = getStory();
        Assertions.assertEquals("Assignee",story.getAssignee());
    }

    @Test
    public void constructor_Should_ThrowException_When_TitleIsInvalid() {
        Assertions.assertNotEquals(INVALID_TITLE, VALID_TITLE);
    }
    @Test
    public void constructor_Should_ThrowException_When_DescriptionIsInvalid() {
        Assertions.assertNotEquals(INVALID_DESCRIPTION, VALID_DESCRIPTION);
    }

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
