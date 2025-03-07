import java.util.Scanner;

public class Lab07TreesWAB {
    public static void main(String[] args) {
        //Necessary strings
        String introString =
                "Welcome to the Tree Hugger Program\n" +
                        "Author: William Anthony Burch\n";

        String optionString =
                "\nSelect an option from the menu:\n\n" +
                        "1. Add an item to the tree\n" +
                        "2. Find an item on the tree\n" +
                        "3. Remove an item from the tree\n" +
                        "4. Count the nodes on the tree\n" +
                        "5. Compute the tree height\n" +
                        "6. Find the largest element on the tree\n" +
                        "7. Find the sum of the elements\n" +
                        "8. Find the average of the elements\n" +
                        "9. Find if one element is an ancestor of another\n" +
                        "10. Print the Tree (Pre-Order)\n" +
                        "11. Print the Tree (Post-Order)\n" +
                        "12. Print the Tree (In-Order)\n"+
                        "13. Quit\n"+
                        "\nEnter your choice: ";


        String quit = "N";
        String choice = "x";

        //Scanner Object creation
        Scanner scanMan = new Scanner(System.in);

        int alpInt = 0;
        int alpInt2 = 0;
        BinaryTree treeMan = new BinaryTree();

        System.out.println(introString);

        while (quit.charAt(0) != 'Y' && quit.charAt(0) != 'y')
        {
            System.out.print(optionString);
            choice = scanMan.nextLine();

            switch (choice)
            {
                case "1":
                    System.out.print("\nEnter an element to add to the tree: ");
                    alpInt = Integer.parseInt(scanMan.nextLine());

                    if(treeMan.Find(alpInt) == true)
                    {
                        System.out.println("Element " + alpInt + " already exists on the tree, try again!");
                        break;
                    }

                    treeMan.Add(alpInt);
                    System.out.println("Element " + alpInt + " added to the tree!");

                    break;

                case "2":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }

                    System.out.print("\nEnter an element to search for on the tree: ");
                    alpInt = Integer.parseInt(scanMan.nextLine());

                    if(treeMan.Find(alpInt) == true)
                    {
                        System.out.println("Element " + alpInt + " exists on the tree!");
                        break;
                    }

                    System.out.println("Element " + alpInt + " does not exist on the tree!\n");
                    break;

                case "3":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is already empty, try again!");
                        break;
                    }
                    System.out.print("\nEnter an element to delete from the tree: ");
                    alpInt = Integer.parseInt(scanMan.nextLine());

                    if(!treeMan.Find(alpInt))
                    {
                        System.out.println("Element " + alpInt + " doesn't exist on the tree!");
                        break;
                    }

                    treeMan.Delete(alpInt);
                    System.out.println("Element " + alpInt + " deleted from the tree!");

                    break;

                case "4":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }
                    alpInt = treeMan.CountNodes();

                    System.out.println("There are " + alpInt + " nodes on the tree.");
                    break;

                case "5":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }

                    System.out.println("The height of the tree is " + treeMan.GetHeight());
                    break;

                case "6":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }

                    alpInt = treeMan.FindLargest();
                    System.out.println("\nThe largest element on the tree is " + alpInt);
                    break;

                case "7":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }

                    alpInt = treeMan.GetSum();

                    System.out.println("\nThe sum of all nodes on the tree is " + alpInt);
                    break;

                case "8":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }

                    alpInt = treeMan.GetSum();

                    System.out.println("\nThe average of all nodes on the tree is: " + (alpInt/treeMan.CountNodes()));

                    break;

                case "9":
                    boolean desc;
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }

                    System.out.print("Enter an Ancestor node: ");
                    alpInt = Integer.parseInt(scanMan.nextLine());

                    System.out.print("Enter an Descendant node to search for: ");
                    alpInt2 = Integer.parseInt(scanMan.nextLine());

                    desc = treeMan.IsAncestor(alpInt, alpInt2);

                    if(desc)
                    {
                        System.out.println(alpInt2 + " is a descendant of " + alpInt);
                        break;
                    }
                    else
                    {
                        System.out.println(alpInt2 + " is not a descendant of " + alpInt);
                        break;
                    }


                case "10":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }
                    System.out.println("\nPre-Order Traversal: ");
                    treeMan.PreOrderTraversal(treeMan.root);
                    System.out.println("");
                    break;

                case "11":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }
                    System.out.println("\nPost-Order Traversal: ");
                    treeMan.PostOrderTraversal(treeMan.root);
                    System.out.println("");
                    break;

                case "12":
                    if(treeMan.root == null)
                    {
                        System.out.println("\nThe tree is empty, try again!");
                        break;
                    }
                    System.out.println("\nIn-Order Traversal: ");
                    treeMan.InOrderTraversal(treeMan.root);
                    System.out.println("");
                    break;

                case "13":
                    System.out.print("Are you sure you want to quit? [Y/N]");
                    quit = scanMan.nextLine();

                    if(Character.toUpperCase(quit.charAt(0)) == 'N' || Character.toLowerCase(quit.charAt(0)) == 'n')
                    {
                        break;
                    }
                    else if(Character.toUpperCase(quit.charAt(0)) == 'Y' || Character.toLowerCase(quit.charAt(0)) == 'y')
                    {
                        quit = "yes";
                        break;
                    }
                    else
                    {
                        break;
                    }

                case "99":
                    treeMan.Add(61);
                    treeMan.Add(66);
                    treeMan.Add(48);
                    treeMan.Add(70);
                    treeMan.Add(75);
                    treeMan.Add(59);
                    treeMan.Add(60);
                    treeMan.Add(49);
                    treeMan.Add(51);
                    treeMan.Add(52);
                    break;
            }
        }
    }
}