package com.company.oopTaskManagement.teams.contracts;

import com.company.oopTaskManagement.tasks.contracts.Printable;
import com.company.oopTaskManagement.teams.BoardImpl;
import com.company.oopTaskManagement.teams.MemberImpl;

import java.util.ArrayList;

public interface Team extends Printable {

    String getName();
    ArrayList<Member> getMembers();
    ArrayList<Board> getBoards();

    void addMembers(Member member);
    void addBoard(Board board);
}
