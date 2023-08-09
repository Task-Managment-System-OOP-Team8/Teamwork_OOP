package core;

import core.contracts.TaskManagementRepository;
import tasks.Comment;
import tasks.History;
import tasks.contracts.Bug;
import tasks.contracts.Feedback;
import tasks.contracts.Story;
import tasks.models.BugImpl;
import tasks.models.FeedbackImpl;
import tasks.models.StoryImpl;
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

    private int nextId;
    private List<Member> members;
    private List<Teams> teams;
    private List<Board> boards;
    private List<BugImpl> bugs;
    private List<StoryImpl> stories;
    private List<FeedbackImpl> feedbacks;
    private List<Comment>comments;


    public TaskManagementRepositoryImpl() {
        nextId=0;
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
    public Bug createBug( String title, String description, PriorityEnums priority,
                         SeverityEnums severity, String assignee) {
        BugImpl bug = new BugImpl(++nextId,title,description,priority,severity,assignee);
        this.bugs.add(bug);
        return bug;
    }

    @Override
    public Story createStory(String title, String description,PriorityEnums priority,
                             SizeEnums size,String assignee) {
        StoryImpl story = new StoryImpl(++nextId,title,description,priority,size,assignee);
        this.stories.add(story);
        return story;
    }

    @Override
    public Feedback createFeedback(String title, String description, int rating) {
        FeedbackImpl feedback = new FeedbackImpl(++nextId,title,description,rating);
        this.feedbacks.add(feedback);
        return feedback;
    }

    @Override
    public Comment createComment(String author, String message) {
        Comment comment = new Comment(author,message);
        this.comments.add(comment);
        return comment;
    }
//TODO
    @Override
    public History showAllHistory(ArrayList<String> history) {
        return null;
    }

}