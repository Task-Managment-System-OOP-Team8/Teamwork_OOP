package com.company.oopTaskManagement.teams.contracts;

import com.company.oopTaskManagement.tasks.contracts.Printable;
import com.company.oopTaskManagement.teams.BoardImpl;
import com.company.oopTaskManagement.teams.MemberImpl;

import java.util.ArrayList;

public interface Team extends Printable {

    String getName();
    ArrayList<MemberImpl> getMembers();
    ArrayList<BoardImpl> getBoards();

    void addMembers(MemberImpl member);
    void addBoard(BoardImpl board);
}
