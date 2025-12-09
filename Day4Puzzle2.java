void main() throws IOException{
    File input = new File("inputday4.txt");
    Scanner in = new Scanner(input);
    int rows = 0;
    int cols = 0;
    //determine the number of rows and cols
    while (in.hasNext()) {
        String row = in.nextLine();
        rows++;
        cols = row.length();
    }
    String[][] inventory = new String [rows][cols];
    String[][] updatedInventory = new String[rows][cols];
    int r = 0;
    Scanner in2 = new Scanner(input);

    //Set up inventory
    while (in2.hasNext()) {
        String row = in2.nextLine();
        for (int ind = 0; ind < row.length(); ind++) {
            inventory[r][ind] = row.substring(ind,ind + 1);
        }
        r++;
    }


    int totalRemovable = 0; 
    int removable = 1; 
    int pass = 0; 
    while (removable > 0) {
        removable = 0;
        pass++;
    for (int theRow = 0; theRow < inventory[0].length; theRow++) {
        for (int theCol = 0; theCol < inventory.length; theCol++) {
            int count = 0;
            if (inventory[theRow][theCol].equals("@")) {
                for (int nearRow = theRow - 1; nearRow <= theRow + 1; nearRow++) {
                    for (int nearCol = theCol - 1; nearCol <= theCol + 1; nearCol++) {
                        if (nearRow >= 0 && nearRow < inventory[0].length) {
                            if (nearCol >= 0 && nearCol < inventory.length) {
                                if (nearCol != theCol || nearRow != theRow) {
                                    if (inventory[nearRow][nearCol].equals ("@")) {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
                if (count < 4) {
                    removable++;
                    totalRemovable++;
                    updatedInventory[theRow][theCol] = "x";
                }
                else {
                    updatedInventory[theRow][theCol] = inventory[theRow][theCol];
                }
            } else {
                updatedInventory[theRow][theCol] = inventory[theRow][theCol];
            }
        }

    }

    inventory = updatedInventory;
    }
    IO.println(totalRemovable);
}
