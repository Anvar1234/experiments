package org.example.enums;

enum Direction {
    NORTH{
        Direction getOppositeDirection(){
            return SOUTH;
        }
    }, SOUTH{
        Direction getOppositeDirection(){
            return NORTH;
        }
    }, EAST{
        Direction getOppositeDirection(){
            return WEST;
        }
    }, WEST{
        Direction getOppositeDirection(){
            return EAST;
        }
    };

    abstract Direction getOppositeDirection();
//    {
//        switch (direction) {
//            case NORTH:
//                return SOUTH;
//            case SOUTH:
//                return NORTH;
//            case EAST:
//                return WEST;
//            case WEST:
//                return EAST;
//            default:
//                throw new IllegalArgumentException("Invalid direction: " + direction);
//        }
//    }



    public static void main(String[] args) {
        Direction currentDirection = Direction.NORTH;
        Direction oppositeDirection = currentDirection.getOppositeDirection();
        System.out.println("Opposite direction of " + currentDirection + " is " + oppositeDirection);
    }

}