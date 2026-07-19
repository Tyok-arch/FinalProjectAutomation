package automation.api.bodies.angkatan;

public final class AngkatanBodies {

    private AngkatanBodies() {
    }

    /**
     * Create Angkatan
     */
    public static String createAngkatanQuery() {

        return """
                mutation CreateAngkatan($input: AngkatanInput!) {
                  createAngkatan(input: $input) {
                    id
                    name
                    description
                  }
                }
                """;
    }

    /**
     * List Angkatan
     */
    public static String listAngkatanQuery() {

        return """
                query Angkatans {
                  angkatans {
                    id
                    name
                  }
                }
                """;
    }

    /**
     * Get Angkatan
     */
    public static String getAngkatanQuery() {

        return """
                query AngkatanById($id: Float!) {
                  angkatanById(id: $id) {
                    id
                    name
                    description
                  }
                }
                """;
    }

    /**
     * Update Angkatan
     */
    public static String updateAngkatanQuery() {

        return """
                mutation UpdateAngkatan($id: Float!, $input: AngkatanInput!) {
                  updateAngkatan(id: $id, input: $input) {
                    id
                    name
                    description
                  }
                }
                """;
    }

    /**
     * Delete Angkatan
     */
    public static String deleteAngkatanQuery() {

        return """
                mutation DeleteAngkatan($id: Float!) {
                  deleteAngkatan(id: $id)
                }
                """;
    }

}