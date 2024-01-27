import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person {

    String name;
    int level;

    public Person(String name, int level) {
        this.name = name;
        this.level = level;
    }

}

// 20006
public class Main {

    static int p, m, l;
    static String n;
    static ArrayList<Queue<Person>> arrayList = new ArrayList<>();
    static Queue<Person> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        p = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < p; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            l = Integer.parseInt(stringTokenizer.nextToken());
            n = stringTokenizer.nextToken();
            if (arrayList.size() == 0) {
                queue = new LinkedList<>();
                queue.offer(new Person(n, l));
                arrayList.add(queue);
                continue;
            }
            int len = arrayList.size();
            for (int j = 0; j < len; j++) {
                Queue<Person> curRoom = arrayList.get(j);
                if (curRoom.peek().level - 10 <= l && l <= curRoom.peek().level + 10) {
                    if (curRoom.size() < m) {
                        curRoom.offer(new Person(n, l));
                        break;
                    }
                    if (j == arrayList.size() - 1) {
                        queue = new LinkedList<>();
                        queue.offer(new Person(n, l));
                        arrayList.add(queue);
                        break;
                    }
                    if (curRoom.size() == m) {
                        continue;
                    }
                }
                if (j == arrayList.size() - 1) {
                    queue = new LinkedList<>();
                    queue.offer(new Person(n, l));
                    arrayList.add(queue);
                    break;
                }
            }
        }

        for (Queue<Person> room : arrayList) {
            Person[] persons = new Person[room.size()];
            room.toArray(persons);
            if (persons.length > 1) {
                Arrays.sort(persons, Comparator.comparing(o -> o.name));
            }
            if (room.size() == m) {
                System.out.println("Started!");
                for (int j = 0; j < m; j++) {
                    System.out.println(persons[j].level + " " + persons[j].name);
                }
                continue;
            }
            System.out.println("Waiting!");
            for (Person person : persons) {
                System.out.println(person.level + " " + person.name);
            }
        }
    }
}