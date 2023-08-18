package models;

import com.company.oopTaskManagement.tasks.models.FeedbackImpl;
import com.company.oopTaskManagement.tasks.models.enums.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestUtilities;

public class FeedbackImplTests {

    private static final int TITLE_MIN_LENGTH = 10;
    private static final int TITLE_MAX_LENGTH = 50;

    private static final int DESCRIPTION_MIN_LENGTH = 10;
    private static final int DESCRIPTION_MAX_LENGTH = 500;

    private static final String VALID_TITLE = TestUtilities.getString(TITLE_MIN_LENGTH + 1);
    private static final String INVALID_TITLE = TestUtilities.getString(TITLE_MAX_LENGTH + 1);
    private static final String VALID_DESCRIPTION = TestUtilities.getString(DESCRIPTION_MIN_LENGTH + 1);

    private static final String INVALID_DESCRIPTION = TestUtilities.getString(DESCRIPTION_MAX_LENGTH + 1);

    @Test
    public void constructor_Should_InitializeTitle_When_ArgumentsAreValid() {
        Assertions.assertEquals(VALID_TITLE, getFeedback().getTitle());
    }

    @Test
    public void constructor_Should_InitializeDescription_When_ArgumentsAreValid() {
        Assertions.assertEquals(VALID_DESCRIPTION,getFeedback().getDescription());
    }


    @Test
    public void constructor_Should_InitializeStatus_When_ArgumentsAreValid() {
        Assertions.assertEquals(FeedbackEnums.NEW, getFeedback().getStatus());
    }

    @Test
    public void constructor_Should_InitializeRating_When_ArgumentsAreValid(){

        Assertions.assertEquals(1,getFeedback().getRating());
    }

    @Test
    public void constructor_Should_ThrowException_When_TitleIsInvalid() {
        Assertions.assertNotEquals(INVALID_TITLE, VALID_TITLE);
    }

    @Test
    public void constructor_Should_ThrowException_When_DescriptionIsInvalid() {
        Assertions.assertNotEquals(INVALID_DESCRIPTION, VALID_DESCRIPTION);
    }
    @Test
    public void constructor_Should_ThrowException_When_RatingIsInvalid(){
        Assertions.assertNotEquals(0,getFeedback().getRating());
    }


    private FeedbackImpl getFeedback() {
        return new FeedbackImpl(
                VALID_TITLE,VALID_DESCRIPTION,1);
    }
}
