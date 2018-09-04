package _09_ObjectCommunicationAndEvents_Lab.models;

import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.Handler;
import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.LogType;
import _09_ObjectCommunicationAndEvents_Lab._04_Observer.ObservableTarget;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler logger) {
        super(id, dmg, logger);
    }

    @Override
    protected void executeClassSpecificAttack(ObservableTarget target, int dmg, Handler logger) {
        logger.handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
