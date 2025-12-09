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
 
            for (int ind = 1; ind <= idString.length() / 2; ind++) {
              String part = idString.substring(0, ind);
      
              boolean match = true;
              if (idString.length() % part.length() == 0) {

                for (int ind2 = part.length(); ind2 < idString.length() && match; ind2 += part.length()){
                  String nextPart = idString.substring(ind2, ind2 + part.length());
                  if (!part.equals(nextPart)) {
                     match = false;
                  }
              }
              if (match) {
                total += id;
                ind = idString.length();
              }
            }
          }
        }
    }
    IO.println(total);
}
