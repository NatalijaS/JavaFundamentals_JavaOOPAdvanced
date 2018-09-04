package _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.core.factories;

import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.enums.ReportLevel;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Appender;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.AppenderFactory;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.File;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.interfaces.Layout;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.models.FileAppender;
import _07_OpenClosedAndLiskovSubstitution_Exercises._01_Logger.models.LogFile;

public class AppenderFactoryImpl implements AppenderFactory {

    private static final String MODELS_PATH = "g_openClosedPrincipies.j_objectCommunicationAndEvents.exercises.a_logger.domain.";

    @Override
    @SuppressWarnings("unchecked")
    public Appender createAppender(String[] params) throws ReflectiveOperationException {
        String appenderName = params[0];
        String layoutName = params[1];
        Class<Appender> appenderClass = (Class<Appender>) Class.forName(MODELS_PATH + appenderName);
        Class<Layout> layoutClass = (Class<Layout>) Class.forName(MODELS_PATH  + layoutName);
        Layout layout = layoutClass.getDeclaredConstructor().newInstance();
        Appender appender = appenderClass.getDeclaredConstructor(Layout.class).newInstance(layout);
        if (appender instanceof FileAppender) {
            File file = new LogFile();
            ((FileAppender) appender).setFile(file);
        }
        if (params.length > 2) {
            ReportLevel reportLevel = ReportLevel.valueOf(params[2]);
            appender.setReportLevel(reportLevel);
        }
        return appender;
    }
}
