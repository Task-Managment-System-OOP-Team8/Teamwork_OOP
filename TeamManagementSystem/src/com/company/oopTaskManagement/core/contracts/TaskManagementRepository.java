package com.company.oopTaskManagement.core.contracts;

import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.contracts.*;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import com.company.oopTaskManagement.teams.contracts.Board;
import com.company.oopTaskManagement.teams.contracts.Member;
import com.company.oopTaskManagement.teams.contracts.Team;
import java.util.List;

public interface TaskManagementRepository {

    List<Member> getMembers();

    List<Team> getTeams();

    List<Board> getBoards();

    List<History> getHistory();


    Member createMember(String name);

    Team createTeam(String name);

    Board createBoard(String boardName);

    Bug createBug(String title, String description,List<String> steps, PriorityEnums priority,
                      SeverityEnums severity, String assignee);

    Story createStory(String title, String description, PriorityEnums priority, SizeEnums size, String assignee);  //?

    Feedback createFeedback(String title, String description, int rating);

    Comment createComment(String author, String message);

    Member addMember(Member memberToAdd);
    History addActivity(History activityToAdd);

    Board addBoard(Board boardName);

    Bug addBug(Bug bugTitle);

    Story addStory(Story storyTitle);

    Team addTeam(Team teamName);

    Feedback addFeedback(Feedback feedbackTitle);

    Member findMemberByUsername(String username);

    Board findBoardByName(String boardName);

    List<Bug> getBugs();

    List<Story> getStories ();

    List<Feedback> getFeedbacks();
    List<Task> getTasks();

   Task findTaskByName(String taskName);

   Team findTeamByName(String teamName);




    // History showAllHistory( ArrayList<String> history);


}


