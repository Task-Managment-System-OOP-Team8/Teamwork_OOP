package com.company.oopTaskManagement.core.contracts;

import com.company.oopTaskManagement.tasks.CommentImpl;
import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.models.BugImpl;
import com.company.oopTaskManagement.tasks.models.FeedbackImpl;
import com.company.oopTaskManagement.tasks.models.StoryImpl;
import com.company.oopTaskManagement.tasks.models.TaskImpl;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;

import com.company.oopTaskManagement.teams.BoardImpl;
import com.company.oopTaskManagement.teams.MemberImpl;
import com.company.oopTaskManagement.teams.TeamImpl;

import java.util.List;

public interface TaskManagementRepository {

    List<MemberImpl> getMembers();

    List<TeamImpl> getTeams();

    List<BoardImpl> getBoards();

    List<History> getHistory();


    MemberImpl createMember(String name);

    TeamImpl createTeam(String name);

    BoardImpl createBoard(String boardName);

    BugImpl createBug(String title, String description,List<String> steps, PriorityEnums priority,
                      SeverityEnums severity, String assignee);  //?

    StoryImpl createStory(String title, String description, PriorityEnums priority, SizeEnums size, String assignee);  //?

    FeedbackImpl createFeedback(String title, String description, int rating);

    CommentImpl createComment(String author, String message);

    MemberImpl addMember(MemberImpl memberToAdd);
    History addActivity(History activityToAdd);

    BoardImpl addBoard(BoardImpl boardName);

    BugImpl addBug(BugImpl bugTitle);

    StoryImpl addStory(StoryImpl storyTitle);

    TeamImpl addTeam(TeamImpl teamName);

    FeedbackImpl addFeedback(FeedbackImpl feedbackTitle);

    MemberImpl findMemberByUsername(String username);

    BoardImpl findBoardByName(String boardName);

    List<BugImpl> getBugs();

    List<StoryImpl> getStories ();

    List<FeedbackImpl> getFeedbacks();
    List<TaskImpl> getTasks();

   TaskImpl findTaskByName(String taskName);

   TeamImpl findTeamByName(String teamName);




    // History showAllHistory( ArrayList<String> history);


}


