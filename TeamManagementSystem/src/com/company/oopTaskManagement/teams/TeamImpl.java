package com.company.oopTaskManagement.teams;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.teams.contracts.Board;
import com.company.oopTaskManagement.teams.contracts.Member;
import com.company.oopTaskManagement.teams.contracts.Team;

import java.util.ArrayList;

public class TeamImpl implements Team {
    public static final int NAME_MAX_LENGTH = 15;
    public static final int NAME_MIN_LENGTH = 5;
    public static final String INVALID_TEAM_NAME = String.format("Team name must be between %d and %d symbols", NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private String name;
    private ArrayList<Member> members;
    private ArrayList<Board> boards;

    public TeamImpl(String name) {
        setName(name);
        this.members = new ArrayList<>();
        this.boards = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Member> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public ArrayList<Board> getBoards() {
        return new ArrayList<>(boards);
    }
@Override
    public void addMembers(Member member) {
        members.add(member);
    }
@Override
    public void addBoard(Board board) {
        boards.add(board);
    }

    @Override
    public String getAsString() {
        return String.format("Team name: %s\n",getName());
    }

    private void setName(String name) {
        ValidationHelpers.ValidateIntRange(name.length(), NAME_MIN_LENGTH, NAME_MAX_LENGTH, INVALID_TEAM_NAME);
        this.name = name;
    }
}
