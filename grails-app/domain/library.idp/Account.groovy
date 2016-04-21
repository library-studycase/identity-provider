package library.idp

class Account {

    Integer nativeId

    String login
    Set<String> roles

    Date registered
    Date lastModified

    static transients = ['roles', 'registered', 'lastModified']
}
