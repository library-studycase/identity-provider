package library.idp

class User {

    Integer nativeId

    String login
    Set<String> roles

    Date registered
    Date lastModified
    Date lastActed

    String token
}
