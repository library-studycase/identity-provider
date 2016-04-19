package library.idp

import grails.transaction.Transactional

@Transactional
class UserService {

    def getAll() {
        [new User(id: 'test-id', nativeId: 'test-nativeId', login: 'test-login', roles: ['ADMIN'], registered: 1, lastModified: 4)]
    }
}
