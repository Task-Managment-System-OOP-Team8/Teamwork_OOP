package models;

import com.company.oopTaskManagement.tasks.models.BugImpl;
import com.company.oopTaskManagement.tasks.models.enums.BugEnums;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class BugImplTests {
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
        BugImpl bug = getBug();
        Assertions.assertEquals(VALID_TITLE, bug.getTitle());
    }

    @Test
    public void constructor_Should_InitializeDescription_When_ArgumentsAreValid() {
        BugImpl bug = getBug();
        Assertions.assertEquals(VALID_DESCRIPTION, bug.getDescription());
    }

    @Test
    public void constructor_Should_Initialize_When_ListIsEmpty() {
        ArrayList<String> steps = getBug().getSteps();
        Assertions.assertNotNull(steps);
        Assertions.assertEquals(0, steps.size());
    }

    @Test
    public void constructor_Should_InitializePriority_When_ArgumentsAreValid() {
        Assertions.assertEquals(3, PriorityEnums.values().length);
        Assertions.assertEquals(PriorityEnums.HIGH, PriorityEnums.valueOf("HIGH"));
        Assertions.assertEquals(PriorityEnums.MEDIUM, PriorityEnums.valueOf("MEDIUM"));
        Assertions.assertEquals(PriorityEnums.LOW, PriorityEnums.valueOf("LOW"));
    }

    @Test
    public void constructor_Should_InitializeSeverity_When_ArgumentsAreValid() {
        Assertions.assertEquals(3, SeverityEnums.values().length);
        Assertions.assertEquals(SeverityEnums.CRITICAL, SeverityEnums.valueOf("CRITICAL"));
        Assertions.assertEquals(SeverityEnums.MINOR, SeverityEnums.valueOf("MINOR"));
        Assertions.assertEquals(SeverityEnums.MAJOR, SeverityEnums.valueOf("MAJOR"));

    }

    @Test
    public void constructor_Should_InitializeStatus_When_ArgumentsAreValid() {
        Assertions.assertEquals(2, BugEnums.values().length);
        Assertions.assertEquals(BugEnums.ACTIVE, BugEnums.valueOf("ACTIVE"));
        Assertions.assertEquals(BugEnums.FIXED, BugEnums.valueOf("FIXED"));
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
    public void constructor_Should_InitializeAssignee(){
        BugImpl bug = getBug();
        Assertions.assertEquals("Assignee",bug.getAssignee());
    }

    private BugImpl getBug() {
        return new BugImpl(
                VALID_TITLE,
                VALID_DESCRIPTION,
                Collections.singletonList("Steps"),
                PriorityEnums.HIGH,
                SeverityEnums.MAJOR,
                "Assignee");
    }

}
