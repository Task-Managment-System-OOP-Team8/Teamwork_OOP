package commands.core;


import com.company.oopTaskManagement.commands.CreateMemberCommand;
import com.company.oopTaskManagement.core.TaskManagementRepositoryImpl;
import com.company.oopTaskManagement.core.contracts.TaskManagementRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateMemberTests {

    @Test
    void testExecuteCommand_ValidUsername_Success() {
        TaskManagementRepository repository = new TaskManagementRepositoryImpl();
        CreateMemberCommand createMemberCommand = new CreateMemberCommand(repository);
        List<String> parameters = new ArrayList<>(List.of("username"));

        String result = createMemberCommand.executeCommand(parameters);

        Assertions.assertEquals("Member username registered successfully!", result);

    }
}
