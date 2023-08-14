package com.company.oopTaskManagement.core;

import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.Comment;
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
    private List<TeamImpl> teams;
    private List<BoardImpl> boards;
    private List<BugImpl> bugs;
    private List<StoryImpl> stories;
    private List<FeedbackImpl> feedbacks;
    private List<Comment> comments;

    private List<TaskImpl> task;

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
    public List<TeamImpl> getTeams() {
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
    public TeamImpl createTeam(String name) {
        return new TeamImpl(name);
    }

    @Override
    public TeamImpl addTeam(TeamImpl teamName) {
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
            if (member.getName().equalsIgnoreCase(username)) {
                return member;
            }
        }
        throw new IllegalArgumentException(String.format(NO_VALID_USERNAME, username));
    }

    @Override
    public BoardImpl findBoardByName(String boardName) {
        for (BoardImpl board : boards) {
            if (board.getName().equalsIgnoreCase(boardName)) {
                return board;
            }
        }
        throw new IllegalArgumentException(String.format(NO_VALID_BOARD_NAME, boardName));
    }

    @Override
    public BoardImpl createBoard(String boardName) {
        return new BoardImpl(boardName);
    }

    @Override
    public BugImpl createBug(String title, String description, PriorityEnums priority,
                             SeverityEnums severity, String assignee) {
        BugImpl bug = new BugImpl(title, description, priority, severity, assignee);
        this.bugs.add(bug);
        return bug;
    }

    @Override
    public StoryImpl createStory(String title, String description, PriorityEnums priority,
                                 SizeEnums size, String assignee) {
        StoryImpl story = new StoryImpl(title, description, priority, size, assignee);
        this.stories.add(story);
        return story;
    }

    @Override
    public FeedbackImpl createFeedback(String title, String description, int rating) {
        FeedbackImpl feedback = new FeedbackImpl(title, description, rating);
        this.feedbacks.add(feedback);
        return feedback;
    }

    @Override
    public Comment createComment(String author, String message) {
        Comment comment = new Comment(author, message);
        this.comments.add(comment);
        return comment;
    }

    @Override
    public List<BugImpl> getBugs() {
        return new ArrayList<>(bugs);
    }

    @Override
    public List<StoryImpl> getStories() {
        return new ArrayList<>(stories);
    }

    @Override
    public List<FeedbackImpl> getFeedbacks() {
        return new ArrayList<>(feedbacks);
    }

    //create history
    @Override
    public List<TaskImpl> getTasks() {
        return new ArrayList<>(task);
    }


    @Override
    public TaskImpl findTaskByName(String taskName) {
        for (TaskImpl task : getTasks()) {
            if (task.getTitle().equalsIgnoreCase(taskName)) {
                return task;
            }

            throw new IllegalArgumentException(String.format("Task with name %s doesn't exist.", taskName));
        }

        return null;
    }

}