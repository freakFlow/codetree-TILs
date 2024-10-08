#include <iostream>
using namespace std;

int main() {
    int n;
    int arr[10][10];

    cin >> n;

    for(int i=0; i<n; i++){
        arr[i][0] = arr[0][i] = 1;
    }

    for(int r=1; r<n; r++){
        for(int c=1; c<n; c++){
            arr[r][c] = arr[r-1][c] + arr[r][c-1] + arr[r-1][c-1];
        }
    }

    for(int r=0; r<n; r++){
        for(int c=0; c<n; c++){
            cout << arr[r][c] << ' ';
        }
        cout << endl;
    }

    return 0;
}