import groovy.json.JsonSlurper
import main.groovy.Equalator
import main.groovy.Person

//Person p1 = new Person(name: 'denik', age: 12)
//Person p2 = new Person(name: 'denik', age: 12)

def resp = new JsonSlurper().parse(new URL("https://currency-api.appspot.com/api/EUR/RUB.json")).rate;

//for (def i in 0..10) println(i )

String str = "minsk.dfg"

str = str[0..-5]
println str;

def pers = [new Person(age: 112), new Person(age: 10)]
pers.each { it.age += 10 }
println(pers.age)


void printFunc(String name, Closure clous) {
    println clous(name)
}

printFunc('denik'){name -> name.replace("e", "a")}

def person = new Person(age: 122, name: 'Denik');

def count = new Equalator().calcDuplicates(pers, person, {p1, p2 -> p1.age == p2.age});

println(count);

//person.metaClass.name = 'Вася';
person.metaClass.do << {println("hi, ${delegate.name}")}

person.do();

person.metaClass.propertyMissing = {println 'No property 1.'}
person.aa;


