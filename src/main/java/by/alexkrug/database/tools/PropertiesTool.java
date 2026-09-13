package by.alexkrug.database.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesTool {
    public final Properties PROPERTIES = new Properties();

    {
        loadProp();
    }

    private void loadProp() {
        InputStream is = PropertiesTool.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            PROPERTIES.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
