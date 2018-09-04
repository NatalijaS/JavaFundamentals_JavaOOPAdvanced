package _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.io;

import _09_ObjectCommunicationAndEvents_Exercises._02_KingsGambit.RoyalGroup;

public interface Executor {

    void executeCommand(String[] data, RoyalGroup royalGroup);
}
