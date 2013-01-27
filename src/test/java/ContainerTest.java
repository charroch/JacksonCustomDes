import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContainerTest {

    String json = "{\"pages\": 23, \"name\": \"Carl\", \"Employee\": {\"lastName\": \"Harroch\" }}";
    String json2 = "{\"pages\": 23, \"name\": \"Carl\", \"lastName\": \"Harroch\" }";


    @Test
    public void testing() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ContainerOf<Employee> membersWrapper =
                objectMapper.readValue(json2, new TypeReference<ContainerOf<Employee>>() {});
        assertThat(membersWrapper.pages, equalTo(23));
        assertThat(membersWrapper.name, equalTo("Carl"));
        assertNotNull(membersWrapper.what);
        assertThat(membersWrapper.what.lastName, equalTo("Harroch"));
    }


}
