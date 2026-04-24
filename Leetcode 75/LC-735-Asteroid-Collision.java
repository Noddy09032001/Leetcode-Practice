class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> collisions = new Stack<>(); // storing the details of the collisions
        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            if (curr < 0) {
                boolean destroyed = false;
                while (!collisions.isEmpty() && collisions.peek() > 0) {
                    int top = collisions.peek();
                    if (top < -curr) {
                        collisions.pop(); // top explodes
                    } else if (top == -curr) {
                        collisions.pop(); // both explode
                        destroyed = true;
                        break;
                    } else {
                        destroyed = true; // current explodes
                        break;
                    }
                }
                if (!destroyed) {
                    collisions.push(curr);
                }
            } else {
                collisions.push(curr);
            }
        }

        // convert stack to array
        int[] res = new int[collisions.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = collisions.pop();
        }

        return res;
    }
}