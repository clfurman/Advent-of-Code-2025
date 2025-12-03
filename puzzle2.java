record Rotation (String direction, int amount) {}
record RotationResults (int endSpot, int updateZero) {}

void main() throws IOException {
    int passcode = getCount();
    IO.println(passcode);
}

int getCount () throws IOException {
    File input = new File("input.txt");
    Scanner in = new Scanner (input);
    int startSpot = 50;
    int zeroCount = 0;
    while (in.hasNext()) {
        String line = in.nextLine();
        String direction = line.substring (0, 1);
        int amount = Integer.parseInt(line.substring(1));
        Rotation currentRotation = new Rotation (direction, amount);
       // IO.println(currentRotation);
        RotationResults results = updateRotation(startSpot, currentRotation);
        zeroCount += results.updateZero();
        startSpot = results.endSpot();
    }
    return zeroCount;
}

RotationResults updateRotation (int start, Rotation rotate) {
    int endSpot = start;
    int zeroCount = 0;
   
    if (rotate.direction().equals("R")) {
        endSpot = (start + rotate.amount());
        while (endSpot > 100) {
            zeroCount++;
            endSpot -= 100;
        }
        if (endSpot == 100) {
            endSpot = 0;
        }
    }
    else {
        endSpot = start - rotate.amount();
        IO.println(endSpot);

        //avoid duplicate counting 0 if we are less than 0, and started at 0.
        if (endSpot < 0 && start == 0) {
            zeroCount--;
        }
        while (endSpot < 0) {
            zeroCount++;
            endSpot = 100 + endSpot; 
            IO.println("In while: " + endSpot);
        }
    }
    if (endSpot == 0) {
        zeroCount++;
    }

    RotationResults results = new RotationResults(endSpot, zeroCount);
    IO.println(results);
    return results;
}
