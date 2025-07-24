public class TestStudents {
    public Test() {
        Student s1 = new Student("Fred", 3.0F);
        Student s2 = new Student("Sam", 3.5F);
        Student s3 = new Student("Steve", 2.1F);
        if (s3.compareTo((Object)s2) < 0)
        System.out.println(s3.getName() + " has a lower gpa than " + s2.getName());
//Set is an interface in Java ; TreeSet is its implementation
        Set studentSet = new TreeSet();
//Method of set add(element)
        studentSet.add(s1); studentSet.add(s2); studentSet.add(s3);
//Iterator interface access elements of Map, List, Set
        Iterator i = studentSet.iterator();
//method of Iterator hasNext()
        while(i.hasNext()) System.out.println( ((Student)i.next()).getName());
    }
}