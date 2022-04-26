package Command;

/**
 * A Command Abstraction for all types of command
 * Each Command's implementation HAS A Receiver instance on which the command needs to be applied
 */
public interface Command {
    void execute();
    void undo();
}
