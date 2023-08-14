import com.company.oopTaskManagement.tasks.models.BugImpl;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;

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