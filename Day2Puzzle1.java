void main() throws IOException{
    String ids;
    File input = new File("inputday2.txt");
    Scanner in = new Scanner(input);
    ids = in.nextLine();
  
    long total = 0;
    String[] idRanges = ids.split(",");
    for (String range : idRanges) {
        int dash = range.indexOf("-");
        long start = Long.parseLong(range.substring(0,dash));
        long end = Long.parseLong(range.substring(dash + 1));
        for (long id = start; id <= end; id++) {
            String idString = "" + id;
          
            if (idString.length() % 2 == 0) {
                String first = idString.substring(0, idString.length() / 2);
                String last = idString.substring(idString.length() / 2);
              
                if (first.equals(last)) {
                    total += id;
                }
            }
        }
    }
    IO.println(total);
}
