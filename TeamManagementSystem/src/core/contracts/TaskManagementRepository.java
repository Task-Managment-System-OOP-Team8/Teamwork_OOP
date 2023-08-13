package core.contracts;

import tasks.Comment;
import tasks.History;
import tasks.contracts.Bug;
import tasks.contracts.Feedback;
import tasks.contracts.Story;
import tasks.models.BugImpl;
import tasks.models.FeedbackImpl;
import tasks.models.StoryImpl;
import tasks.models.TaskImpl;
import tasks.models.enums.*;
import teams.BoardImpl;
import teams.MemberImpl;
import teams.Teams;

import java.util.ArrayList;
import java.util.List;

public interface TaskManagementRepository {

    List<MemberImpl> getMembers();

    List<Teams> getTeams();

    List<BoardImpl> getBoards();

    List<History> getHistory();


    MemberImpl createMember(String name);

    Teams createTeam(String name);

    BoardImpl createBoard(String boardName);

    BugImpl createBug(String title, String description, PriorityEnums priority,
                      SeverityEnums severity, String assignee);  //?

    StoryImpl createStory(String title, String description, PriorityEnums priority, SizeEnums size, String assignee);  //?

    FeedbackImpl createFeedback(String title, String description, int rating);

    Comment createComment(String author, String message);

    MemberImpl addMember(MemberImpl memberToAdd);
    History addActivity(History activityToAdd);

    BoardImpl addBoard(BoardImpl boardName);

    BugImpl addBug(BugImpl bugTitle);

    StoryImpl addStory(StoryImpl storyTitle);

    Teams addTeam(Teams teamName);

    FeedbackImpl addFeedback(FeedbackImpl feedbackTitle);

    MemberImpl findMemberByUsername(String username);

    BoardImpl findBoardByName(String boardName);

    List<BugImpl> getBugs();

    List<StoryImpl> getStories ();

    List<FeedbackImpl> getFeedbacks();
    List<TaskImpl> getTasks();
    // History showAllHistory( ArrayList<String> history);


}


