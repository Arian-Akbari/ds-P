#include <iostream>
#include <vector>

using namespace std;

class Node
{
public:
    Node()
    {
    }

    int data = 0;
    vector<Node *> father;

    Node(int item)
    {
        data = item;
    }
};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, q;
    cin >> n >> q;
    vector<Node *> tree(n);
    Node *root = new Node(1);
    tree[0] = root;
    while (n != 1)
    {
        int v1, v2;
        cin >> v1 >> v2;
        Node *node = new Node(v2);
        node->father.push_back(tree[v1 - 1]);
        tree[v2 - 1] = node;
        n--;
    }
    while (q != 0)
    {
        int v1, v2;
        cin >> v1 >> v2;
        if (v1 == 1)
            cout << "YES"
                 << "\n";
        else
        {
            Node temp = *tree[v2 - 1];
            while (true)
            {
                if (temp.data == 1)
                {
                    cout << "NO"
                         << "\n";
                    break;
                }
                if (temp.data == v1)
                {
                    cout << "YES"
                         << "\n";
                    break;
                }
                temp = *temp.father[0];
            }
        }
        q--;
    }
}