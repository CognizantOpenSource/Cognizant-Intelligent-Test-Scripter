package org.json.simple;

import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sample usage:
 * <pre>
 * Writer writer = new JSONWriter(); // this writer adds indentation
 * jsonobject.writeJSONString(writer);
 * System.out.println(writer.toString());
 * </pre>
 *
 * @author Elad Tabak
 * @author Maciej Komosinski, minor improvements, 2015
 * @since 28-Nov-2011
 * @version 0.2 Modified
 */
public class JSONWriter extends StringWriter {

    final static String INDENT_STRING = "  "; //define as you wish
    final static String SPACE_AFTER_COLON = " "; //use "" if you don't want space after colon

    private int indentlevel = 0;

    @Override
    public void write(int c) {
        char ch = (char) c;
        switch (ch) {
            case '[':
            case '{':
                super.write(c);
                super.write('\n');
                indentlevel++;
                writeIndentation();
                break;
            case ',':
                super.write(c);
                super.write('\n');
                writeIndentation();
                break;
            case ']':
            case '}':
                super.write('\n');
                indentlevel--;
                writeIndentation();
                super.write(c);
                break;
            case ':':
                super.write(c);
                super.write(SPACE_AFTER_COLON);
                break;
            default:
                super.write(c);
                break;
        }

    }

    private void writeIndentation() {
        for (int i = 0; i < indentlevel; i++) {
            super.write(INDENT_STRING);
        }
    }

    public static String getJSONString(JSONObject obj) {
        try {
            JSONWriter writer = new JSONWriter();
            obj.writeJSONString(writer);
            return writer.toString();
        } catch (IOException ex) {
            Logger.getLogger(JSONWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
