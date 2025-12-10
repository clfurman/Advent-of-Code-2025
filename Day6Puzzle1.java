record MathProblem (ArrayList<Integer> problems, String operation) {
    long compute () {
        long total; 
        if (operation.equals("+")) {
            total = 0;
            for (Integer num : problems) {
                total += num;
            }
        } else {
            total = 1; 
            for (Integer num : problems) {
                total *= num;
            }
        }
        IO.println("Problem answer: " + total);
        return total;
    }

}

void main() throws IOException{
    File input = new File("inputday6.txt");
    Scanner in = new Scanner(input);
    ArrayList<String> lines = new ArrayList<>();
    Long total = Long.parseLong("0");
    while (in.hasNext()) {
        String line = in.nextLine();
        lines.add(line);
    }
    IO.println(lines);
    for (int index = 0; index < lines.size(); index++) {
        lines.set(index, clean(lines.get(index)));
    }
    IO.println(lines);
    
 
    String oper; 
    int totalProblems = lines.get(0).split(" ").length;
    for (int numProbs = 0; numProbs < totalProblems; numProbs++) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int linesIndex = 0; linesIndex < lines.size() - 1; linesIndex++) {
            String line = lines.get(linesIndex);
            String[] parsedLine = line.split(" ");
            nums.add(Integer.parseInt(parsedLine[numProbs]));
        }
        String probOps = lines.get(lines.size() - 1);
        String[] operSplit = probOps.split(" ");
        oper = operSplit[numProbs];
        IO.println("numbers to do operations" + nums + "operation: " + oper);
        MathProblem problem = new MathProblem(nums, oper);
        total += problem.compute();
    }
    IO.println(total); 
}

String clean (String line) {
    int spaceInd = line.indexOf(" ");    
    while(spaceInd != -1) {
        if (spaceInd == 0) {
            line = line.substring(spaceInd + 1);
            spaceInd--;
        } else {
            if (line.substring(spaceInd - 1, spaceInd).equals (" ")) {
                line = line.substring(0, spaceInd) + line.substring(spaceInd + 1);
                spaceInd--;
            }
        }
        spaceInd = line.indexOf(" ", spaceInd + 1);
    }
    IO.println(line);
    return line;
}
