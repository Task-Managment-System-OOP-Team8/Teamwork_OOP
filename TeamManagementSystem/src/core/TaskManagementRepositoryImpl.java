package core;

import Utils.ListingHelpers;
import core.contracts.TaskManagementRepository;
import tasks.Comment;
import tasks.History;
import tasks.contracts.Bug;
import tasks.contracts.Feedback;
import tasks.contracts.Story;
import tasks.models.BugImpl;
import tasks.models.FeedbackImpl;
import tasks.models.StoryImpl;
import tasks.models.TaskImpl;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SeverityEnums;
import tasks.models.enums.SizeEnums;
import teams.BoardImpl;
import teams.MemberImpl;
import teams.Teams;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementRepositoryImpl implements TaskManagementRepository {
    public static final String THIS_MEMBER_ALREADY_EXISTS = "This member already exists.";
    public static final String THIS_TEAM_ALREADY_EXISTS = "This team already exists";
    public static final String BOARD_ALREADY_EXISTS = "Board already exists";
    public static final String FEEDBACK_ALREADY_EXISTS = "Feedback already exists";
    public static final String NO_VALID_USERNAME = "There is no member with username: %s";
    public static final String NO_VALID_BOARD_NAME = "There is no board with name: %s";
    private int nextId;
    private List<MemberImpl> members;
    private List<Teams> teams;
    private List<BoardImpl> boards;
    private List<BugImpl> bugs;
    private List<StoryImpl> stories;
    private List<FeedbackImpl> feedbacks;
    private List<Comment> comments;

    private List <TaskImpl> task;

    public TaskManagementRepositoryImpl() {
        nextId = 1;
        this.bugs = new ArrayList<>();
        this.stories = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.boards = new ArrayList<>();
        this.members = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.task = new ArrayList<>();
    }

    @Override
    public List<MemberImpl> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public List<Teams> getTeams() {
        return new ArrayList<>(teams);
    }

    @Override
    public List<BoardImpl> getBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public List<History> getHistory() {
        return null;
    }

    @Override
    public MemberImpl addMember(MemberImpl memberToAdd) {
        if (members.contains(memberToAdd)) {
            throw new IllegalArgumentException(THIS_MEMBER_ALREADY_EXISTS);
        }
        members.add(memberToAdd);
        return memberToAdd;
    }

    @Override
    public History addActivity(History activityToAdd) {
        return null;
    }

    @Override
    public BoardImpl addBoard(BoardImpl boardName) {
        if (boards.contains(boardName)) {
            throw new IllegalArgumentException(BOARD_ALREADY_EXISTS);
        }
        boards.add(boardName);
        return boardName;
    }

    @Override
    public BugImpl addBug(BugImpl bugTitle) {
        return bugTitle;
    }

    @Override
    public StoryImpl addStory(StoryImpl storyTitle) {
        return storyTitle;
    }

    @Override
    public MemberImpl createMember(String name) {
        return new MemberImpl(name);
    }

    @Override
    public Teams createTeam(String name) {
        return new Teams(name);
    }

    @Override
    public Teams addTeam(Teams teamName) {
            if (teams.contains(teamName)) {
                throw new IllegalArgumentException(THIS_TEAM_ALREADY_EXISTS);
            }
            teams.add(teamName);
            return teamName;
    }

    @Override
    public FeedbackImpl addFeedback(FeedbackImpl feedbackTitle) {
        if (feedbacks.contains(feedbackTitle)) {
            throw new IllegalArgumentException(FEEDBACK_ALREADY_EXISTS);
        }
        feedbacks.add(feedbackTitle);
        return feedbackTitle;
    }

    @Override
    public MemberImpl findMemberByUsername(String username) {
        for (MemberImpl member : members) {
            if (member.getName().equalsIgnoreCase(username)){
                return member;
            }
        }
      throw new IllegalArgumentException(String.format(NO_VALID_USERNAME,username));
    }

    @Override
    public BoardImpl findBoardByName(String boardName) {
        for (BoardImpl board : boards){
            if (board.getName().equalsIgnoreCase(boardName)){
                return board;
            }
        }
    throw new IllegalArgumentException(String.format(NO_VALID_BOARD_NAME,boardName));
    }

    @Override
    public BoardImpl createBoard(String boardName) {
        return new BoardImpl(boardName);
    }

    @Override
    public BugImpl createBug( String title, String description, PriorityEnums priority,
                         SeverityEnums severity, String assignee) {
        BugImpl bug = new BugImpl(title,description,priority,severity,assignee);
        this.bugs.add(bug);
        return bug;
    }

    @Override
    public StoryImpl createStory(String title, String description,PriorityEnums priority,
                             SizeEnums size,String assignee) {
        StoryImpl story = new StoryImpl(title,description,priority,size,assignee);
        this.stories.add(story);
        return story;
    }

    @Override
    public FeedbackImpl createFeedback(String title, String description, int rating) {
        FeedbackImpl feedback = new FeedbackImpl(title,description,rating);
        this.feedbacks.add(feedback);
        return feedback;
    }

    @Override
    public Comment createComment(String author, String message) {
        Comment comment = new Comment(author,message);
        this.comments.add(comment);
        return comment;
    }
@Override
    public List<BugImpl> getBugs() {
        return new ArrayList<>(bugs);
    }
    @Override
    public List<StoryImpl> getStories(){
        return new ArrayList<>(stories);
    }
@Override
    public List<FeedbackImpl> getFeedbacks(){
        return new ArrayList<>(feedbacks);
    }
    //create history
@Override
    public List<TaskImpl> getTasks(){
        return new ArrayList<>(task);
    }

    }



