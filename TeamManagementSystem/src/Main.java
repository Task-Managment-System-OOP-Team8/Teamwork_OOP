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

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Task bug = new BugImpl("dsdda","dasausa",PriorityEnums.HIGH,SeverityEnums.MAJOR,"ffffff");
        Task bug1 = new BugImpl("sasasa","dwsdasada",PriorityEnums.HIGH,SeverityEnums.MAJOR,"ggggg");

        Feedback ff = new FeedbackImpl("dwsdss","sasasa",6);
        Story story = new StoryImpl("dsdadsd","dsdsds",PriorityEnums.HIGH, SizeEnums.LARGE,"fdssd");


//        System.out.println(bug.getId());
//        System.out.println(bug1.getId());
//        System.out.println(ff.getId());
//        System.out.println(story.getId());

        System.out.println(TaskImpl.totalId);
    }
}