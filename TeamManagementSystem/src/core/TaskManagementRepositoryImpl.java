package core;

import core.contracts.TaskManagementRepository;
import tasks.Comment;
import tasks.contracts.Bug;
import tasks.contracts.Feedback;
import tasks.contracts.Story;
import tasks.models.BugImpl;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SeverityEnums;
import tasks.models.enums.SizeEnums;
import tasks.models.enums.StatusEnums;
import teams.Board;
import teams.Member;
import teams.Teams;
import teams.contracts.Team;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementRepositoryImpl implements TaskManagementRepository {
    public static final String THIS_MEMBER_ALREADY_EXISTS = "This member already exists.";
    private List<Member> members;

    public TaskManagementRepositoryImpl(List<Member> members) {
        this.members = new ArrayList<>();
    }

    @Override
    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public void addMember(Member memberToAdd) {
        if (members.contains(memberToAdd)) {
            throw new IllegalArgumentException(THIS_MEMBER_ALREADY_EXISTS);
        }
        members.add(memberToAdd);
    }

    @Override
    public Member createMember(String name) {
        return new Member(name);
    }

    @Override
    public Teams createTeam(String name) {
        return new Teams(name);
    }

    @Override
    public Board createBoard(String boardName) {
        return new Board(boardName);
    }

    @Override
    public Bug createBug(String title, String description, ArrayList<String> steps, SeverityEnums severity,
                         StatusEnums status, PriorityEnums priority, Member assignee) {
        return new BugImpl(title, description, steps, severity, status, priority, assignee);
    }

    @Override
    public Story createStory(String title, int id, String description, StatusEnums status
                             PriorityEnums priority,
                             SizeEnums size, Member assignee) {
        return null;
    }

    @Override
    public Feedback createFeedback(String title, int id, String description, int rating, StatusEnums status,
                                   SizeEnums size) {
        return null;
    }

    @Override
    public Comment createComment(String author, String message) {
        return null;
    }
}
