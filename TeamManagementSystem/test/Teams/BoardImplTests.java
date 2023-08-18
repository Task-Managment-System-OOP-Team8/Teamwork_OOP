package Teams;

import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.contracts.Comment;
import com.company.oopTaskManagement.tasks.contracts.Task;
import com.company.oopTaskManagement.tasks.models.FeedbackImpl;
import com.company.oopTaskManagement.tasks.models.TaskImpl;
import com.company.oopTaskManagement.teams.BoardImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardImplTests {

    @Test
    public void testConstructorValidName() {
        // Arrange
        String validName = "ValidName";

        // Act
        BoardImpl board = new BoardImpl(validName);

        // Assert
        Assertions.assertEquals(validName, board.getName());
        Assertions.assertTrue(board.getTasks().isEmpty());
        Assertions.assertTrue(board.getHistory().isEmpty());
    }

    @Test
    public void testConstructorEmptyName() {
        // Arrange
        String emptyName = "";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(emptyName));
    }

    @Test
    public void testConstructorNameTooShort() {
        // Arrange
        String shortName = "Sh";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(shortName));
    }

    @Test
    public void testConstructorNameTooLong() {
        // Arrange
        String longName = "VeryLongName";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> new BoardImpl(longName));
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
        Assertions.assertTrue(board.getTasks().contains(feedback1));
        Assertions.assertTrue(board.getTasks().contains(feedback2));
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
        Assertions.assertTrue(board.getTasks().isEmpty());
    }

    @Test
    public void testRemoveNonExistentTask() {
        // Arrange
        BoardImpl board = new BoardImpl("TestBoard");
        Task task = new FeedbackImpl("Tasdhashdashdhas", "djsajdjasdjasdja", 1);

        // Act and Assert
        assertDoesNotThrow(() -> board.removeTask(task));
        Assertions.assertFalse(board.getTasks().contains(task));
    }

    @Test
    public void testRemoveMultipleTasks() {
        // Arrange
        BoardImpl board = new BoardImpl("TestBoard");
        Task task1 = new FeedbackImpl("dasdasdasdasdas", "dsadasdasdasdasdasd", 1);
        Task task2 = new FeedbackImpl("dsadasdassada", "dsadasdasdasdasdassd", 2);
        board.addTask(task1);
        board.addTask(task2);

        // Act
        board.removeTask(task1);

        // Assert
        Assertions.assertFalse(board.getTasks().contains(task1));
        Assertions.assertTrue(board.getTasks().contains(task2));
        Assertions.assertEquals(1, board.getTasks().size());
    }

    @Test
    public void testAddActivity() {
        // Arrange
        BoardImpl board = new BoardImpl("TestBoard");
        History activity = new History("Activity 1");

        // Act
        board.addActivity(activity);

        // Assert
        Assertions.assertTrue(board.getHistory().contains(activity));
    }

    @Test
    public void testAddMultipleActivities() {
        // Arrange
        BoardImpl board = new BoardImpl("TestBoard");
        History activity1 = new History("Activity 1");
        History activity2 = new History("Activity 2");

        // Act
        board.addActivity(activity1);
        board.addActivity(activity2);

        // Assert
        Assertions.assertTrue(board.getHistory().contains(activity1));
        Assertions.assertTrue(board.getHistory().contains(activity2));
        Assertions.assertEquals(2, board.getHistory().size());
    }

}
