package automation.api.bodies.announcement;

public final class AnnouncementBodies {

    private AnnouncementBodies() {
    }

    public static String createAnnouncementQuery() {

        return """
                mutation CreateAnnouncement($input: AnnouncementInput!) {
                  createAnnouncement(input: $input) {
                    id
                    title
                    content
                  }
                }
                """;
    }

    public static String getAnnouncementQuery() {

        return """
                query AnnouncementById($id: String!) {
                  announcementById(id: $id) {
                    id
                    title
                    content
                  }
                }
                """;
    }

    public static String updateAnnouncementQuery() {

        return """
                mutation UpdateAnnouncement($id: String!, $input: AnnouncementInput!) {
                  updateAnnouncement(id: $id, input: $input) {
                    id
                    title
                  }
                }
                """;
    }

}