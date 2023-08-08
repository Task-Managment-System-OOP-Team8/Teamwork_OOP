package teams;

import Utils.ValidationHelpers;
import java.util.ArrayList;

public class Teams implements teams.contracts.Team {
    public static final int NAME_MAX_LENGTH = 15;
    public static final int NAME_MIN_LENGTH = 5;
    public static final String INVALID_TEAM_NAME = String.format("Team name must be between %d and %d symbols", NAME_MIN_LENGTH, NAME_MAX_LENGTH);
    private String name;
    private ArrayList<Member> members;
    private ArrayList<Board> boards;

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
    public ArrayList<Member> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public ArrayList<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    private void setName(String name) {
        //TODO
        ValidationHelpers.ValidateIntRange(name.length(), NAME_MIN_LENGTH, NAME_MAX_LENGTH, INVALID_TEAM_NAME);
        this.name = name;
    }

    private void addMembers(Member member) {
        members.add(member);
    }

    private void addBoard(Board board) {
        boards.add(board);
    }

//    public void allTeamNames(String teamName) {
//        ArrayList<String> teams = new ArrayList<String>();
//        teams.add(teamName);

}
