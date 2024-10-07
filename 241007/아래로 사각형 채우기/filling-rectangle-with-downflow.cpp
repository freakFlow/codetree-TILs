#include <iostream>
using namespace std;

int main() {
    int n;
    int arr[10][10];

    cin >> n;

    int num = 1;
    for(int c=0; c<n; c++){
        for(int r=0; r<n; r++){
            arr[r][c] = num++;
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