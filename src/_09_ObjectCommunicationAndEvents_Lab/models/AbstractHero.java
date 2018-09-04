package _09_ObjectCommunicationAndEvents_Lab.models;

import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.Handler;
import _09_ObjectCommunicationAndEvents_Lab._01_LoggerChainOfResponsibility.LogType;
import _09_ObjectCommunicationAndEvents_Lab._04_Observer.ObservableTarget;
import _09_ObjectCommunicationAndEvents_Lab._04_Observer.Observer;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";

    private String id;
    private int dmg;
    private ObservableTarget target;
    private Handler logger;

    AbstractHero(String id, int dmg, Handler logger) {
        this.id = id;
        this.dmg = dmg;
        this.logger = logger;
    }

    public void setTarget(ObservableTarget target) {
        if (target == null) {
            this.logger.handle(LogType.ERROR,TARGET_NULL_MESSAGE );
        } else {
            this.target = target;
            this.logger.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    public final void attack() {
        if (this.target == null) {
            this.logger.handle(LogType.ERROR,String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.logger.handle(LogType.TARGET,String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg, this.logger);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(ObservableTarget target, int dmg, Handler logger);

    @Override
    public void update(int value) {
        this.logger.handle(LogType.EVENT, String.format("%s gains %s xp", this, value));
    }
}
