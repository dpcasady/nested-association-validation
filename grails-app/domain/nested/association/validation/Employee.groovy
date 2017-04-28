package nested.association.validation

class Employee extends Person {

    static belongsTo = [
        business: Business
    ]

}
