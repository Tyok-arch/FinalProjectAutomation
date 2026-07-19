package automation.api.bodies.program;

public final class ProgramBodies {

    private ProgramBodies() {
    }

    /**
     * Create Program
     */
    public static String createProgramQuery() {

        return """
                mutation CreateProgram($input: ProgramInput!) {
                  createProgram(input: $input) {
                    id
                    title
                    type
                  }
                }
                """;
    }

    /**
     * Get Program
     */
    public static String getProgramQuery() {

        return """
                query ProgramById($id: String!) {
                  programById(id: $id) {
                    id
                    title
                    description
                    type
                  }
                }
                """;
    }

    /**
     * Update Program
     */
    public static String updateProgramQuery() {

        return """
                mutation UpdateProgram($id: String!, $input: ProgramInput!) {
                  updateProgram(id: $id, input: $input) {
                    id
                    title
                  }
                }
                """;
    }

    /**
     * Delete Program
     */
    public static String deleteProgramQuery() {

        return """
                mutation DeleteProgram($id: String!) {
                  deleteProgram(id: $id)
                }
                """;
    }

}