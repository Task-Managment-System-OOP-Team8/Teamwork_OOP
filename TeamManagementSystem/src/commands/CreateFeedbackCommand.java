package commands;

import Utils.ValidationHelpers;
import core.contracts.TaskManagementRepository;
import tasks.models.FeedbackImpl;

import java.util.List;

public class CreateFeedbackCommand extends BaseCommand {
    public static final String FEEDBACK_S_CREATED_SUCCESSFULLY = "Feedback %s created successfully";
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;

    protected CreateFeedbackCommand(TaskManagementRepository taskManagementRepository) {
        super(taskManagementRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String feedbackTitle = parameters.get(0);
        String feedbackDescription = parameters.get(1);
        int feedbackRating = Integer.parseInt(parameters.get(2));

        return createFeedback(feedbackTitle, feedbackDescription, feedbackRating);

    }

    private String createFeedback(String title, String description, int rating) {
        FeedbackImpl feedback = getTaskManagementRepository().createFeedback(title, description, rating);
        getTaskManagementRepository().addFeedback(feedback);
        return String.format(FEEDBACK_S_CREATED_SUCCESSFULLY, title);
    }


}
