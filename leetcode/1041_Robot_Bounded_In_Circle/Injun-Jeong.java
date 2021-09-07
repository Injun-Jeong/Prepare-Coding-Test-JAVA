package leetcode;

public class Q1041_Robot_Bounded_In_Circle {
    String[] instruction;
    Node node;
    String dir = "up";  // dir = [up, left, right, down]

    class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isRobotBounded(String instructions) {
        boolean answer = false;
        instruction = instructions.split("");

        node = new Node(0,0);
        for ( int cnt = 0; cnt < instructions.length() * 4; cnt++ ) {
            simulation();

            if (node.x == 0 && node.y == 0) {
                answer = true;
                break;
            }
        }

        return answer;
    }


    private void simulation() {
        for (String inst : instruction) {
            if (inst.equals("G")) {
                go(inst);
            } else {
                turnDir(inst);
            }
        }
    }

    private void go(String instruction) {
        if ( dir.equals("up") ) {
            node.y = node.y + 1;
        } else if ( dir.equals("left") ) {
            node.x = node.x - 1;
        } else if ( dir.equals("down") ) {
            node.y = node.y - 1;
        } else if ( dir.equals("right") ) {
            node.x = node.x + 1;
        }
    }

    private void turnDir(String instruction) {
        if ( instruction.equals("L") ) {
            if ( dir.equals("up") ) {
                dir = "left";
            } else if ( dir.equals("left") ) {
                dir = "down";
            } else if ( dir.equals("down") ) {
                dir = "right";
            } else if ( dir.equals("right") ) {
                dir = "up";
            }
        } else {
            if ( dir.equals("up") ) {
                dir = "right";
            } else if ( dir.equals("right") ) {
                dir = "down";
            } else if ( dir.equals("down") ) {
                dir = "left";
            } else if ( dir.equals("left") ) {
                dir = "up";
            }
        }
    }
}
