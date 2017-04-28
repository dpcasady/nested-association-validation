package nested.association.validation

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class BusinessSpec extends Specification {

    void "invalid business has errors"() {
        given: "an invalid business"
        Business b = new Business(name: null)

        and: "a valid employee that belongs to the business"
        Person p = new Employee(business: b)
        b.addToPeople(p)

        when:
        b.save()
        // Validation causes a NotReadablePropertyException: Invalid property 'people[0].people[0]'

        then:
        !b.hasErrors()
    }
}
