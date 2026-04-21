import java.util.*;

public class SocialNetwork {

    static HashMap<Integer, List<Integer>> graph = new HashMap<>();

    static void addUser(int u) {
        graph.putIfAbsent(u, new ArrayList<>());
    }

    static void addFriend(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void suggestFriends(int user) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(user);
        visited.add(user);

        System.out.print("Suggested Friends: ");

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int nei : graph.get(curr)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.add(nei);
                    System.out.print(nei + " ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        addUser(1);
        addUser(2);
        addUser(3);
        addUser(4);
        addUser(5);

        addFriend(1, 2);
        addFriend(1, 3);
        addFriend(2, 4);
        addFriend(3, 5);

        suggestFriends(1);
    }
}
