import java.util.*;
class ijse{
    private static Scanner s = new Scanner(System.in);
    private static String[][] supplier = new String[0][0];
    private static String[] category = new String[0];
    private static String[][] item = new String[0][0];

    public static void login(String uName, String PW){

        boolean isTrue = true;

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|			LOGIN PAGE			|");
        System.out.println("+-------------------------------------------------------+\n");

        while(isTrue){

            System.out.print("User Name : ");
            String username = s.next();

            if(username.equals(uName)){

                while (isTrue){

                    System.out.print("\nPassword : ");
                    String password = s.next();

                    if(password.equals(PW)){

                        isTrue = false;
                    }else{

                        System.out.println("password is incorrect. please try again!");
                    }
                }

            }else{
                System.out.println("user name is invalid. please try again!\n");
            }
        }
        clearConsole();
        mainMenu(uName,PW);
        clearConsole();
    }
    public final static void clearConsole(){

        final String os = System.getProperty("os.name");

        try{

            if (os.equals("Linux")) {

                System.out.print("\033\143");
            } else if (os.equals("Windows")){

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {

                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
        }
    }
    public static void mainMenu(String uName, String PW){

        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|\t\tWELCOME TO IJSE STOCK MANAGEMENT SYSTEM\t\t\t|");
        System.out.println("+-----------------------------------------------------------------------+\n");
        System.out.println("[1] Change the Credentials\t\t[2] Supplier Manage");
        System.out.println("[3] Stock Manage\t\t\t[4] Log out");
        System.out.println("[5] Exit the system\n");

        while(true){

            System.out.print("Enter an option to continue > ");
            String op1 = s.next();

            switch (op1){

                case "1":
                    clearConsole();
                    manageCredentials(uName,PW);
                    clearConsole();
                    break;
                case "2":
                    clearConsole();
                    manageSupplier(uName,PW);
                    clearConsole();
                    break;
                case "3":
                    clearConsole();
                    manageStock(uName,PW);
                    clearConsole();
                    break;
                case "4":
                    clearConsole();
                    logOut(uName,PW);
                    clearConsole();
                case "5":
                    clearConsole();
                    System.exit(5);
                default:

                    System.out.print("invalid number! try again\n\n");
            }
        }
    }
    public static void manageCredentials(String uName, String PW){

        boolean ISTRUE = true;

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tCREDENTIAL MANAGE\t\t\t|");
        System.out.println("+---------------------------------------------------------------+");

        l2:
        while(ISTRUE){
            System.out.print("\nPlease enter the user name to verify it's you: ");
            String uname = s.next();

            if (uname.equals(uName)){

                System.out.println("Hey "+uName);

                l1:
                while(ISTRUE){

                    System.out.print("Enter your current password: ");
                    String pw = s.next();

                    if (pw.equals(PW)){

                        System.out.print("Enter your new password: ");
                        String newPw = s.next();

                        PW = newPw;
                        System.out.print("Password changed successfully! ");
                        while(true){

                            System.out.print("Do you want to go home page (Y/N): ");
                            char flag = s.next().charAt(0);

                            if (flag == 'Y'){

                                clearConsole();
                                mainMenu(uName,PW);
                                return;
                            }else if(flag == 'N'){
                                continue l2;
                            }else{

                                System.out.print("invalid answer try again!!\n\n");
                            }
                        }
                    }else{

                        System.out.print("incorrect password. try again!\n\n");
                    }
                }
            }else{

                System.out.println("invalid user name. try again!");
            }
        }
    }
    public static void manageSupplier(String uName, String PW){


        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tSUPPLIER MANAGE\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");
        System.out.println("[1] Add Supplier\t\t\t[2] Update Supplier");
        System.out.println("[3] Delete Supplier\t\t\t[4] View Suppliers");
        System.out.println("[5] Search Supplier\t\t\t[6] Home Page\n");

        while(true){

            System.out.print("Enter an option to continue > ");
            String op2 = s.next();

            switch (op2){

                case "1":
                    clearConsole();
                    addSupplier(uName,PW);
                    clearConsole();
                    break;
                case "2":
                    clearConsole();
                    updateSupplier(uName,PW);
                    clearConsole();
                    break;
                case "3":
                    clearConsole();
                    deleteSupplier(uName,PW);
                    clearConsole();
                    break;
                case "4":
                    clearConsole();
                    viewSupplier(uName,PW);
                    clearConsole();
                    break;
                case "5":
                    clearConsole();
                    searchSupplier(uName,PW);
                    clearConsole();
                    break;
                case "6":
                    clearConsole();
                    mainMenu(uName,PW);
                    break;
                default:
                    System.out.print("invalid answer.. try again!!\n\n");
            }
        }
    }
    public static void addSupplier(String uName,String PW){

        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tADD SUPPLIER\t\t\t\t|");
        System.out.println("+-----------------------------------------------------------------------+");

        l1:	while(true){

            System.out.print("\nSupplier ID\t: ");
            String ID = s.next();

            for (int i = 0; i < supplier.length; i++){
                if (ID.equals(supplier[i][0])){

                    System.out.print("already exists. try another supplier id!\n");
                    continue l1;
                }
            }
            System.out.print("Supplier Name\t: ");
            String name = s.next();

            grow(ID,name);
            System.out.print("added successfully!");
            l2:	while(true){

                System.out.print("Do you want add another supplier (Y/N)? ");
                char flag3 = s.next().charAt(0);

                if (flag3 == 'Y'){
                    continue l1;
                }else if(flag3 == 'N'){

                    clearConsole();
                    manageSupplier(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("invalid answer.. try again!\n");
                    continue l2;
                }
            }
        }
    }
    public static void grow(String ID, String name){

        String[][] temp = new String[supplier.length + 1][2];

        for (int i = 0; i < supplier.length; i++){
            for (int j = 0; j < supplier[i].length; j++){

                temp[i][j] = supplier[i][j];
            }
        }
        temp[temp.length -1][0] = ID;
        temp[temp.length -1][1] = name;
        supplier = temp;
    }
    public static void updateSupplier(String uName,String PW){

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tUPDATE SUPPLIER\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+");

        boolean isFalse = false;

        l1:	while(true){

            System.out.print("\nSupplier ID	: ");
            String id = s.next();

            if(supplier.length == 0){

                System.out.println("\nerror! you didn't initialize any supplier.. ");

                l3:	while(true){

                    System.out.print("You nedd to add Supplier first...Press \"Y\" for add a supplier : ");
                    char flag4 = s.next().charAt(0);

                    if(flag4 == 'Y'){

                        clearConsole();
                        addSupplier(uName,PW);
                        clearConsole();
                    }else{

                        System.out.println("\ninvalid answer! try again..\n");
                        continue l3;
                    }
                }
            }

            l2:	while(true){

                boolean isTrue = false;

                l5:	for (int i = 0; i < supplier.length; i++){

                    if (id.equals(supplier[i][0])){

                        System.out.print("Supplier Name	: " + supplier[i][1]);

                        System.out.print("\n\nEnter the new supplier name : ");
                        supplier[i][1] = s.next();

                        System.out.print("Updated Successfully! ");

                        break;
                    }
                    if (i == supplier.length - 1){

                        isTrue = true;
                    }
                }
                if (isTrue){

                    System.out.print("can't find supplier id.. try again!\n\n");
                    continue l1;
                }

                l4:	while(true){

                    System.out.print("Do you want to update another supplier ? (Y/N)");
                    char flag = s.next().charAt(0);

                    if(flag == 'Y'){

                        continue l1;
                    }else if(flag == 'N'){

                        clearConsole();
                        manageStock(uName,PW);
                        clearConsole();
                    }else{

                        System.out.println("invalid answer.. try again!\n");
                        continue l4;
                    }
                }
            }
        }
    }
    public static void deleteSupplier(String uName,String PW){

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tDELETE SUPPLIER\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+");

        l1: while(true){

            System.out.print("\nSupplier ID	: ");
            String id = s.next();

            if (supplier.length == 0){

                System.out.println("\nerror! you didn't initialize any supplier.. ");

                l2:	while(true){

                    System.out.print("You nedd to add Supplier first...Press \"Y\" for add a supplier : ");
                    char flag = s.next().charAt(0);

                    if (flag == 'Y'){
                        clearConsole();
                        addSupplier(uName,PW);
                        clearConsole();
                    }else{

                        System.out.println("invalid answer! try again..\n");
                        continue l2;
                    }
                }
            }
            boolean isTrue = false;
            int index = -1;

            l4:	for (int i = 0; i < supplier.length; i++){

                if (id.equals(supplier[i][0])){

                    index = i;
                    break l4;
                }
                if (i == supplier.length - 1){

                    isTrue = true;
                }
            }
            if (isTrue){

                System.out.print("can't find supplier id.. try again!\n");
                continue l1;
            }
            deleteIndex(index);
            System.out.print("deleted successfully! ");
            l3: while(true){
                System.out.print("Do you want to delete another?(Y/N) : ");
                char flag2 = s.next().charAt(0);

                if (flag2 == 'Y'){

                    continue l1;
                }else if(flag2 == 'N'){

                    clearConsole();
                    manageSupplier(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("invalid answer! try again..\n");
                    continue l3;
                }
            }
        }
    }
    public static void deleteIndex(int index){

        String[][] temp = new String[supplier.length - 1][2];


        for (int i = 0,j = 0; i < temp.length; i++,j++){

            if (index == i){
                j++;
            }
            temp[i] = supplier[j];
        }
        supplier = temp;

        if (item.length > 0){
            String[][] temp2 = new String[item.length - 1][6];

            String id = null;
            for (int i = 0; i < supplier.length; i++){

                if (i==index){

                    id = supplier[i][0];
                }
            }
            for (int i = 0,j = 0; i < temp2.length; i++,j++){

                if (id.equals(item[i][1])){

                    j++;
                }
                temp2[i] = item[j];
            }
            item = temp2;
        }
    }
    public static void viewSupplier(String uName,String PW){

        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tVIEW SUPPLIERS\t\t\t\t\t|");
        System.out.println("+------------------------------------------------------------------------------+\n");
        boolean isTrue = false;
        if (supplier.length == 0){

            System.out.println("You didn't initialize any supplier! You nedd to add Supplier first... \n");
            isTrue = true;
        }

        System.out.println("+-------------------------------+-------------------------------+");
        System.out.println("|\tSUPPLIER_ID	\t|\tSUPPLIER_NAME	\t|");
        System.out.println("+-------------------------------+-------------------------------+");


        if (isTrue){

            System.out.println("|\t   NULL   \t\t|\t    NULL   \t\t|");
            isTrue = true;
        }
        for (int i = 0; i < supplier.length; i++){

            System.out.println("|\t   "+supplier[i][0]+"   \t\t|\t    "+supplier[i][1]+"   \t\t|");
        }
        System.out.println("+-------------------------------+-------------------------------+");

        l1:	while(true){

            System.out.print("\nDo you want to go supplier manage page(Y/N)? ");
            char flag3 = s.next().charAt(0);

            if (flag3 == 'Y'){

                clearConsole();
                manageSupplier(uName,PW);
                clearConsole();
            }else if(flag3 == 'N'){


            }else{

                System.out.print("invalid answer! try again..\n");
                continue l1;
            }
        }
    }
    public static void searchSupplier(String uName,String PW){

        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tSEARCH SUPPLIER\t\t\t\t\t|");
        System.out.println("+------------------------------------------------------------------------------+");

        l1:	while(true){

            System.out.print("\nSupplier ID	: ");
            String id = s.next();

            if (supplier.length == 0){

                System.out.println("\nerror! you didn't initialize any supplier.. ");

                l2:	while(true){

                    System.out.print("You nedd to add Supplier first...Press \"Y\" for add a supplier : ");
                    char flag = s.next().charAt(0);

                    if (flag == 'Y'){
                        clearConsole();
                        addSupplier(uName,PW);
                        clearConsole();
                    }else{

                        System.out.println("invalid answer! try again..\n");
                        continue l2;
                    }
                }
            }
            boolean isTrue = false;

            l3:	for (int i = 0; i < supplier.length; i++){

                if (id.equals(supplier[i][0])){

                    System.out.println("Supplier Name	: "+supplier[i][1]);
                    System.out.print("added successfully! ");
                    break l3;
                }
                if (i == supplier.length - 1){

                    isTrue = true;
                }
            }
            if (isTrue){

                System.out.print("can't find supplier id. try again!\n");
                continue l1;
            }
            l2:	while(true){

                System.out.print("Do you want to search another supplier(Y/N)? ");
                char flag4 = s.next().charAt(0);

                if (flag4 == 'Y'){

                    continue l1;
                }else if(flag4 == 'N'){

                    clearConsole();
                    manageSupplier(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("invalid answer! try again..\n");
                    continue l2;
                }
            }
        }
    }
    public static void manageStock(String uName, String PW){

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tSTOCK MANAGEMENT\t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");
        System.out.println("[1] Manage Item Categories\t\t[2] Add Item");
        System.out.println("[3] Get Items Supplier Wise\t\t[4] View Items");
        System.out.println("[5] Rank Items Per Unit Price\t\t[6] Home Page\n");

        while(true){

            System.out.print("Enter an option to continue > ");
            String op3 = s.next();

            switch (op3){
                case "1":
                    clearConsole();
                    manageCategorie(uName,PW);
                    clearConsole();
                    break;
                case "2":
                    clearConsole();
                    addItem(uName,PW);
                    clearConsole();
                    break;
                case "3":
                    clearConsole();
                    detailItemSupplier(uName,PW);
                    clearConsole();
                    break;
                case "4":
                    clearConsole();
                    viewItem(uName,PW);
                    clearConsole();
                    break;
                case "5":
                    clearConsole();
                    rankItem(uName,PW);
                    clearConsole();
                    break;
                case "6":
                    clearConsole();
                    mainMenu(uName,PW);
                    clearConsole();
                    break;
                default:
                    System.out.print("invalid answer.. try again!!\n\n");
            }

        }
    }
    public static void manageCategorie(String uName,String PW){

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tMANAGE ITEM CATEGORY\t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");
        System.out.println("[1] Add New Item Category\t\t[2] Delete Item Category");
        System.out.println("[3] Update Item Category\t\t[4] Stock Management\n");

        while(true){

            System.out.print("Enter an option to continue > ");
            String op3 = s.next();

            switch (op3){
                case "1":
                    clearConsole();
                    addItemCategory(uName,PW);
                    clearConsole();
                    break;
                case "2":
                    clearConsole();
                    deleteCategory(uName,PW);
                    clearConsole();
                    break;
                case "3":
                    clearConsole();
                    updateCategory(uName,PW);
                    clearConsole();
                    break;
                case "4":
                    clearConsole();
                    manageStock(uName,PW);
                    clearConsole();
                    break;
                default:

                    System.out.println("inalid answer.. try again!!\n");
            }
        }
    }
    public static void addItemCategory(String uName,String PW){

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tADD ITEM CATEGORY\t\t\t|");
        System.out.println("+---------------------------------------------------------------+");

        l1:	while(true){

            System.out.print("\nEnter the new item category: ");
            String cat = s.next();

            for (int i = 0; i < category.length; i++){

                if (cat.equals(category[i])){

                    System.out.println("category alredy exists try another.. \n");
                    continue l1;
                }
            }
            growCat(cat);
            System.out.print("added successfully! ");
            l2:	while(true){

                System.out.print("Do you want to add another category(Y/N)? ");
                char flag = s.next().charAt(0);

                if (flag == 'Y'){

                    continue l1;
                }else if(flag == 'N'){
                    clearConsole();
                    manageCategorie(uName,PW);
                    clearConsole();
                }else{

                    System.out.print("invalid answer.. try again!\n\n");
                    continue l2;
                }
            }
        }
    }
    public static void growCat(String cat){

        String[] temp = new String[category.length + 1];

        for (int i = 0; i < category.length; i++){

            temp[i] = category[i];
        }
        temp[temp.length -1] = cat;
        category = temp;
    }
    public static void deleteCategory(String uName,String PW){

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tDELETE CATEGORY\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+");

        l1: while(true){

            System.out.print("\nEnter category name you want to delete: ");
            String cat = s.next();

            if (category.length == 0){

                System.out.println("\nerror! you didn't initialize any category.. ");

                l2:	while(true){

                    System.out.print("You nedd to add category first...Press \"Y\" for add a category : ");
                    char flag = s.next().charAt(0);

                    if (flag == 'Y'){
                        clearConsole();
                        addItemCategory(uName,PW);
                        clearConsole();
                    }else{

                        System.out.println("invalid answer! try again..\n");
                        continue l2;
                    }
                }
            }
            boolean isTrue = false;
            int index = -1;

            l4:	for (int i = 0; i < category.length; i++){

                if (cat.equals(category[i])){

                    index = i;
                    break l4;
                }
                if (i == category.length - 1){

                    isTrue = true;
                }
            }
            if (isTrue){

                System.out.print("can't find category try again!\n");
                continue l1;
            }
            deleteCatIndex(index);
            System.out.print("deleted successfully! ");
            l3: while(true){
                System.out.print("Do you want to delete another?(Y/N) : ");
                char flag2 = s.next().charAt(0);

                if (flag2 == 'Y'){

                    continue l1;
                }else if(flag2 == 'N'){

                    clearConsole();
                    manageCategorie(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("invalid answer! try again..\n");
                    continue l3;
                }
            }
        }
    }
    public static void deleteCatIndex(int index){

        String[] temp = new String[category.length - 1];

        for (int i = 0,j = 0; i < temp.length; i++,j++){

            if (index == i){
                j++;
            }
            temp[i] = category[j];
        }
        category = temp;

    }
    public static void updateCategory(String uName,String PW){

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tUPDATE CATEGORY\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+");

        boolean isFalse = false;

        l1:	while(true){

            System.out.print("\nEnter the category name you want to update	: ");
            String cat = s.next();

            if(category.length == 0){

                System.out.println("\nerror! you didn't initialize any category.. ");

                l3:	while(true){

                    System.out.print("You nedd to add category first...Press \"Y\" for add a category : ");
                    char flag4 = s.next().charAt(0);

                    if(flag4 == 'Y'){

                        clearConsole();
                        addItemCategory(uName,PW);
                        clearConsole();
                    }else{

                        System.out.println("\ninvalid answer! try again..\n");
                        continue l3;
                    }
                }
            }

            l2:	while(true){

                boolean isTrue = false;

                l5:	for (int i = 0; i < category.length; i++){

                    if (cat.equals(category[i])){

                        System.out.print("\nEnter the new category name : ");
                        category[i]= s.next();

                        for (int j = 0; j < item.length; j++){

                            if (cat.equals(item[j][2])){

                                item[j][2] = category[i];
                            }
                        }


                        System.out.print("Updated Successfully! ");

                        break;
                    }
                    if (i == category.length - 1){

                        isTrue = true;
                    }
                }
                if (isTrue){

                    System.out.print("can't find category.. try again!\n\n");
                    continue l1;
                }
                l4:	while(true){

                    System.out.print("Do you want to update another category ? (Y/N)");
                    char flag = s.next().charAt(0);

                    if(flag == 'Y'){

                        continue l1;
                    }else if(flag == 'N'){

                        clearConsole();
                        manageCategorie(uName,PW);
                        clearConsole();
                    }else{

                        System.out.println("invalid answer.. try again!\n");
                        continue l4;
                    }
                }
            }
        }
    }
    public static void addItem(String uName,String PW){

        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tADD ITEM\t\t\t\t|");
        System.out.println("+-----------------------------------------------------------------------+");

        if (category.length == 0){

            System.out.println("OOPS! It seems that you don't have any item categories in the system.");
            l2: while(true){

                System.out.print("Do you want to add a new item category?(Y/N) ");
                char flag3 = s.next().charAt(0);

                if (flag3 == 'Y'){

                    clearConsole();
                    addItemCategory(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("You don't have any other option!! Please Prees \"Y\"\n");
                    continue l2;
                }
            }
        }
        if (supplier.length == 0){

            System.out.println("OOps It seems that you don't have any suppliers in the system.");

            l3: while(true){

                System.out.print("Do you want to add a new supplier?(Y/N) ");
                char flag4 = s.next().charAt(0);

                if (flag4 == 'Y'){

                    clearConsole();
                    addSupplier(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("You dan't have any other option!! Please press\"Y\"\n");
                    continue l3;
                }
            }
        }
        l1: while(true){

            System.out.print("\nItem Code	:");
            String itemCode = s.next();

            for (int i = 0; i < item.length; i++){

                if (itemCode.equals(item[i][0])){

                    System.out.println("Item Code alredy exist! try another one..");
                    continue l1;
                }
            }

            growItem(itemCode);

            System.out.println("\nSuppliers list: ");
            System.out.println("+---------------+-----------------------+-------------------------------+");
            System.out.println("|\t# \t|\tSUPPLIER ID\t|\tSUPPLIER NAME	\t|");
            System.out.println("+---------------+-----------------------+-------------------------------+");

            for (int i = 0; i < supplier.length; i++){

                System.out.println("|\t"+(i+1)+" \t|\t    "+supplier[i][0]+"\t|\t    "+supplier[i][1]+" \t\t|");
            }
            System.out.println("+---------------+-----------------------+-------------------------------+\n");

            l5: while(true){

                System.out.print("Enter the supplier number > ");
                String Flag = s.next();

                boolean isNumberic = true;

                try{

                    int flag = Integer.parseInt(Flag);
                }catch (NumberFormatException ex){
                    isNumberic = false;
                }

                if (isNumberic){

                    int flag = Integer.parseInt(Flag);

                    if ((0 >= flag) || (supplier.length < flag)){

                        System.out.println("error! give a valid number..");
                        continue l5;
                    }

                    for (int i = 0; i < supplier.length; i++){

                        if ((flag - 1) == i){

                            item[item.length - 1][1] = supplier[i][0];
                        }
                    }
                    break l5;
                }else{

                    System.out.println("error! only numbers is valid..\n");
                    continue l5;
                }

            }
            System.out.println("\nItem Categories: ");
            System.out.println("+---------------+-------------------------------+");
            System.out.println("|\t# \t|\tCATEGORY NAME		|");
            System.out.println("+---------------+-------------------------------+");

            for (int i = 0; i < category.length; i++){

                System.out.println("|\t"+(i+1)+" \t|\t    "+category[i]+" \t\t|");
            }
            System.out.println("+---------------+-------------------------------+");

            l6: while(true){

                System.out.print("\nEnter the Category number > ");
                String Flag1 = s.next();

                boolean isNumberic1 = true;

                try{

                    int flag5 = Integer.parseInt(Flag1);
                }catch (NumberFormatException ex){
                    isNumberic1 = false;
                }

                if (isNumberic1){

                    int flag5 = Integer.parseInt(Flag1);

                    if ((0 >= flag5) || (category.length < flag5)){

                        System.out.println("error! give a valid number..");
                        continue l6;
                    }

                    for (int i = 0; i < category.length; i++){

                        if ((flag5 - 1) == i){

                            item[item.length - 1][2] = category[i];
                        }
                    }
                    break l6;
                }else{

                    System.out.println("error! only numbers is valid..");
                    continue l6;
                }
            }
            System.out.print("\nDescription	: ");
            item[item.length - 1][3] = s.next();

            l5: while(true){

                System.out.print("Unit price	: ");
                item[item.length - 1][4] = s.next();

                boolean isNumberic1 = true;
                try{

                    int flag5 = Integer.parseInt(item[item.length - 1][4]);
                    break;
                }catch (NumberFormatException ex){

                    isNumberic1 = false;
                }
                if (isNumberic1){

                    System.out.println("error! only numbers are valid..\n");
                    continue l5;
                }
            }
            l6: while(true){

                System.out.print("QTY on hand	: ");
                item[item.length - 1][5] = s.next();

                boolean isNumberic2 = true;
                try{

                    int flag5 = Integer.parseInt(item[item.length - 1][5]);
                    break;
                }catch (NumberFormatException ex){

                    isNumberic2 = false;
                }
                if (isNumberic2){
                    System.out.println("error! only numbers are valid..\n");
                    continue l6;
                }
            }
            System.out.print("added successfully! ");

            l4: while(true){

                System.out.print("Do you want to add another Item(Y/N)? ");
                char flag2 = s.next().charAt(0);

                if (flag2 == 'Y'){

                    continue l1;
                }else if(flag2 == 'N'){

                    clearConsole();
                    manageStock(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("invalid answer! try again..");
                    continue l4;
                }
            }
        }
    }
    public static void growItem(String IC){

        String[][] temp = new String[item.length + 1][6];

        for (int i = 0; i < item.length; i++){
            for (int j = 0; j < item[i].length; j++){

                temp[i][j] = item[i][j];
            }
        }
        temp[temp.length - 1][0] = IC;
        item = temp;
    }
    public static void detailItemSupplier(String uName,String PW){



        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tSEARCH SUPPLIER\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");

        if (item.length == 0){

            l3: while(true){

                System.out.print("You didn't initialize any item..please press \'Y\' to go for add item : ");
                char flag0 = s.next().charAt(0);

                if (flag0 == 'Y'){

                    clearConsole();
                    addItem(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("You don't have any option!\n");
                    continue l3;
                }
            }
        }
        l1: while(true) {

            System.out.print("Enter Supplier ID : ");
            String Id = s.next();

            boolean isFalse = true;

            l6:	for (int i = 0; i < item.length; i++){

                if (Id.equals(item[i][1])){

                    isFalse = false;
                }


            }
            if (isFalse){

                System.out.println("No supply from this supplier..\ntry another Id...");
                continue l1;
            }
            for (int i = 0; i < supplier.length; i++){

                if (Id.equals(supplier[i][0])){

                    System.out.println("Supplier Name	: "+supplier[i][1]);
                }
            }

            System.out.println("\n\n+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
            System.out.println("|\tITEM CODE\t|\tDESCRIPTION\t|\tUNIT PRICE\t|\tQTY ON HAND\t|\tCATEGORY\t   |");
            System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

            for (int i = 0; i < item.length; i++){
                if (Id.equals(item[i][1])){

                    System.out.println("|\t"+item[i][1]+"	\t|\t"+item[i][0]+"	\t|\t"+item[i][4]+"	\t|	 "+item[i][5]+" 		|\t"+item[i][2]+"	\t   |");
                }
            }
            System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
            System.out.print("search successfully! ");

            l2:	while(true){

                System.out.print("Do you want to another search?(Y/N) ");
                char flag = s.next().charAt(0);

                if (flag == 'Y'){

                    continue l1;
                }else if(flag == 'N'){
                    clearConsole();
                    manageStock(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("invalid answer! try again..\n");
                    continue l2;
                }
            }
        }
    }
    public static void viewItem(String uName,String PW){

        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tVIEW ITEMS\t\t\t\t|");
        System.out.println("+-----------------------------------------------------------------------+\n");

        if (category.length == 0){

            l1: while(true){

                System.out.println("You didn't have initialize any Item.. please press \'Y'\' to go back : ");
                char flag = s.next().charAt(0);

                if (flag == 'Y'){

                    clearConsole();
                    manageStock(uName,PW);
                    clearConsole();
                }else{

                    System.out.print("you don't have any option!!..");
                    continue l1;
                }
            }
        }
        for (int i = 0; i < category.length; i++){
            for (int j = 0; j < item.length; j++){

                if (category[i].equals(item[j][2])){

                    System.out.println(category[i]+":");

                    System.out.println("+----------------+---------------+---------------+---------------+--------------+");
                    System.out.println("|\tSID\t |\tCODE\t |\tDESC\t |\tPRICE\t |\tQTY\t|");
                    System.out.println("+----------------+---------------+---------------+---------------+--------------+");
                    for (int r = 0; r < item.length; r++){

                        if (category[i] == item[r][2]){


                            System.out.println("|\t"+item[j][1]+"\t |\t"+item[j][0]+"\t |\t"+item[j][3]+"\t |\t"+item[j][4]+"\t |\t"+item[j][5]+"\t|");

                        }
                    }
                    System.out.println("+----------------+---------------+---------------+---------------+--------------+\n");
                }
            }
        }
        System.out.print("PRESS any key to go Back : ");
        char flag2 = s.next().charAt(0);

        clearConsole();
        manageStock(uName,PW);
        clearConsole();
    }
    public static void rankItem(String uName,String PW){

        int[] temp1 = new int[item.length];
        String[] temp2 = new String[item.length];
        String[][] temp3 = new String[item.length][6];

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\tRANKED UNIT PRICE\t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n\n");

        if (item.length == 0){

            System.out.println("You didn't initialize any item.. please add items first!..");
            l7: while(true){
                System.out.print("Press \'Y\' to go add item page : ");
                char flag = s.next().charAt(0);

                if (flag == 'Y'){

                    clearConsole();
                    addItem(uName,PW);
                    clearConsole();
                }else{

                    System.out.println("invalid answer! try again.. \n");
                    continue l7;
                }
            }
        }
        for (int i = 0; i < item.length; i++){

            temp1[i] = Integer.parseInt(item[i][4]);
        }
        for (int i = 0; i < temp1.length; i++){
            for (int j = 1; j < temp1.length; j++){

                if (temp1[j-1]>temp1[j]){

                    int num = temp1[j];
                    temp1[j] = temp1[j-1];
                    temp1[j-1] = num;
                }
            }
        }
        for (int i = 0; i < item.length; i++){

            temp2[i] = Integer.toString(temp1[i]);
        }
        for (int i = 0; i < item.length; i++){
            for (int j = 0; j < item.length; j++){

                if (temp2[i].equals(item[j][4])){

                    temp3[i] = item[j];
                }
            }
        }

        System.out.println("+----------------+---------------+---------------+---------------+--------------+----------------+");
        System.out.println("|	SID 	 |	CODE	 |	DESC	 |	PRICE	 |	QTY	 |	CAT	 |");
        System.out.println("+----------------+---------------+---------------+---------------+--------------+----------------+");
        for (int i = 0; i < temp3.length; i++){

            System.out.println("|	"+temp3[i][1]+"	 |	"+temp3[i][0]+"	 |	"+temp3[i][3]+"	 |	"+temp3[i][4]+"	 |	"+temp3[i][5]+"	 |	"+temp3[i][2]+"	 |");
        }
        System.out.println("+----------------+---------------+---------------+---------------+--------------+----------------+");

        l1:	while(true){

            System.out.print("Do yo want to go stock manage page?(Y) ");
            char flag = s.next().charAt(0);

            if (flag == 'Y'){

                clearConsole();
                manageStock(uName,PW);
                clearConsole();
            }else{

                System.out.println("You don't have any other option!!");
                continue l1;
            }
        }
    }
    public static void logOut(String uName, String PW){

        while(true){
            System.out.print("Are you sure you want to logOut (Y/N)");
            char flag1 = s.next().charAt(0);

            if(flag1 == 'Y'){
                clearConsole();
                login(uName,PW);
                clearConsole();
            }else if(flag1 == 'N'){
                clearConsole();
                mainMenu(uName,PW);
                clearConsole();
            }else{

                System.out.print("error.. try again!!\n\n");
            }
        }
    }

    public static void main(String args[]){

        String uName = "dulmin";
        String PW = "1234";

        login(uName,PW);
    }
}
