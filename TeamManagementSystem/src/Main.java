import com.company.oopTaskManagement.core.TaskManagementEngineImpl;
import com.company.oopTaskManagement.tasks.models.BugImpl;
import com.company.oopTaskManagement.tasks.models.enums.PriorityEnums;
import com.company.oopTaskManagement.tasks.models.enums.SeverityEnums;

public class Main {
    public static void main(String[] args) {
        TaskManagementEngineImpl engine = new TaskManagementEngineImpl();
        engine.start();


    }
}