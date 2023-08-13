package listing;

import Utils.ListingHelpers;
import commands.contracts.Command;
import core.contracts.TaskManagementRepository;
import tasks.models.FeedbackImpl;

import java.util.List;

public class ListFeedbackCommand implements Command {

    public static final String FEEDBACKS_AVAILABLE = "There is no feedbacks available.";
    //TODO
    private final List<FeedbackImpl> feedbacks;

    public ListFeedbackCommand(TaskManagementRepository taskManagementRepository){
        feedbacks=taskManagementRepository.getFeedbacks();
    }

    @Override
    public String execute(List<String> parameters) {
        if (feedbacks.isEmpty()){
            return FEEDBACKS_AVAILABLE;
        }
        return ListingHelpers.elements(feedbacks);
    }
}
