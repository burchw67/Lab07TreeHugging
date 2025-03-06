public class BinaryTree
{
    public TNode root;
///////////////////////---------Basic Methods---------///////////////////////
    public void Add(int data)
    {
        root = addRecursive(root, data);
    }

    private TNode addRecursive(TNode current, int data)
    {
        if (current == null)
        {
            return new TNode(data);
        }
        if (data < current.data)
        {
            current.left = addRecursive(current.left, data);
        }
        else if (data > current.data)
        {
            current.right = addRecursive(current.right, data);
        }
        else
        {
            return current; //data already on the tree
        }

        return current;
    }

    public void Find(int data)
    {
        TNode currentNode = root;

        while(currentNode != null)
        {
            if(currentNode.data == data)
            {
                System.out.println("Element " + data + " found in the tree.");
                return;
            }
            else if(data < currentNode.data)
            {
                currentNode = currentNode.left;
            }
            else
            {
                currentNode = currentNode.right;
            }
        }

        System.out.println("Element " + data + " not found in the tree.");
        return;
    }

    public void Delete(int target)
    {
        ////////////////----------------This code is sourced from ChatGPT and modified by me----------------////////////////
        TNode current = root;
        TNode parent = null;

        // Step 1: Search for the node to delete and track its parent
        while (current != null && current.data != target)
        {
            parent = current;
            if (target < current.data)
            {
                current = current.left;
            } else
            {
                current = current.right;
            }
        }

        // If the target is not found, return
        if (current == null)
        {
            System.out.println("Element " + target + " not found in the tree.");
            return;
        }

        // Step 2: Handle deletion cases

        // Case 1: Node has no children (leaf node)
        if (current.left == null && current.right == null)
        {
            if (current == root) {
                root = null; // If it's the root, make it null
            }
            else if (parent.left == current)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
        }

        // Case 2: Node has one child
        else if (current.left == null || current.right == null)
        {
            TNode child = (current.left != null) ? current.left : current.right;

            if (current == root)
            {
                root = child; // If root has one child, replace root
            } else if (parent.left == current)
            {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // Case 3: Node has two children
        else
        {
            TNode successorParent = current;
            TNode successor = current.right;

            // Find the inorder successor (smallest node in right subtree)
            while (successor.left != null)
            {
                successorParent = successor;
                successor = successor.left;
            }

            // Replace the node's data with successor's data
            current.data = successor.data;

            // Delete the successor (which has at most one child)
            if (successorParent.left == successor)
            {
                successorParent.left = successor.right;
            }
            else
            {
                successorParent.right = successor.right;
            }
        }
    }

///////////////////////---------Traversal Methods---------///////////////////////
    public void InOrderTraversal(TNode tree)
    {
        if(tree != null){
            InOrderTraversal(tree.left); //left
            System.out.print(tree.data + " "); //visit
            InOrderTraversal(tree.right); //right
        }
    }

    public void PreOrderTraversal(TNode tree)
    {
        if(tree != null){
            System.out.print(tree.data + " "); //visit
            PreOrderTraversal(tree.left); //left
            PreOrderTraversal(tree.right); //right
        }
    }

    public void PostOrderTraversal(TNode tree)
    {
        if(tree != null)
        {
            PostOrderTraversal(tree.left);
            PostOrderTraversal(tree.right);
            System.out.print(tree.data + " ");
        }
    }


///////////////////////---------Getter Methods---------///////////////////////
    public int GetHeight(TNode tree)
    {
        if (root == null)
        {
            return -1;
        }

        int leftHeight = GetHeight(root.left);
        int rightHeight = GetHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int CountNodes(TNode tree)
    {
        if (tree == null)
        {
            return 0;
        }

        int l = CountNodes(tree.left);
        int r = CountNodes(tree.right);

        return 1 + l + r;
    }

    public int GetSum(TNode tree)
    {
        if (tree == null)
        {
            return 0;
        }

        int leftSum = GetSum(tree.left);
        int rightSum = GetSum(tree.right);

        return tree.data + leftSum + rightSum;
    }

    public int FindLargest(TNode tree)
    {
        if (tree.right == null)
        {
            return tree.data;
        }

        return FindLargest(tree.right);
    }

    public boolean IsAncestor(int ancestor, int descendant)
    {
        return false;
    }
}
