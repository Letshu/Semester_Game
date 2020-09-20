import java.util.Arrays;

public class UsefulMethods_23605383 {
    public static int WarriorRow =0;
    public static int WarriorColumn=0;
    public static boolean MagicActivation(String[][] temp){
        int row = temp.length;
        int column = temp[0].length;
        boolean Stone = false;
        boolean Water = false;
        boolean Flame = false;
        boolean Air = false;
        String name= "";
        for(int i=0;i<temp.length;i++){
            for (int j=0;j< temp[0].length;j++){
                int count=0;
                if((i>0 && i< row-1) && (j>0 && j<column-1)){
                    if(temp[i][j].contains("c")){
                        name= temp[i+1][j+1];
                        for(int k=0; k< name.length();k++){
                            switch(name.charAt(k)){
                                case 'A':
                                    Air = true;
                                    count++;
                                    break;
                                case 'W':
                                    Water=true;
                                    count++;
                                    break;
                                case 'F':
                                    Flame= true;
                                    count++;
                                    break;
                                case 'S':
                                    Stone = true;
                                    count++;
                                    break;
                            }
                            if(count == 1){
                                break;
                            }
                        }
                        name= temp[i+1][j-1];
                        for(int k=0; k< name.length();k++){
                            switch(name.charAt(k)){
                                case 'A':
                                    Air = true;
                                    count++;
                                    break;
                                case 'W':
                                    Water=true;
                                    count++;
                                    break;
                                case 'F':
                                    Flame= true;
                                    count++;
                                    break;
                                case 'S':
                                    Stone = true;
                                    count++;
                                    break;
                            }
                            if(count == 1){
                                break;
                            }
                        }
                        name= temp[i-1][j-1];
                        for(int k=0; k< name.length();k++){
                            switch(name.charAt(k)){
                                case 'A':
                                    Air = true;
                                    count++;
                                    break;
                                case 'W':
                                    Water=true;
                                    count++;
                                    break;
                                case 'F':
                                    Flame= true;
                                    count++;
                                    break;
                                case 'S':
                                    Stone = true;
                                    count++;
                                    break;
                            }
                            if(count == 1){
                                break;
                            }
                        }
                        name= temp[i-1][j+1];
                        for(int k=0; k< name.length();k++){
                            switch(name.charAt(k)){
                                case 'A':
                                    Air = true;
                                    count++;
                                    break;
                                case 'W':
                                    Water=true;
                                    count++;
                                    break;
                                case 'F':
                                    Flame= true;
                                    count++;
                                    break;
                                case 'S':
                                    Stone = true;
                                    count++;
                                    break;
                            }
                            if(count == 1){
                                break;
                            }
                        }
                    }
                }
                if( Stone && Water && Flame && Air){
                    return true;
                }
                if(i>0 && j==0){
                    name = temp[i-1][j+1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name = temp[i+1][j+1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name = temp[i-1][column-1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name = temp[i+1][column-1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    if(Stone && Air && Water && Flame){
                        return true;
                    }

                }
                if(i>0 &&j== column -1){
                    name = temp[i+1][j-1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name = temp[i-1][j-1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name = temp[i-1][0];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name= temp[i+1][0];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    if(Stone && Flame && Water && Air){
                        return true;
                    }
                }
                if( i==0 && j==0){
                    name = temp[i+1][j+1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name = temp[i+1][column-1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name = temp[row-1][column-1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    name= temp[row-1][1];
                    for(int k=0; k< name.length();k++){
                        switch(name.charAt(k)){
                            case 'A':
                                Air = true;
                                count++;
                                break;
                            case 'W':
                                Water=true;
                                count++;
                                break;
                            case 'F':
                                Flame= true;
                                count++;
                                break;
                            case 'S':
                                Stone = true;
                                count++;
                                break;
                        }
                        if(count == 1){
                            break;
                        }
                    }
                    if(Stone && Air && Water && Flame){
                        return true;
                    }
                }
                //do the other corners except the corner of 0,0
            }
        }
        return false;
    }
    public static boolean checkNumberWarriors(String[][] temp){
        for (int i=0;i<temp.length;i++){
            for (int j=0;j< temp[0].length;j++){
                if(temp[i][j].length() >10){
                    if(NumberOfWarriors(temp[i][j])>10){
                        WarriorRow=i;
                        WarriorColumn=j;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static int NumberOfWarriors(String temp){
        int countWarrior=0;
        for(int i=0;i<temp.length();i++){
            switch(temp.charAt(i)){
                case 'A':
                    countWarrior++;
                    break;
                case 'F':
                    countWarrior++;
                    break;
                case 'S':
                    countWarrior++;
                    break;
                case 'W':
                    countWarrior++;
                    break;
            }
        }
        return countWarrior;
    }
    public static void AddWater(String[][] temp){
        /*
        This method checks if there's 3 water object in the neighborhood of a cell that doesn't have water object
         */
        int count =0;
        for(int i=0;i<temp.length;i++){
            for (int j = 0; j <temp[i].length ; j++) {
                if(!temp[i][j].contains("w")){
                    if((i>0 && i<temp.length-1) && (j>0 && j<temp[0].length-1)){
                        count = NumberOfWarrior(temp[i-1][j+1])+NumberOfWarrior(temp[i-1][j-1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i+1][j+1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i+1][j-1])+NumberOfWarrior(temp[i][j-1]);
                    }
                    if(i == temp.length-1 && (j>0 && j<temp[0].length-1)){
                        count= NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[i-1][j+1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i-1][j-1])+NumberOfWarrior(temp[0][j+1])+NumberOfWarrior(temp[0][j])+NumberOfWarrior(temp[0][j-1]);
                    }
                    if(i==0 && (j>0 && j<temp[0].length-1)){
                        count= NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[i+1][j+1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i+1][j-1])+NumberOfWarrior(temp[temp.length-1][j+1])+NumberOfWarrior(temp[temp.length-1][j-1])+NumberOfWarrior(temp[temp.length-1][j]);
                    }
                    if(i==0 && j==0){
                        count = NumberOfWarrior(temp[i+1][j+1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[temp.length-1][j+1])+NumberOfWarrior(temp[temp.length-1][j])+NumberOfWarrior(temp[temp.length-1][temp[0].length-1])+NumberOfWarrior(temp[0][temp[0].length-1])+NumberOfWarrior(temp[i+1][temp[0].length-1]);
                    }
                    if(i==0 && j== temp[0].length-1){
                        count = NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i+1][j-1])+NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[temp.length-1][j-1])+NumberOfWarrior(temp[temp.length-1][j])+NumberOfWarrior(temp[temp.length-1][0])+NumberOfWarrior(temp[0][0])+NumberOfWarrior(temp[1][0]);
                    }
                    if(i== temp.length-1 && j== temp[0].length-1){
                        count = NumberOfWarrior(temp[i-1][j-1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[0][temp[0].length-1])+NumberOfWarrior(temp[0][j-1])+NumberOfWarrior(temp[0][0])+NumberOfWarrior(temp[i-1][0])+NumberOfWarrior(temp[temp.length-1][0]);
                    }
                    if (i== temp.length-1 && j==0){
                        count = NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i-1][j+1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i-1][temp.length-1])+NumberOfWarrior(temp[i][temp[0].length-1])+NumberOfWarrior(temp[0][temp[0].length-1])+NumberOfWarrior(temp[0][j])+NumberOfWarrior(temp[0][j+1]);
                    }
                    if(j==0 && (i>0 && i<temp.length-1)){
                        count = NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i+1][j+1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i-1][j+1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i-1][temp[0].length-1])+NumberOfWarrior(temp[i][temp[0].length-1])+NumberOfWarrior(temp[i+1][temp[0].length-1]);
                    }
                    if(j== temp[0].length-1 && (i>0 && i<temp.length-1)){
                        count = NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i-1][j-1])+NumberOfWarrior(temp[i+1][j-1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i+1][0])+NumberOfWarrior(temp[i][0])+NumberOfWarrior(temp[i-1][0]);
                    }
                    if(count == 3){
                        temp[i][j] += "w";
                    }
                }
            }
        }
    }
    public static void waterNeighbor(String[][] temp){
        int count =0;
        for(int i=0;i< temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                if(temp[i][j].contains("w")){
                    if((i>0 && i<temp.length-1) && (j>0 && j<temp[0].length-1)){
                        count = NumberOfWarrior(temp[i-1][j+1])+NumberOfWarrior(temp[i-1][j-1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i+1][j+1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i+1][j-1])+NumberOfWarrior(temp[i][j-1]);
                    }
                    if(i == temp.length-1 && (j>0 && j<temp[0].length-1)){
                        count= NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[i-1][j+1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i-1][j-1])+NumberOfWarrior(temp[0][j+1])+NumberOfWarrior(temp[0][j])+NumberOfWarrior(temp[0][j-1]);
                    }
                    if(i==0 && (j>0 && j<temp[0].length-1)){
                        count= NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[i+1][j+1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i+1][j-1])+NumberOfWarrior(temp[temp.length-1][j+1])+NumberOfWarrior(temp[temp.length-1][j-1])+NumberOfWarrior(temp[temp.length-1][j]);
                    }
                    if(i==0 && j==0){
                        count = NumberOfWarrior(temp[i+1][j+1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[temp.length-1][j+1])+NumberOfWarrior(temp[temp.length-1][j])+NumberOfWarrior(temp[temp.length-1][temp[0].length-1])+NumberOfWarrior(temp[0][temp[0].length-1])+NumberOfWarrior(temp[i+1][temp[0].length-1]);
                    }
                    if(i==0 && j== temp[0].length-1){
                        count = NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i+1][j-1])+NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[temp.length-1][j-1])+NumberOfWarrior(temp[temp.length-1][j])+NumberOfWarrior(temp[temp.length-1][0])+NumberOfWarrior(temp[0][0])+NumberOfWarrior(temp[1][0]);
                    }
                    if(i== temp.length-1 && j== temp[0].length-1){
                        count = NumberOfWarrior(temp[i-1][j-1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[0][temp[0].length-1])+NumberOfWarrior(temp[0][j-1])+NumberOfWarrior(temp[0][0])+NumberOfWarrior(temp[i-1][0])+NumberOfWarrior(temp[temp.length-1][0]);
                    }
                    if (i== temp.length-1 && j==0){
                        count = NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i-1][j+1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i-1][temp.length-1])+NumberOfWarrior(temp[i][temp[0].length-1])+NumberOfWarrior(temp[0][temp[0].length-1])+NumberOfWarrior(temp[0][j])+NumberOfWarrior(temp[0][j+1]);
                    }
                    if(j==0 && (i>0 && i<temp.length-1)){
                        count = NumberOfWarrior(temp[i][j+1])+NumberOfWarrior(temp[i+1][j+1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i-1][j+1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i-1][temp[0].length-1])+NumberOfWarrior(temp[i][temp[0].length-1])+NumberOfWarrior(temp[i+1][temp[0].length-1]);
                    }
                    if(j== temp[0].length-1 && (i>0 && i<temp.length-1)){
                        count = NumberOfWarrior(temp[i][j-1])+NumberOfWarrior(temp[i-1][j])+NumberOfWarrior(temp[i-1][j-1])+NumberOfWarrior(temp[i+1][j-1])+NumberOfWarrior(temp[i+1][j])+NumberOfWarrior(temp[i+1][0])+NumberOfWarrior(temp[i][0])+NumberOfWarrior(temp[i-1][0]);
                    }
                }
                if(count <= 1 || count >= 4){
                    temp[i][j]=RemoveWater(temp[i][j]);
                }
            }


        }

    }
    public static String RemoveWater(String temp){
        temp = temp.replace("w","");
        return temp;
    }
    public  static boolean[][] WarriorNeighborhood(String[][] temp,int i,int j){
        /*
        this method returns the neighborhood of a warrior in terms of an 2d array
        where its neighborhood cell is set to true
         */
        boolean[][] t = new boolean[temp.length][temp[0].length];
        for (int k = 0; k < temp.length; k++) {
            for (int l = 0; l <temp[i].length ; l++) {
                t[k][l] = false;
            }
        }
        if ((i>0 && i<temp.length-1) && (j>0 && j<temp[0].length-1)){
            t[i+1][j-1]= true;
            t[i+1][j]=true;
            t[i+1][j+1]=true;
            t[i][j+1]=true;
            t[i][j-1]=true;
            t[i-1][j-1]=true;
            t[i-1][j]=true;
            t[i-1][j+1]=true;
        }
        if (i == temp.length-1 && (j>0 && j<temp[0].length-1)){
            t[i-1][j-1]=true;
            t[i-1][j]=true;
            t[i-1][j+1]=true;
            t[i][j+1]=true;
            t[i][j-1]=true;
            t[0][j-1] =true;
            t[0][j]=true;
            t[0][j+1]=true;
        }
        if(i==0 && (j>0 && j<temp[0].length-1)){
            t[i+1][j-1]= true;
            t[i+1][j]=true;
            t[i+1][j+1]=true;
            t[i][j+1]=true;
            t[i][j-1]=true;
            t[temp.length-1][j-1] = true;
            t[temp.length-1][j] = true;
            t[temp.length-1][j+1] = true;
        }
        if (j==0 && (i>0 && i<temp.length-1)){
            t[i][j+1]=true;
            t[i+1][j+1]=true;
            t[i+1][j]=true;
            t[i-1][j+1]=true;
            t[i-1][j]=true;
            t[i-1][temp[0].length-1]=true;
            t[i][temp[0].length-1]=true;
            t[i-1][temp[0].length-1]=true;
        }
        if(j==temp[0].length &&(i>0 && i<temp[0].length-1)){
            t[i][j-1]=true;
            t[i-1][j-1]=true;
            t[i+1][j-1]=true;
            t[i+1][j]=true;
            t[i-1][j]=true;
            t[i][0]=true;
            t[i-1][0]=true;
            t[i+1][0]=true;
        }
        if(j== temp[0].length-1 && i== temp.length-1){
            t[i][j-1]=true;
            t[i-1][j-1]=true;
            t[i-1][j]=true;
            t[i-1][0]=true;
            t[i][0]=true;
            t[0][j-1]=true;
            t[0][j]=true;
            t[0][0]=true;
        }
        if(i==0 && j==0){
            t[i][j+1]=true;
            t[i+1][j+1]=true;
            t[i+1][j]=true;
            t[i+1][temp[0].length-1] = true;
            t[i][temp[0].length-1]=true;
            t[temp.length-1][j] = true;
            t[temp.length-1][j+1] = true;
            t[temp.length-1][temp[0].length-1] = true;

        }
        if(i==0 && j== temp.length-1){
            t[i][j-1]=true;
            t[i+1][j]=true;
            t[i+1][j-1]=true;
            t[i][0]=true;
            t[i+1][0]=true;
            t[temp.length-1][0]=true;
            t[temp.length-1][j]=true;
            t[temp.length-1][j-1]=true;
        }
        if(i== temp.length-1 && j==0){
            t[i][j+1]=true;
            t[i-1][j+1]=true;
            t[i-1][j]=true;
            t[i-1][temp[0].length-1]=true;
            t[i][temp[0].length-1]=true;
            t[0][temp[0].length-1]=true;
            t[0][0]=true;
            t[0][j+1]=true;
        }
        return t;
    }
    public static int NumberOfWarrior(String temp){
        /*
        This methods counts specifically the number of water piece in a cell
         */
        int count =0;
        for (int i = 0; i < temp.length() ; i++) {
            if (temp.charAt(i) == 'w') {
                count++;
            }
        }
        return count;
    }
    public static void printWarrior(Warrior_23605383[] t){
        for (int i = 0; i <t.length ; i++) {
            System.out.println(t[i]);
        }
    }
    public static void sortWarrior(Warrior_23605383[] t){
        //This methods sorts the warriors that are in the same cell
        for (int i = 0; i <t.length ; i++) {
            for (int j = i; j <t.length ; j++) {
                if(t[i].getPlayerRow() == t[j].getPlayerRow() && t[i].getPlayerColumn() == t[j].getPlayerColumn()){
                    if(t[i].getID() > t[j].getID()){
                        Warrior_23605383 temp = t[i];
                        t[i] = t[j];
                        t[j]= temp;
                    }
                }
            }
        }
    }
    public static String removeCharAt(String s, int i) {
        if (i == 0) {
            return s.substring(1);
        }

        if (i == s.length() - 1) {
            return s.substring(0, s.length() - 1); // up to and excluding the last char
        }

        // up to and excluding char at i, then concatenate from char at i + 1 to the end of the String
        return s.substring(0, i) + s.substring(i + 1);
    }
    public static void removeAddDot(String[][] temp){
        for (int i = 0; i <temp.length ; i++) {
            for (int j = 0; j <temp[i].length ; j++) {
                if(temp.length >1){
                    temp[i][j] = removeCharAt(".",temp[i][j].indexOf("."));
                }
            }
        }
    }
}
