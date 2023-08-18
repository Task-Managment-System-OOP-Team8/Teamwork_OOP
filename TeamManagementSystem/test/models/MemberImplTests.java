package models;

import com.company.oopTaskManagement.teams.MemberImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestUtilities;

public class MemberImplTests {
    public static final int MEMBER_NAME_MAX_LENGTH = 15;
    public static final int MEMBER_NAME_MIN_LENGTH = 5;

    public static final String VALID_NAME = TestUtilities.getString(MEMBER_NAME_MIN_LENGTH);
    public static final String INVALID_NAME = TestUtilities.getString(MEMBER_NAME_MAX_LENGTH+1);
    @Test
    public void constructor_Should_Initialize_When_NameIsValid(){
        Assertions.assertEquals(VALID_NAME,getMember().getName());
    }
    @Test
    public void constructor_Should_Initialize_When_NameIsInvalid(){
        Assertions.assertNotEquals(INVALID_NAME,VALID_NAME);
    }




    private MemberImpl getMember(){
        return new MemberImpl(VALID_NAME);
    }
}
