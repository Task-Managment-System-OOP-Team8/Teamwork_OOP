package Teams;

import com.company.oopTaskManagement.tasks.contracts.Task;
import com.company.oopTaskManagement.tasks.models.FeedbackImpl;
import com.company.oopTaskManagement.teams.BoardImpl;
import com.company.oopTaskManagement.teams.MemberImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberImplTests {
    @Test
    public void testConstructorValidName() {
        // Arrange
        String validName = "ValidMemberName";

        // Act
        MemberImpl member = new MemberImpl(validName);

        // Assert
        Assertions.assertEquals(validName, member.getName());
    }

    @Test
    public void testConstructorEmptyName() {
        // Arrange
        String emptyName = "";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new MemberImpl(emptyName));
    }

    @Test
    public void testConstructorNameTooShort() {
        // Arrange
        String shortName = "Sh";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new MemberImpl(shortName));
    }

    @Test
    public void testConstructorNameTooLong() {
        // Arrange
        String longName = "VeryLongMemberName123";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new MemberImpl(longName));
    }

    @Test
    public void testAddTask() {
        // Arrange
        BoardImpl board = new BoardImpl("TestBoard");
        FeedbackImpl feedback = new FeedbackImpl("sadasdfasdas", "fsfsdfsdfsdfsdfsdfsd", 1);

        // Act
        board.addTask(feedback);

        // Assert
        Assertions.assertTrue(board.getTasks().contains(feedback));
    }

    @Test
    public void testAddMultipleTasks() {
        // Arrange
        BoardImpl board = new BoardImpl("TestBoard");
        Task feedback1 = new FeedbackImpl("dfdsfwedasdasd", "fwfwefewfwefwefwe", 1);
        Task feedback2 = new FeedbackImpl("rewrdwedasdasda", "fjhdshfhsdfd", 2);

        // Act
        board.addTask(feedback1);
        board.addTask(feedback2);

        // Assert
        Assertions.assertEquals(2, board.getTasks().size());
    }

    @Test
    public void testRemoveTask() {
        // Arrange
        BoardImpl board = new BoardImpl("TestBoard");
        Task task = new FeedbackImpl("dadasdasdasd", "dsadasdasdasdas", 1);
        board.addTask(task);

        // Act
        board.removeTask(task);

        // Assert
        Assertions.assertFalse(board.getTasks().contains(task));
    }

    @Test
    public void testRemoveNonExistentTask() {
        // Arrange
        BoardImpl board = new BoardImpl("TestBoard");
        Task task = new FeedbackImpl("Tasdhashdashdhas", "djsajdjasdjasdja", 1);

        // Act and Assert
        Assertions.assertFalse(board.getTasks().contains(task));
    }
}
