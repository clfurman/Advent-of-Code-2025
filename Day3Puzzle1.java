void main() throws IOException{
    String battery;
    File input = new File("inputday3.txt");
    Scanner in = new Scanner(input);
    int totalJoltage = 0;
    while (in.hasNext()) {
        battery = in.nextLine();
        int maxJoltage = Integer.parseInt(battery.substring(0, 2));
        for (int index = 0; index < battery.length(); index++) {
            int digit1 = Integer.parseInt(battery.substring(index, index + 1));
            for (int index2 = index + 1; index2 < battery.length(); index2++) {
                if (index != index2) {
                    int digit2 = Integer.parseInt(battery.substring(index2, index2 + 1));
                    int joltage = digit1 * 10 + digit2;
                    if (joltage > maxJoltage) {
                        maxJoltage = joltage;
                    }
                }
            }

        }
        totalJoltage += maxJoltage;
    }
    IO.println(totalJoltage);
}
