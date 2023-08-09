package teams.contracts;

import teams.Board;
import teams.Member;

import java.util.ArrayList;

public interface Team {

    String getName();
    ArrayList<Member> getMembers();
    ArrayList<Board> getBoards();
}
