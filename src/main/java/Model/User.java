package Model;

import java.util.Objects;

public class User {
    private final String EMAIL = "pavliksokolov0993@gmail.com";
    private final String PASSWORD = "0993sokol";



    @Override
    public int hashCode() {
        return Objects.hash(EMAIL, PASSWORD);
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

}
