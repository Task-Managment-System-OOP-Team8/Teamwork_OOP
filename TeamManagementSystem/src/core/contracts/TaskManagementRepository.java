package core.contracts;

import tasks.Comment;
import tasks.History;
import tasks.contracts.Bug;
import tasks.contracts.Feedback;
import tasks.contracts.Story;
import tasks.models.enums.*;
import teams.Board;
import teams.Member;
import teams.Teams;

import java.util.ArrayList;
import java.util.List;

public interface TaskManagementRepository {

    List<Member> getMembers();


    Member addMember(Member memberToAdd);

    Member createMember(String name);

    Teams createTeam(String name);


    Board createBoard(String boardName);


   Bug createBug ( String title, String description, PriorityEnums priority,
                  SeverityEnums severity, String assignee);  //?

    Story createStory(String title, String description,PriorityEnums priority,SizeEnums size,String assignee);  //?

    Feedback createFeedback(String title, String description, int rating);

    Comment createComment(String author, String message);

   // History showAllHistory( ArrayList<String> history);


}


