package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import teams.MemberImpl;

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
            MemberImpl member = getTaskManagementRepository().findMemberByUsername(username);
            if (member.getHistory().isEmpty()){
                return String.format(NO_ACTIVITY_FOR_MEMBER, member.getName());
            }
            return member.getHistory().stream().toList().toString();

        }
}
