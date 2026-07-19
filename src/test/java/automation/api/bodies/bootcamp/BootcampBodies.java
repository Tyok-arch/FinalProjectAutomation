package automation.api.bodies.bootcamp;

public final class BootcampBodies {

    private BootcampBodies() {
    }

    public static String createBootcampQuery() {

        return """
                mutation CreateBootcamp($input: InputBootcamp!) {
                  createBootcamp(input: $input) {
                    id
                    title
                  }
                }
                """;
    }

    public static String getBootcampQuery() {

        return """
                query BootcampById($id: String!) {
                  bootcampById(id: $id) {
                    id
                    title
                    descriptions
                  }
                }
                """;
    }

    public static String updateBootcampQuery() {

        return """
                mutation UpdateBootcamp($id: String!, $input: InputBootcamp!) {
                  updateBootcamp(id: $id, input: $input) {
                    id
                    title
                  }
                }
                """;
    }

    public static String deleteBootcampQuery() {

        return """
                mutation DeleteBootcamp($id: String!) {
                  deleteBootcamp(id: $id) {
                    id
                    title
                  }
                }
                """;
    }

}