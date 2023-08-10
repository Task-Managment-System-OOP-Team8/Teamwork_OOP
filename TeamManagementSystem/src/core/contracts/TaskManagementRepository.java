package core.contracts;

import tasks.Comment;
import tasks.contracts.Bug;
import tasks.contracts.Feedback;
import tasks.contracts.Story;
import tasks.models.BugImpl;
import tasks.models.FeedbackImpl;
import tasks.models.StoryImpl;
import tasks.models.enums.*;
import teams.BoardImpl;
import teams.MemberImpl;
import teams.Teams;

import java.util.List;

public interface TaskManagementRepository {

    List<MemberImpl> getMembers();


    MemberImpl createMember(String name);

    Teams createTeam(String name);

    BoardImpl createBoard(String boardName);

    BugImpl createBug(String title, String description, PriorityEnums priority,
                      SeverityEnums severity, String assignee);  //?

    StoryImpl createStory(String title, String description, PriorityEnums priority, SizeEnums size, String assignee);  //?

    FeedbackImpl createFeedback(String title, String description, int rating);

    Comment createComment(String author, String message);

    MemberImpl addMember(MemberImpl memberToAdd);

    BoardImpl addBoard(BoardImpl boardName);

    BugImpl addBug(BugImpl bugTitle);

    StoryImpl addStory(StoryImpl storyTitle);

    Teams addTeam(Teams teamName);


    // History showAllHistory( ArrayList<String> history);


}


