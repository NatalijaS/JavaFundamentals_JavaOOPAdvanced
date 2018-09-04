package _09_ObjectCommunicationAndEvents_Lab;

import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.Logger;
import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.loggers.CombatLogger;
import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.loggers.ErrorLogger;
import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.loggers.EventLogger;
import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.loggers.TargetLogger;
import _09_ObjectCommunicationAndEvents_Lab._02_Command.Command;
import _09_ObjectCommunicationAndEvents_Lab._02_Command.CommandExecutor;
import _09_ObjectCommunicationAndEvents_Lab._02_Command.Executor;
import _09_ObjectCommunicationAndEvents_Lab._02_Command.commands.GroupAttackCommand;
import _09_ObjectCommunicationAndEvents_Lab._02_Command.commands.GroupTargetCommand;
import _09_ObjectCommunicationAndEvents_Lab._03_Mediator.AttackGroup;
import _09_ObjectCommunicationAndEvents_Lab._03_Mediator.Group;
import _09_ObjectCommunicationAndEvents_Lab._04_Observer.ObservableTarget;
import _09_ObjectCommunicationAndEvents_Lab.models.Dragon;
import _09_ObjectCommunicationAndEvents_Lab.models.Warrior;

public class Main {
    public static void main(String[] args) {

        Logger combatLogger = new CombatLogger();
        Logger eventLogger = new EventLogger();
        Logger errorLogger = new ErrorLogger();

        combatLogger.setSuccessor(eventLogger);
        eventLogger.setSuccessor(errorLogger);

        AttackGroup group = new Group();
        group.addMember(new Warrior("Warrior", 10 , combatLogger));
        group.addMember(new Warrior("ElderWarrior", 15, combatLogger));

        ObservableTarget dragon = new Dragon("Dragon", 10, 100, combatLogger);

        Executor commandExecutor = new CommandExecutor();
        Command groupTarget = new GroupTargetCommand(group, dragon);
        Command attackCommand = new GroupAttackCommand(group);

        commandExecutor.executeCommand(groupTarget);
        commandExecutor.executeCommand(attackCommand);
    }
}
