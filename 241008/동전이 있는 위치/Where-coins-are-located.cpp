#include <iostream>
using namespace std;

int main() {
    int n, m;
    int arr[10][10];

    cin >> n >> m;
    for(int i=0; i<m; i++){
        int r, c;
        cin >> r >> c;
        arr[r][c] = 1;
    }

    for(int r=1; r<=n; r++){
        for(int c=1; c<=n; c++){
            cout << arr[r][c] << ' ';
        }
        cout << endl;
    }

    return 0;
}