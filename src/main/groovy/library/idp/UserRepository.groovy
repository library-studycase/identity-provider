package library.idp

import grails.transaction.Transactional
import org.apache.commons.collections.map.HashedMap

import javax.annotation.PostConstruct

@Transactional
class UserRepository {

    private final Map<String, UserWithCredentials> users = new HashMap<>()

    @PostConstruct
    private def onConstructed() {

    }
}
