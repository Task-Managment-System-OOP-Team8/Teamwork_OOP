package Teams;

import com.company.oopTaskManagement.teams.MemberImpl;
import com.company.oopTaskManagement.teams.TeamImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamImplTests {

    public static final String VALID_TITLE = "aaaaaa";
    public static final String INVALID_TITLE_TOO_SHORT = "aaa";
    public static final String INVALID_TITLE_TOO_LONG = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    @Test
    void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        String validName = "aaaaaaa";
        TeamImpl team = new TeamImpl(validName);
        Assertions.assertEquals(validName, team.getName());
    }
    @Test
    void constructor_Should_ThrowException_When_NameLengthIsTooShort() {
        TeamImpl team = validTeam();
        Assertions.assertThrows(IllegalArgumentException.class, () -> new TeamImpl(INVALID_TITLE_TOO_SHORT));
    }
    @Test
    void constructor_Should_ThrowException_When_NameLengthIsTooLong() {
        TeamImpl team = validTeam();
        Assertions.assertThrows(IllegalArgumentException.class, () -> new TeamImpl(INVALID_TITLE_TOO_LONG));
    }
    @Test
    void members_Should_beAddedToTeam_When_ArgumentsAreValid() {
        TeamImpl team = validTeam();
        MemberImpl member = new MemberImpl("Lenko");
        team.addMembers(member);
        Assertions.assertEquals(1,team.getMembers().size());
    }
//    @Test
//    void members_Should_beAddedToTeam_When_ArgumentsAreInvalid() {
//        TeamImpl team = validTeam();
//        MemberImpl member = new MemberImpl("Leni");
//        team.addMembers(member);
//        Assertions.assertEquals(0,team.getMembers().size());
//    }
//
//    @Test
//    void getBoards() {
//    }
//
//    @Test
//    void addMembers() {
//    }
//
//    @Test
//    void addBoard() {
//    }

    private TeamImpl validTeam() {
        return new TeamImpl(VALID_TITLE);
    }
}
