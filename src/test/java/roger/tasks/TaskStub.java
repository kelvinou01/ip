package roger.tasks;

import java.time.LocalDate;

/**
 * Testing stub for Task class.
 */
public class TaskStub extends Task {

    public TaskStub(String name) {
        super(name);
        this.date = LocalDate.parse("2022-02-02");
    }

    public void markAsDone() {
    }

    public void unmarkAsDone() {
    }

    public String toString() {
        return "";
    }

    public String getName() {
        return "";
    }

    public boolean isDone() {
        return true;
    }
}