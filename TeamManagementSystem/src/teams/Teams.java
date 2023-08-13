package teams;

import Utils.ValidationHelpers;
import teams.contracts.Team;

import java.util.ArrayList;

public class Teams implements Team {
    public static final int NAME_MAX_LENGTH = 15;
    public static final int NAME_MIN_LENGTH = 5;
    public static final String INVALID_TEAM_NAME = String.format("Team name must be between %d and %d symbols", NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private String name;
    private ArrayList<MemberImpl> members;
    private ArrayList<BoardImpl> boards;

    public Teams(String name) {
        setName(name);
        this.members = new ArrayList<>();
        this.boards = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<MemberImpl> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public ArrayList<BoardImpl> getBoards() {
        return new ArrayList<>(boards);
    }

    private void setName(String name) {
        //TODO
        ValidationHelpers.ValidateIntRange(name.length(), NAME_MIN_LENGTH, NAME_MAX_LENGTH, INVALID_TEAM_NAME);
        this.name = name;
    }

    public void addMembers(MemberImpl member) {
        members.add(member);
    }

    public void addBoard(BoardImpl board) {
        boards.add(board);
    }


    @Override
    public String getAsString() {
        return String.format("%s",getName());
    }
}
