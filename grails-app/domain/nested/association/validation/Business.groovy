package nested.association.validation

class Business {

    String name

    static hasMany = [
        people: Person
    ]

}
