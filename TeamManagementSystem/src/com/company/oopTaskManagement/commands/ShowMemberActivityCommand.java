package com.company.oopTaskManagement.commands;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import com.company.oopTaskManagement.teams.contracts.Member;
import java.util.List;

    public class ShowMemberActivityCommand extends BaseCommand{
        public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;

        public static final String NO_ACTIVITY_FOR_MEMBER = "Currently there is no activity to display for member %s.";


        public ShowMemberActivityCommand(TaskManagementRepository tmsRepository) {
            super(tmsRepository);
        }

        @Override
        protected String executeCommand(List<String> parameters) {
            ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
            String username = parameters.get(0);
            Member member = getTaskManagementRepository().findMemberByUsername(username);
            if (member.getHistory().isEmpty()){
                return String.format(NO_ACTIVITY_FOR_MEMBER, member.getName());
            }
            return member.getHistory().stream().toList().toString();

        }
}
