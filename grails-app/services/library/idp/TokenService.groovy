package library.idp

import grails.transaction.Transactional

@Transactional
class TokenService {

    def renew(Credentials credentials) {
        new Token(value: 'some-random-UUID-value')
    }
}
