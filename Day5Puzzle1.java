void main() throws IOException{
    File input = new File("inputday5.txt");
    Scanner in = new Scanner(input);
    ArrayList<String> ranges = new ArrayList<>();
    ArrayList<Long> ids = new ArrayList<>();
    while (in.hasNext()) {
        String line = in.nextLine();
        if (line.indexOf("-") > 0) {
            ranges.add(line);
        } else {
            if (line.length() > 0) {
                ids.add(Long.parseLong(line));
            }
        }
    }
    int numFresh = 0;
    boolean found = false;
    for (Long id : ids) {
        found = false;
        for (String range : ranges) {
            int dashIndex = range.indexOf("-");
            long start = Long.parseLong(range.substring(0, dashIndex));
            long end = Long.parseLong(range.substring(dashIndex + 1));
            if (!found && (start <= id && id <= end)) {
                found = true;
                numFresh++;
            }
        }
    }
    IO.println(numFresh);
}
