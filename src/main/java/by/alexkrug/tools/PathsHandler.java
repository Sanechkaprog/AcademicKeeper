package by.alexkrug.tools;

public class PathsHandler {
    private PathsHandler(){}

    public static String handle(String fileName) {
        return "src/main/webapp/"  + fileName + ".jsp";
    }
}
