package group.rxcloud.capa.bff.hjson;

public class AntlrUtils {

    public static String parseRowString(String rowString) {
        return rowString.substring(1, rowString.length() - 1);
    }
}
