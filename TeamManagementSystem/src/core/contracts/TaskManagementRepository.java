package core.contracts;

import tasks.Comment;
import tasks.contracts.Bug;
import tasks.contracts.Feedback;
import tasks.contracts.Story;
import tasks.contracts.Task;
import tasks.models.enums.*;
import teams.Board;
import teams.Member;
import teams.Teams;

import java.util.ArrayList;
import java.util.List;

public interface TaskManagementRepository {

    List<Member> getMembers();


    void addMember(Member memberToAdd);

    Member createMember(String name);

    Teams createTeam(String name);


    Board createBoard(String boardName);


   Bug createBug (String title, int id, String description, ArrayList<String> steps, SeverityEnums severity,
                  StatusEnums status, PriorityEnums priority, Member assignee);  //?

    Story createStory(String title, int id, String description, StatusEnums status, PriorityEnums priority,
                      SizeEnums size,Member assignee);  //?

    Feedback createFeedback(String title, int id, String description,int rating, StatusEnums status,
                            SizeEnums size);

    Comment createComment(String author, String message);


}


