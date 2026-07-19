package automation.api.bodies;

public class GraphQLPayload {

    private GraphQLPayload() {
    }

    public static String build(String operationName,
                               String query,
                               String variables) {

        return String.format("""
                {
                  "operationName":"%s",
                  "query":"%s",
                  "variables":%s
                }
                """,
                operationName,
                query.replace("\"", "\\\"").replace("\n", "\\n"),
                variables
        );
    }

}