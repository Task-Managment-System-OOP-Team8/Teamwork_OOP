package teams.contracts;

import tasks.contracts.Printable;
import teams.BoardImpl;
import teams.MemberImpl;

import java.util.ArrayList;

public interface Team extends Printable {

    String getName();
    ArrayList<MemberImpl> getMembers();
    ArrayList<BoardImpl> getBoards();

    void addMembers(MemberImpl member);
    void addBoard(BoardImpl board);
}
