record Rotation (String direction, int amount) {}
void main() throws IOException{
    int password = getCode();
    IO.println(password);
}

int getCode() throws IOException {
    File combos = new File("input.txt");
    int currentDialSpot = 50;
    int zerocount = 0;
    Scanner input = new Scanner (combos);
    while (input.hasNext()) {
        String combo = input.nextLine();
        Rotation rotate = new Rotation (combo.substring(0,1), Integer.parseInt(combo.substring(1))); 
        currentDialSpot = nextDialSpot (currentDialSpot, rotate);
        if (currentDialSpot == 0) {
            zerocount++;
        }
    }
    return zerocount;
}

int nextDialSpot (int current, Rotation rotate) {
    int nextSpot = current;
    if (rotate.direction().equals("R")) {
        nextSpot = (current + rotate.amount()) % 100;
    } else {
        nextSpot = current - rotate.amount();
        while (nextSpot < 0) {
            nextSpot = 100 + nextSpot;
        }
    }
    return nextSpot;
}
