package com.company.oopTaskManagement.core;

import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.tasks.CommentImpl;
import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.contracts.*;
import com.company.oopTaskManagement.tasks.models.BugImpl;
import com.company.oopTaskManagement.tasks.models.FeedbackImpl;
import com.company.oopTaskManagement.tasks.models.StoryImpl;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SizeEnums;
import com.company.oopTaskManagement.teams.BoardImpl;
import com.company.oopTaskManagement.teams.MemberImpl;
import com.company.oopTaskManagement.teams.TeamImpl;
import com.company.oopTaskManagement.teams.contracts.Board;
import com.company.oopTaskManagement.teams.contracts.Member;
import com.company.oopTaskManagement.teams.contracts.Team;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementRepositoryImpl implements TaskManagementRepository {
    public static final String THIS_MEMBER_ALREADY_EXISTS = "This member already exists.";
    public static final String THIS_TEAM_ALREADY_EXISTS = "This team already exists";
    public static final String BOARD_ALREADY_EXISTS = "Board already exists";
    public static final String FEEDBACK_ALREADY_EXISTS = "Feedback already exists";
    public static final String NO_VALID_USERNAME = "There is no member with username: %s";
    public static final String NO_VALID_BOARD_NAME = "There is no board with name: %s";
    public static final String TEAM_DOES_NOT_EXIST = "A team with %s name does not exist.";
    public static final String TASK_DOES_NOT_EXIST = "Task with name %s doesn't exist.";
    private int nextId;
    private List<Member> member;
    private List<Team> teams;
    private List<Board> boards;
    private List<Bug> bugs;
    private List<Story> stories;
    private List<com.company.oopTaskManagement.tasks.contracts.Feedback> feedbacks;
    private List<Comment> comments;

    private List<Task> task;

    public TaskManagementRepositoryImpl() {
        nextId = 1;
        this.bugs = new ArrayList<Bug>();
        this.stories = new ArrayList<Story>();
        this.feedbacks = new ArrayList<Feedback>();
        this.comments = new ArrayList<Comment>();
        this.boards = new ArrayList<Board>();
        this.member = new ArrayList<Member>();
        this.teams = new ArrayList<Team>();
        this.task = new ArrayList<Task>();
    }

    @Override
    public List<Member> getMembers() {
        return new ArrayList<>(member);
    }

    @Override
    public List<Team> getTeams() {
        return new ArrayList<>(teams);
    }

    @Override
    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public List<History> getHistory() {
        return null;
    }

    @Override
    public Member addMember(Member memberToAdd) { //сравняваме името а не референцията
//        if (members.contains(memberToAdd)) {
//            throw new IllegalArgumentException(THIS_MEMBER_ALREADY_EXISTS);
//        }
//        members.add(memberToAdd);
//        return memberToAdd;
        boolean memberExists =
       this.member
               .stream()
               .anyMatch(member -> member.getName().equalsIgnoreCase(memberToAdd.getName()));
        if (memberExists) {
            member.add(memberToAdd);
            return memberToAdd;
        }
        throw new IllegalArgumentException(THIS_MEMBER_ALREADY_EXISTS);
    }

    @Override
    public History addActivity(History activityToAdd) {
        return null;
    }

    @Override
    public Board addBoard(Board boardName) {
        if (boards.contains(boardName)) {
            throw new IllegalArgumentException(BOARD_ALREADY_EXISTS);
        }
        boards.add(boardName);
        return boardName;
    }

    @Override
    public Bug addBug(Bug bugTitle) {
        return bugTitle;
    }

    @Override
    public Story addStory(Story storyTitle) {
        return storyTitle;
    }

    @Override
    public Member createMember(String name) {
        return new MemberImpl(name);
    }

    @Override
    public Team createTeam(String name) {
        return new TeamImpl(name);
    }

    @Override
    public Team addTeam(Team teamName) {
        if (teams.contains(teamName)) {
            throw new IllegalArgumentException(THIS_TEAM_ALREADY_EXISTS);
        }
        teams.add(teamName);
        return teamName;
    }

    @Override
    public Feedback addFeedback(Feedback feedbackTitle) {
        if (feedbacks.contains(feedbackTitle)) {
            throw new IllegalArgumentException(FEEDBACK_ALREADY_EXISTS);
        }
        feedbacks.add(feedbackTitle);
        return feedbackTitle;
    }

    @Override
    public Member findMemberByUsername(String username) {
        return member.stream()
                .filter(member -> member.getName().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NO_VALID_USERNAME, username)));
    }

    @Override
    public Board findBoardByName(String boardName) {
        return boards.stream()
                .filter(board -> board.getName().equalsIgnoreCase(boardName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NO_VALID_BOARD_NAME, boardName)));
    }

    @Override
    public Board createBoard(String boardName) {
        return new BoardImpl(boardName);
    }

    @Override
    public Bug createBug(String title, String description,List<String> steps, PriorityEnums priority,
                             SeverityEnums severity, String assignee) {
        Bug bug = new BugImpl(title, description,steps, priority, severity, assignee);
        this.bugs.add(bug);
        return bug;
    }

    @Override
    public Story createStory(String title, String description, PriorityEnums priority,
                                 SizeEnums size, String assignee) {
        Story story = new StoryImpl(title, description, priority, size, assignee);
        this.stories.add(story);
        return story;
    }

    @Override
    public Feedback createFeedback(String title, String description, int rating) {
        Feedback feedback = new FeedbackImpl(title, description, rating);
        this.feedbacks.add(feedback);
        return feedback;
    }

    @Override
    public Comment createComment(String author, String message) {
        Comment comment = new CommentImpl(author, message);
        this.comments.add(comment);
        return comment;
    }

    @Override
    public List<Bug> getBugs() {
        return new ArrayList<>(bugs);
    }

    @Override
    public List<Story> getStories() {
        return new ArrayList<>(stories);
    }

    @Override
    public List<Feedback> getFeedbacks() {
        return new ArrayList<>(feedbacks);
    }

    //create history
    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(task);
    }


    @Override
    public Task findTaskByName(String taskName) {
        return getTasks().stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(taskName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(TASK_DOES_NOT_EXIST, taskName)));
    }

    @Override
    public Team findTeamByName(String teamName) {
        return teams.stream()
                .filter(team -> team.getName().equalsIgnoreCase(teamName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(TEAM_DOES_NOT_EXIST, teamName)));
    }

}