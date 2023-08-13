import core.TaskManagementEngineImpl;
import core.TaskManagementRepositoryImpl;
import tasks.contracts.Bug;
import tasks.contracts.Feedback;
import tasks.contracts.Story;
import tasks.contracts.Task;
import tasks.models.BugImpl;
import tasks.models.FeedbackImpl;
import tasks.models.StoryImpl;
import tasks.models.TaskImpl;
import tasks.models.enums.PriorityEnums;
import tasks.models.enums.SeverityEnums;
import tasks.models.enums.SizeEnums;
import teams.Teams;
import teams.contracts.Team;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
//        TaskManagementEngineImpl engine = new TaskManagementEngineImpl();
//        engine.start();
//        Teams team = new Teams("AFSfasf");
//        System.out.println(team.getAsString());

        BugImpl bug1 = new BugImpl("dnjsasadedldsd","sggdhwaddahdhdh",PriorityEnums.HIGH,SeverityEnums.MAJOR,"fedfddf");
        BugImpl bug2 = new BugImpl("dsdsxssasassds","sdsdssdsdssd",PriorityEnums.HIGH,SeverityEnums.MAJOR,"dsdsdsd");

        System.out.println(bug1.getId());
        System.out.println(bug2.getId());

        System.out.println(BugImpl.totalId);
    }
}