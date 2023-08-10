package teams.contracts;

import teams.BoardImpl;
import teams.MemberImpl;

import java.util.ArrayList;

public interface Team {

    String getName();
    ArrayList<MemberImpl> getMembers();
    ArrayList<BoardImpl> getBoards();

    void addMembers(MemberImpl member);
    void addBoard(BoardImpl board);
}
