#include <bits/stdc++.h>
using namespace std;
int a[] = {1, 3, 7, 9};
int n = 4;
bool used[4];
int x[4];
void in()
{
    for (int i = 0; i < n; i++)
        cout << x[i] << " ";
    cout << endl;
}
void hoanVi(int j)
{
    for (int i = 0; i < n; i++)
    {
        if (!used[i])
        {
            x[j] = a[i];
            used[i] = true;
            if (j == n - 1)
                in();
            else
                hoanVi(j + 1);

            used[i] = false;
        }
    }
}
int main()
{
    hoanVi(0);
    return 0;
}
