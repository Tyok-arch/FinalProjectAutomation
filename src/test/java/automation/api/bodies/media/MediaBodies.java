package automation.api.bodies.media;

public final class MediaBodies {

    private MediaBodies() {
    }

    public static String mediasQuery() {

        return """
                query Medias {
                  medias {
                    id
                    title
                    extension
                    size
                    type
                    mimeType
                    status
                  }
                }
                """;
    }

    public static String countMediasQuery() {

        return """
                query CountMedias {
                  countMedias
                }
                """;
    }

    public static String availableStorageQuery() {

        return """
                query AvailableStorage {
                  availableStorage {
                    max
                    occupied
                    available
                  }
                }
                """;
    }

}