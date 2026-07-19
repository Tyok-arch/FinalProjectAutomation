package automation.api.bodies.division;

public final class DivisionBodies {

    private DivisionBodies() {
    }

    /**
     * Create Division
     */
    public static String createDivisionQuery() {

        return """
                mutation CreateDivision($input: DivisionInput!) {
                  createDivision(input: $input) {
                    id
                    name
                    description
                  }
                }
                """;
    }

    /**
     * Get Division
     */
    public static String getDivisionQuery() {

        return """
                query DivisionById($id: String!) {
                  divisionById(id: $id) {
                    id
                    name
                    description
                  }
                }
                """;
    }

    /**
     * Update Division
     */
    public static String updateDivisionQuery() {

        return """
                mutation UpdateDivision($id: String!, $input: DivisionInput!) {
                  updateDivision(id: $id, input: $input) {
                    id
                    name
                  }
                }
                """;
    }

    /**
     * Delete Division
     */
    public static String deleteDivisionQuery() {

        return """
                mutation DeleteDivision($id: String!) {
                  deleteDivision(id: $id)
                }
                """;
    }

}